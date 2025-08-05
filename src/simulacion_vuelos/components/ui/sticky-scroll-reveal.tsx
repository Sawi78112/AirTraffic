"use client";
import React, { useRef } from "react";
import { useMotionValueEvent, useScroll } from "framer-motion";
import { motion } from "framer-motion";
import { cn } from "@/libs/utils";

export const StickyScroll = ({
  content,
  contentClassName,
}: {
  content: {
    col1: React.ReactNode;
    col2?: React.ReactNode;
  }[];
  contentClassName?: string;
}) => {
  const [activeCard, setActiveCard] = React.useState(0);
  const ref = useRef<any>(null);
  const { scrollYProgress } = useScroll({
    container: ref,
    offset: ["start start", "end start"],
  });
  const cardLength = content.length;

  useMotionValueEvent(scrollYProgress, "change", (latest) => {
    const cardsBreakpoints = content.map((_, index) => index / cardLength);
    const closestBreakpointIndex = cardsBreakpoints.reduce(
      (acc, breakpoint, index) => {
        const distance = Math.abs(latest - breakpoint);
        if (distance < Math.abs(latest - cardsBreakpoints[acc])) {
          return index;
        }
        return acc;
      },
      0,
    );
    setActiveCard(closestBreakpointIndex);
  });

  return (
    <div
      className="relative flex h-[30rem] justify-center overflow-y-auto rounded-md p-4 md:space-x-10 md:p-10"
      ref={ref}
      style={{
        scrollbarWidth: "none",
        msOverflowStyle: "none"
      }}
    >
      <div className="div relative flex w-full items-start px-2 md:px-4">
        <div className="w-full">
          {content.map((item, index) => (
            <div key={index} className="my-10 md:my-20">
              <motion.div
                initial={{
                  opacity: 0,
                }}
                animate={{
                  opacity: activeCard === index ? 1 : 0.3,
                }}
                className="flex flex-col items-center gap-4 md:flex-row md:gap-10"
              >
                <div className="w-full md:flex-1">{item.col1}</div>
                {item.col2 && (
                  <div
                    className={cn(
                      "mt-4 w-full md:mt-0 md:flex-1",
                      contentClassName,
                    )}
                  >
                    {item.col2}
                  </div>
                )}
              </motion.div>
            </div>
          ))}
          <div className="h-20 md:h-40" />
        </div>
      </div>
    </div>
  );
};

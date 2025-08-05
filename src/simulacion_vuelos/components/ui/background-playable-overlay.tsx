"use client";
import { cn } from "@/libs/utils";
import { ArrowUpRight, Check } from "lucide-react";
import { motion } from "framer-motion";
import { AnimatedArrowButton } from "./animated-arrow-button";
// import { LeadForm } from "../common/lead-form";

interface BackgroundPlayableOverlayProps {
  backgroundImageUrl: string;
  hoverImageUrl: string;
  id: string;
  title: string;
  description: string;
  buttontext: string;
  bulletPoints?: string[];
  bgColor: string;
  textColor: string;
  buttonColor: string;
  arrowBgColor: string;
  isHovered: boolean;
  onMouseEnter: () => void;
  onMouseLeave: () => void;
  formSource: string;
  formId: string;
}

export function BackgroundPlayableOverlay({
  id,
  title,
  description,
  backgroundImageUrl,
  hoverImageUrl,
  buttontext,
  bulletPoints,
  bgColor,
  textColor,
  buttonColor,
  arrowBgColor,
  isHovered,
  onMouseEnter,
  onMouseLeave,
  formSource,
  formId,
}: BackgroundPlayableOverlayProps) {
  return (
    <motion.div
      className={cn(
        `group flex h-[480px] rounded-[20px] bg-gray-200 p-6 text-black hover:text-white`,
        "card relative cursor-pointer overflow-hidden",
        // "bg-[url(https://images.unsplash.com/photo-1476842634003-7dcca8f832de?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80)] bg-cover",
        // Preload hover image by setting it in a pseudo-element
        "bg-cover before:fixed before:inset-0 before:z-[-1] before:bg-[url(https://res.cloudinary.com/dnq4oscjm/image/upload/v1726810826/Gen-3_Alpha_Turbo_3762570463_Create_a_hyper-reali_Cropped_-_iStock-121_4_pdc6gy.gif)] before:opacity-0",
        "hover:bg-[url(https://res.cloudinary.com/dnq4oscjm/image/upload/v1726810826/Gen-3_Alpha_Turbo_3762570463_Create_a_hyper-reali_Cropped_-_iStock-121_4_pdc6gy.gif)]",
        "hover:after:absolute hover:after:inset-0 hover:after:bg-black hover:after:opacity-50 hover:after:content-['']",
        "transition-all duration-500 ease-out",
      )}
      onMouseEnter={onMouseEnter}
      onMouseLeave={onMouseLeave}
      animate={{
        flex: isHovered ? 2 : 1,
      }}
      transition={{ duration: 0.3 }}
    >
      <div className="text relative z-50 flex h-full flex-col justify-between">
        <div>
          <div className="mb-4 flex items-start justify-between">
            <motion.h2
              className="font-semibold tracking-tight"
              animate={{
                fontSize: isHovered ? "2rem" : "1.2rem",
              }}
              transition={{ duration: 0.3 }}
            >
              {title}
            </motion.h2>
            <div className={`rounded-full p-5 ${arrowBgColor}`}>
              <ArrowUpRight className="h-6 w-6" />
            </div>
          </div>

          <div className="space-y-2">
            <p className="mb-12 text-sm leading-6 tracking-tight">
              {description}
            </p>
            <motion.div
              className="overflow-hidden text-sm"
              animate={{
                height: isHovered ? "auto" : 0,
                opacity: isHovered ? 1 : 0,
              }}
              transition={{ duration: 0.3 }}
            >
              {bulletPoints && (
                <ul className="mb-4 list-none space-y-2">
                  {bulletPoints.map((point, index) => (
                    <li key={index} className="flex items-center text-sm">
                      <div
                        className={cn(
                          "mr-2 w-fit rounded-full p-[3px] text-white",
                          buttonColor,
                        )}
                      >
                        <Check className="size-3" strokeWidth={3} />
                      </div>
                      {point}
                    </li>
                  ))}
                </ul>
              )}
            </motion.div>
          </div>
        </div>
        {/* <LeadForm id={formId || ""} source={formSource || ""}>
          <AnimatedArrowButton
            className={`${buttonColor} w-fit text-xs font-semibold text-white`}
          >
          </AnimatedArrowButton>
        </LeadForm> */}
            {buttontext}
      </div>
    </motion.div>
  );
}
//  ${bgColor} ${textColor}
//  mx-auto flex h-96   flex-col justify-end border border-transparent p-4 shadow-xl dark:border-neutral-800
// <motion.div
// className={cn(
//
//   "card group relative mx-auto flex h-fit w-full cursor-pointer flex-col justify-end overflow-hidden rounded-md border border-transparent p-4 shadow-xl dark:border-neutral-800",
//   "bg-cover",
//   "before:fixed before:inset-0 before:z-[-1] before:opacity-0",
//   "hover:after:absolute hover:after:inset-0 hover:after:bg-black hover:after:opacity-50 hover:after:content-['']",
//   "transition-all duration-500",
// )}
// onMouseEnter={onMouseEnter}
// onMouseLeave={onMouseLeave}
// animate={{
//   flex: isHovered ? 2 : 1,
// }}
// transition={{ duration: 0.3 }}
// style={{
//   backgroundImage: `url(${backgroundImageUrl})`,
// }}
// >
// <div
//   className="absolute inset-0 h-full w-full opacity-0 transition-opacity duration-500 group-hover:opacity-100"
//   style={{
//     backgroundImage: `url(${hoverImageUrl})`,
//   }}
// />

// </motion.div>

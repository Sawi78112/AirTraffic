"use client";

import { cn } from "@/libs/utils";
import { motion } from "framer-motion";
import { QuoteSolid } from "iconoir-react";

export function HoveringQuoteMark(props: { className?: string }) {
  const { className } = props;

  return (
    <motion.div
      animate={{ y: [0, -10, 0] }}
      transition={{ repeat: Infinity, duration: 2 }}
    >
      <QuoteSolid className={cn("text-gray-300", className)} width={52} height={52} />
    </motion.div>
  );
}

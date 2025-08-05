import { Button } from "./button";
import { ButtonProps } from "./button";
import { ArrowRight } from "lucide-react";
import { cn } from "@/libs/utils";

export function AnimatedArrowButton({ children, className, ...props }: ButtonProps) {
  return (
    <Button
      {...props}
      className={cn("group flex items-center gap-2 rounded-full transition-all duration-300 ease-in-out", className)}
    >
      {children}
      <span className="h-5 w-0 overflow-hidden transition-all duration-300 ease-in-out group-hover:w-5 ">
        <ArrowRight className="size-5 -translate-x-full transition-transform delay-200 duration-200 ease-in-out group-hover:translate-x-0" />
      </span>
    </Button>
  );
}

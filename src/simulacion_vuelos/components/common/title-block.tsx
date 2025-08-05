import { cn } from "@/libs/utils";
import { cva, type VariantProps } from "class-variance-authority";
import { ComponentPropsWithoutRef, ElementType, ReactNode } from "react";

const titleBlockVariants = cva("flex w-full flex-col justify-center space-y-4 py-4", {
  variants: {
    align: {
      left: "items-start text-left",
      center: "items-center text-center",
      right: "items-end text-right",
    },
    size: {
      sm: "text-2xl",
      md: "text-3xl",
      lg: "text-4xl",
      xl: "text-5xl",
    },
  },
  defaultVariants: {
    align: "center",
    size: "md",
  },
});

type TitleBlockProps = VariantProps<typeof titleBlockVariants> & 
  ComponentPropsWithoutRef<"div"> & {
    title: ReactNode;
    heading: ReactNode;
    headingElement?: ElementType;
    classNames?: {
      container?: string;
      title?: string;
      heading?: string;
    };
  };

export function TitleBlock({
  title,
  heading,
  align,
  size,
  classNames,
  headingElement: HeadingElement = "p",
  ...props
}: TitleBlockProps) {
  return (
    <div 
      className={cn(
        titleBlockVariants({ align, size }), 
        classNames?.container
      )}
      {...props}
    >
      <h2 className={cn(
        "font-mono text-base font-semibold uppercase text-primary",
        classNames?.title
      )}>
        {title}
      </h2>
      <HeadingElement className={cn(
        "font-sans leading-[1.2] -tracking-[0.02em]",
        {
          "text-2xl leading-[36px] -tracking-[1.2px]": size === "sm",
          "text-3xl leading-[42px] -tracking-[1.5px]": size === "md",
          "text-4xl leading-[48px] -tracking-[1.8px]": size === "lg",
          "text-5xl leading-[56px] -tracking-[2px]": size === "xl",
        },
        classNames?.heading
      )}>
        {heading}
      </HeadingElement>
    </div>
  );
}
import { cva, type VariantProps } from "class-variance-authority";

const iconContainerVariants = cva(
  "flex items-center justify-center rounded-sm bg-blue-950/15",
  {
    variants: {
      size: {
        sm: "h-8 w-8",
        md: "h-12 w-12",
        lg: "h-16 w-16",
      },
    },
    defaultVariants: {
      size: "md",
    },
  },
);

interface IconContainerProps
  extends VariantProps<typeof iconContainerVariants> {
  icon: JSX.Element;
  className?: string;
}

export function IconContainer({
  icon,
  size,
  className = "",
}: IconContainerProps) {
  return (
    <div className={iconContainerVariants({ size, className })}>{icon}</div>
  );
}

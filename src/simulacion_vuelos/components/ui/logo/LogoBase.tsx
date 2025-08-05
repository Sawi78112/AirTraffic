import React from "react";

interface LogoBaseProps {
  size?: "sm" | "md" | "lg";
  variant?: "default" | "onBlack" | "onWhite";
  className?: string;
  renderLogo: (props: {
    width: number;
    height: number;
    fillColor: string;
  }) => React.ReactNode;
}

export function LogoBase(props: LogoBaseProps) {
  const { size = "md", variant = "default", className, renderLogo } = props;

  const dimensions = {
    sm: { width: 120, height: 30 },
    md: { width: 169, height: 42 },
    lg: { width: 338, height: 84 },
  };

  const { width, height } = dimensions[size];

  const getFillColor = () => {
    if (className) return className;
    switch (variant) {
      case "onBlack":
        return "#FFFFFF";
      case "onWhite":
        return "#000000";
      default:
        return "#1A1414";
    }
  };

  return renderLogo({ width, height, fillColor: getFillColor() });
}

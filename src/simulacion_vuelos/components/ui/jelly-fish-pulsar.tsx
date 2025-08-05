import React from "react";

const JellyfishPulsar = () => {
  return (
    <div className="relative flex h-full w-full items-center justify-center">
      {/* Container for all rings */}
      <div className="relative w-full h-full">
        {[...Array(10)].map((_, index) => (
          <div
            key={index}
            className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 rounded-full border-2 border-stone-300/60 animate-jelly-pulse"
            style={{
              width: `${(index + 1) * 4}rem`,
              height: `${(index + 1) * 4}rem`,
              animationDelay: `${index * 0.15}s`,
            //   filter: `blur(${index * 2}px)`,
            }}
          />
        ))}
      </div>
    </div>
  );
};

export { JellyfishPulsar };

"use client";

import React, { useEffect, useRef, useState } from 'react';

interface DotProps {
  id: number;
  isActive: boolean;
}

interface DottedBackgroundProps {
  children?: React.ReactNode;
}

const DottedBackground = ({ children }: DottedBackgroundProps) => {
  const containerRef = useRef<HTMLDivElement>(null);
  const [dots, setDots] = useState<DotProps[]>([]);
  const animationDuration = 1200; // Slower animation duration
  const dotSize = 4; // 8px diameter
  const gap = 24; // 24px between dots

  useEffect(() => {
    const container = containerRef.current;
    if (!container) return;

    const calculateGrid = () => {
      const containerWidth = container.offsetWidth;
      const containerHeight = container.offsetHeight;
      
      const numCols = Math.floor(containerWidth / (dotSize + gap));
      const numRows = Math.floor(containerHeight / (dotSize + gap));
      
      container.style.gridTemplateColumns = `repeat(${numCols}, ${dotSize}px)`;
      container.style.gridTemplateRows = `repeat(${numRows}, ${dotSize}px)`;
      container.style.gap = `${gap}px`;

      return Array.from({ length: numCols * numRows }, (_, i) => ({
        id: i,
        isActive: false
      }));
    };

    const shuffleArray = (array: DotProps[]) => {
      for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
      }
      return array;
    };

    const initializeDots = () => {
      const newDots = calculateGrid();
      setDots(newDots);
    };

    if (!dots.length) {
      initializeDots();
      return;
    }

    let dotElements = Array.from(container.querySelectorAll<HTMLDivElement>('.dot'));
    if (dotElements.length !== dots.length) {
      initializeDots();
      return;
    }

    let currentIndex = 0;
    const shuffledDots = shuffleArray([...dots]);

    const animateDot = () => {
      // Reset previous active dot
      setDots(prev => prev.map(dot => ({
        ...dot,
        isActive: false
      })));

      // Activate new dot
      setDots(prev => prev.map(dot => 
        dot.id === shuffledDots[currentIndex].id 
          ? { ...dot, isActive: true } 
          : dot
      ));

      currentIndex = (currentIndex + 1) % shuffledDots.length;
    };

    const animationInterval = setInterval(animateDot, animationDuration);
    return () => clearInterval(animationInterval);
  }, [dots.length]);

  return (
    <div className="relative w-full h-full">
      {/* Dots background layer */}
      <div
        ref={containerRef}
        className="absolute inset-0 grid pointer-events-none z-0"
        style={{
          justifyContent: 'center',
          alignContent: 'center',
        }}
      >
        {dots.map((dot) => (
          <div 
            key={dot.id}
            className={`dot relative transition-colors duration-300 ${
              dot.isActive ? 'bg-primary' : 'bg-muted'
            } rounded-full`}
            style={{
              width: `${dotSize}px`,
              height: `${dotSize}px`,
            }}
          >
            <div className={`
              absolute inset-0 border-4 border-primary rounded-full
              opacity-0 scale-0 transition-all duration-300
              ${dot.isActive ? 'animate-ring' : ''}
            `}/>
          </div>
        ))}
      </div>

      {/* Children content layer */}
      <div className="relative z-10 w-full h-full">
        {children}
      </div>
    </div>
  );
};

export { DottedBackground };

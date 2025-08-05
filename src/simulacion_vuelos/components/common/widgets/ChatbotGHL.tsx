"use client";

import Script from "next/script";
import { useState } from "react";

interface ChatbotGHLProps {
  widgetId: string;
}

export function ChatbotGHL({
  widgetId = "6747394e29fc591edbcaccce",
}: ChatbotGHLProps) {
  const [isLoaded, setIsLoaded] = useState(false);

  const handleLoad = () => {
    setIsLoaded(true);
    console.log("Chat widget loaded successfully");
  };

  const handleError = () => {
    const error = new Error("Failed to load LeadConnector chat widget");
    console.error("Chat widget error:", error);
  };

  return (
    <>
      <Script
        id="leadconnector-widget"
        src="https://widgets.leadconnectorhq.com/loader.js"
        data-resources-url="https://widgets.leadconnectorhq.com/chat-widget/loader.js"
        data-widget-id={widgetId}
        onLoad={handleLoad}
        onError={handleError}
        strategy="afterInteractive"
      />
    </>
  );
}

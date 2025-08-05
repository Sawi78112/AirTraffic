import Script from "next/script";

interface GHLChatBotProps {
  widgetId: string;
  loaderUrl: string;
  chatWidgetUrl: string;
}

export function GHLChatBot(props: GHLChatBotProps) {
  return (
    <Script
      id="leadconnector-widget"
      src={props.loaderUrl}
      data-resources-url={props.chatWidgetUrl}
      data-widget-id={props.widgetId}
      strategy="afterInteractive"
    />
  );
}

"use client";

import { useState } from "react";
import { Oval } from "react-loader-spinner";

import { ScrollArea, ScrollBar } from "../ui/scroll-area";
import { Sheet, SheetContent, SheetTrigger } from "../ui/sheet";

type BookingFormProps = {
  children: React.ReactNode;
  iframeUrl: string;
  iframeId: string;
};

export function BookingForm(props: BookingFormProps) {
  const [loading, setLoading] = useState(true);

  return (
    <Sheet>
      <SheetTrigger asChild>{props.children}</SheetTrigger>
      <SheetContent className="">
        {loading && (
          <div className="absolute left-0 top-0 z-10 flex h-full w-full items-center justify-center bg-background">
            <div className="h-fit w-fit text-secondary">
              <Oval height="40" width="40" color="white" ariaLabel="loading" />
            </div>
          </div>
        )}

        <ScrollArea className="h-[560px] w-full overflow-scroll">
          <iframe
            src={props.iframeUrl}
            style={{
              opacity: loading ? 0 : 1,
              width: "100%",
              height: "1300px",
              border: "none",
              overflowX: "hidden",
            }}
            scrolling="no"
            id={props.iframeId}
            onLoad={() => setLoading(false)}
          ></iframe>
          <div className="h-[200px] w-full" />
          <ScrollBar orientation="vertical" />
        </ScrollArea>
      </SheetContent>
    </Sheet>
  );
}

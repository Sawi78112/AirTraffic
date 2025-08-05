import Link from "next/link";
import { ArrowRight } from "lucide-react";

import { lab } from "@/constants/nav-links";

export function LabsPanel() {
  return (
    <div className="min-w-[1100px]">
      <div className="bg-background py-6  text-foreground">
        <div className="mx-auto grid max-w-7xl grid-cols-1 gap-12 px-4 md:grid-cols-2">
          {/* Left Column */}
          <div className="space-y-4">
            {lab.slice(0, 2).map((item, index) => (
              <div
                key={index}
                className="space-y-4 rounded-lg bg-muted p-6 transition-colors"
              >
                <h2 className="font-semibold text-foreground">
                  {item.name}

                </h2>
                <p className="text-muted-foreground text-sm">{item.description}</p>
                <Link
                  href={item.href || ""}
                  className="inline-flex items-center text-sm transition-colors hover:text-primary"
                >
                  {item.cta}
                  <ArrowRight className="ml-2 h-4 w-4" />
                </Link>
              </div>
            ))}
          </div>

          {/* Right Column */}
          <div className="space-y-8 pt-6">
            <div>
              {lab[2] && (
                <>
                  <h3 className="mb-4 text-foreground font-semibold">{lab[2].name}</h3>
                  <p className="mb-4 text-muted-foreground text-sm">{lab[2].description}</p>
                  {lab[2].list && (
                    <div className="flex flex-col gap-2">
                      {lab[2].list.map((item, index) => (
                        <div key={index}>
                          <Link
                            href={item.href}
                            className="block text-sm py-2 transition-colors hover:text-primary"
                          >
                            {item.name}
                          </Link>
                          {index < (lab[2]?.list?.length ?? 0) - 1 && (
                            <hr className="border-border mt-1" />
                          )}
                        </div>
                      ))}
                    </div>
                  )}
                </>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

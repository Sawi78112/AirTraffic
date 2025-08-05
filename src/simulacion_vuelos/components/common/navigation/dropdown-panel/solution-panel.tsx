"use client";

import Image from "next/image";
import Link from "next/link";
import { useState } from "react";
import { 
  ArrowRight,
  Search,
  Bot,
  RefreshCw,
  Palette,
  Users,
  Brain,
  UserCheck,
  BarChart3,
  MessageSquare,
  LineChart,
  Wallet,
  LayoutDashboard,
  UserPlus
} from "lucide-react";

import { solutions } from "@/constants/nav-links";

const iconMap: { [key: string]: any } = {
  search: Search,
  bot: Bot,
  "refresh-cw": RefreshCw,
  palette: Palette,
  users: Users,
  brain: Brain,
  "user-check": UserCheck,
  "line-chart": LineChart,
  "message-square": MessageSquare,
  wallet: Wallet,
  "bar-chart-3": BarChart3,
  "layout-dashboard": LayoutDashboard,
  "user-plus": UserPlus
};

const getIconForItem = (item: any) => {
  return iconMap[item.icon] || Users;
};

export function SolutionPanel() {
  const [activeSolution, setActiveSolution] = useState(solutions[0]);
  const [activeItem, setActiveItem] = useState(solutions[0].list[0]);

  return (
    <div className="min-w-[1100px] bg-background p-8">
      <div className="w-full flex flex-col justify-between gap-6 md:flex-row">
        {/* Solutions Column */}
        <div className="space-y-6 md:w-1/5">
          <h2 className="mb-4 text-sm font-medium text-muted-foreground">Solutions</h2>
          <div className="space-y-1">
            {solutions.map((solution) => (
              <button
                key={solution.name}
                onClick={() => {
                  setActiveSolution(solution);
                  setActiveItem(solution.list[0]);
                }}
                className={`text-sm group flex w-full items-center justify-between rounded-md px-3 py-2 text-left transition-colors hover:bg-accent hover:text-accent-foreground ${
                  activeSolution.name === solution.name ? "bg-accent" : ""
                }`}
              >
                <span>{solution.name}</span>
                <ArrowRight className="h-4 w-4 opacity-0 transition-opacity group-hover:opacity-100" />
              </button>
            ))}
          </div>
        </div>

        {/* Separator */}
        <div className="hidden w-px self-stretch bg-border md:block" />

        {/* List Items Column */}
        <div className="space-y-6 md:w-2/5">
          <h2 className="mb-4 text-sm font-medium text-muted-foreground">
            {activeSolution.name}
          </h2>
          <div className="space-y-1">
            {activeSolution.list.map((item, index) => {
              const Icon = getIconForItem(item);
              return (
                <div key={item.name}>
                  <button
                    onMouseOver={() => setActiveItem(item)}
                    onMouseOut={() => setActiveItem(activeItem)}
                    className={`text-sm text-muted-foreground flex w-full items-center gap-3 h-fit text-left transition-colors hover:text-foreground hover:font-bold ${
                      activeItem.name === item.name ? "text-black dark:text-white font-bold" : ""
                    }`}
                  >

                    <div className={`p-1 rounded-md bg-muted ${activeItem.name === item.name ? "bg-muted/20 border border-border text-foreground" : ""}`}>
                      <Icon className="h-4 w-4" />
                    </div>
                    <span>{item.name}</span>
                  </button>
                  {index < activeSolution.list.length - 1 && (
                    <div className="h-px w-full bg-border my-3" />
                  )}
                </div>
              );
            })}
          </div>
        </div>

        {/* Separator */}
        <div className="hidden w-px self-stretch bg-border md:block" />

        {/* Description Column */}
        <div className="space-y-6 md:w-2/5">
          <h2 className="mb-4 text-sm font-medium text-muted-foreground">
            About
          </h2>
          <div className="space-y-4">
            <div className="relative w-full h-[200px]">
              <Image
                src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67971a3c4f0aeb52025cbb54.webp"
                alt={`Preview of ${activeItem.name}`}
                fill
                className="rounded-lg object-cover"
              />
            </div>
            <h3 className="text-lg font-medium leading-tight">
              {activeItem.name}
            </h3>
            <p className="text-muted-foreground text-sm">{activeItem.description}</p>
            <Link
              href={activeItem.href}
              className="inline-flex items-center text-sm transition-colors hover:text-foreground text-primary"
            >
              Learn more
              <ArrowRight className="ml-2 h-4 w-4" />
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
}

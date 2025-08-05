"use client";

import { useState, useEffect } from "react";
import { ChevronRight, X } from "lucide-react";
import Hamburger from "hamburger-react";

export interface SolutionItem {
  name: string;
  href: string;
  icon: string;
  description: string;
}

export interface SolutionPanel {
  name: string;
  list: SolutionItem[];
}

export interface LabItem {
  name: string;
  description: string;
  cta?: string;
  list?: { name: string; href: string }[];
}

export interface NavLink {
  name: string;
  href?: string;
  menu?: SolutionPanel[] | LabItem[];
}

interface MobileNavigationProps {
  navLinks: NavLink[];
}

export function MobileNavigation({ navLinks }: MobileNavigationProps) {
  const [isOpen, setIsOpen] = useState(false);
  const [activeMenu, setActiveMenu] = useState<NavLink | null>(null);
  const [activeSolutionPanel, setActiveSolutionPanel] =
    useState<SolutionPanel | null>(null);

  const openMenu = (link: NavLink) => {
    setActiveMenu(link);
    setActiveSolutionPanel(null);
  };

  const openSolutionPanel = (panel: SolutionPanel) => {
    setActiveSolutionPanel(panel);
  };

  const goBack = () => {
    if (activeSolutionPanel) {
      setActiveSolutionPanel(null);
    } else if (activeMenu) {
      setActiveMenu(null);
    } else {
      setIsOpen(false);
    } 
  };

  const handleLinkClick = () => {
    setIsOpen(false);
    setActiveMenu(null);
    setActiveSolutionPanel(null);
  };

  useEffect(() => {
    if (isOpen) {
      document.body.style.overflow = "hidden";
    } else {
      document.body.style.overflow = "auto";
    }
  }, [isOpen]);

  return (
    <>
      {/* <button onClick={() => setIsOpen(true)}>Menu</button> */}
      <Hamburger
        toggled={isOpen}
        toggle={() => setIsOpen(!isOpen)}
        size={24}
        color="currentColor"
      />

      {isOpen && (
        <div className="fixed inset-0 h-screen z-[200] overflow-hidden bg-background">
          <div className="flex h-full flex-col">
            <div className="flex items-center justify-between border-b p-4">
              <button onClick={goBack} className="p-2">
                {activeMenu || activeSolutionPanel ? (
                  <ChevronRight className="rotate-180" />
                ) : (
                  <X />
                )}
              </button>
              <h2 className="text-lg font-semibold">
                {activeSolutionPanel
                  ? activeSolutionPanel.name
                  : activeMenu
                    ? activeMenu.name
                    : "Menu"}
              </h2>
              <div className="w-8" /> {/* Spacer for alignment */}
            </div>

            <div className="flex-1 overflow-y-auto">
              {!activeMenu && (
                <ul className="py-2">
                  {navLinks.map((link) => (
                    <li key={link.name} className="border-b last:border-b-0">
                      {link.href ? (
                        <a href={link.href} className="block p-4" onClick={handleLinkClick}>
                          {link.name}
                        </a>
                      ) : (
                        <button
                          onClick={() => openMenu(link)}
                          className="flex w-full items-center justify-between p-4"
                        >
                          {link.name}
                          <ChevronRight className="h-5 w-5" />
                        </button>
                      )}
                    </li>
                  ))}
                </ul>
              )}

              {activeMenu &&
                activeMenu.menu &&
                "list" in activeMenu.menu[0] &&
                !activeSolutionPanel && (
                  <ul className="py-2">
                    {(activeMenu.menu as SolutionPanel[]).map((solution) => (
                      <li
                        key={solution.name}
                        className="border-b last:border-b-0"
                      >
                        <button
                          onClick={() => openSolutionPanel(solution)}
                          className="flex w-full items-center justify-between p-4"
                        >
                          {solution.name}
                          <ChevronRight className="h-5 w-5" />
                        </button>
                      </li>
                    ))}
                  </ul>
                )}

              {activeSolutionPanel && (
                <ul className="py-2">
                  {activeSolutionPanel.list.map((item) => (
                    <li key={item.name} className="border-b last:border-b-0">
                      <a href={item.href} className="block p-4" onClick={handleLinkClick}>
                        <div className="font-semibold">{item.name}</div>
                        <div className="text-sm text-muted-foreground">
                          {item.description}
                        </div>
                      </a>
                    </li>
                  ))}
                </ul>
              )}

              {activeMenu &&
                activeMenu.menu &&
                "description" in activeMenu.menu[0] && (
                  <ul className="py-2">
                    {(activeMenu.menu as LabItem[]).map((item) => (
                      <li key={item.name} className="border-b last:border-b-0">
                        <div className="p-4">
                          <div className="font-semibold">{item.name}</div>
                          <div className="text-sm text-muted-foreground">
                            {item.description}
                          </div>
                          {item.list ? (
                            <ul className="mt-2">
                              {item.list.map((subItem) => (
                                <li key={subItem.name}>
                                  <a
                                    href={subItem.href}
                                    className="block py-1 text-primary"
                                    onClick={handleLinkClick}
                                  >
                                    {subItem.name}
                                  </a>
                                </li>
                              ))}
                            </ul>
                          ) : item.cta ? (
                            <a href="#" className="mt-2 block text-primary" onClick={handleLinkClick}>
                              {item.cta}
                            </a>
                          ) : null}
                        </div>
                      </li>
                    ))}
                  </ul>
                )}
            </div>
          </div>
        </div>
      )}
    </>
  );
}

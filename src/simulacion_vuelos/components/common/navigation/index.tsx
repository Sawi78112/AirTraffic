import Link from "next/link";

import {
  NavigationMenu,
  NavigationMenuContent,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger,
  navigationMenuTriggerStyle,
} from "@/components/ui/navigation-menu";
import { LabsPanel } from "@/components/common/navigation/dropdown-panel/labs-panel";
import { SolutionPanel } from "@/components/common/navigation/dropdown-panel/solution-panel";

import { navLinks, type NavLink } from "@/constants/nav-links";

export function NavBar() {
  return (
    <NavigationMenu className="hidden lg:flex">
      <NavigationMenuList>
        {navLinks.map((item: NavLink) => {
          if (item.menu) {
            return (
              <NavigationMenuItem key={item.name}>
                <NavigationMenuTrigger>{item.name}</NavigationMenuTrigger>
                <NavigationMenuContent>
                  {item.name === "Lab" && <LabsPanel />}
                  {item.name === "Solutions" && <SolutionPanel />}
                </NavigationMenuContent>
              </NavigationMenuItem>
            );
          }

          return (
            <NavigationMenuItem key={item.name}>
              <Link href={item.href} legacyBehavior passHref>
                <NavigationMenuLink className={navigationMenuTriggerStyle()}>
                  {item.name}
                </NavigationMenuLink>
              </Link>
            </NavigationMenuItem>
          );
        })}
      </NavigationMenuList>
    </NavigationMenu>
  );
}

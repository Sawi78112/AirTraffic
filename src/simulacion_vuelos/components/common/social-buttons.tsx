import { SocialIcon } from "react-social-icons";

import config from "@/app/config";

export function SocialButtons() {
  return (
    <>
      {Object.entries(config.socials).map(([key, value]) => (
        <SocialIcon
          url={value}
          key={key}
          href={value}
          target="_blank"
          bgColor="#09d0ef"
          fgColor="#020817"
          style={{ height: 40, width: 40 }}
        />
      ))}
    </>
  );
}

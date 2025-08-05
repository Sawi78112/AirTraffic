import Link from "next/link";
import Image from "next/image";

import { CoAILogo } from "@/components/ui/logo/CoAILogo";
import { footerLinks } from "@/constants/footer-links";
import { SocialButtons } from "@/components/common/social-buttons";

import config from "@/app/config";

export function Footer() {
  return (
    <footer className="border-t border-border bg-background text-sm text-foreground">
      <div className="container border-x border-border pt-16  flex w-full flex-col justify-between gap-y-12 pb-12 sm:flex-row">
        <div className="space-y-12">
          <CoAILogo variant="onBlack" />

          <div className="max-w-[600px] space-y-2">
            <h4 className="text-2xl tracking-tighter">
              {"Let's"} get in touch and {"we'll"} show you how {"we've"} helped
              others with similar problems
            </h4>
            <p className="leading-6 text-muted-foreground">
              We are your partner for AI research and development, regardless of
              your size, expertise, or financial constraints. We will help you
              succeed and always stay one step ahead of the curve.
            </p>
          </div>

          <div className="space-y-2">
            <p>{config.address}</p>
            <p>
              <a href={`tel:${config.phoneNumber}`} className="font-semibold">
                Call Us: {config.phoneNumber}
              </a>
            </p>
          </div>

          <div className="my-2 flex flex-wrap items-center gap-x-2">
            <SocialButtons />
          </div>
        </div>

        <div className="flex flex-col gap-y-10">
          <div className="grid grid-cols-2 gap-x-10">
            {footerLinks.map((link, index) => (
              <FooterLinkGroup
                key={`${link.groupLabel}-${index}`}
                groupLabel={link.groupLabel}
                links={link.sub}
              />
            ))}
          </div>

          <div className="grid-row-2 grid grid-cols-2 gap-4">
            <Image
              alt=""
              src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67a20932aaffd34d444db698.png"
              height={80}
              width={80}
            />
            <Image
              alt=""
              src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67a8e87e4325e137ca596ea6.webp"
              height={80}
              width={80}
            />
            <Image
              alt=""
              src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67a8e889fc7685c6e514b4b6.png"
              height={80}
              width={80}
            />
            <Image
              alt=""
              src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67a8e88b9769a70884615920.webp"
              height={80}
              width={80}
            />
            <Image
              alt=""
              src="https://storage.googleapis.com/msgsndr/SRTw3xlSbwAV7iycIh1t/media/67a8e892232902411c410166.webp"
              height={80}
              width={80}
            />
          </div>
        </div>
      </div>

      <div className="border-t border-border">
        <FooterStrip />
      </div>
    </footer>
  );
}

const FooterLinkGroup = ({
  groupLabel,
  links,
}: {
  groupLabel: string;
  links: { label: string; href: string }[];
}) => (
  <div className="space-y-2 capitalize">
    <FooterHeading>{groupLabel}</FooterHeading>
    <div className="flex flex-col gap-y-2">
      {links.map((link, index) => (
        <Link key={`${link.label}-${index}`} href={link.href}>
          {link.label}
        </Link>
      ))}
    </div>
  </div>
);

const FooterHeading = ({ children }: { children: React.ReactNode }) => (
  <h5 className="font-bold text-muted-foreground">{children}</h5>
);

function FooterStrip() {
  return (
    <div className="container flex flex-col justify-between gap-6 py-7 text-sm text-muted-foreground md:flex-row md:items-center">
      <p>© {new Date().getFullYear()} Clinic of AI. All Rights Reserved.</p>
      <p>Making 🤖 with 💖 for the 🌏</p>
    </div>
  );
}

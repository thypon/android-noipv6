package it.gtd.noipv6.wifi;

import eu.chainfire.libsuperuser.Shell;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class NoIPv6Commands {
    @Getter(lazy = true) private static final NoIPv6Commands instance = new NoIPv6Commands();

    public boolean thenDo() {
        if (Shell.SU.available()) {
            Shell.SU.run("sysctl -w net.ipv6.conf.all.disable_ipv6=1");
            Shell.SU.run("sysctl -w net.ipv6.conf.default.disable_ipv6=1");
            Shell.SU.run("sysctl -w net.ipv6.conf.lo.disable_ipv6=1");

            return true;
        } else {
            return false;
        }
    }
}

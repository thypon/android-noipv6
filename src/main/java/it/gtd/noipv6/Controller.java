package it.gtd.noipv6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import it.gtd.noipv6.wifi.NoIPv6Commands;

public final class Controller extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NoIPv6Commands.getInstance().thenDo();
    }
}

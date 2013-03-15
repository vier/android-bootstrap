package com.donnfelker.android.bootstrap.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import com.donnfelker.android.bootstrap.service.StartupService;

/**
 * Created with IntelliJ IDEA.
 * User: nohono
 * Date: 13. 3. 15.
 * Time: 오후 4:24
 * To change this template use File | Settings | File Templates.
 */
public class StartupReceiver extends BroadcastReceiver{

    public static final String SMS_EXTRA_NAME ="pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, StartupService.class));

        // Get the SMS map from Intent
        Bundle extras = intent.getExtras();

        String messages = "";

        if ( extras != null )
        {
            // Get received SMS array
            Object[] smsExtra = (Object[]) extras.get( SMS_EXTRA_NAME );

            for (Object aSmsExtra : smsExtra) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) aSmsExtra);

                String body = sms.getMessageBody();
                String address = sms.getOriginatingAddress();

                messages += "SMS from " + address + " :\n";
                messages += body + "\n";
            }

            // Display SMS message
            Toast.makeText(context, messages, Toast.LENGTH_SHORT).show();
        }
    }
}

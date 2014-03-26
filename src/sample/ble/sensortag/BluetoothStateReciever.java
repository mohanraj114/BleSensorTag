package sample.ble.sensortag;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import sample.ble.sensortag.utils.BleUtils;

public class BluetoothStateReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final BluetoothAdapter adapter = BleUtils.getBluetoothAdapter(context);
        final Intent gattServiceIntent = new Intent(context, BleSensorsRecordService.class);
        if (adapter != null && adapter.isEnabled()) {
            context.startService(gattServiceIntent);
        } else {
            context.stopService(gattServiceIntent);
        }
    }
}

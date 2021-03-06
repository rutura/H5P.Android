package io.dcloud.feature.apsGt;

import io.dcloud.common.adapter.util.Logger;
import io.dcloud.feature.aps.NotificationReceiver;
import android.content.Context;
import android.content.Intent;

import com.igexin.sdk.PushManager;

public class GTNotificationReceiver extends NotificationReceiver{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		try {
			String _action = intent.getAction();
			if(_action != null) {
				if (_action.equals(Intent.ACTION_BOOT_COMPLETED)) {
					Logger.d("ACTION_BOOT_COMPLETED:开机初始化.");
					PushManager.getInstance().initialize(context.getApplicationContext(), GTNormalPushService.class);
					PushManager.getInstance().registerPushIntentService(context.getApplicationContext(), GTNormalIntentService.class);
				} else {
					super.onReceive(context, intent);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

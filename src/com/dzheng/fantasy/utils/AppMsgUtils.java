package com.dzheng.fantasy.utils;

import static android.text.TextUtils.isEmpty;
import android.app.Activity;
/**
 * toast
 * @author Michael Deng
 *
 */
public class AppMsgUtils {

	/**
	 * 
	 * @param context
	 * 上下文
	 * @param styleSelected
	 * 弹出框颜色 0:红色  1:绿色
	 * @param providedMsg
	 * 弹出信息
	 */
	public static void showAppMsg(Activity context, int styleSelected, String providedMsg) {
        final int priority = AppMsg.PRIORITY_HIGH;
        final CharSequence msg = isEmpty(providedMsg)
                ? new StringBuilder().append(1)
                .append(" ").append(AppMsg.PRIORITY_HIGH).toString()
                : providedMsg;
        final AppMsg.Style style;
        boolean customAnimations = false;
        AppMsg provided = null;
        switch (styleSelected) {
            case 0:
                style = AppMsg.STYLE_ALERT;
                break;
            default:
                style = AppMsg.STYLE_INFO;
                break;
        }
        // create {@link AppMsg} with specify type
        AppMsg appMsg = provided != null ? provided : AppMsg.makeText(context, msg, style);
        appMsg.setPriority(priority);
        if (customAnimations) {
            appMsg.setAnimation(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        appMsg.show();

    }

}

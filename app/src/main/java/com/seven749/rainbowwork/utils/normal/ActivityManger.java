package com.seven749.rainbowwork.utils.normal;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/4/27
 * @description 这是一个活动管理器的工具类
 */
public class ActivityManger {
    private ActivityManger() {};
    public static List<Activity> activities = new ArrayList<>();

    /**
     * 把活动加入
     * @param activity
     */
    public  static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     *  把活动移除
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 结束所有活动
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }
}

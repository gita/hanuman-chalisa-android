package com.nandi.hanuman.chalisa;

/**
 * Created by RadhaKrishna on 25/10/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * A helper class with methods to detect Locale changes and recreate the Activities accordingly.
 */
public class ActivityRecreationHelper {

    private static final Map<String, Locale> localesOnActivities = new HashMap<>();

    private ActivityRecreationHelper(){
    }

    /**
     * Call this method on the Activity onResume. It will recreate the Activity if a Locale change is detected.
     * @param activity
     */
    public static void onResume(Activity activity) {
        Locale previousLocale = localesOnActivities.get(activity.toString());
        boolean shouldRestartActivity = previousLocale != null && !previousLocale.equals(Locale.getDefault());
        if (shouldRestartActivity) {
            recreate(activity, false);
        } else {
            localesOnActivities.put(activity.toString(), Locale.getDefault());
        }
    }

    /**
     * Call this method on the Activity onDestroy.
     * @param activity
     */
    public static void onDestroy(Activity activity) {
        localesOnActivities.remove(activity.toString());
    }

    /**
     * Helper method to recreate the Activity. This method should be called after a Locale change.
     * @param activity the Activity that will be recreated
     * @param animate a flag indicating if the recreation will be animated or not
     */
    public static void recreate(Activity activity, boolean animate) {
        if (animate) {
            Intent restartIntent = new Intent(activity, activity.getClass());

            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                restartIntent.putExtras(extras);
            }
            ActivityCompat.startActivity(
                    activity,
                    restartIntent,
                    ActivityOptionsCompat
                            .makeCustomAnimation(activity, android.R.anim.fade_in, android.R.anim.fade_out)
                            .toBundle()
            );
            activity.finish();
        } else {
            activity.recreate();
        }
    }
}
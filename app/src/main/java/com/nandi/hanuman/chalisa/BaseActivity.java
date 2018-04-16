package com.nandi.hanuman.chalisa;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.nandi.hanuman.chalisa.fragments.MainFragment;
import com.nandi.hanuman.chalisa.fragments.SecondFragment;

/**
 * Created by RadhaKrishna on 10/19/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public int drawableID = 0;
    public String mantraText = "";

    public SectionsPagerAdapter mSectionsPagerAdapter;
    public ImageView flower;
    public ImageView flower1;
    public ImageView flower2;
    public ImageView flower3;
    public ImageView flower4;
    public ImageView flower5;
    public ImageView flower6;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return MainFragment.newInstance(drawableID);
            } else {
                return SecondFragment.newInstance(mantraText);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Bhajan";
                case 1:
                    return "Lyrics";
            }
            return null;
        }
    }

    public void animat() {
        TranslateAnimation tAnimation = new TranslateAnimation(-50, 150, 0, 2100);

        tAnimation.setDuration(2000);
        tAnimation.setRepeatCount(Animation.INFINITE);
        tAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        tAnimation.setFillAfter(true);
        tAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                flower.setVisibility(View.GONE);


            }
        });

        flower.startAnimation(tAnimation);
//        TranslateAnimation tAnimation1 = new TranslateAnimation(0, 30, 0, 2100);
//
//        tAnimation1.setDuration(2070);
//        tAnimation1.setRepeatCount(Animation.INFINITE);
//        tAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
//        tAnimation1.setFillAfter(true);
//        tAnimation1.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                // TODO Auto-generated method stub
//
//                flower1.setVisibility(View.GONE);
//
//
//            }
//        });
//        flower1.startAnimation(tAnimation1);
        TranslateAnimation tAnimation2 = new TranslateAnimation(0, 210, 0, 2100);

        tAnimation2.setDuration(2900);
        tAnimation2.setRepeatCount(Animation.INFINITE);
        tAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        tAnimation2.setFillAfter(true);
        tAnimation2.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                flower2.setVisibility(View.GONE);


            }
        });
        flower2.startAnimation(tAnimation2);
//        TranslateAnimation tAnimation3 = new TranslateAnimation(0, 400, 0, 2100);
//
//        tAnimation3.setDuration(2000);
//        tAnimation3.setRepeatCount(Animation.INFINITE);
//        tAnimation3.setInterpolator(new AccelerateDecelerateInterpolator());
//        tAnimation3.setFillAfter(true);
//        tAnimation3.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                // TODO Auto-generated method stub
//
//                flower3.setVisibility(View.GONE);
//
//
//            }
//        });
//        flower3.startAnimation(tAnimation3);
        TranslateAnimation tAnimation4 = new TranslateAnimation(0, 500, 0, 2100);

        tAnimation4.setDuration(2700);
        tAnimation4.setRepeatCount(Animation.INFINITE);
        tAnimation4.setInterpolator(new AccelerateDecelerateInterpolator());
        tAnimation4.setFillAfter(true);
        tAnimation4.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                flower4.setVisibility(View.GONE);


            }
        });
        flower4.startAnimation(tAnimation4);
//        TranslateAnimation tAnimation5 = new TranslateAnimation(0, 300, 0, 2100);
//
//        tAnimation5.setDuration(2400);
//        tAnimation5.setRepeatCount(Animation.INFINITE);
//        tAnimation5.setInterpolator(new AccelerateDecelerateInterpolator());
//        tAnimation5.setFillAfter(true);
//        tAnimation5.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                // TODO Auto-generated method stub
//
//                flower5.setVisibility(View.GONE);
//
//
//            }
//        });
//        flower5.startAnimation(tAnimation5);
        TranslateAnimation tAnimation6 = new TranslateAnimation(0, 90, 0, 2100);

        tAnimation6.setDuration(2200);
        tAnimation6.setRepeatCount(Animation.INFINITE);
        tAnimation6.setInterpolator(new AccelerateDecelerateInterpolator());
        tAnimation6.setFillAfter(true);
        tAnimation6.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                flower6.setVisibility(View.GONE);


            }
        });
        flower6.startAnimation(tAnimation6);
    }


}

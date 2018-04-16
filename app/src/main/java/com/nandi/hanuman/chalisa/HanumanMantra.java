package com.nandi.hanuman.chalisa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.kobakei.ratethisapp.RateThisApp;
import com.nandi.hanuman.chalisa.fragments.MainFragment;

import java.io.IOException;

/**
 * RadhaKrishna
 */

public class HanumanMantra extends BaseActivity implements MediaPlayer.OnPreparedListener {

    private ImageButton playButton;
    private ImageButton pauseButton;
    private ImageButton stopButton;
    private ImageButton repeatButton;
    private ImageButton repeatButton1;
    private ImageButton repeatButton2;

    private SeekBar seekBar;

    private TabLayout tabs;
    private Toolbar toolbar;
    private ViewPager mViewPager;

    private EditText yourEditText;

    private static MediaPlayer player;
    static Handler handler;
    static Uri audio;
    static boolean canMakeCall = false;
    boolean flag = false;
    boolean flag1 = false;
    boolean flag3 = true;

    int count = 1;
    int maxCount = 1;
    int finalValue = 1;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganeshamantra_demo);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        drawableID = MainFragment.GANESH_JI;
        mantraText = getResources().getString(R.string.my_mantra_new);

        RateThisApp.onCreate(this);
        RateThisApp.showRateDialogIfNeeded(this);

        playButton = (ImageButton) findViewById(R.id.btn1);
        pauseButton = (ImageButton) findViewById(R.id.btn2);
        stopButton = (ImageButton) findViewById(R.id.btn3);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        repeatButton = (ImageButton) findViewById(R.id.btn4);
        repeatButton1 = (ImageButton) findViewById(R.id.btn5);
        repeatButton2 = (ImageButton) findViewById(R.id.btn6);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        flower = (ImageView) findViewById(R.id.flower);
        flower1 = (ImageView) findViewById(R.id.flower1);
        flower2 = (ImageView) findViewById(R.id.flower2);
        flower3 = (ImageView) findViewById(R.id.flower3);
        flower4 = (ImageView) findViewById(R.id.flower4);
        flower5 = (ImageView) findViewById(R.id.flower5);
        flower6 = (ImageView) findViewById(R.id.flower6);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        tabs = (TabLayout) findViewById(R.id.tabs);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabs.setupWithViewPager(mViewPager);
//        animat();

        player = MediaPlayer.create(HanumanMantra.this, R.raw.maruthanandana);
        seekBar.setMax(0);
        seekBar.setMax(player.getDuration());
        yourEditText = (EditText) findViewById(R.id.textView16);
        yourEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


                try {
                    String value = yourEditText.getText().toString();
                    finalValue = new Integer(value).intValue();
                } catch (NumberFormatException e) {
                    finalValue = 1;
                }


                count = 1;
                maxCount = finalValue;

                TextView tr = (TextView) findViewById(R.id.textView1);
                tr.setText(" ");
                flag3 = true;
                yourEditText.setEnabled(true);

                repeatButton1.setEnabled(false);
                repeatButton.setEnabled(false);
                repeatButton2.setEnabled(false);

                seekBar.setMax(player.getDuration());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        if (canMakeCall = true) {
            player.setOnPreparedListener(this);

            handler = new Handler();

            seekBar.setMax(player.getDuration());

            playButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!player.isPlaying()) {
                        player.start();

                        updateSeekBar();
                    }

                }
            });
            repeatButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    count = 1;
                    maxCount = 3;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);

                    repeatButton1.setEnabled(false);
                    repeatButton.setEnabled(false);
                    repeatButton2.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });
            repeatButton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    count = 1;
                    maxCount = 7;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);
                    repeatButton.setEnabled(false);

                    repeatButton1.setEnabled(false);
                    repeatButton2.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });
            repeatButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    count = 1;
                    maxCount = 11;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);
                    repeatButton.setEnabled(false);
                    repeatButton1.setEnabled(false);

                    repeatButton2.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });


            pauseButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    if (player.isPlaying()) {
                        flag1 = true;
                        player.pause();

                    }

                }
            });

            stopButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (player.isPlaying()) {
                        player.stop();


                        seekBar.setProgress(0);

                        seekBar.invalidate();
                        yourEditText.setText("");
                        yourEditText.setEnabled(true);
                        count = 1;
                        TextView tr = (TextView) findViewById(R.id.textView1);
                        tr.setText(" ");
                        repeatButton.setEnabled(true);
                        repeatButton1.setEnabled(true);
                        repeatButton2.setEnabled(true);


                        try {
                            player.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        flag1 = false;
                        seekBar.setProgress(0);

                    }
                }
            });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if (b) {

                        seekChanged(seekBar, i, b);

                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {


                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (count < maxCount) {
                        TextView tr = (TextView) findViewById(R.id.textView1);
                        tr.setText(" " + count);
                        count++;
                        seekBar.setProgress(0);
                        player.seekTo(0);
                        player.start();
                    } else {
                        TextView tr = (TextView) findViewById(R.id.textView1);
                        tr.setText(" " + count);
                        flag3 = false;
                        //player.release();
                        seekBar.setProgress(0);
                        //player.prepareAsync();
                        seekBar.invalidate();
                        yourEditText.setText("");
                        yourEditText.setEnabled(true);

                        repeatButton.setEnabled(true);

                        repeatButton2.setEnabled(true);
                        repeatButton1.setEnabled(true);

                    }
                    //player.stop();

                }
            });
        }
    }


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        playButton.setEnabled(true);
        canMakeCall = true;
    }

    public void seekChanged(SeekBar seekBar, int progress, boolean fromUser) {

        player.seekTo(progress);

    }

    public void updateSeekBar() {

        if (!flag) {
            if (flag3) {
                seekBar.setProgress(player.getCurrentPosition());
                if (!(player.isPlaying()) && !flag1) {
                    seekBar.setProgress(0);

                }
                if (player.isPlaying()) {
                    Runnable notification = new Runnable() {
                        public void run() {

                            updateSeekBar();
                        }
                    };
                    handler.postDelayed(notification, 1500);
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        quit();
    }

    public void quit() {
        quitDialog();
    }

    private void quitDialog() {

        flag = true;
        player.release();
        finish();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.hanumanchalisa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_language) {
            showChangeLangDialog();
            return true;
        }
        if (item.getItemId() == R.id.action_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Hey! Check out this awesome Hanuman Chalisa app - https://play.google.com/store/apps/details?id=com.nandi.hanuman.chalisa";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        if (item.getItemId() == R.id.action_about) {
            String str;
            try {
                str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                PackageManager.NameNotFoundException nameNotFoundException = e;
                str = "1.1";
                nameNotFoundException.printStackTrace();
            }
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.app_name) + " " + str)
                    .setCancelable(false)
                    .setPositiveButton("Try More Apps!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Hanuman");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("OK", null)
                    .show();

        }
        if (item.getItemId() == R.id.action_about_hanuman) {
            Uri uri = Uri.parse("https://hanumanchalisa.net");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language, null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner1 = (Spinner) dialogView.findViewById(R.id.spinner1);

        dialogBuilder.setTitle(getResources().getString(R.string.lang_dialog_title));
        dialogBuilder.setMessage(getResources().getString(R.string.lang_dialog_message));
        dialogBuilder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int langpos = spinner1.getSelectedItemPosition();
                switch(langpos) {
                    case 0: //English
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                        updateViews("en");
                        return;
                    case 1: //Hindi
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "hi").commit();
                        updateViews("hi");
                        return;
                    default: //By default set to english
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                        updateViews("en");
                        return;
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    private void updateViews(String languageCode) {
        Context context = LocaleHelper.setLocale(this, languageCode);
        Resources resources = context.getResources();
        ActivityRecreationHelper.recreate(this, true);
    }

}


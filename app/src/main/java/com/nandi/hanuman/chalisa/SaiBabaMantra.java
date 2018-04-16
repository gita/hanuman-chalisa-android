package com.nandi.hanuman.chalisa;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nandi.hanuman.chalisa.fragments.MainFragment;

import java.io.IOException;

/**
 * RadhaKrishna
 */

public class SaiBabaMantra extends BaseActivity implements MediaPlayer.OnPreparedListener {

    private ImageButton playButton;
    private ImageButton pauseButton;
    private ImageButton stopButton;
    private Button repeatButton;
    private Button repeatButton1;
    private Button repeatButton2;
    private Button repeatButton3;

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

        drawableID = MainFragment.SAI_BABA_JI;
        mantraText = getResources().getString(R.string.my_mantra_new11);

        playButton = (ImageButton) findViewById(R.id.btn1);
        pauseButton = (ImageButton) findViewById(R.id.btn2);
        stopButton = (ImageButton) findViewById(R.id.btn3);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        repeatButton = (Button) findViewById(R.id.btn4);
        repeatButton1 = (Button) findViewById(R.id.btn5);
        repeatButton2 = (Button) findViewById(R.id.btn6);
        repeatButton3 = (Button) findViewById(R.id.btn7);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        flower = (ImageView) findViewById(R.id.flower);
        flower2 = (ImageView) findViewById(R.id.flower2);
        flower4 = (ImageView) findViewById(R.id.flower4);
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
        animat();

        player = MediaPlayer.create(SaiBabaMantra.this, R.raw.hanumanchalisa);
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
                repeatButton3.setEnabled(false);

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
                    maxCount = 11;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);

                    repeatButton1.setEnabled(false);
                    repeatButton.setEnabled(false);
                    repeatButton2.setEnabled(false);
                    repeatButton3.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });
            repeatButton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    count = 1;
                    maxCount = 21;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);
                    repeatButton.setEnabled(false);

                    repeatButton1.setEnabled(false);
                    repeatButton2.setEnabled(false);
                    repeatButton3.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });
            repeatButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    count = 1;
                    maxCount = 51;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);
                    repeatButton.setEnabled(false);
                    repeatButton1.setEnabled(false);

                    repeatButton3.setEnabled(false);
                    repeatButton2.setEnabled(false);


                    seekBar.setMax(player.getDuration());


                }

            });
            repeatButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    count = 1;
                    maxCount = 108;
                    TextView tr = (TextView) findViewById(R.id.textView1);
                    tr.setText(" ");
                    flag3 = true;
                    yourEditText.setEnabled(false);
                    repeatButton.setEnabled(false);
                    repeatButton1.setEnabled(false);
                    repeatButton2.setEnabled(false);
                    repeatButton3.setEnabled(false);


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
                        repeatButton3.setEnabled(true);


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
                        repeatButton3.setEnabled(true);

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


}


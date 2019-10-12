package com.example.ddh;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    ConstraintLayout mSleepLayout;
    ConstraintLayout mWakeLayout;

    EditText mEtDay;
    EditText mEtEve;
    EditText mEtNightAfter;
    EditText mEtNightBefore;
    EditText mEtWake;

    Switch mSleepSwitch;
    Switch mWakeSwitch;
    Switch mWorkSwitch;

    Animation mSlideDown;
    Animation mSlideUp;

    int[] mTime = {-1, -1, -1, -1, -1};
    boolean[] mCheckAlarm = {false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mSleepLayout = findViewById(R.id.con_setting_sleep);
        mWakeLayout = findViewById(R.id.con_setting_wake);

        mEtDay = findViewById(R.id.et_setting_d);
        mEtEve = findViewById(R.id.et_setting_e);
        mEtNightAfter = findViewById(R.id.et_setting_n_after);
        mEtNightBefore = findViewById(R.id.et_setting_n_before);
        mEtWake = findViewById(R.id.et_setting_wake);

        mSleepSwitch = findViewById(R.id.switch_setting_sleep);
        mWakeSwitch = findViewById(R.id.switch_setting_wake);
        mWorkSwitch = findViewById(R.id.switch_setting_work);

        mSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        mSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);


        class sleepSwitchListener implements CompoundButton.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    mCheckAlarm[0] = true;
                } else {
                    mCheckAlarm[0] = false;
                }

            }
        }

        class wakeSwitchListener implements CompoundButton.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    mCheckAlarm[1] = true;
                } else {
                    mCheckAlarm[1] = false;
                }

            }
        }

        class workSwitchListener implements CompoundButton.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    mCheckAlarm[2] = true;
                } else {
                    mCheckAlarm[2] = false;
                }

            }
        }

        mSleepSwitch.setOnCheckedChangeListener(new sleepSwitchListener());
        mWakeSwitch.setOnCheckedChangeListener(new wakeSwitchListener());
        mWorkSwitch.setOnCheckedChangeListener(new workSwitchListener());
    }

    public void SettingOnClick(View view){
        switch (view.getId()) {
            case R.id.bt_setting_sleep:
                if(mSleepLayout.getVisibility() == View.GONE){

                    Transition transition = new Fade();
                    transition.setDuration(600);
                    transition.addTarget(mSleepLayout);

                    TransitionManager.beginDelayedTransition(mSleepLayout, transition);
                    mSleepLayout.setVisibility(View.VISIBLE);
                } else {
                    mSleepLayout.setVisibility(View.GONE);
                }
                break;

            case R.id.bt_setting_wake:
                if(mWakeLayout.getVisibility() == View.GONE){
                    Transition transition = new Fade();
                    transition.setDuration(600);
                    transition.addTarget(mWakeLayout);

                    TransitionManager.beginDelayedTransition(mWakeLayout, transition);
                    mWakeLayout.setVisibility(View.VISIBLE);
                } else {
                    mWakeLayout.setVisibility(View.GONE);
                }
                break;

            default:
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent resultIntent = new Intent();
        if(!mEtDay.equals("")){
            mTime[0] = Integer.parseInt(mEtDay.getText().toString());
        }
        if(!mEtEve.equals("")){
            mTime[1] = Integer.parseInt(mEtEve.getText().toString());
        }
        if(!mEtNightBefore.equals("")){
            mTime[2] = Integer.parseInt(mEtNightBefore.getText().toString());
        }
        if(!mEtNightAfter.equals("")){
            mTime[3] = Integer.parseInt(mEtNightAfter.getText().toString());
        }
        if(!mEtWake.equals("")){
            mTime[4] = Integer.parseInt(mEtWake.getText().toString());
        }

        resultIntent.putExtra("time", mTime);
        resultIntent.putExtra("check", mCheckAlarm);
        setResult(RESULT_OK, resultIntent);
        finish();

    }
}

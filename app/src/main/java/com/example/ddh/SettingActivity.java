package com.example.ddh;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    ConstraintLayout mSleepLayout;
    ConstraintLayout mWakeLayout;

    EditText mEtDay;
    EditText mEtEve;
    EditText mEtNightAfter;
    EditText mEtNightBefore;
    EditText mEtWake;

    int[] time = {-1, -1, -1, -1, -1};
    boolean[] checkAlame = {false, false, false};


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
    }

    public void SettingOnClick(View view){
        switch (view.getId()) {
            case R.id.bt_setting_sleep:
                if(mSleepLayout.getVisibility() == View.GONE){
                    mSleepLayout.setVisibility(View.VISIBLE);
                } else {
                    mSleepLayout.setVisibility(View.GONE);
                }
                break;

            case R.id.bt_setting_wake:
                if(mWakeLayout.getVisibility() == View.GONE){
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
    }
}

package com.example.ddh;

import android.content.Intent;

import android.os.Bundle;


import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.ImageView;


import android.widget.TextView;

import com.example.ddh.MaterialCalendarDecorator.DayDecorator;
import com.example.ddh.MaterialCalendarDecorator.EveningDecorator;
import com.example.ddh.MaterialCalendarDecorator.NightDecorator;
import com.example.ddh.MaterialCalendarDecorator.OffDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout clBtnDuties;

    private MaterialCalendarView calendarView;
    private ImageButton btnDay, btnEvening, btnNight, btnOff;
    private TextView tvSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clBtnDuties = findViewById(R.id.clDuties);
        btnDay = findViewById(R.id.btnDay);
        btnEvening = findViewById(R.id.btnEvening);
        btnNight = findViewById(R.id.btnNight);
        btnOff = findViewById(R.id.btnOff);
        tvSetting = findViewById(R.id.tvSetting);

        tvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

        calendarView = findViewById(R.id.calendarView);

        calendarView.state().edit()
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull final CalendarDay date, boolean selected) {
                clBtnDuties.setVisibility(View.VISIBLE);
                // 버튼 클릭 리스너 처리
                final Button.OnClickListener onClickListener = new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()){
                            case R.id.btnDay:
                                calendarView.addDecorator(new DayDecorator(MainActivity.this, date));
                                break;
                            case R.id.btnEvening:
                                calendarView.addDecorator(new EveningDecorator(MainActivity.this, date));
                                break;
                            case R.id.btnNight:
                                calendarView.addDecorator(new NightDecorator(MainActivity.this, date));
                                break;
                            case R.id.btnOff:
                                calendarView.addDecorator(new OffDecorator(MainActivity.this, date));
                                break;
                        }
                    }
                };
                btnDay.setOnClickListener(onClickListener);
                btnEvening.setOnClickListener(onClickListener);
                btnNight.setOnClickListener(onClickListener);
                btnOff.setOnClickListener(onClickListener);
            }
        });

        TextView btnMy = findViewById(R.id.tvSetting);
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

        ImageView btnCheckList = findViewById(R.id.btn_check_list);
        ImageView btnOffMatch = findViewById(R.id.btn_off_matching);

        btnCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CheckListActivity.class));
            }
        });
        btnOffMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OffMatchingActivity.class));
            }
        });

    }

}

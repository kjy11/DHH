package com.example.ddh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.tmall.ultraviewpager.UltraViewPager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;


public class OffMatchingActivity extends AppCompatActivity {

    private OffMatchingAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView weekCalendar;

    private TextView ymwTxtView;
    private ImageView btnLeft, btnRight;

    private String mStrWeek;

    private int mYear = 0;
    private int mMonth = 0;
    private int mDay = 0;
    private int mDayNum = 0;
    private int mWeek = 0;
    private int mCurPos = 0;
    private int mStartDayNum = 0;

    private Vector<Week> weeks;

    private int mEnd = 0;

    private GregorianCalendar mCalendar;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat monthFormat;
    private SimpleDateFormat yearFormat;
    private SimpleDateFormat cdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_matching);

        Date date = new Date();

        weekCalendar = findViewById(R.id.daysRecyclerView);
        ymwTxtView = findViewById(R.id.ymwTxtView);
        btnLeft = findViewById(R.id.imgLeft);
        btnRight = findViewById(R.id.imgRight);

        cdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
        dayFormat = new SimpleDateFormat("dd", Locale.KOREA);
        monthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        yearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        mCalendar = new GregorianCalendar(Locale.KOREA);

        try {
            bottomTab(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UltraViewPager viewPager = findViewById(R.id.vpImage);
        viewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        OffMatchingViewPagerAdapter vpAdapter = new OffMatchingViewPagerAdapter(this);

        vpAdapter.addItem(getDrawable(R.drawable.everland));
        vpAdapter.addItem(getDrawable(R.drawable.coffee));
        vpAdapter.addItem(getDrawable(R.drawable.classic));

        viewPager.setAdapter(vpAdapter);
    }

    private void bottomTab(Date date) throws ParseException {
        String today = cdf.format(date);
        String startDate = "2019-10-13";
        mEnd = Integer.parseInt(today.replace("-", ""));
        initCalendar(startDate, today);
    }

    private int calcDateBetweenEndAndStart(String end, String start) throws ParseException {
        Date endDate = cdf.parse(end);
        Date startDate = cdf.parse(start);
        String[] ymd = start.split("-");
        GregorianCalendar mCal = new GregorianCalendar();
        mCal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1])+1, Integer.parseInt(ymd[2]));
        mStartDayNum = mCal.get(Calendar.DAY_OF_WEEK);
        Long diff = endDate.getTime() - startDate.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        Log.e("날짜차이", String.valueOf(diffDays));
        return diffDays + 1;

    }

    private void initCalendar(String startDate, String today) throws ParseException {
        Log.e("startDate", startDate);
        Log.e("today", today);

        int diff = calcDateBetweenEndAndStart(today, startDate);
        mLayoutManager = new LinearLayoutManager(OffMatchingActivity.this, LinearLayoutManager.HORIZONTAL, false);
        weekCalendar = findViewById(R.id.daysRecyclerView);
        weekCalendar.setLayoutManager(mLayoutManager);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(weekCalendar);

        mYear = mCalendar.get(Calendar.YEAR);
        mMonth = mCalendar.get(Calendar.MONTH) + 1;
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
        mWeek = mCalendar.get(Calendar.WEEK_OF_MONTH);
        mDayNum = mCalendar.get(Calendar.DAY_OF_WEEK);
        mStrWeek = getStrWeek(mWeek);
        mCalendar.set(mYear, mMonth, mDay);

        String thisWeek = String.valueOf(mYear) + ". " + String.valueOf(mMonth);
        ymwTxtView.setText(thisWeek);
        Vector<Day> days = new Vector<>();
        Calendar calendar = Calendar.getInstance();

        for(int i=-((mStartDayNum)+diff);i<(7-mDayNum);i++){
            calendar.set(mYear, mMonth-1, mDay+i);
            Date date1 = calendar.getTime();
            days.add(new Day(yearFormat.format(date1), monthFormat.format(date1), dayFormat.format(date1)));
        }
        weeks = new Vector();
        for(int j=0;j<(days.size()/7);j++){
            weeks.add(new Week(days.get(7*j), days.get(7*j+1)
                    ,days.get(7*j+2), days.get(7*j+3), days.get(7*j+4),
                    days.get(7*j+5), days.get(7*j+6)));
        }

        mCurPos = weeks.size() - 1;
        mAdapter = new OffMatchingAdapter(this, weeks, today, startDate);
        weekCalendar.setAdapter(mAdapter);
        weekCalendar.scrollToPosition(mCurPos);
        mAdapter.notifyDataSetChanged();

        Vector<Day> dayss = new Vector<>();

        dayss.add(weeks.get(mCurPos).getDay1());
        dayss.add(weeks.get(mCurPos).getDay2());
        dayss.add(weeks.get(mCurPos).getDay3());
        dayss.add(weeks.get(mCurPos).getDay4());
        dayss.add(weeks.get(mCurPos).getDay5());
        dayss.add(weeks.get(mCurPos).getDay6());
        dayss.add(weeks.get(mCurPos).getDay7());

    }

    private String getStrWeek(int intWeek){
        String strWeek;
        switch (intWeek){
            case 1:
                strWeek = "첫째주";
                break;
            case 2:
                strWeek = "둘째주";
                break;
            case 3:
                strWeek = "셋째주";
                break;
            case 4:
                strWeek = "넷째주";
                break;
            case 5:
                strWeek = "다섯째주";
                break;
            default:
                strWeek = "";
        }
        return strWeek;
    }

}

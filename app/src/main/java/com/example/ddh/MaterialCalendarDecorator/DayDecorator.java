package com.example.ddh.MaterialCalendarDecorator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.ddh.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.Objects;

public class DayDecorator implements DayViewDecorator{

    private final Calendar calendar = Calendar.getInstance();
    private CalendarDay date;
    private Context context;

    public DayDecorator(Context context, CalendarDay date){
        this.context = context;
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day){
        return day == date;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(Objects.requireNonNull(context.getDrawable(R.drawable.day)));
    }
}

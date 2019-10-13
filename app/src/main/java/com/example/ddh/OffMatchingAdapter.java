package com.example.ddh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class OffMatchingAdapter extends RecyclerView.Adapter<OffMatchingAdapter.MainViewHolder> {

    private Vector<Week> weeks;
    private Context context;
    private String today;
    private String startDay;

    private int iToday = 0;
    private int iStartDay = 0;

    private ArrayList<TextView> tvs;

    public class MainViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvSun;
        protected TextView tvMon;
        protected TextView tvTues;
        protected TextView tvWed;
        protected TextView tvThur;
        protected TextView tvFri;
        protected TextView tvSat;

        public MainViewHolder(@NonNull View view) {
            super(view);
            this.tvSun = view.findViewById(R.id.sunTxtView);
            this.tvMon = view.findViewById(R.id.monTxtView);
            this.tvTues = view.findViewById(R.id.tueTxtView);
            this.tvWed = view.findViewById(R.id.wedTxtView);
            this.tvThur = view.findViewById(R.id.thuTxtView);
            this.tvFri = view.findViewById(R.id.friTxtView);
            this.tvSat = view.findViewById(R.id.satTxtView);
            final View mView = view;
        }
    }

    public OffMatchingAdapter(Context context, Vector<Week> weeks, String today, String startDay) {
        this.weeks = weeks;
        this.today = today;
        this.startDay = startDay;
        this.iToday = Integer.parseInt(today.replace("-",""));
        this.iStartDay = Integer.parseInt(startDay.replace("-",""));
        this.context = context;
    }

    @NonNull
    @Override
    public OffMatchingAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_day, viewGroup, false);

        MainViewHolder viewHolder = new MainViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OffMatchingAdapter.MainViewHolder viewHolder, int position) {
        Week week = weeks.get(position);

        viewHolder.tvSun.setText(week.getDay1().getDay());
        viewHolder.tvMon.setText(week.getDay2().getDay());
        viewHolder.tvTues.setText(week.getDay3().getDay());
        viewHolder.tvWed.setText(week.getDay4().getDay());
        viewHolder.tvThur.setText(week.getDay5().getDay());
        viewHolder.tvFri.setText(week.getDay6().getDay());
        viewHolder.tvSat.setText(week.getDay7().getDay());

    }

    @Override
    public int getItemCount() {

        return weeks.size();
    }
    public String todays(int pos1, int pos2){
        Week week = weeks.get(pos1);
        Day day = null;
        switch (pos2){
            case 0:
                day = week.getDay1();
                break;
            case 1:
                day = week.getDay2();
                break;
            case 2:
                day = week.getDay3();
                break;
            case 3:
                day = week.getDay4();
                break;
            case 4:
                day = week.getDay5();
                break;
            case 5:
                day = week.getDay6();
                break;
            case 6:
                day = week.getDay7();
                break;
        }
        return day.getYear() + "-" + day.getMonth() + "-" + day.getDay();

    }
}

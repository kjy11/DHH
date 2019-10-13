package com.example.ddh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ddh.service.OffMatchingItem;

import java.util.ArrayList;

public class OffMatchingViewPagerAdapter extends PagerAdapter {

    private Context context = null;
    private ArrayList<OffMatchingItem> mList = new ArrayList<>();

    public OffMatchingViewPagerAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        View view = null;
        if(context != null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_image, container, false);
            ImageView imageView = view.findViewById(R.id.imgVp);

            OffMatchingItem item = mList.get(position);

            imageView.setImageDrawable(item.getImg_festival());

            container.addView(view);

        }
        return view;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    public void addItem(Drawable image){

        OffMatchingItem item = new OffMatchingItem(image);

        mList.add(item);

    }
}

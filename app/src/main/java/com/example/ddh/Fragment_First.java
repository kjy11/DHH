package com.example.ddh;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment_First extends Fragment {
    ViewPager viewPager;

    public Fragment_First(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ListView listview;
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Adapter 생성
        CustomChoiceListViewAdapter adapter = new CustomChoiceListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem("암막커튼");
        // 두 번째 아이템 추가.
        adapter.addItem("수면배개");
        adapter.addItem("아로마향");
        adapter.addItem("바디필로우");
        adapter.addItem("수면안대");
        adapter.addItem("가습기");



        return view;

    }

}
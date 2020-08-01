package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class DayView extends FrameLayout {

    private  DayModel dayModel;

    public DayView(Context context,DayModel dayModel) {
        super(context);
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view  =layoutInflater.inflate(R.layout.fragment_day_view,null);
        Button btn= (Button) view.findViewById(R.id.buttonDay);
        btn.setText(dayModel.getDateData());
        this.addView(view);
        this.setPadding(5,5,5,5);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public DayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DayView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View view = inflater.inflate(R.layout.fragment_day_view, container, false);
//        Button btn= (Button) view.findViewById(R.id.buttonDay);
//        btn.setText(dayModel.getDateData());
//        return view;
//    }
}
package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    public final String TAG = "Log";
    private GridLayout mothView;
    private View dayView;

    private int yearNow,mothNow,dayNow;

    public  MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        yearNow=2020;
        mothNow=8;
        dayNow=1;

        innitView();
        loadDay();

    }

    private void loadDay(){


        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        int halfScreenWidth = (int)(screenWidth /7);
        int quarterScreenWidth = (int)(halfScreenWidth * 0.5);

        LocalDate localDate=null;
        // Find the day from the local date
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            Date date=new Date();
            localDate = LocalDate.of(yearNow,mothNow, dayNow);
            DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
            Calendar calendar = Calendar.getInstance();
            int firstDayOfWeek=calendar.getFirstDayOfWeek()-1;
            int dayOfWeekValue=dayOfWeek.getValue();

            int adddays= firstDayOfWeek-dayOfWeekValue;

            if(adddays>0)
                adddays-=7;

            SimpleDateFormat sdf = new SimpleDateFormat("dd");

            for (int i = 0; i < mothView.getRowCount(); i++) {
                GridLayout.Spec rowSpec = GridLayout.spec(i, 1, GridLayout.FILL);

                for (int j = 0; j < mothView.getColumnCount(); j++) {

                    GridLayout.Spec colSpec = GridLayout.spec(j, 1, GridLayout.FILL);

                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(Calendar.DATE,adddays++);

                    DayModel dayModel = new DayModel();
                    dayModel.setDateData("" +sdf.format(calendar2.getTime()));
                    dayModel.setIDColum(i);
                    dayModel.setIDRow(j);
                    DayView dayView = new DayView(this, dayModel);
                    dayView.setMinimumWidth(0);

                    GridLayout.LayoutParams myGLP = new GridLayout.LayoutParams();
                    myGLP.rowSpec = rowSpec;
                    myGLP.columnSpec = colSpec;
                    myGLP.width=halfScreenWidth;
                    myGLP.height=halfScreenWidth;
                    myGLP.setGravity(Gravity.CENTER);

                    mothView.addView(dayView,myGLP);
                }
            }
        }







    }

    private void innitView() {

//        LayoutInflater layoutInflater= (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
//        dayView=layoutInflater.inflate(R.layout.fragment_day_view,null);

        mothView = findViewById(R.id.mothView);
        mothView.setColumnCount(7);
        mothView.setRowCount(6);
        mothView.setFitsSystemWindows(true);




    }
}
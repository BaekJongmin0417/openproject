package opensourceteamproject.calendar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SchedulingActivity extends AppCompatActivity {
    FloatingActionButton btn_RegisterS,btn_CancelS;
    Switch btn_dDay,btn_allDay;
    TimePicker btn_startTime,btn_endTime;
    DatePicker btn_date;
    ToggleButton btn_calendar;
    Spinner btn_group;
    LinearLayout show_allDay,show_startTime,show_endTime,show_calendar,show_group;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduling);

        Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        btn_RegisterS=(FloatingActionButton)findViewById(R.id.RegisterS);
        btn_RegisterS.setOnClickListener(RegisterSClickListener);
        btn_CancelS=(FloatingActionButton)findViewById(R.id.CancelS);
        btn_CancelS.setOnClickListener(CancelSClickListener);

        //일정 생성
        btn_dDay=(Switch)findViewById(R.id.select_dDay);
        btn_date=(DatePicker)findViewById(R.id.select_date);
        btn_allDay=(Switch)findViewById(R.id.select_allDay);
        btn_startTime=(TimePicker) findViewById(R.id.select_startTime);
        btn_endTime=(TimePicker) findViewById(R.id.select_endTime);
        btn_calendar=(ToggleButton)findViewById(R.id.select_calendar);
        btn_group=(Spinner)findViewById(R.id.select_group);

        show_allDay=(LinearLayout)findViewById(R.id.list_allDay);
        show_startTime=(LinearLayout)findViewById(R.id.list_startTime);
        show_endTime=(LinearLayout)findViewById(R.id.list_endTime);
        show_calendar=(LinearLayout)findViewById(R.id.list_calendar);
        show_group=(LinearLayout)findViewById(R.id.list_group);


        btn_date.getDayOfMonth(); //일, 정수형
        btn_date.getMonth(); //월, 정수형
        btn_date.getYear(); //년, 정수형

        btn_dDay.setOnClickListener(btn_dDayClickListener);
        btn_allDay.setOnClickListener(btn_allDayClickListener);
        btn_calendar.setOnClickListener(btn_CalendarClickListener);

        /*int scheduleYear=btn_date.getYear();
        int scheduleMonth=btn_date.getMonth()+1;
        int scheduleDay=btn_date.getDayOfMonth();
        int startHour=btn_startTime.getHour();
        int startMinute=btn_startTime.getMinute();
        int endHour=btn_endTime.getHour();
        int endMinute=btn_endTime.getMinute();*/


        final String[] Group={"오픈소스","데베","컴그"};
        ArrayAdapter<String> adapter_group=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Group);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        btn_group.setAdapter(adapter_group);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater=getMenuInflater();
        mInflater.inflate(R.menu.menu,menu);
        return true;
    }
    View.OnClickListener RegisterSClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Toast.makeText(getApplicationContext(),"새로운 일정이 생성되었습니다.",Toast.LENGTH_SHORT).show();

            finish();
        }
    };
    View.OnClickListener CancelSClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_SHORT).show();
            finish();
        }
    };
    View.OnClickListener btn_dDayClickListener=new View.OnClickListener(){
        public void onClick(View v){
            btn_allDay.setChecked(true);
            show_startTime.setVisibility(View.GONE);
            show_endTime.setVisibility(View.GONE);
            btn_calendar.setChecked(true);
            show_group.setVisibility(View.GONE);
            if(btn_dDay.isChecked()){ //디데이 on할 경우 - 개인(default), 그룹 일정 생성
                show_allDay.setVisibility(View.GONE);
                show_calendar.setVisibility(View.VISIBLE);
            }
            else{ //디데이 off할 경우 - 일반 일정 생성
                show_allDay.setVisibility(View.VISIBLE);
                show_calendar.setVisibility(View.GONE);
            }
        }
    };
    View.OnClickListener btn_allDayClickListener=new View.OnClickListener(){ // 디데이 off일 때
        public void onClick(View v){
            if(btn_allDay.isChecked()){ // 하루종일 on할 경우
                show_startTime.setVisibility(View.GONE);
                show_endTime.setVisibility(View.GONE);
            }
            else{ // 하루종일 on할 경우
                show_startTime.setVisibility(View.VISIBLE);
                show_endTime.setVisibility(View.VISIBLE);
            }
        }
    };
    View.OnClickListener btn_CalendarClickListener=new View.OnClickListener(){ // 디데이 on일 때
        public void onClick(View v){
            if(btn_calendar.isChecked()){ // 캘린더 종류 개인인 경우
                show_group.setVisibility(View.GONE);
            }
            else{ // 캘린더 종류 그룹인 경우
                show_group.setVisibility(View.VISIBLE);
            }
        }
    };
}

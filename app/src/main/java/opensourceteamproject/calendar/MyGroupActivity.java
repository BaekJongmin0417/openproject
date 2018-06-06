package opensourceteamproject.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MyGroupActivity extends AppCompatActivity {
    Button btn_mySelf;
    FloatingActionButton btn_MakeS;

    ToggleButton btn_calendar;

    ArrayList<Data> instanceList = new ArrayList<>();
    ArrayList<Data> instanceList1 = new ArrayList<>();
    ArrayList<Data_Group> instance = new ArrayList<>();
    Data data_container1,data_container2,data_container3;
    Data_Group data_container0,data_container00;
    DataAdapter_MyGroup dataAdapter;
    ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygroup);

        Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.rgb(93,181,164));
        toolbar.setTitleTextColor(Color.WHITE);

        btn_mySelf=(Button)findViewById(R.id.mySelf);
        btn_mySelf.setOnClickListener(btn_mySelfClickListener);
        btn_MakeS=(FloatingActionButton)findViewById(R.id.MakeS);
        btn_MakeS.setOnClickListener(MakeSClickListener);

        btn_MakeS.setRippleColor(Color.rgb(93,181,164));

        btn_calendar=(ToggleButton)findViewById(R.id.select_calendar);

        initListView();
    }

    public void initListView() {
        data_container1=new Data("D-10","오픈소스","2018/06/11");
        data_container2=new Data("D-100","데베","2018/06/11");
        data_container3=new Data("D-1000","가나다라마바사아자차카타파하","2018/06/11");
        instanceList.add(data_container1);instanceList.add(data_container2);instanceList.add(data_container3);

        data_container0=new Data_Group("그룹1",instanceList);
        data_container00=new Data_Group("그룹2",instanceList1);
        instance.add(data_container0);instance.add(data_container00);

        dataAdapter = new DataAdapter_MyGroup(this, instance);

        listView = (ExpandableListView) findViewById(R.id.list_myGroup);
        listView.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater=getMenuInflater();
        mInflater.inflate(R.menu.menu,menu);
        return true;
    }
    View.OnClickListener btn_mySelfClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent(getApplicationContext(),MySelfActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener MakeSClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent(getApplicationContext(),Scheduling_MyGroup.class);
            startActivity(intent);
        }
    };
}

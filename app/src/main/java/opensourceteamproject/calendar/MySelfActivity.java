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
import android.widget.ListView;

import java.util.ArrayList;

public class MySelfActivity extends AppCompatActivity{
    Button btn_myGroup;
    FloatingActionButton btn_MakeS;

    ArrayList<Data> instanceList = new ArrayList<>();
    Data data_container1,data_container2,data_container3;
    DataAdapter_MySelf dataAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myself);
        setTitle("Calendar");

        Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.rgb(93,181,164));
        toolbar.setTitleTextColor(Color.WHITE);

        btn_myGroup=(Button)findViewById(R.id.myGroup);
        btn_myGroup.setOnClickListener(btn_myGroupClickListener);
        btn_MakeS=(FloatingActionButton)findViewById(R.id.MakeS);
        btn_MakeS.setOnClickListener(MakeSClickListener);

        btn_MakeS.setRippleColor(Color.rgb(93,181,164));

        initListView();
    }

    public void initListView() {
        data_container1=new Data("D-10","오픈소스","2018/06/11");
        data_container2=new Data("D-100","데베","2018/06/11");
        data_container3=new Data("D-1000","가나다라마바사아자차카타파하","2018/06/11");
        instanceList.add(data_container1);instanceList.add(data_container2);instanceList.add(data_container3);
        dataAdapter = new DataAdapter_MySelf(this, instanceList);
        listView = (ListView) findViewById(R.id.list_mySelf);
        listView.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater=getMenuInflater();
        mInflater.inflate(R.menu.menu,menu);
        return true;
    }
    View.OnClickListener btn_myGroupClickListener=new android.view.View.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent(getApplicationContext(),MyGroupActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener MakeSClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent(getApplicationContext(),Scheduling_MySelf.class);
            startActivity(intent);
        }
    };

}

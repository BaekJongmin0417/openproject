package opensourceteamproject.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyGroupActivity extends AppCompatActivity {
    Button btn_mySelf;
    FloatingActionButton btn_MakeS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygroup);


        Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        btn_mySelf=(Button)findViewById(R.id.mySelf);
        btn_mySelf.setOnClickListener(btn_mySelfClickListener);
        btn_MakeS=(FloatingActionButton)findViewById(R.id.MakeS);
        btn_MakeS.setOnClickListener(MakeSClickListener);

        //그룹 일정
        final String[] myGroupData={"오픈소스","데베","컴그"};//sample

        ListView myGroupList=(ListView)findViewById(R.id.list_myGroup);

        ArrayAdapter<String> adapter_myGroupList=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myGroupData);
        myGroupList.setAdapter(adapter_myGroupList);
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
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener MakeSClickListener=new View.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent(getApplicationContext(),SchedulingActivity.class);
            startActivity(intent);
        }
    };
}

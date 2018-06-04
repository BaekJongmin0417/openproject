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

public class MainActivity extends AppCompatActivity{
    Button btn_myGroup;
    FloatingActionButton btn_MakeS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myself);
        setTitle("Calendar");

        Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        btn_myGroup=(Button)findViewById(R.id.myGroup);
        btn_myGroup.setOnClickListener(btn_myGroupClickListener);
        btn_MakeS=(FloatingActionButton)findViewById(R.id.MakeS);
        btn_MakeS.setOnClickListener(MakeSClickListener);

        //개인 일정
        final String[] mySelfData={"오픈소스","데베","컴그"};//sample

        ListView mySelfList=(ListView)findViewById(R.id.list_mySelf);

        ArrayAdapter<String> adapter_mySelfList=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mySelfData);
        mySelfList.setAdapter(adapter_mySelfList);
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
            Intent intent=new Intent(getApplicationContext(),SchedulingActivity.class);
            startActivity(intent);
        }
    };

}

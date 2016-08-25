package gpslocation.wonho.example.com.postmetest;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gpslocation.wonho.example.com.postmetest.Fragment.CubbyholeFrament;
import gpslocation.wonho.example.com.postmetest.Fragment.MapFragment;
import gpslocation.wonho.example.com.postmetest.Fragment.HistoryFragment;
import gpslocation.wonho.example.com.postmetest.Fragment.SettingFragment;

public class TabActivity extends AppCompatActivity {

    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_tab);
        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);                     //프레그먼트 탭호스트 정의
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);  //.setup(context, Manager, layout)

        tabHost.addTab(tabHost.newTabSpec("di1").setIndicator("지도")
                ,MapFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("id2").setIndicator("히스토리")
                ,HistoryFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("id3").setIndicator("보관함")
                ,CubbyholeFrament.class, null);

        tabHost.addTab(tabHost.newTabSpec("id4").setIndicator("설정")
                ,SettingFragment.class, null);
    }
}
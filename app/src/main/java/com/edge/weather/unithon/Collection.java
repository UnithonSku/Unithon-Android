package com.edge.weather.unithon;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

//필요한 정보 =====> 캐릭터 이미지,설명
public class Collection extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        listView = (ListView)findViewById(R.id.collection_listView);
        datasetting();
    }
    public void datasetting(){
        CollectionViewAdapter customViewAdapter = new CollectionViewAdapter();
       for(int i=0;i<3;i++) {
           customViewAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_launcher_background));

       }
        listView.setAdapter(customViewAdapter);

    }
}



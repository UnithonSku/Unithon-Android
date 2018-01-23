package com.edge.weather.unithon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView userimage,userimagethink;
    Button newtodo;
    ListView listView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userimage = (ImageView)findViewById(R.id.userimage);

        //캐릭터 말풍선 이미지뷰
        userimagethink = (ImageView)findViewById(R.id.userimagethink);
        newtodo = (Button)findViewById(R.id.Newtodo) ;
        listView = (ListView)findViewById(R.id.list_view);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);




        //GIF 파일 넣는 코드
        GlideDrawableImageViewTarget Userimage = new GlideDrawableImageViewTarget(userimage);
        Glide.with(this).load(R.drawable.yawoori).into(Userimage);

        userimagethink.setImageResource(R.drawable.thinking);


        progressBar.setProgress(50);




        //할일 추가하기 버튼 클릭시 발생 이벤트 커스텀 리스트 뷰 한 아이템 추가!
        newtodo.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                toDOViewAdapter toDOViewAdapter = new toDOViewAdapter();
                toDOViewAdapter.addItem("This is title");
                listView.setAdapter(toDOViewAdapter);

                //다른 액티비티로 가즈아~~~
                //startActivityForResult(new Intent(MainActivity.this,AddtoDo.class));

            }


        });
    }

}
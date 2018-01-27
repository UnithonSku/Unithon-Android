package com.edge.weather.unithon;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.edge.weather.unithon.utils.AudioWriterPCM;
import com.naver.speech.clientapi.SpeechRecognitionResult;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.edge.weather.unithon.R.raw.song_1;

public class MainActivity extends AppCompatActivity {
    private toDOViewAdapter toDOViewAdapter;
    private ImageView userimage,userimagethink;
    private SwipeMenuListView listView;
    private FloatingActionButton schedule_list_btn, toDo_create_btn, collection_btn;;
    private ProgressBar progressBar;
    private static final int MY_PERMISSION_AUDIO=1111;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String CLIENT_ID = "4c82B7NUDDtSt7HFzjZK";
    private RecognitionHandler handler;
    private NaverRecognizer naverRecognizer;
    private AudioWriterPCM writer;
    private FloatingActionButton btnStart;
    private String mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인 캐릭터 이미지
        userimage = (ImageView)findViewById(R.id.userimage);
        //안드로이드 기기 고유 값
        String idByANDROID_ID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        //음성 인식 버튼
        btnStart = (FloatingActionButton) findViewById(R.id.btn_start);
        //권한 허용 메소드
        checkPremission();

        //clova api 사용하기 위한 세팅
        handler = new RecognitionHandler(this);
        naverRecognizer = new NaverRecognizer(this, handler, CLIENT_ID);


        //clova api 실행
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!naverRecognizer.getSpeechRecognizer().isRunning()) {
                    // Start button is pushed when SpeechRecognizer's state is inactive.
                    // Run SpeechRecongizer by calling recognize().
                    mResult = "";
                    //txtResult.setText("Connecting...");
                    //btnStart.setText(recognize_stop_str);
                    naverRecognizer.recognize();
                } else {
                    Log.d(TAG, "stop and wait Final Result");
                    btnStart.setEnabled(false);

                    naverRecognizer.getSpeechRecognizer().stop();
                }
            }
        });


        //캐릭터 말풍선 이미지뷰
        userimagethink = (ImageView)findViewById(R.id.userimagethink);

        //To do 리스트뷰
        listView = (SwipeMenuListView) findViewById(R.id.list_view);
        //경험치 프로그레스바
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        //calandar view 버튼
        schedule_list_btn=(FloatingActionButton)findViewById(R.id.schedule_list_btn);
        //To do 추가 버튼
        toDo_create_btn = (FloatingActionButton) findViewById(R.id.toDo_create_btn);
        //collection 버튼
        collection_btn = (FloatingActionButton) findViewById(R.id.collection_btn);

        //말풍선 쓰레드 시작
        UserThinking userThinking = new UserThinking();
        userThinking.start();

        //GIF 파일 넣는 코드
        GlideDrawableImageViewTarget Userimage = new GlideDrawableImageViewTarget(userimage);
        Glide.with(this).load(R.drawable.yawoori).into(Userimage);

        userimagethink.setImageResource(R.drawable.thinking);
        progressBar.setProgress(50);

        //메인 리스트뷰 어뎁터
        toDOViewAdapter = new toDOViewAdapter();
        listView.setAdapter(toDOViewAdapter);


        schedule_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ScheduleListActivity.class);
                startActivity(intent);
            }
        });

        //할일 추가하기 버튼 클릭시 발생 이벤트 커스텀 리스트 뷰 한 아이템 추가!
        toDo_create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WritetodoList.class);
                startActivityForResult(intent, 1);
            }
        });
        collection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Collection.class);
                startActivityForResult(intent, 1);

            }
        });

        //리스트뷰의 스와이프 기능
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                        0xff)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(android.R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // 첫번째 버튼 클릭 시
                        break;
                    case 1:
                        // 두번째 버튼 클릭 시
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }


    // Handle clova api
    private void handleMessage(Message msg) {
        switch (msg.what) {
            case R.id.clientReady:
                // Now an user can speak.
                //txtResult.setText("Connected");
                writer = new AudioWriterPCM(
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/NaverSpeechTest");
                writer.open("Test");
                break;

            case R.id.audioRecording:
                writer.write((short[]) msg.obj);
                break;

            case R.id.partialResult:
                // Extract obj property typed with String.
                mResult = (String) (msg.obj);
                //txtResult.setText(mResult);
                break;

            case R.id.finalResult:
                // Extract obj property typed with String array.
                // The first element is recognition result for speech.
                SpeechRecognitionResult speechRecognitionResult = (SpeechRecognitionResult) msg.obj;
                List<String> results = speechRecognitionResult.getResults();
                StringBuilder strBuf = new StringBuilder();
                for(String result : results) {
                    strBuf.append(result);
                    strBuf.append("\n");
                }
                mResult = strBuf.toString();
                //txtResult.setText(mResult);
                Toast.makeText(getApplicationContext(),mResult+"",Toast.LENGTH_SHORT).show();
                break;

            case R.id.recognitionError:
                if (writer != null) {
                    writer.close();
                }

                mResult = "Error code : " + msg.obj.toString();
                //txtResult.setText(mResult);
                //btnStart.setText(R.string.str_start);
                btnStart.setEnabled(true);
                break;

            case R.id.clientInactive:
                if (writer != null) {
                    writer.close();
                }

                //btnStart.setText(R.string.str_start);
                btnStart.setEnabled(true);
                break;
        }
    }

    //권한 허용 메소드
    private void checkPremission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if((ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE))||
                    (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))){
                new AlertDialog.Builder(this)
                        .setTitle("알림")
                        .setMessage("저장소 권한 거부")
                        .setNegativeButton("설정",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i =new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.setData(Uri.parse("package"+getPackageName()));
                                startActivity(i);
                            }
                        })
                        .setPositiveButton("확인",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();

            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO},MY_PERMISSION_AUDIO);
            }
        }
    }
    //request 권한 Result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_AUDIO:
                for(int i=0; i<grantResults.length;i++){
                    if(grantResults[i]<0){
                        Toast.makeText(MainActivity.this,"해당 권한을 활성화 해야합니다.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                break;
        }
    }
    //인텐트에서 값 받아오는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String Todo= data.getStringExtra("Todo");
                String Date=data.getStringExtra("Date");
                if(Todo.equals("")){
                    Toast.makeText(getApplicationContext(),"할 일을 입력해주세요",Toast.LENGTH_SHORT).show();
                }else{
                    toDOViewAdapter.addItem(Todo);
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }
    }//onActivityResult
    //말풍선을 랜덤으로 보여주고 사라지게 하는 클래스스
    class UserThinking extends Thread {
        int num=3;

        @Override
        public void run() {
            super.run();

            for(;;){
                try{
                    Thread.sleep(1000);
                    Random rnd = new Random();
                    num = rnd.nextInt(100);
                    Thread.sleep(1000);
                }
                catch(Exception e){}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(num%3==0){
                            userimagethink.setVisibility(View.INVISIBLE);
                        }
                        else{
                            userimagethink.setVisibility(View.VISIBLE);
                            //말풍선과 함께 음성도 나오도록!!ㅋㅋㅋㅋㅋㅋ
                            MediaPlayer mPlayer2= MediaPlayer.create(getApplicationContext(),R.raw.song_1);
                            mPlayer2.start();
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // NOTE : initialize() must be called on start time.
        naverRecognizer.getSpeechRecognizer().initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mResult = "";
        //txtResult.setText("");
        //btnStart.setText(R.string.str_start);
        btnStart.setEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // NOTE : release() must be called on stop time.
        naverRecognizer.getSpeechRecognizer().release();
    }

    // Declare handler for handling SpeechRecognizer thread's Messages.
    static class RecognitionHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        RecognitionHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }
    }

}
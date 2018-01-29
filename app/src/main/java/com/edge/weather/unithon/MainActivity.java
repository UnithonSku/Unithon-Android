package com.edge.weather.unithon;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
<<<<<<< HEAD
import android.os.Bundle;
=======
import android.os.AsyncTask;
>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4
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
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
=======
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.edge.weather.unithon.utils.AudioWriterPCM;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.naver.speech.clientapi.SpeechRecognitionResult;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
//<<<<<<< HEAD
//=======
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
<<<<<<< HEAD
import java.util.Date;
=======
//>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    static public toDOViewAdapter toDOViewAdapter;
    private int thinkingindex,res;
    private SwipeMenuListView listView;
    private ImageView schedule_list_btn, toDo_create_btn, collection_btn;;
=======


    private toDOViewAdapter toDOViewAdapter;
    private ImageView userimagedefault, userimagethink, userimagehappy;
    private SwipeMenuListView listView;
    private FloatingActionButton schedule_list_btn, toDo_create_btn, collection_btn;
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
    private ProgressBar progressBar;
    private static final int MY_PERMISSION_AUDIO = 1111;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String CLIENT_ID = "7mMbd8FS1_lD3k99NYKu";
    private RecognitionHandler handler;
    private NaverRecognizer naverRecognizer;
    private AudioWriterPCM writer;
<<<<<<< HEAD
    private ImageView btnStart;
    private String mResult,mood;
    private OAuthLoginButton mOAuthLoginButton;
=======
    private FloatingActionButton btnStart;
//<<<<<<< HEAD
    private String mResult, mood;
    private GlideDrawableImageViewTarget Userimagedefault, Userimagehappy;
    int tvalue = 0;
    private static final int userthinking[]={R.drawable.userthinking1,R.drawable.userthinking2,R.drawable.userthinking3,R.drawable.userthinking4
    ,R.drawable.userthinking5,R.drawable.userthinking6,R.drawable.userthinking7};

//=======


>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
    private static Context mContext;
    private static String OAUTH_CLIENT_ID = "7mMbd8FS1_lD3k99NYKu";
    private static String OAUTH_CLIENT_SECRET = "bFINTBJLUk";
    private static String OAUTH_CLIENT_NAME = "네이버 아이디로 로그인";
    String access_token="";
    private GlideDrawableImageViewTarget Userimagedefault, Userimagehappy,Userimageunhappy,level_1,level_3;
    static public ImageView level_2_image,userimagehappy,userimageunhappy, userimagethink,level_1_image,level_3_image;
    String email="";
    Intent alarmintent;
    PendingIntent pendingIntent;
    long triggerTime=0;
    String judge="";
    String idByANDROID_ID;
    private final int[] ranthink={R.drawable.userthinking1,R.drawable.userthinking2,R.drawable.userthinking3,R.drawable.userthinking4,R.drawable.userthinking5,R.drawable.userthinking6,R.drawable.userthinking7,R.drawable.userthinking8,R.drawable.userthinking9};
    JsonObject jsonObject;

  //  private static OAuthLogin mOAuthLoginInstance;
//>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level_2_image = (ImageView) findViewById(R.id.userimagedefault);
        userimagehappy = (ImageView) findViewById(R.id.userimagehappy);
        userimageunhappy = (ImageView) findViewById(R.id.userimageunhappy);
        level_1_image = (ImageView) findViewById(R.id.level_1);
        level_3_image = (ImageView) findViewById(R.id.level_3);

        OAuthLoginDefine.DEVELOPER_VERSION = true;
        mContext = this;
        initData();
        updateView();
        this.setTitle("OAuthLoginSample Ver." + OAuthLogin.getVersion());
        mOAuthLoginInstance.startOauthLoginActivity(MainActivity.this, mOAuthLoginHandler);
        new RequestApiTask().execute();


<<<<<<< HEAD

=======
        //메인 캐릭터 이미지
        userimagedefault = (ImageView) findViewById(R.id.userimagedefault);
        userimagehappy = (ImageView) findViewById(R.id.userimagehappy);
        userimagehappy.setVisibility(View.GONE);
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
        //안드로이드 기기 고유 값
        idByANDROID_ID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        /*UserInfo userInfo=new UserInfo(idByANDROID_ID);
        userInfo.execute();*/
        //음성 인식 버튼
        btnStart = (ImageView) findViewById(R.id.btn_start);
        //권한 허용 메소드
        checkPremission();

        //clova api 사용하기 위한 세팅
        handler = new RecognitionHandler(this);
        naverRecognizer = new NaverRecognizer(this, handler, CLIENT_ID);

        Userimagedefault = new GlideDrawableImageViewTarget(level_2_image);
        Userimagehappy = new GlideDrawableImageViewTarget(userimagehappy);
        Userimageunhappy = new GlideDrawableImageViewTarget(userimageunhappy);
        level_1=new GlideDrawableImageViewTarget(level_1_image);
        level_3=new GlideDrawableImageViewTarget(level_3_image);
        Glide.with(this).load(R.drawable.default1).into(Userimagedefault);
        Glide.with(this).load(R.drawable.happy).into(Userimagehappy);
        Glide.with(this).load(R.drawable.unhappy).into(Userimageunhappy);
        Glide.with(this).load(R.drawable.level_1_default).into(level_1);
        Glide.with(this).load(R.drawable.level_3_default).into(level_3);
        userimagehappy.setVisibility(View.GONE);
        userimageunhappy.setVisibility(View.GONE);
        level_2_image.setVisibility(View.GONE);
        level_3_image.setVisibility(View.GONE);
        //clova api 실행
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!naverRecognizer.getSpeechRecognizer().isRunning()) {
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
        userimagethink = (ImageView) findViewById(R.id.userimagethink);

        //To do 리스트뷰
        listView = (SwipeMenuListView) findViewById(R.id.list_view);
        //경험치 프로그레스바
<<<<<<< HEAD
        progressBar = (ProgressBar)findViewById(R.id.main_front_progress);
        //calandar view 버튼
        schedule_list_btn=(ImageView) findViewById(R.id.schedule_list_btn);
=======
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        //calandar view 버튼
        schedule_list_btn = (FloatingActionButton) findViewById(R.id.schedule_list_btn);
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
        //To do 추가 버튼
        toDo_create_btn = (ImageView) findViewById(R.id.toDo_create_btn);
        //collection 버튼
<<<<<<< HEAD
        collection_btn = (ImageView) findViewById(R.id.collection_btn);
=======
        collection_btn = (FloatingActionButton) findViewById(R.id.collection_btn);

<<<<<<< HEAD

        //말풍선 쓰레드 시작
        UserThinking userThinking = new UserThinking();
        userThinking.start();

        //GIF 파일 넣는 코드
        Userimagedefault = new GlideDrawableImageViewTarget(userimagedefault);
        Userimagehappy = new GlideDrawableImageViewTarget(userimagehappy);
        Glide.with(this).load(R.drawable.lv1_basic).into(Userimagedefault);
        Glide.with(this).load(R.drawable.lv2_basic).into(Userimagehappy);
=======
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01


>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4
        userimagethink.setImageResource(R.drawable.thinking);
        progressBar.setProgress(50);

        //말풍선 쓰레드 시작
        UserThinking userThinking = new UserThinking();
        userThinking.start();

        //메인 리스트뷰 어뎁터
        toDOViewAdapter = new toDOViewAdapter();
        listView.setAdapter(toDOViewAdapter);

        jsonObject=new JsonObject();
        jsonObject.addProperty("title","줄넘기 50개");
        jsonObject.addProperty("date","2018-01-25");
        jsonObject.addProperty("done",false);

        toDOViewAdapter.addItem(jsonObject);

        jsonObject=new JsonObject();
        jsonObject.addProperty("title","영단어 50개 외우기");
        jsonObject.addProperty("date","2018-02-10");
        jsonObject.addProperty("done",false);

        toDOViewAdapter.addItem(jsonObject);



        schedule_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScheduleListActivity.class);
                startActivity(intent);
            }
        });

        //할일 추가하기 버튼 클릭시 발생 이벤트 커스텀 리스트 뷰 한 아이템 추가!
        toDo_create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WritetodoList.class);
                intent.putExtra("token",access_token);
                intent.putExtra("email",email);
                startActivity(intent);
            }

        });

        collection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Collection.class);
                startActivityForResult(intent, 1);
                //달력 추가
                /*CalendarCall calendarCall=new CalendarCall();
               calendarCall.setAccess_token(access_token);
               calendarCall.setStart_day("20171212");
                calendarCall.setEnd_day("20171215");
                calendarCall.setTitle("kimgunyoung");
                calendarCall.setEmail(email);
                calendarCall.setCal_id("ewrewrwererererere");
                calendarCall.execute();*/
            }
        });

        //리스트뷰의 스와이프 기능
        final SwipeMenuCreator creator = new SwipeMenuCreator() {
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
<<<<<<< HEAD
                        //첫번째 버튼 클릭시
                        toDOViewAdapter.myitems.remove((JsonObject)toDOViewAdapter.getItem(position));
                        toDOViewAdapter.notifyDataSetChanged();

                        break;
                    case 1:
                        // 두번째 버튼 클릭 시

                        toDOViewAdapter.myitems.remove((JsonObject)toDOViewAdapter.getItem(position));
                        toDOViewAdapter.notifyDataSetChanged();
=======
                        //수정
                        String title2 = toDOViewAdapter.getTitleItem(position);

                        Intent intent = new Intent(MainActivity.this, Replacetodo.class);
                        intent.putExtra("title", title2);
                        intent.putExtra("position", position);
                        Toast.makeText(getApplicationContext(), title2 + "을 수정합니다." + position + "번째 목록", Toast.LENGTH_LONG).show();
                        startActivity(intent);

                        // toDOViewAdapter.replaceItem(position,"new replace");


                        break;
                    case 1:
                        // 삭제
                        toDOViewAdapter.delItem(position);

                        //Toast.makeText(getApplicationContext(), "삭제할 내용"+index+"//"+position, Toast.LENGTH_SHORT).show();
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
        //long intervalTime = 24 * 60 * 60 * 1000;// 24시간
        /*AlarmNotificationReceiver.content="오늘 하루 습관을 키워봐요!!";
        AlarmManager manager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmintent=new Intent(getApplicationContext(),AlarmNotificationReceiver.class);
        pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),0,alarmintent,0);
        triggerTime = setTriggerTime(18,25);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime,intervalTime,pendingIntent);*/

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
                for (String result : results) {
                    strBuf.append(result);
                    strBuf.append("/");
                }
                mResult = strBuf.toString();
                //txtResult.setText(mResult);
<<<<<<< HEAD
                Toast.makeText(getApplicationContext(),mResult+"",Toast.LENGTH_SHORT).show();
                Voiceclassify voiceclassify = new Voiceclassify(mResult);
                mood= voiceclassify.classify();
                // Toast.makeText(getApplicationContext(), mood + "", Toast.LENGTH_SHORT).show();
                //모션시작
=======
                Toast.makeText(getApplicationContext(), mResult + "", Toast.LENGTH_LONG).show();
                Voiceclassify voiceclassify = new Voiceclassify(mResult);
                mood = voiceclassify.classify();
                Toast.makeText(getApplicationContext(), mood + "", Toast.LENGTH_SHORT).show();
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
                Motion motion = new Motion(mood);
                motion.start();
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
    private void checkPremission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if ((ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) ||
                    (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))) {
                new AlertDialog.Builder(this)
                        .setTitle("알림")
                        .setMessage("저장소 권한 거부")
                        .setNegativeButton("설정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.setData(Uri.parse("package" + getPackageName()));
                                startActivity(i);
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, MY_PERMISSION_AUDIO);
            }
        }
    }

    //request 권한 Result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_AUDIO:
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] < 0) {
                        Toast.makeText(MainActivity.this, "해당 권한을 활성화 해야합니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                break;
        }
    }

    //인텐트에서 값 받아오는 메소드
<<<<<<< HEAD
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//<<<<<<< HEAD
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String Todo = data.getStringExtra("Todo");
                String Date = data.getStringExtra("Date");
                if (Todo.equals("")) {
                    Toast.makeText(getApplicationContext(), "할 일을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    toDOViewAdapter.addItem(Todo);
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }


    }//onActivityResult

    //말풍선을 랜덤으로 보여주고 사라지게 하는 클래스
    class UserThinking extends Thread {


        int num = 3;

        @Override
        public void run() {
            super.run();

            for (; ; ) {
                try {

                    Thread.sleep(1000);
                    Random rnd = new Random();
                    num = rnd.nextInt(100);
                    Log.d("숫자는 ", String.valueOf(num));
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (num % 3 == 0) {
                            userimagethink.setVisibility(View.INVISIBLE);
                        } else {

                            userimagethink.setVisibility(View.VISIBLE);
                            //말풍선과 함께 음성도 나오도록!!ㅋㅋㅋㅋㅋㅋ
                            MediaPlayer mPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.song_1);
                            mPlayer2.start();
                        }
                    }
                });
            }
        }
    }
=======

>>>>>>> 43ded7c697fd3d01b4a04ccab8768afe878e15c4


    //음성인식 행동 변화 클래스
    class Motion extends Thread {
        String nmood;
        public Motion(String nmood){
            this.nmood = nmood;
        }

        @Override
        public void run() {
            super.run();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (nmood.equals("happy")) {
                            Handler mhandler = new Handler();
                            mhandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    userimagehappy.setVisibility(View.GONE);
                                    userimagedefault.setVisibility(View.VISIBLE);
                                }
                            },3000);
                            userimagehappy.setVisibility(View.VISIBLE);
                            userimagedefault.setVisibility(View.GONE);


                        }
                        else {
                            Handler mhandler = new Handler();
                            mhandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    userimagehappy.setVisibility(View.GONE);
                                    userimagedefault.setVisibility(View.VISIBLE);
                                }
                            },3000);
                            userimagehappy.setVisibility(View.VISIBLE);
                            userimagedefault.setVisibility(View.GONE);


                        }
                    }
                });

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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
    private void initData() {
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
		/*
		 * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
		 * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
		 */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
    }

    private void updateView() {
        access_token=mOAuthLoginInstance.getAccessToken(mContext)+"";


    }
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
                access_token=accessToken;


            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };

    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        String result="";

        @Override
        protected void onPreExecute() {

        }
        @Override
        protected String doInBackground(Void... params) {
            String token = access_token;// 네이버 로그인 접근 토큰;
            String header = "Bearer " + token; // Bearer 다음에 공백 추가
            try {
                String apiURL = "https://openapi.naver.com/v1/nid/me";
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Authorization", header);
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                Log.d("인증",response.toString());
                JSONObject jsonObject=new JSONObject(response.toString());
                result=jsonObject.getJSONObject("response").get("email").toString();
                System.out.println(result.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
            return result;
        }
        protected void onPostExecute(String content) {
            email=content;

        }
    }

    private long setTriggerTime(int hour, int minute)
    {
        // timepicker
        Calendar curTime = Calendar.getInstance();
        curTime.set(Calendar.HOUR_OF_DAY,hour);
        curTime.set(Calendar.MINUTE,minute);
        curTime.set(Calendar.SECOND, 0);
        long btime = curTime.getTimeInMillis();
        long triggerTime = btime;
        return triggerTime;
    }
    class Motion extends Thread {
        String nmood;
        public Motion(String nmood){
            this.nmood = nmood;
        }

        @Override
        public void run() {
            super.run();


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (nmood.equals("happy")) {
                        Handler mhandler = new Handler();
                        mhandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                userimagehappy.setVisibility(View.GONE);
                                level_2_image.setVisibility(View.VISIBLE);
                            }
                        },3000);
                        userimagehappy.setVisibility(View.VISIBLE);
                        level_2_image.setVisibility(View.GONE);


                    }
                    else {
                        Handler mhandler = new Handler();
                        mhandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                userimageunhappy.setVisibility(View.GONE);
                                level_2_image.setVisibility(View.VISIBLE);
                            }
                        },3000);
                        userimageunhappy.setVisibility(View.VISIBLE);
                        level_2_image.setVisibility(View.GONE);


                    }
                }
            });

        }
    }
    class UserThinking extends Thread {

        int num = 3;

        @Override
        public void run() {
            super.run();

            for (; ; ) {
                try {

                    Thread.sleep(1000);
                    Random rnd = new Random();
                    num = rnd.nextInt(100);
                    //Log.d("숫자는 ", String.valueOf(num));
                    thinkingindex = num%8;  //랜덤하게 0~7까지 숫자 받아옴
                    res = ranthink[thinkingindex];

                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (num % 3 == 0) {
                            userimagethink.setImageResource(res);
                            userimagethink.setVisibility(View.VISIBLE);
                        } else {
                            userimagethink.setVisibility(View.INVISIBLE);


                        }
                    }
                });
            }
        }
    }



}


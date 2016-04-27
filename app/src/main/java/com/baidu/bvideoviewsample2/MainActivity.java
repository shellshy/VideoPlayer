package com.baidu.bvideoviewsample2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private final String TAG = "MainActivity";
	private Button mPlayBtn;
	private EditText mSourceET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUI();
	}
	
	void initUI(){
		mPlayBtn = (Button)findViewById(R.id.playBtn);
		mSourceET = (EditText)findViewById(R.id.getET);
		mPlayBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch(id){
		case R.id.playBtn:
			/**
			 * 播放一个视频
			 */
			playVideo();
			break;
		default:
			break;
		}
	}
	
	private void playVideo(){
		String source = mSourceET.getText().toString();
			if(source == null || source.equals("")){
				/**
				 * 简单检测播放源的合法性,不合法不播放
				 */
				Toast.makeText(this, "please input your video source", 500).show();
				source = "http://devimages.apple.com/iphone/samples/bipbop/gear4/prog_index.m3u8";
				Intent intent = new Intent(this, VideoViewPlayingActivity.class);
				intent.setData(Uri.parse(source));
				startActivity(intent);		
				
				
			}else{
				Intent intent = new Intent(this, VideoViewPlayingActivity.class);
				intent.setData(Uri.parse(source));
				startActivity(intent);
			}	
	}
}

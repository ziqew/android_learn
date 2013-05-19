package com.appdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TokenFragment extends Fragment {
	Handler mHandler = new Handler();
	private static final String TAG = "TokenFragment";
	private String mTag;
	private int count;
	private TextView countTxt;
	private TextView curTimeTxt;
	private TextView shieldViewText;
	
	public TokenFragment() {
	}

	public TokenFragment(String tag) {
		mTag = tag;
		Log.d(TAG, "Constructor: tag=" + tag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.token_layout, container, false);
		curTimeTxt = (TextView) view.findViewById(R.id.curTime);
		countTxt = (TextView) view.findViewById(R.id.countdown);
		shieldViewText =(TextView)view.findViewById(R.id.shieldViewText);
		count=30;
		mHandler.postDelayed(mUpdateDynaPassTask, 0); 
		return view;
	}
	
	private Runnable mUpdateDynaPassTask = new Runnable() {
		public void run() {
			if(count==0){
				count=30;
			}
			if(count==30){
				showToken();
			}
			showDateTime();
			countTxt.setText(" " + count);
			count--;
			mHandler.postDelayed(mUpdateDynaPassTask, 1000); // run thread each 1 second
		}
	};

	private void showDateTime() {
		Date curDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		curTimeTxt.setText(sdf.format(curDate));
	}

	private void showToken() {
		String deviceId="1234567890";
		String password="111111";
		String token = "999999";
		shieldViewText.setText(token);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		Log.d(TAG, "Token Fragment onPause");
		mHandler.removeCallbacks(mUpdateDynaPassTask);
		count=30;
	}

}
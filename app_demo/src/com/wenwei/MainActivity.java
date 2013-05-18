package com.wenwei;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	private static final String TAG="MainActivity";
    /** Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    } */
    
    private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		listView = new ListView(this);
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getData()));
		
		setContentView(listView);
		listView.setOnItemClickListener(listListener);
	}
	
	private OnItemClickListener listListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			intentActivity(position);
		}
	};
	
	// according to the index is show activity
	private void intentActivity(int index) {
		Intent intent = new Intent();
		if(index == 0) {
			intent.setClass(this, BtnClickActivity.class);
		} else if(index == 1) {
			intent.setClass(this, SelectExampleActivity.class);
		} else if(index == 2) {
			intent.setClass(this, FragmentTestActivity.class);
		} 
		else if(index == 2) {
			intent.setClass(this, FragmentTestActivity.class);
		} 
		startActivity(intent);
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add("ButtonClick");
		data.add("SelectExample");
		data.add("FragmentTest");
		data.add("HttpTest");
		return data;
	}
	

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "onStart");
	}




	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
	
}
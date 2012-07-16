package com.wenwei;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
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
		startActivity(intent);
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add("ButtonClick");
		data.add("SelectExample");
		data.add("FragmentTest");
		return data;
	}
}
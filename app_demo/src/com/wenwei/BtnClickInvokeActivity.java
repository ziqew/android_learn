package com.wenwei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BtnClickInvokeActivity extends Activity {
	
	private static final String TAG="BtnClickInvokeActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		LinearLayout layout=new LinearLayout(this);
		
		TextView textView=new TextView(this);
		textView.setText("Foo");
		layout.addView(textView);
		
		Button btn=new Button(this);
		btn.setText("Return");
		layout.addView(btn);
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				 Intent intent=new Intent();
				 intent.putExtra("SEND_BACK", "COOKIE");
				 setResult(RESULT_OK, intent);
		         finish();
		         
				
			}
			
		});
		
		this.setContentView(layout);
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

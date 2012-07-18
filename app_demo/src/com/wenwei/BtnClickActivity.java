package com.wenwei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BtnClickActivity extends Activity implements OnClickListener{
	private static final String TAG="BtnClickActivity";
	
	private OnClickListener clickHandler1=new OnClickListener(){

		@Override
		public void onClick(View v) {
			Log.i(TAG,"Button clicked");
			
		}
		
		
	};
	

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

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.btn_click);
        Button btn1=(Button)this.findViewById(R.id.btn1);
        Button btn2=(Button)this.findViewById(R.id.btn2);
        Button btn3=(Button)this.findViewById(R.id.btn3);
        Button btn4=(Button)this.findViewById(R.id.btn4);
        //btn5 use android:onClick="handleClick"
        Button btn5=(Button)this.findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(new HandleClick());
        btn3.setOnClickListener(clickHandler1);
        btn4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Log.i(TAG,"Button clicked");
				
			}
        	
        });
        
    }
    
    public void handleClick(View arg0) {
    	Log.i(TAG,"Button clicked");
    }


	@Override
	public void onClick(View v) {
		Log.i(TAG,"Button Clicked");
		Intent intent=new Intent(this,BtnClickInvokeActivity.class);
		this.startActivityForResult(intent, 1);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
	    if (resultCode == Activity.RESULT_OK && requestCode == 1) {
	    	Log.i(TAG,data.getStringExtra("SEND_BACK"));
	    }
	}
	
	private class HandleClick implements OnClickListener{
		public void onClick(View arg0) {
			Log.i(TAG,"Button Clicked");
		}
	}
}

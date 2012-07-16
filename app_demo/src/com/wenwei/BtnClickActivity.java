package com.wenwei;

import android.app.Activity;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
		// TODO Auto-generated method stub
		
	}
	
	private class HandleClick implements OnClickListener{
		public void onClick(View arg0) {
			Log.i(TAG,"Button Clicked");
		}
	}
}

package com.appdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class DisplayViewActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.main);
    	
    	
    	LinearLayout layout = (LinearLayout)getLayoutInflater().inflate(R.layout.main,
    			null);
    	Button reset = new Button(this);
    	reset.setText("Reset Form");
    	layout.addView(reset,
    	new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
    	LayoutParams.WRAP_CONTENT));
    	//Attach the view to the window
    	setContentView(layout);
    }
}

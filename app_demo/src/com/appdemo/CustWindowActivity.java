package com.appdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CustWindowActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	//Request window features before setContentView
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.main);
    	getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
    }
}

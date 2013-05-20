package com.appdemo.fiftyhacks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;

import com.appdemo.fiftyhacks.hack07.view.DrawView;

public class Hack07Activity extends Activity {

	  private DrawView mDrawView;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    Display display = getWindowManager().getDefaultDisplay();
	    mDrawView = new DrawView(this);
	    mDrawView.height = display.getHeight();
	    mDrawView.width = display.getWidth();

	    setContentView(mDrawView);
	  }
	}
package com.appdemo;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MoreFragment extends Fragment{
	private static final String TAG = "MoreFragment";
	private String mTag;
	
	public MoreFragment() {
	}

	public MoreFragment(String tag) {
		mTag = tag;
		Log.d(TAG, "Constructor: tag=" + tag);
	}
}
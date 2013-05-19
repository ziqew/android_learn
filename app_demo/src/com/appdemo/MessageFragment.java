package com.appdemo;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MessageFragment extends Fragment{
	
	private static final String TAG = "MessageFragment";
	private String mTag;
	
	
	public MessageFragment() {
	}

	public MessageFragment(String tag) {
		mTag = tag;
		Log.d(TAG, "Constructor: tag=" + tag);
	}
}


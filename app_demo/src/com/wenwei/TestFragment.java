package com.wenwei;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestFragment extends Fragment {
	private int magznumber;

	private static final String TAG="TestFragment";
	
	public TestFragment() {
	}

	/**
	 * Constructor for being created explicitly
	 */
	public TestFragment(int position) {
		this.magznumber = position;
	}

	/**
	 * If we are being created with saved state, restore our state
	 */
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		Log.i(TAG, "onCreate");
		if (null != saved) {
			magznumber = saved.getInt("magznumber");
		}
	}

	/**
	 * Save the number of Androids to be displayed
	 */
	@Override
	public void onSaveInstanceState(Bundle toSave) {
		toSave.putInt("magznumber", magznumber);
	}

	/**
	 * Make a grid to view the magazines
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle saved) {
		Log.i(TAG, "onCreateView");
		Context c = getActivity().getApplicationContext();
		LinearLayout l = new LinearLayout(c);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT, 0);
		l.setLayoutParams(params);
		ImageView i = new ImageView(c);
		switch (magznumber) {
		case 1:
			i.setImageResource(R.drawable.gallery_photo_1);
			break;
		case 2:
			i.setImageResource(R.drawable.gallery_photo_2);
			break;
		case 3:
			i.setImageResource(R.drawable.gallery_photo_3);
			break;
		}
		l.addView(i);
		return l;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.i(TAG, "onAttach");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.i(TAG, "onDestroyView");
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.i(TAG, "onDetach");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "onPause");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "onStart");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "onStop");
	}
	
	

}

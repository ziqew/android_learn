package com.wenwei;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestFragment extends Fragment {
	private int magznumber;

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

}

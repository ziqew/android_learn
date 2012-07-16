package com.wenwei;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentTestActivity extends FragmentActivity implements
		OnItemClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_test);
		ListView l = (ListView) findViewById(R.id.number_list);
		ArrayAdapter<String> magzTitles = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				new String[] { "Electronics For You", "Linux For You",
						"Facts For you" });
		// It would be better to move the array of titles into XML and use
		// R.array.magz_titles);
		l.setAdapter(magzTitles);
		l.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Fragment f = new TestFragment(position + 1);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.the_frag, f);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.addToBackStack(null);
		ft.commit();
	}

}

package com.appdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabsFragment extends Fragment implements OnTabChangeListener {

	private static final String TAG = "TabsFragment";
	public static final String TAB_WALLET = "tab_wallet";
	public static final String TAB_TOKEN = "tab_token";
	public static final String TAB_MESSAGE = "tab_message";
	public static final String TAB_MORE = "tab_more";

	private View mRoot;
	private TabHost mTabHost;
	private int mCurrentTab;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRoot = inflater.inflate(R.layout.tabs_fragment, null);
		mTabHost = (TabHost) mRoot.findViewById(android.R.id.tabhost);
		setupTabs();
		return mRoot;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		// manually start loading stuff in the first tab
		updateTab(TAB_WALLET, R.id.tab_wallet_tabcontent);
	}

	private void setupTabs() {
		mTabHost.setup(); // important!
		mTabHost.addTab(newTab(TAB_WALLET, R.string.tab_wallet, R.drawable.tab_home,R.id.tab_wallet_tabcontent));
		mTabHost.addTab(newTab(TAB_TOKEN, R.string.tab_token,R.drawable.tab_token, R.id.tab_token_tabcontent));
		mTabHost.addTab(newTab(TAB_MESSAGE, R.string.tab_message,R.drawable.payitem, R.id.tab_message_tabcontent));
		mTabHost.addTab(newTab(TAB_MORE, R.string.tab_more,R.drawable.more, R.id.tab_more_tabcontent));

	}

	private TabSpec newTab(String tag, int labelId,int imageId, int tabContentId) {
		Log.d(TAG, "buildTab(): tag=" + tag);

		View indicator = LayoutInflater.from(getActivity()).inflate(
				R.layout.tab,
				(ViewGroup) mRoot.findViewById(android.R.id.tabs), false);
		((TextView) indicator.findViewById(R.id.text)).setText(labelId);
		((ImageView) indicator.findViewById(R.id.image)).setImageResource(imageId);
		TabSpec tabSpec = mTabHost.newTabSpec(tag);
		tabSpec.setIndicator(indicator);
		tabSpec.setContent(tabContentId);
		return tabSpec;
	}

	@Override
	public void onTabChanged(String tabId) {
		Log.d(TAG, "onTabChanged(): tabId=" + tabId);
		if (TAB_WALLET.equals(tabId)) {
			updateTab(tabId, R.id.tab_wallet_tabcontent);
			mCurrentTab = 0;
			return;
		}
		if (TAB_TOKEN.equals(tabId)) {
			updateTab(tabId, R.id.tab_token_tabcontent);
			mCurrentTab = 1;
			return;
		}
		if (TAB_MESSAGE.equals(tabId)) {
			updateTab(tabId, R.id.tab_message_tabcontent);
			mCurrentTab = 2;
			return;
		}
		if (TAB_MORE.equals(tabId)) {
			updateTab(tabId, R.id.tab_more_tabcontent);
			mCurrentTab = 3;
			return;
		}
	}

	private void updateTab(String tabId, int placeholder) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if(TAB_WALLET.equals(tabId)){
			if (fragmentManager.findFragmentByTag(tabId) == null) {
				Tab1Fragment homeFragment=new Tab1Fragment(tabId);
				transaction.replace(placeholder, homeFragment, tabId);
				//transaction.addToBackStack(tabId);
				transaction.commit();
			}
		}else if(TAB_TOKEN.equals(tabId)){
			if (fragmentManager.findFragmentByTag(tabId) == null) {
				TokenFragment tokenFragment=new TokenFragment(tabId);
				transaction.replace(placeholder, tokenFragment, tabId);
				//transaction.addToBackStack(tabId);
				transaction.commit();
			}
		}else if(TAB_MESSAGE.equals(tabId)){
			if (fragmentManager.findFragmentByTag(tabId) == null) {
				MessageFragment messageFragment=new MessageFragment(tabId);
				transaction.replace(placeholder, messageFragment, tabId);
				//transaction.addToBackStack(tabId);
				transaction.commit();
			}
		}else if(TAB_MORE.equals(tabId)){
			if (fragmentManager.findFragmentByTag(tabId) == null) {
				MoreFragment moreFragment=new MoreFragment(tabId);
				transaction.replace(placeholder, moreFragment, tabId);
				//transaction.addToBackStack(tabId);
				transaction.commit();
			}
		}
		
	}
	

}
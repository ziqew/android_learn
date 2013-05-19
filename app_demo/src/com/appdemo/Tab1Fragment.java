package com.appdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class Tab1Fragment extends Fragment {
	private static final String TAG = "Tab1Fragment";
	private String mTag;

	public Tab1Fragment() {
	}

	public Tab1Fragment(String tag) {
		mTag = tag;
		Log.d(TAG, "Constructor: tag=" + tag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home, container, false);

		GridView gridView = (GridView) view.findViewById(R.id.home_gridview);

		ArrayList<HashMap<String, Object>> gridItems = new ArrayList<HashMap<String, Object>>();
		gridItems.add(createItem(R.drawable.barcode, "条码"));
		gridItems.add(createItem(R.drawable.camera, "扫描"));
		gridItems.add(createItem(R.drawable.paipai, "拍照"));
		gridItems.add(createItem(R.drawable.shake, "晃动"));
		gridItems.add(createItem(R.drawable.fu, "付出"));
		gridItems.add(createItem(R.drawable.shou, "收如"));
		gridItems.add(createItem(R.drawable.sound, "声音"));
		gridItems.add(createItem(R.drawable.fingerprint, "指纹"));
		gridItems.add(createItem(R.drawable.face, "人脸"));
		gridItems.add(createItem(R.drawable.consume, "消费"));
		gridItems.add(createItem(R.drawable.fee, "费用"));
		gridItems.add(createItem(R.drawable.balance, "查询"));
		SimpleAdapter saImageItems = new SimpleAdapter(
				Tab1Fragment.this.getActivity(), gridItems, R.layout.grid_item,
				new String[] { "ItemImage", "ItemText" }, new int[] {
						R.id.ItemImage, R.id.ItemText });
		gridView.setAdapter(saImageItems);
		gridView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d(TAG, "position=" + arg2);
				if(arg2==0){
					FragmentManager fragmentManager = getFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					BarcodePayFragment barcodePayFragment=new BarcodePayFragment(TabsFragment.TAB_WALLET);
					transaction.replace(R.id.tab_wallet_tabcontent, barcodePayFragment, TabsFragment.TAB_WALLET);
					transaction.addToBackStack(TabsFragment.TAB_WALLET);
					transaction.commit();
				}else if(arg2==1){
					
				}else if(arg2==2){
					
				}else if(arg2==3){
					
				}else if(arg2==4){
					
				}else if(arg2==5){
					
				}else if(arg2==6){
					
				}else if(arg2==7){
					
				}else if(arg2==8){
					
				}else if(arg2==9){
					
				}else if(arg2==10){
					
				}else if(arg2==11){
					
				}
				
				
				
				
			}
			
		});
		return view;

	}

	private HashMap<String, Object> createItem(int icon, String iconDesc) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemImage", icon);
		map.put("ItemText", iconDesc);
		return map;
	}

}
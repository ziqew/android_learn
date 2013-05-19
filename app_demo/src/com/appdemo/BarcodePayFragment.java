package com.appdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class BarcodePayFragment extends Fragment{
	private static final String TAG = "BarcodePayFragment";
	private String mTag;
	ViewPagerAdapter adapter;
	ViewPager pager;
	
	public BarcodePayFragment() {
	}

	public BarcodePayFragment(String tag) {
		mTag = tag;
		Log.d(TAG, "Constructor: tag=" + tag);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.barcode_pay_layout, container, false);
		adapter=new ViewPagerAdapter(getFragmentManager());
		pager=(ViewPager)view.findViewById(R.id.pager);
		pager.setAdapter(adapter);
		pager.setCurrentItem(0);
		return view;
		
	}
	
	public static class ViewPagerAdapter extends FragmentPagerAdapter {
		public static final int NUM_ITEMS=2;
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
        	if(position==0){
        		return new BarcodeViewFragment(position);
        	}else if(position==1){
        		return new QrCodeViewFragment(position);
        	}else{
        		return null;
        	}
            
        }
    }
	
	
	public static class BarcodeViewFragment extends Fragment{
		private TextView barcodeViewText;
		private int num;
		
		public BarcodeViewFragment(){
			
			
		}
		
		public BarcodeViewFragment(int num){
			 this.num=num;
			 Log.d(TAG, "page num=" + this.num);
			
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState){
			View view = inflater.inflate(R.layout.barcode_view_item, container, false);
			
			MultiFormatWriter writer=new MultiFormatWriter();
			try {
				BitMatrix bitMatrix=writer.encode("13711111111222222", BarcodeFormat.CODE_128, 240, 120);
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			barcodeViewText = (TextView) view.findViewById(R.id.barcodeViewText);
			barcodeViewText.setText("barcode view");
			return view;
			
		}
		
	}
	
	public static class QrCodeViewFragment extends Fragment{
		private TextView qrcodeViewText;
		private int num;
		
		public QrCodeViewFragment(){
			
			
		}
		
		public QrCodeViewFragment(int num){
			this.num=num;
			Log.d(TAG, "page num=" + this.num);
			
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState){
			View view = inflater.inflate(R.layout.qrcode_view_item, container, false);
			qrcodeViewText = (TextView) view.findViewById(R.id.qrcodeViewText);
			qrcodeViewText.setText("qrcode view");
			return view;
			
		}	
	}


}
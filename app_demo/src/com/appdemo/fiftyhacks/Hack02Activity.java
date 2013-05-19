package com.appdemo.fiftyhacks;


import android.os.Bundle;
import android.view.View;
import com.appdemo.R;
import com.google.android.maps.MapActivity;

public class Hack02Activity extends MapActivity {

    private View mViewStub;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hack02);
        mViewStub = findViewById(R.id.map_stub);
    }

    public void onShowMap(View v) {
        mViewStub.setVisibility(View.VISIBLE);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
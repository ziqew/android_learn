package com.msi.manning.chapter8.SimpleToast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
 
public class SimpleToast extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button_short);
        button.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(SimpleToast.this, "A short Toast", Toast.LENGTH_SHORT).show();
            }
        });

        button = (Button) findViewById(R.id.button_long);
        button.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(SimpleToast.this,"A Longer Toast",Toast.LENGTH_LONG).show();
            }
        });
    }
}

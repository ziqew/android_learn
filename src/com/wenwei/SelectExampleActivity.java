package com.wenwei;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectExampleActivity extends Activity {
	private CheckBox checkBox;
	private TextView txtCheckBox, txtRadio;
	private RadioButton rb1, rb2, rb3;
	private Spinner spnMusketeers;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_example);
		checkBox = (CheckBox) findViewById(R.id.cbxBox1);
		txtCheckBox = (TextView) findViewById(R.id.txtCheckBox);
		txtRadio = (TextView) findViewById(R.id.txtRadio);
		rb1 = (RadioButton) findViewById(R.id.RB1);
		rb2 = (RadioButton) findViewById(R.id.RB2);
		rb3 = (RadioButton) findViewById(R.id.RB3);
		spnMusketeers = (Spinner) findViewById(R.id.spnMusketeers);
		// React to events from the CheckBox
		checkBox.setOnClickListener(new CheckBox.OnClickListener() {
			public void onClick(View v) {
				if (checkBox.isChecked()) {
					txtCheckBox.setText("CheckBox: Box is checked");
				} else {
					txtCheckBox.setText("CheckBox: Not checked");
				}
			}
		});
		// React to events from the RadioGroup
		rb1.setOnClickListener(new RadioGroup.OnClickListener() {
			public void onClick(View v) {
				txtRadio.setText("Radio: Button 1 picked");
			}
		});
		rb2.setOnClickListener(new RadioGroup.OnClickListener() {
			public void onClick(View v) {
				txtRadio.setText("Radio: Button 2 picked");
			}
		});
		rb3.setOnClickListener(new RadioGroup.OnClickListener() {
			public void onClick(View v) {
				txtRadio.setText("Radio: Button 3 picked");
			}
		});
		// Set up the Spinner entries
		List<String> lsMusketeers = new ArrayList<String>();
		lsMusketeers.add("Athos");
		lsMusketeers.add("Porthos");
		lsMusketeers.add("Aramis");
		ArrayAdapter<String> aspnMusketeers = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lsMusketeers);
		aspnMusketeers
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnMusketeers.setAdapter(aspnMusketeers);
		// Set up a callback for the spinner
		spnMusketeers.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onNothingSelected(AdapterView<?> arg0) {
			}

			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				// Code that does something when the Spinner value changes
			}
		});
	}

}

package com.example.agent_new;

import java.util.ArrayList;
import java.util.List;

//import com.mkyong.android.CustomOnItemSelectedListener;
//import com.mkyong.android.MyAndroidAppActivity;
//import com.mkyong.android.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Prof extends Activity {
	private Spinner spinner1,spinner2;
	
	   AutoCompleteTextView autocomplete;
	   
	   String[] arr = { "Paries,France", "PA,United States","Parana,Brazil", 
	      "Padua,Italy", "Pasadena,CA,United States"};



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prof);
		
	      autocomplete = (AutoCompleteTextView)             
	    	      findViewById(R.id.TextView);

	    	      ArrayAdapter<String> adapter = new ArrayAdapter<String>  
	    	      (this,android.R.layout.select_dialog_item, arr);

	    	      autocomplete.setThreshold(2);
	    	      autocomplete.setAdapter(adapter);

		
		
//		addItemsOnSpinner2();
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();

	}

	//add items into spinner dynamically
//	public void addItemsOnSpinner2() {
//
//		spinner2 = (Spinner) findViewById(R.id.spinner2);
//		List<String> list = new ArrayList<String>();
//		list.add("list 1");
//		list.add("list 2");
//		list.add("list 3");
//		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
//		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner2.setAdapter(dataAdapter);
//	}

	public void addListenerOnSpinnerItemSelection(){
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	//get the selected dropdown list value
	public void addListenerOnButton() {

		spinner1 = (Spinner) findViewById(R.id.spinner1);
//		spinner2 = (Spinner) findViewById(R.id.spinner2);
		
//		btnSubmit = (Button) findViewById(R.id.btnSubmit);

//		btnSubmit.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//
//				Toast.makeText(MyAndroidAppActivity.this,
//						"OnClickListener : " + 
//						"\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
//						"\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
//						Toast.LENGTH_SHORT).show();
//			}
//
//		});



	

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.prof, menu);
//		return true;
//	}
	 Button orderButton = (Button)findViewById(R.id.button12);

	    orderButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(Prof.this, Pay.class);
	        startActivity(intent);
	      }
	 
	    });

	    }
}

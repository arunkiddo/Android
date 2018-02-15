package com.example.feelbetter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Allopathy extends Activity{
	
	Spinner dis;
	Button bck;
	TextView sysmtoms,treat;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allopathy);
		dis=(Spinner) this.findViewById(R.id.spdis);
		sysmtoms=(TextView) this.findViewById(R.id.txtsymtoms);
		treat=(TextView) this.findViewById(R.id.txtaldes);
		bck=(Button) this.findViewById(R.id.btnallback);
		
		List<String> list = new ArrayList<String>();
		list.add("SELECT DISORDERS");
		list.add("VIRAL FEVER");
		list.add("HEADACHE");
		list.add("BACK PAIN");
		list.add("DIARRHEA");
		list.add("JOINT PAIN");
		list.add("TOOTH PAIN");
		list.add("STOMACH PAIN");
		list.add("EAR PAIN");
		list.add("MUSCLE TENSION");
		list.add("VOMITING");
		list.add("MUSCLE ACHES");
		list.add("COLD");
		list.add("GENERAL PAIN");
		list.add("COUGH");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dis.setAdapter(dataAdapter);
		
		dis.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				String item=dis.getSelectedItem().toString();
				Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
			//	AdapterView<?> parent, View view, int position, long id
				// TODO Auto-generated method stub
				AssetManager assetManager=getAssets();
				item=item.trim();
		         
		        InputStream input;
		         
		        try {
		             
		        //	assetManager.
		            input=assetManager.open("allopathy.txt");
		            InputStreamReader inputreader = new InputStreamReader(input);
		           BufferedReader br=new BufferedReader(inputreader);
		           sysmtoms.setText("");
		           treat.setText("");
		           String line="";
		           while((line=br.readLine())!=null)
		           {
		        	    String s[]=line.split(":");
		        		String disord=s[0];
		        		if(disord.equalsIgnoreCase(item))
		        		{
		        			sysmtoms.setText(s[1]);
		        			treat.setText(s[2]);
		        		}
		        		
		        	    
		           }
		             
		        } catch (Exception e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
		         
				
				
				
				
				
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		bck.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(Allopathy.this, Home.class);
				startActivity(hl);
				
			}
		});
		
	}
	
	

}

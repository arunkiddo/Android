package com.example.feelbetter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AllopatDoctor  extends Activity{
	
	Button b1,b2;
	TextView res;
	EditText serch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alapaothydoc);
		b1 = (Button) this.findViewById(R.id.btnsercdoc);
		b2 = (Button) this.findViewById(R.id.btnalsrcbck);
		res = (TextView) this.findViewById(R.id.textaldocres);
		serch = (EditText) this.findViewById(R.id.txtseraldoc);
		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String search=serch.getText().toString().trim();
				
				
				
				AssetManager assetManager=getAssets();
			
		         
		        InputStream input;
		         
		        try {
		             
		        //	assetManager.
		            input=assetManager.open("allopathydoc.txt");
		            InputStreamReader inputreader = new InputStreamReader(input);
		           BufferedReader br=new BufferedReader(inputreader);
		           res.setText("");
		           
		           res.append(" Doctor Details\n");
		           res.append(" ========================================\n");
		           String line="";
		           while((line=br.readLine())!=null)
		           {
		        	    String s[]=line.split(":");
		        		String disord=s[0];
		        	
		        			res.append("Name :"+s[0]+"\n");
		        			res.append("qualification :"+s[1]+"\n");
		        			res.append("Clinic :"+s[2]+"\n");
		        			res.append("Street :"+s[3]+"\n");	
		        			res.append("city :"+s[4]+"\n");	
		        			res.append("cantacct num :"+s[5]+"\n");	
		        			
		        			
		        			  res.append(" ========================================\n");	
		        	    
		           }
		             
		        } catch (Exception e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
				
				
			}
		});
		
		
b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(AllopatDoctor.this, Home.class);
				startActivity(hl);
				
			}
		});

	
	
	}

}

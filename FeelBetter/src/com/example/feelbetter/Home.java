package com.example.feelbetter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {

	Button allap, sidat, frsaid, docdet, phardetail, btnclose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		allap = (Button) this.findViewById(R.id.btnallbat);
		sidat = (Button) this.findViewById(R.id.btnsid);
		frsaid = (Button) this.findViewById(R.id.btnfrsaid);
		docdet = (Button) this.findViewById(R.id.btndoct);
		phardetail = (Button) this.findViewById(R.id.btnphar);
		btnclose = (Button) this.findViewById(R.id.btncls);
		
		allap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent al=new Intent(Home.this, Allopathy.class);
				startActivity(al);
			}
		});
		
		
		sidat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent al=new Intent(Home.this, Siddtha.class);
				startActivity(al);
			}
		});
		
		
		frsaid.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent al=new Intent(Home.this, FirstAid.class);
				startActivity(al);
			}
		});
		
		
		
		docdet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent al=new Intent(Home.this, Doctor.class);
				startActivity(al);
			}
		});
		
		
		
		phardetail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent al=new Intent(Home.this, Pharmacy.class);
				startActivity(al);
			}
		});
		
		
		
		
		//close
		
		btnclose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

}

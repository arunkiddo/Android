package com.example.feelbetter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pharmacy  extends Activity{
	
	Button b1,b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pharmacy);
		b1 = (Button) this.findViewById(R.id.btndphallop);
		b2 = (Button) this.findViewById(R.id.btndephsid);
		b3 = (Button) this.findViewById(R.id.btnpharbck);
		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(Pharmacy.this, AllopatParm.class);
				startActivity(hl);
				
			}
		});
		
		
b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(Pharmacy.this, SiddaParm.class);
				startActivity(hl);
				
			}
		});

b3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent hl=new Intent(Pharmacy.this, Home.class);
		startActivity(hl);
		
	}
});
	}
	
	
	


}

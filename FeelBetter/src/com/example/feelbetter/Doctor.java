package com.example.feelbetter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor  extends Activity{
	
	Button b1,b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor);
		b1 = (Button) this.findViewById(R.id.btndallop);
		b2 = (Button) this.findViewById(R.id.btndedsid);
		b3 = (Button) this.findViewById(R.id.btndocbck);
		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(Doctor.this, AllopatDoctor.class);
				startActivity(hl);
				
			}
		});
		
		
b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent hl=new Intent(Doctor.this, SiddaDoctor.class);
				startActivity(hl);
				
			}
		});

b3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent hl=new Intent(Doctor.this, Home.class);
		startActivity(hl);
		
	}
});
	}
	
	
	


}

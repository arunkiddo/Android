package com.example.feelbetter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstAid extends Activity {
	Button  fback;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstaid);
		fback=(Button) this.findViewById(R.id.btnfaidcls);
		
		fback.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
				Intent hl=new Intent(FirstAid.this, Home.class);
				startActivity(hl);
			}
		});
				
	}

}


package com.example.agent_new;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
 EditText e1,e2;
	private Button login;
	private TextView loginLockedTV;
	private TextView attemptsLeftTV;
	private TextView numberOfRemainingLoginAttemptsTV;
	int numberOfRemainingLoginAttempts = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setupVariables();
		
		e1 = (EditText) findViewById(R.id.editTextt10);
		e2 = (EditText) findViewById(R.id.editTextt20);
	//	login = (Button) findViewById(R.id.button1);
		loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
		attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
		numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
		numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
		
	}
	
	
	
	public void LoginAdmin(View v){
		String rlno= e1.getText().toString();
		String pass= e2.getText().toString();
		
		if(rlno.contentEquals("1234") && pass.contentEquals("admin")){
			Toast.makeText(MainActivity.this,"Login Successfully...", Toast.LENGTH_LONG).show();
			Intent ii = new Intent(this,Prof.class);
			startActivity(ii);
		}else{
			
				Toast.makeText(MainActivity.this,"Authentication Failure", Toast.LENGTH_LONG).show();
			}
		
		e1.setText("");
		e2.setText("");
	
    	    }
    
	/*public void clicks(View view) {
		String nam= username.getText().toString();
		String pwd=password.getText().toString();
		String u="1";
		String p="a";
		
		Toast.makeText(getApplicationContext(),nam + pwd, 
				Toast.LENGTH_SHORT).show(); 
		 
		
		if (nam.contentEquals("aaa") && 
				pwd.contentEquals("aaa")) {
			Toast.makeText(getApplicationContext(), "Hello admin!", 
			Toast.LENGTH_SHORT).show(); 
		      Intent intent = new Intent(MainActivity.this, Prof.class);
		        startActivity(intent);
		} 
		else {
			Toast.makeText(getApplicationContext(), "Seems like you 're not admin!", 
					Toast.LENGTH_SHORT).show();
			numberOfRemainingLoginAttempts--;
			attemptsLeftTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
			numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
			
			if (numberOfRemainingLoginAttempts == 0) {
				login.setEnabled(false);
				loginLockedTV.setVisibility(View.VISIBLE);
				loginLockedTV.setBackgroundColor(Color.RED);
				loginLockedTV.setText("LOGIN LOCKED!!!");
			}
		}
	
	}*/
/*
	 void setupVariables() {
		username = (EditText) findViewById(R.id.editText10);
		password = (EditText) findViewById(R.id.editText20);
		login = (Button) findViewById(R.id.button1);
		loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
		attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
		numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
		numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
	}
	*/

        
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//public void onclicks(View view) {
//      Intent intent = new Intent(MainActivity.this, Prof.class);
//        startActivity(intent);
//     }
 
    }

 
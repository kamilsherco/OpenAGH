package com.example.openagh;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignInActivity extends Activity implements OnClickListener  {
	
	private EditText userName;
    private EditText password;
    private Button signin;
      
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        inicialize();
      
    }

	void inicialize()
    {

        userName = (EditText) findViewById(R.id.etName);
       
      
        password = (EditText) findViewById(R.id.edPassword);
        
        
        signin= (Button) findViewById(R.id.bSignin);
        signin.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 switch(arg0.getId())
	        {
	case R.id.bSignin:
		SignInRead task = new SignInRead();
		
        task.name=userName.getText().toString();
        task.pass=password.getText().toString();
        task.execute();
       
		finish();
    	Intent signin = new Intent(this, MainActivity.class);
    	startActivity(signin);


        break;
		
	}
	}
}

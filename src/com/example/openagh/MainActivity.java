package com.example.openagh;


import java.util.concurrent.ExecutionException;



import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	String html = "cos ";

   
    private static TextView test;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView)findViewById(R.id.tvURL);
      
    
      try {
		html= new HtmlRead().execute().get();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      test.setText(html);
        
    }


	
	
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

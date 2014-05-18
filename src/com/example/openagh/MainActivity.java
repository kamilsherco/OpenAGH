package com.example.openagh;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;



import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

	String[] html = new String[2] ;

   
    private static ListView test;
    private ArrayAdapter<String> listAdapter ; 
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test =(ListView)findViewById(R.id.lvURL);
      
    
     // Create and populate a List of tag.
      try {
		html= new HtmlRead().execute().get();
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	} catch (ExecutionException e) {
		
		e.printStackTrace();
	}
      ArrayList<String> tagList = new ArrayList<String>();  
      tagList.addAll( Arrays.asList(html) );
      
      // Create ArrayAdapter using the tag list. 
      listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, tagList); 
      
      
      // Set the ArrayAdapter as the ListView's adapter.
      test.setAdapter( listAdapter );
        
    }


	
	
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

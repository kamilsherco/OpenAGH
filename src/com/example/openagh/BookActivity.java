package com.example.openagh;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class BookActivity extends Activity implements OnItemClickListener {
	
	
   
    private static ListView test;
    private ArrayAdapter<String> listAdapter ;
    
    private String link;
    private String classTag;
    private String linkTag;
    private String withActivity;
    private HtmlRead task;
    
   
    
    private Intent mainIntent;
    
    private List<String> respone = new ArrayList<String>();
    private ArrayList<String> tagList = new ArrayList<String>(); 
    private List<String> tagLink = new ArrayList<String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_book);
        test =(ListView)findViewById(R.id.lvURL);
        if(!isOnline()){
        	Toast.makeText(getApplicationContext(), "Brak dostêpu do internetu. Proszê sie po³¹czyæ!!", 
        			   Toast.LENGTH_LONG).show();
        }
        
        mainIntent = getIntent(); // gets the previously created intent
        link = mainIntent.getStringExtra("link");
        classTag = mainIntent.getStringExtra("classTag");
        linkTag = mainIntent.getStringExtra("linkTag");
        withActivity=mainIntent.getStringExtra("activity");
        
        
        task = new HtmlRead();
        task.alias=link;
        task.TagsToClass=classTag;
        task.TagsToLink=linkTag;
        
     	task.execute();
     	try {
			respone=task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	
        
     
      for (int i = 0; i < respone.size(); i++) {
    	  if(i%2==0)
    		tagList.add((respone.get(i)));
    	  else
    		  tagLink.add((respone.get(i)));
  	}
      
 
      
      // Create ArrayAdapter using the tag list. 
      listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, tagList); 
      
      
      // Set the ArrayAdapter as the ListView's adapter.
      test.setAdapter( listAdapter );
      
      test.setOnItemClickListener(this);
      
        
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		// Toast.makeText(getApplicationContext(), "pos "+tagLink.get(position), Toast.LENGTH_SHORT).show();
		if(withActivity.equals("main")){
		Intent chose = new Intent(this, BookActivity.class);
     	chose.putExtra("link",tagLink.get(position));
     	chose.putExtra("classTag","chapter-name");
     	chose.putExtra("linkTag","div.chapter-name a");
     	chose.putExtra("activity","book");
     	startActivity(chose);
		 
		}
		else{
			Intent chose = new Intent(this, ViewBookActivity.class);
	     	chose.putExtra("link",tagLink.get(position));
	     	
	     	startActivity(chose);
			 
			}
	}
	public boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
	 @Override
	    public void onBackPressed() {
	            super.onBackPressed();
	            this.finish();
	            
	 }
	

}

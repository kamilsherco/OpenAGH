package com.example.openagh;



import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener {

	private ImageView maths;
    private ImageView physic;
    private Button signin;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicialize();
        if(!isOnline()){
        	Toast.makeText(getApplicationContext(), "Brak dostêpu do internetu. Proszê sie po³¹czyæ!!", 
        			   Toast.LENGTH_LONG).show();
        }
      
    }

	private void inicialize()
    {

        maths = (ImageView) findViewById(R.id.imMaths);
        maths.setOnClickListener(this);
      
        physic = (ImageView) findViewById(R.id.imPhysic);
        physic.setOnClickListener(this);
        
        signin= (Button) findViewById(R.id.bSignMain);
        signin.setOnClickListener(this);
        
        
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
	    public void onClick(View arg0) {
	        // TODO Auto-generated method stub
	        switch(arg0.getId())
	        {

	        case R.id.imMaths:

	        	Intent maths = new Intent(this, BookActivity.class);
	        	maths.putExtra("link","openagh-podreczniki.php?categId=4");
	        	maths.putExtra("classTag","name");
	        	maths.putExtra("linkTag","div.openagh-podrecznik-ogolny a");
	        	maths.putExtra("activity","main");
	        	startActivity(maths);



	            break;
	        case R.id.imPhysic:
	        	Intent physic = new Intent(this, BookActivity.class);
	        	physic.putExtra("link","openagh-podreczniki.php?categId=1");
	        	physic.putExtra("classTag","name");
	        	physic.putExtra("linkTag","div.openagh-podrecznik-ogolny a");
	        	physic.putExtra("activity","main");
	        	startActivity(physic);
 

	            break;
	            
	        case R.id.bSignMain:
	        
	        	Intent signin = new Intent(this, SignInActivity.class);
	        	startActivity(signin);


	            break;

	        }


	    }
	
	
	
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

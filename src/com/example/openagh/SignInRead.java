package com.example.openagh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;
import android.util.Log;


public class SignInRead extends AsyncTask<Void, Void, List<String>>
{
	private List<String> line = new ArrayList<String>();
	
	public String name;
	public String pass;
	
	
	//private  Element linkToelement;
	
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<String> doInBackground(Void... params) {
    	
 
    	
    	try{



    		
    		Connection.Response res = Jsoup.connect("http://epodreczniki.open.agh.edu.pl/tiki-index.php")
    		        .data("email", name,"logintype","checked", "password",pass,"login","Zaloguj")
    		        .method(Method.POST)
    		        .execute();
    		Map<String, String> loginCookies = res.cookies();
    	    
    		Document doc = Jsoup.connect("http://epodreczniki.open.agh.edu.pl/openagh-panel_user.php")
    			      .cookies(loginCookies)
    			      .get();
    		
    		Log.i("DOC", doc.toString().toString());
            
          
            
            

            	
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	System.out.println("SSS");
            e.printStackTrace();
        }
        
    	
    	
    	return line;
    }

    @Override
    protected void onPostExecute(List<String> result) {

        //bind data in lisview or any other componet
        super.onPostExecute(result);
    }
}

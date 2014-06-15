package com.example.openagh;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;
import android.util.Log;



public class HtmlRead extends AsyncTask<Void, Void, List<String>>
{
	private List<String> line = new ArrayList<String>();
	
	public String alias;
	public String TagsToLink;
	public String TagsToClass;
	
	private  Element linkToelement;
	
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<String> doInBackground(Void... params) {

 
    	
    	try{
            Document doc = Jsoup.connect("http://epodreczniki.open.agh.edu.pl/"+alias).get();
           // Log.i("DOC", doc.toString().toString());
            
            Elements elementsHtml = doc.getElementsByAttributeValue("class", TagsToClass);
            
           
            for(Element element: elementsHtml)
            {
          
                //Log.i("PARSED ELEMENTS:",URLDecoder.decode(element.text(), HTTP.UTF_8));
              
                line.add(element.text());
                linkToelement= doc.select(TagsToLink).first();
                
                
                line.add(linkToelement.attr("href"));
                

            }
            
            

            	
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
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

 



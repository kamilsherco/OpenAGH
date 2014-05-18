package com.example.openagh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;

import android.util.Log;

public class HtmlRead extends AsyncTask<Void, Void, String[]>
{
	private String[] line = new String[2];
	private StringBuilder sb = new StringBuilder();
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String[] doInBackground(Void... params) {

 
    	
    	try{
            Document doc = Jsoup.connect("http://epodreczniki.open.agh.edu.pl/").get();
           // Log.i("DOC", doc.toString().toString());
            
            Elements elementsHtml = doc.getElementsByAttributeValue("class", "openagh-category-container");
            int i =0;
            for(Element element: elementsHtml)
            {
                Log.i("PARSED ELEMENTS:",URLDecoder.decode(element.text(), HTTP.UTF_8));
                   line[i]=element.text();
                   i++;

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    	
    	return line;
    }

    @Override
    protected void onPostExecute(String[] result) {

        //bind data in lisview or any other componet
        super.onPostExecute(result);
    }
}

 


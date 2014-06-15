package com.example.openagh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class ViewBookActivity extends Activity {

	
	private Intent mainIntent;
	private String link;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_viewbook);
       
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setBuiltInZoomControls(true);
        mainIntent = getIntent(); // gets the previously created intent
        link = mainIntent.getStringExtra("link");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://epodreczniki.open.agh.edu.pl/"+link);
	}
}

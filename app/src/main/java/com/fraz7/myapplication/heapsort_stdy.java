package com.fraz7.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class heapsort_stdy extends AppCompatActivity {
    Toolbar myToolbar2;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heapsort_stdy);
        webview = findViewById(R.id.webview);
        myToolbar2 = findViewById(R.id.tool_bar);            // toolbar
        myToolbar2.setNavigationIcon(R.drawable.b);
        myToolbar2.setTitle("Bubble Sort");// toolbar layout file
        setSupportActionBar(myToolbar2);                  // support toolbar as actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // home button (arrow) set

        String url = "file:///android_asset/heapsort.html";
        webview.loadUrl(url);
        webview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webview.setLongClickable(false);
        WebSettings webSettings = webview.getSettings();
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);

        }
        if (id == R.id.studdy)
        {
            Intent i = new Intent(this, heapsort_stdy.class);
            startActivity(i);
        }
        return true;
    }
}

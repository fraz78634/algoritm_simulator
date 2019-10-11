package com.fraz7.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class heapSort extends AppCompatActivity {
    private static Button button, butto2, reset_bu;
    private static ImageView imageView;
    private static TextView textView;
    private int i = 0;
    private Handler handler = new Handler();
    Toolbar myToolbar2;
    // image resource

    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.hep_1, R.string.hep1));
        add(new BSortResource(R.drawable.hep_2, R.string.hep2));
        add(new BSortResource(R.drawable.hep_3, R.string.hep2));
        add(new BSortResource(R.drawable.hep_4, R.string.hep2));
        add(new BSortResource(R.drawable.hep_5, R.string.hep3));
        add(new BSortResource(R.drawable.hep_6, R.string.hep4));
        add(new BSortResource(R.drawable.hep_7, R.string.hep5));
        add(new BSortResource(R.drawable.hep_8, R.string.hep5));
        add(new BSortResource(R.drawable.hep_9, R.string.hep5));
        add(new BSortResource(R.drawable.hep_10, R.string.hep5));
        add(new BSortResource(R.drawable.hep_11, R.string.hep5));
        add(new BSortResource(R.drawable.hep_12, R.string.hep6));
        add(new BSortResource(R.drawable.hep_12, R.string.hep7));
        add(new BSortResource(R.drawable.hep_12, R.string.hep8));
        add(new BSortResource(R.drawable.hep_13, R.string.hep8));
        add(new BSortResource(R.drawable.hep_14, R.string.hep8));
        add(new BSortResource(R.drawable.hep_15, R.string.hep8));
        add(new BSortResource(R.drawable.hep_16, R.string.hep8));
        add(new BSortResource(R.drawable.hep_17, R.string.hep8));
        add(new BSortResource(R.drawable.hep_18, R.string.hep8));
        add(new BSortResource(R.drawable.hep_19, R.string.hep8));
        add(new BSortResource(R.drawable.hep_20, R.string.hep8));
        add(new BSortResource(R.drawable.hep_21, R.string.hep8));
        add(new BSortResource(R.drawable.hep_22, R.string.hep8));
        add(new BSortResource(R.drawable.hep_23, R.string.hep8));
        add(new BSortResource(R.drawable.hep_24, R.string.hep8));
        add(new BSortResource(R.drawable.hep_24, R.string.hep9));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_busort);

        // tool bar
        myToolbar2 = findViewById(R.id.tool_bar);            // toolbar
        myToolbar2.setNavigationIcon(R.drawable.backarrow);
        myToolbar2.setTitle("Heap Sort");// toolbar layout file
        myToolbar2.setBackgroundColor(Color.parseColor("#488bd8"));
        setSupportActionBar(myToolbar2);                  // support toolbar as actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // home button (arrow) set


        button = (Button) findViewById(R.id.button);
        butto2 = (Button) findViewById(R.id.button2);
        reset_bu = (Button) findViewById(R.id.reset_bu);
        final TextView textView = (TextView) findViewById(R.id.textView);
        butto2.setClickable(false);


        addListenerOnButton();
        setInitialImage();
        addback();
        reset();


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
                onBackPressed();

        }
        if (id == R.id.studdy)
        {
            Intent i = new Intent(this, heapsort_stdy.class);
            startActivity(i);
        }
        return true;
    }

    public void addListenerOnButton() {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(true);


                if (i < resourceList.size() - 1) {
                    i++;
                    i = i % resourceList.size();
                    setCurrentImage();

                }
            }
        });
    }


    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(resourceList.get(i).getResourceID());
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(resourceList.get(i).getDescription());


    }

    public void addback() {
        butto2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                if (i > 0) {

                    i--;

                    i = i % resourceList.size();
                    setCurrentImage();
                    butto2.setClickable(true);

                }


            }

        });

    }

    public void reset() {
        reset_bu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 0;
                setCurrentImage();

            }
        });
    }
}

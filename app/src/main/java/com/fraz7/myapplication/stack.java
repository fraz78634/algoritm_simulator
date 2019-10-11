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

public class stack extends AppCompatActivity {
    private static Button next_bu, pre_bu, reset_bu;
    private static ImageView imageView;
    private static TextView textView;
    private int i = 0;
    Toolbar myToolbar2;
    private boolean flag = false;
    // image resource

    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.stc_1, R.string.busort1));
        add(new BSortResource(R.drawable.stc_2, R.string.busort2));
        add(new BSortResource(R.drawable.stc_3, R.string.busort3));
        add(new BSortResource(R.drawable.stc_4, R.string.busort4));
        add(new BSortResource(R.drawable.stc_5, R.string.busort5));
        add(new BSortResource(R.drawable.stc_6, R.string.busort1));
        add(new BSortResource(R.drawable.stc_7, R.string.busort2));
        add(new BSortResource(R.drawable.stc_8, R.string.busort3));
        add(new BSortResource(R.drawable.stc_9, R.string.busort4));
        add(new BSortResource(R.drawable.stc_1, R.string.busort5));
        add(new BSortResource(R.drawable.stc_10, R.string.busort2));
        add(new BSortResource(R.drawable.stc_11, R.string.busort3));
        add(new BSortResource(R.drawable.stc_12, R.string.busort4));
        add(new BSortResource(R.drawable.stc_6, R.string.busort5));



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
        myToolbar2.setTitle("Bubble Sort");// toolbar layout file
        myToolbar2.setBackgroundColor(Color.parseColor("#488bd8"));
        setSupportActionBar(myToolbar2);                  // support toolbar as actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // home button (arrow) set

        next_bu = (Button) findViewById(R.id.button);
        pre_bu = (Button) findViewById(R.id.button2);
        reset_bu = (Button) findViewById(R.id.reset_bu);
        final TextView textView = (TextView) findViewById(R.id.textView);
        next_bu.setClickable(true);
        next_bu.setEnabled(true);
        reset_bu.setClickable(true);
        reset_bu.setEnabled(true);
        pre_bu.setClickable(false);


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
            Intent i = new Intent(this, bubblesortStudy.class);
            startActivity(i);
        }
        return true;
    }

    public void addListenerOnButton() {
        next_bu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                next_bu.setEnabled(true);

                if (flag = true) {
                    if (i < resourceList.size() - 1) {
                        i++;
                        i = i % resourceList.size();
                        setCurrentImage();


                    }
                   /* else {
                       // next_bu.setClickable(false);
                        next_bu.setEnabled(false);
                        next_bu.setBackgroundResource(R.color.bu_disable);
                    } */

                }
                flag = false;

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
        pre_bu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                if (i > 0) {

                    i--;

                    i = i % resourceList.size();
                    setCurrentImage();
                    pre_bu.setClickable(true);

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

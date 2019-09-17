package com.fraz7.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    int[] images = {R.drawable.hep_1,R.drawable.hep_2,R.drawable.hep_3,R.drawable.hep_4,R.drawable.hep_5,R.drawable.hep_6,R.drawable.hep_7,R.drawable.hep_8,R.drawable.hep_9,R.drawable.hep_10
            ,R.drawable.hep_11,R.drawable.hep_12,R.drawable.hep_13,R.drawable.hep_14,R.drawable.hep_15,R.drawable.hep_16,R.drawable.hep_17,R.drawable.hep_18,R.drawable.hep_19,R.drawable.hep_20
            ,R.drawable.hep_21,R.drawable.hep_22,R.drawable.hep_23,R.drawable.hep_24};

    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.hep_1, "Description im_1 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.hep_2, "Description im_2 for image one this is Insertion sort"));
       add(new BSortResource(R.drawable.hep_3, "Description im_3 for image one this is bubble sort"));
        add(new BSortResource(R.drawable.hep_4, "Description im_4 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.hep_5, "Description im_5 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.hep_6, "Description im_6 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.hep_7, "Description im_7 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.hep_8, "Description im_8"));
        add(new BSortResource(R.drawable.hep_9, "Description im_9"));
        add(new BSortResource(R.drawable.hep_10, "Description im_10"));
        add(new BSortResource(R.drawable.hep_11, "Description im_11"));
        add(new BSortResource(R.drawable.hep_12, "Description im_12"));
        add(new BSortResource(R.drawable.hep_13, "Description im_13"));
        add(new BSortResource(R.drawable.hep_14, "Description im_14"));
        add(new BSortResource(R.drawable.hep_15, "Description im_15"));
        add(new BSortResource(R.drawable.hep_16, "Description im_16"));
        add(new BSortResource(R.drawable.hep_17, "Description im_17"));
        add(new BSortResource(R.drawable.hep_18, "Description im_18"));
        add(new BSortResource(R.drawable.hep_19, "Description im_19"));
        add(new BSortResource(R.drawable.hep_20, "Description im_20"));
        add(new BSortResource(R.drawable.hep_21, "Description im_21"));
        add(new BSortResource(R.drawable.hep_22, "Description im_22"));
        add(new BSortResource(R.drawable.hep_23, "Description im_21"));
        add(new BSortResource(R.drawable.hep_24, "Description im_22"));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heap_sort);

        // tool bar
        myToolbar2 = findViewById(R.id.tool_bar);            // toolbar
        myToolbar2.setNavigationIcon(R.drawable.b);
        myToolbar2.setTitle("Heap Sort");// toolbar layout file
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

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

public class selectionSort extends AppCompatActivity {
    private static Button button, butto2, reset_bu;
    private static ImageView imageView;
    private static TextView textView;
    private int i = 0;
    private Handler handler = new Handler();
    Toolbar myToolbar2;
    // image resource

    int[] images = {R.drawable.sel_1,R.drawable.sel_2,R.drawable.sel_3,R.drawable.sel_4,R.drawable.sel_5,R.drawable.sel_6,R.drawable.sel_7,R.drawable.sel_8,R.drawable.sel_9,R.drawable.sel_10
            ,R.drawable.sel_11,R.drawable.sel_12,R.drawable.sel_13,R.drawable.sel_14,R.drawable.sel_15,R.drawable.sel_16};

    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.sel_1, "Description im_1 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_2, "Description im_2 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_3, "Description im_3 for image one this is bubble sort"));
        add(new BSortResource(R.drawable.sel_4, "Description im_4 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_5, "Description im_5 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_6, "Description im_6 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_7, "Description im_7 for image one this is Insertion sort"));
        add(new BSortResource(R.drawable.sel_8, "Description im_8"));
        add(new BSortResource(R.drawable.sel_9, "Description im_9"));
        add(new BSortResource(R.drawable.sel_10, "Description im_10"));
        add(new BSortResource(R.drawable.sel_11, "Description im_11"));
        add(new BSortResource(R.drawable.sel_12, "Description im_12"));
        add(new BSortResource(R.drawable.sel_13, "Description im_13"));
        add(new BSortResource(R.drawable.sel_14, "Description im_14"));
        add(new BSortResource(R.drawable.sel_15, "Description im_15"));
        add(new BSortResource(R.drawable.sel_16, "Description im_16"));

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
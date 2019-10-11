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

public class merge_sort extends AppCompatActivity {
    private static Button next_bu, pre_bu, reset_bu;
    private static ImageView imageView;
    private static TextView textView;
    private int i = 0;
    Toolbar myToolbar2;
    private boolean flag = false;
    // image resource

    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.mer_1, R.string.mer1));
        add(new BSortResource(R.drawable.mer_2, R.string.mer2));
        add(new BSortResource(R.drawable.mer_3, R.string.mer2));
        add(new BSortResource(R.drawable.mer_4, R.string.mer2));
        add(new BSortResource(R.drawable.mer_5, R.string.mer2));
        add(new BSortResource(R.drawable.mer_5, R.string.mer3));
        add(new BSortResource(R.drawable.mer_5, R.string.mer4));
        add(new BSortResource(R.drawable.mer_5, R.string.mer5));
        add(new BSortResource(R.drawable.mer_6, R.string.mer5));
        add(new BSortResource(R.drawable.mer_6b, R.string.mer5));
        add(new BSortResource(R.drawable.mer_6b, R.string.mer6));
        add(new BSortResource(R.drawable.mer_7, R.string.mer7));
        add(new BSortResource(R.drawable.mer_9, R.string.mer8));
        add(new BSortResource(R.drawable.mer_9, R.string.mer9));
        add(new BSortResource(R.drawable.mer_10, R.string.mer10));
        add(new BSortResource(R.drawable.mer_11, R.string.mer11));
        add(new BSortResource(R.drawable.mer_12, R.string.mer12));
        add(new BSortResource(R.drawable.mer_13, R.string.mer13));
        add(new BSortResource(R.drawable.mer_14, R.string.mer14));
        add(new BSortResource(R.drawable.mer_15, R.string.mer14));
        add(new BSortResource(R.drawable.mer_16, R.string.mer14));
        add(new BSortResource(R.drawable.mer_17, R.string.mer14));
        add(new BSortResource(R.drawable.mer_18, R.string.mer14));
        add(new BSortResource(R.drawable.mer_19, R.string.mer14));
        add(new BSortResource(R.drawable.mer_20, R.string.mer14));
        add(new BSortResource(R.drawable.mer_21, R.string.mer14));
        add(new BSortResource(R.drawable.mer_22, R.string.mer14));
        add(new BSortResource(R.drawable.mer_23, R.string.mer14));
        add(new BSortResource(R.drawable.mer_24, R.string.mer14));
        add(new BSortResource(R.drawable.mer_25, R.string.mer14));
        add(new BSortResource(R.drawable.mer_26, R.string.mer14));
        add(new BSortResource(R.drawable.mer_27, R.string.mer14));
        add(new BSortResource(R.drawable.mer_28, R.string.mer14));
        add(new BSortResource(R.drawable.mer_29, R.string.mer14));
        add(new BSortResource(R.drawable.mer_30, R.string.mer15));
        add(new BSortResource(R.drawable.mer_30, R.string.mer16));


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
        myToolbar2.setTitle("Merge Sort");// toolbar layout file
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

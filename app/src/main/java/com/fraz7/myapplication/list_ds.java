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

public class list_ds extends AppCompatActivity {
    private static Button next_bu, pre_bu, reset_bu;
    private static ImageView imageView;
    private static TextView textView;
    private int i = 0;
    Toolbar myToolbar2;
    private boolean flag = false;

    private boolean isStart=true;
    // image resource
    List<BSortResource> resourceList = new ArrayList<BSortResource>() {{
        add(new BSortResource(R.drawable.lst_1, R.string.lst1));
        add(new BSortResource(R.drawable.lst_2, R.string.lst2));
        add(new BSortResource(R.drawable.lst_3, R.string.lst3));
        add(new BSortResource(R.drawable.lst_4, R.string.lst4));
        add(new BSortResource(R.drawable.lst_5, R.string.lst4));
        add(new BSortResource(R.drawable.lst_6, R.string.lst4));
        add(new BSortResource(R.drawable.lst_7, R.string.lst4));
        add(new BSortResource(R.drawable.lst_8, R.string.lst4));
        add(new BSortResource(R.drawable.lst_9, R.string.lst5));
        add(new BSortResource(R.drawable.lst_10, R.string.lst6));
        add(new BSortResource(R.drawable.lst_11, R.string.lst7));
        add(new BSortResource(R.drawable.lst_12, R.string.lst8));
        add(new BSortResource(R.drawable.lst_13, R.string.lst9));
        add(new BSortResource(R.drawable.lst_14, R.string.lst10));
        add(new BSortResource(R.drawable.lst_14, R.string.lst10));

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
        myToolbar2.setTitle(R.string.list);// toolbar layout file
        myToolbar2.setBackgroundColor(Color.parseColor("#1ac260"));
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
        listenForButtonStatus();

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
            Intent i = new Intent(this, list_std.class);
            startActivity(i);
        }
        return true;
    }

    public void addListenerOnButton() {
        next_bu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                next_bu.setEnabled(true);
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


    View.OnClickListener nextBtnListner = new OnClickListener() {
        @Override
        public void onClick(View v) {
            next_bu.setEnabled(true);
            isStart = true;
            if (flag = true) {
                if (i < resourceList.size() - 1) {
                    listenForNextBtn(true);
                    i++;
                    i = i % resourceList.size();
                    setCurrentImage();


                }else{
                    listenForNextBtn(false);

                }

            }
            flag = false;



        }



    };


    View.OnClickListener prevBtnListner=new OnClickListener() {
        @Override
        public void onClick(View v) {


            if (i > 0) {
                listenForPreviousBtn(true);
                i--;

                i = i % resourceList.size();
                setCurrentImage();
                pre_bu.setClickable(true);

            }else{
                listenForPreviousBtn(false);

            }


        }

    };


    View.OnClickListener resetBtnListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            isStart=true;
            listenForButtonStatus();
            i = 0;
            setCurrentImage();


        }
    };


    public void listenForNextBtn(final boolean status){

        if(status){
            next_bu.setOnClickListener(nextBtnListner);
            pre_bu.setOnClickListener(prevBtnListner);
            reset_bu.setOnClickListener(resetBtnListener);

            next_bu.setBackgroundResource(R.drawable.next_button_selector);
            pre_bu.setBackgroundResource(R.drawable.pre_bu_selector);
            reset_bu.setBackgroundResource(R.drawable.reset_bu_selector);
        }else{
            next_bu.setOnClickListener(null);
            next_bu.setBackgroundResource(R.drawable.disabled_bu);
        }

    }

    public void listenForPreviousBtn(final boolean status){
        next_bu.setOnClickListener(nextBtnListner);
        next_bu.setBackgroundResource(R.drawable.next_button_selector);
        if(status){

            pre_bu.setOnClickListener(prevBtnListner);
            pre_bu.setBackgroundResource(R.drawable.pre_bu_selector);

        }else{
            pre_bu.setOnClickListener(null);
            pre_bu.setBackgroundResource(R.drawable.disabled_bu);
            reset_bu.setOnClickListener(null);
            reset_bu.setBackgroundResource(R.drawable.disabled_bu);
        }

    }


    public void listenForButtonStatus(){
        if(isStart){
            next_bu.setOnClickListener(nextBtnListner);
            pre_bu.setOnClickListener(null);
            reset_bu.setOnClickListener(null);
            next_bu.setBackgroundResource(R.drawable.next_button_selector);
            pre_bu.setBackgroundResource(R.drawable.disabled_bu);
            reset_bu.setBackgroundResource(R.drawable.disabled_bu);
        }else{
            next_bu.setOnClickListener(null);
            pre_bu.setOnClickListener(prevBtnListner);
            reset_bu.setOnClickListener(resetBtnListener);

            next_bu.setBackgroundResource(R.drawable.disabled_bu);
            pre_bu.setBackgroundResource(R.drawable.pre_bu_selector);
            reset_bu.setBackgroundResource(R.drawable.reset_bu_selector);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
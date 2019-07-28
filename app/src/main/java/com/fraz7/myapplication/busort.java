package com.fraz7.myapplication;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.os.Handler;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class busort extends AppCompatActivity {
    private static Button button, butto2,reset_bu, auto;
    private static ImageView imageView;
    private static TextView textView;
    private int i=0;
    private Handler handler = new Handler();
    Toolbar myToolbar;
        // image resource

    int[] images = {R.drawable.im_1, R.drawable.im_2, R.drawable.im_3,R.drawable.im_4,R.drawable.im_5,R.drawable.im_6,R.drawable.im_7,R.drawable.im_8,
            R.drawable.im_9,R.drawable.im_10,R.drawable.im_11,R.drawable.im_12,R.drawable.im_13,R.drawable.im_14,R.drawable.im_15,R.drawable.im_16,R.drawable.im_17,
            R.drawable.im_18,R.drawable.im_19,R.drawable.im_20,R.drawable.im_21,R.drawable.im_22,R.drawable.im_23,R.drawable.im_24, R.drawable.im_25, R.drawable.im_26,
            R.drawable.im_27, R.drawable.im_28, R.drawable.im_29,R.drawable.im_30, R.drawable.im_31, R.drawable.im_32,R.drawable.im_33, R.drawable.im_34, R.drawable.im_35,
            R.drawable.im_36, R.drawable.im_37, R.drawable.im_38,R.drawable.im_39, R.drawable.im_40, R.drawable.im_41,R.drawable.im_42, R.drawable.im_43, R.drawable.im_44,
            R.drawable.im_45};

    List<BSortResource> resourceList = new ArrayList<BSortResource>(){{
        add(new BSortResource(R.drawable.im_1,"Description im_1 for image one this is bubble sort"));
        add(new BSortResource(R.drawable.im_2,"Description im_2 for image one this is bubble sort"));
        add(new BSortResource(R.drawable.im_3,"Description im_3 for image one this is bubble sort"));
        add(new BSortResource(R.drawable.im_4,"Description im_4"));
        add(new BSortResource(R.drawable.im_5,"Description im_5"));
        add(new BSortResource(R.drawable.im_6,"Description im_6"));
        add(new BSortResource(R.drawable.im_7,"Description im_7"));
        add(new BSortResource(R.drawable.im_8,"Description im_8"));
        add(new BSortResource(R.drawable.im_9,"Description im_9"));
        add(new BSortResource(R.drawable.im_10,"Description im_10"));
        add(new BSortResource(R.drawable.im_11,"Description im_11"));
        add(new BSortResource(R.drawable.im_12,"Description im_12"));
        add(new BSortResource(R.drawable.im_13,"Description im_13"));
        add(new BSortResource(R.drawable.im_14,"Description im_14"));
        add(new BSortResource(R.drawable.im_15,"Description im_15"));
        add(new BSortResource(R.drawable.im_16,"Description im_16"));
        add(new BSortResource(R.drawable.im_17,"Description im_17"));
        add(new BSortResource(R.drawable.im_18,"Description im_18"));
        add(new BSortResource(R.drawable.im_19,"Description im_19"));
        add(new BSortResource(R.drawable.im_20,"Description im_20"));
        add(new BSortResource(R.drawable.im_21,"Description im_21"));
        add(new BSortResource(R.drawable.im_22,"Description im_22"));
        add(new BSortResource(R.drawable.im_23,"Description im_23"));
        add(new BSortResource(R.drawable.im_24,"Description im_24"));
        add(new BSortResource(R.drawable.im_25,"Description im_25"));
        add(new BSortResource(R.drawable.im_26,"Description im_26"));
        add(new BSortResource(R.drawable.im_27,"Description im_27"));
        add(new BSortResource(R.drawable.im_28,"Description im_28"));
        add(new BSortResource(R.drawable.im_29,"Description im_29"));
        add(new BSortResource(R.drawable.im_30,"Description im_30"));
        add(new BSortResource(R.drawable.im_31,"Description im_31"));
        add(new BSortResource(R.drawable.im_32,"Description im_32"));
        add(new BSortResource(R.drawable.im_33,"Description im_33"));
        add(new BSortResource(R.drawable.im_34,"Description im_34"));
        add(new BSortResource(R.drawable.im_35,"Description im_35"));
        add(new BSortResource(R.drawable.im_36,"Description im_36"));
        add(new BSortResource(R.drawable.im_37,"Description im_37"));
        add(new BSortResource(R.drawable.im_38,"Description im_38"));
        add(new BSortResource(R.drawable.im_39,"Description im_39"));
        add(new BSortResource(R.drawable.im_40,"Description im_40"));
        add(new BSortResource(R.drawable.im_41,"Description im_41"));
        add(new BSortResource(R.drawable.im_42,"Description im_42"));
        add(new BSortResource(R.drawable.im_43,"Description im_43"));
        add(new BSortResource(R.drawable.im_44,"Description im_44"));
        add(new BSortResource(R.drawable.im_45,"Description im_45"));


    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busort);

        // tool bar
        myToolbar = findViewById(R.id.tool_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setSupportActionBar(myToolbar);
        Bundle bundle = getIntent().getExtras();
        if( bundle != null)
        {
            myToolbar.setTitle(bundle.getString("Tool_tile") );
        }


        button = (Button) findViewById(R.id.button);
        butto2 = (Button) findViewById(R.id.button2);
        reset_bu = (Button) findViewById(R.id.reset_bu);
        final TextView textView = (TextView) findViewById(R.id.textView);
        // auto = (Button) findViewById(R.id.auto);
        //  imageView = (ImageView) findViewById(R.id.imageView);

        addListenerOnButton();
        setInitialImage();
        addback();
        reset();

    }
    public void addListenerOnButton () {
        button.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                if (i < resourceList.size() -1){
                    i++;
                    i = i % resourceList.size();
                    setCurrentImage();

                }
            } });
    }
    private void setInitialImage() {
        setCurrentImage();
    }
    private void setCurrentImage() {
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(resourceList.get(i).getResourceID());
        final TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(resourceList.get(i).getDescription());


    }
    public void addback(){
        butto2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0){
                    i--;
                    i = i % resourceList.size();
                    setCurrentImage();
                }

            }

        });

    }
    public void reset(){
        reset_bu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                i=0;
                setCurrentImage();

            }
        });
    }
}

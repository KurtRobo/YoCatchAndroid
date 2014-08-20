package com.example.YoCatchAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import java.util.*;
import android.graphics.Color;
import android.widget.GridLayout.LayoutParams;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private String displayText;
    private TextView myTextView;
    private EditText yoField;
    private EditText nameField;
    private LinearLayout myLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Defining output text
        displayText = "";

        //Linking to XML layout field
        myLayout = (LinearLayout) findViewById(R.id.myLayout);

        //Setting editText parameters
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        editTextParams.leftMargin = 30;
        editTextParams.topMargin = 30;
        editTextParams.rightMargin = 30;

        //Create yo text field
        yoField = new EditText(this.getApplicationContext());
        yoField.setHint("Yo");
        yoField.setWidth(1000);

        //Create name text field
        nameField = new EditText(this.getApplicationContext());
        nameField.setHint("Catch!");
        nameField.setWidth(1000);

        //Create text label
        myTextView = new TextView(this.getApplicationContext());
        myTextView.setTextSize(60);
        myTextView.setText(displayText);
        myTextView.setGravity(Gravity.CENTER);
        myTextView.setTextColor(Color.WHITE);

        //Create button parameters
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        buttonParams.bottomMargin = 30;
        buttonParams.gravity = Gravity.CENTER;

        //Create button
        Button showMessageButton = new Button(this.getApplicationContext());
        showMessageButton.setText("Show Message");

        //Adding objects to view
        setContentView(myLayout, editTextParams);
        myLayout.addView(yoField, editTextParams);
        myLayout.addView(nameField, editTextParams);
        myLayout.addView(myTextView, new LinearLayout.LayoutParams(720, 700));
        myLayout.addView(showMessageButton, buttonParams);


        //Logic etc
        showMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLabel();
            }
        });

        yoField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            changeLabel();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        nameField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_ENTER:
                        changeLabel();
                        return true;
                    default:
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void changeLabel() {
        if(!displayText.equals(yoField.getText() + "\n" + nameField.getText())) {
            //Setting string to current label text
            displayText = yoField.getText() + "\n" + nameField.getText();

            //New color generated
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            myLayout.setBackgroundColor(color);
            myTextView.setText(displayText);
        }
    }
}
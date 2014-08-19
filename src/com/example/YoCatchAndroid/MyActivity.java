package com.example.YoCatchAndroid;

import android.app.Activity;
import android.os.Bundle;
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
    private Button showMessageButton;
    private LinearLayout myLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setContentView(myLayout, linLayoutParam);

        Button newButton = new Button(this.getApplicationContext());
        newButton.setText("button");

        myLayout.addView(newButton, linLayoutParam);

        displayText = "";
       /* myTextView = (TextView) findViewById(R.id.textView);
        yoField = (EditText) findViewById(R.id.yoField);
        nameField = (EditText) findViewById(R.id.nameField);
        showMessageButton = (Button) findViewById(R.id.showMessageButton);
        myLayout = (LinearLayout) findViewById(R.id.myLayout);*/











        //Leave stuff



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
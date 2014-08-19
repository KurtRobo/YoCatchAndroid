package com.example.YoCatchAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.*;
import android.graphics.Color;
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

        displayText = "";
        myTextView = (TextView) findViewById(R.id.textView);
        yoField = (EditText) findViewById(R.id.yoField);
        nameField = (EditText) findViewById(R.id.nameField);
        showMessageButton = (Button) findViewById(R.id.showMessageButton);
        myLayout = (LinearLayout) findViewById(R.id.myLayout);

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
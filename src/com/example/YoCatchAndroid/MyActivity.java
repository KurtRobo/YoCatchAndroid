package com.example.YoCatchAndroid;

import java.util.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView myTextView = (TextView)findViewById(R.id.textView);
        final EditText yoField = (EditText)findViewById(R.id.yoField);
        final EditText nameField = (EditText)findViewById(R.id.nameField);
        final Button showMessageButton = (Button)findViewById(R.id.showMessageButton);

        showMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText(yoField.getText() + "\n" + nameField.getText());
            }
        });

        yoField.setImeActionLabel("Custom text", KeyEvent.KEYCODE_ENTER);

/*
        yoField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        }

            @Override
            public boolean onEditorAction(TextView arg0, int keycode, KeyEvent event) {
                if(arg1 == KeyEvent.FLAG_EDITOR_ACTION){
                    btnSave.requestFocus();
                    return true;
                }
                return false;

            });
*/
    }
}

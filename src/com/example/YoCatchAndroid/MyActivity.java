package com.example.YoCatchAndroid;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
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
    private MediaPlayer normalYo;
    private MediaPlayer softYo;
    private MediaPlayer loudYo;

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

        setupSounds();

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

    public void setupSounds() {
        normalYo = new MediaPlayer();
        softYo = new MediaPlayer();
        loudYo = new MediaPlayer();

        try {
            AssetFileDescriptor normalAfd = getAssets().openFd("yoSound1.mp3");
            AssetFileDescriptor softAfd = getAssets().openFd("yoSound2.mp3");
            AssetFileDescriptor loudAfd = getAssets().openFd("yoSound3.mp3");

            normalYo.setDataSource(normalAfd.getFileDescriptor(), normalAfd.getStartOffset(), normalAfd.getLength());
            softYo.setDataSource(softAfd.getFileDescriptor(), softAfd.getStartOffset(), softAfd.getLength());
            loudYo.setDataSource(loudAfd.getFileDescriptor(), loudAfd.getStartOffset(), loudAfd.getLength());

            normalYo.prepare();
            softYo.prepare();
            loudYo.prepare();
        }
        catch (IllegalArgumentException e) {}
        catch (IllegalStateException e) {}
        catch (IOException e) {}

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

            if(yoField.getText().toString().equals("Yo")) {
                this.normalYo.start();
                System.out.println("normal");
            }
            else if(yoField.getText().toString().equals("yo")) {
                this.softYo.start();
            }
            else if(yoField.getText().toString().equals("YO"))
                this.loudYo.start();

            System.out.println("-" + yoField.getText() + "-");
        }
    }
}
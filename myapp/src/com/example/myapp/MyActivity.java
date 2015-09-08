package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyActivity extends Activity{
    /**
     * Called when the activity is first created.
     */

    private ImageView imageView ;
    private TextView textView ;
    private int alphaValue ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageView = (ImageView)findViewById(R.id.alphaimage);
        textView = (TextView)findViewById(R.id.alphavalue);
        alphaValue = 100;

        imageView.setAlpha(alphaValue);
        textView.setText("Alpha = "+ alphaValue*100/0xff +"%");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.v("MyActivity","onKeyDown : keyCode = "+ keyCode);
        Log.v("MyActivity","onKeyDown : String = "+ event.toString());

        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                alphaValue+=20;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                alphaValue -=20;
                break;
            default:break;
        }

        if(alphaValue >= 0xff){
            alphaValue = 0xff;
        }

        if (alphaValue<= 0x0){
            alphaValue = 0x0;
        }

        imageView.setAlpha(alphaValue);
        textView.setText("Alpha = "+ alphaValue*100/0xff +"%");
        return super.onKeyDown(keyCode, event);
    }
}

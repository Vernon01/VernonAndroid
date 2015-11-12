package com.venom.bestreviewapp.ReviewApp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {

    private static Button button_creatorInfo;
    private static Button button_Review;
    private static Button button_FunInfo;
    private static Button button_AboutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnClickButtonListener();
        OnClickButtonListener2();
        OnClickButtonListener3();
        OnClickButtonListener4();
    }

    public void OnClickButtonListener(){
        button_creatorInfo = (Button)findViewById(R.id.button);
        button_creatorInfo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.venom.bestreviewapp.app.AboutCreator");
                        startActivity(intent);
                    }
                }
        );
    }

    public void OnClickButtonListener2(){
        button_Review = (Button)findViewById(R.id.button2);
        button_Review.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.venom.bestreviewapp.app.Review");
                        startActivity(intent);
                    }
                }
        );
    }

    public void OnClickButtonListener3(){
        button_FunInfo = (Button)findViewById(R.id.button3);
        button_FunInfo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.venom.bestreviewapp.app.FunInformation");
                        startActivity(intent);
                    }
                }
        );
    }

    public void OnClickButtonListener4(){
        button_AboutApp = (Button)findViewById(R.id.button4);
        button_AboutApp.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.venom.bestreviewapp.app.AboutApp");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

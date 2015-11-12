package com.venom.bestreviewapp.ReviewApp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Review extends ActionBarActivity {

    DatabaseHelper myDB;
    private static Button button_Review;
    private static Button button_GetReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        myDB = new DatabaseHelper(this);
        OnClickButtonListener();
        OnClickButtonListener1();

    }


    public void OnClickButtonListener(){
        button_Review = (Button)findViewById(R.id.button5);
        button_Review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.venom.bestreviewapp.app.EnterReview");
                        startActivity(intent);
                    }
                }
        );
    }

    public void OnClickButtonListener1(){
        button_GetReview = (Button)findViewById(R.id.button6);
        button_GetReview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDB.getAllData();
                        if (res.getCount()==0){
                            showMessage("Error", "No Data Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (!res.isAfterLast()){
                            buffer.append("ID: ," + res.getString(0)+"\n");
                            buffer.append("Movie Name: ," + res.getString(1)+"\n");
                            buffer.append("Experience: ," + res.getString(2)+"\n");
                            res.moveToNext();
                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review, menu);
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

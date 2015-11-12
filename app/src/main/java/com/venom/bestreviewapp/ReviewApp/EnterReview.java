package com.venom.bestreviewapp.ReviewApp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EnterReview extends ActionBarActivity {

    DatabaseHelper myDB;

    EditText editView;
    EditText editView1;
    Button button_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_review);
        myDB = new DatabaseHelper(this);

        editView = (EditText)findViewById(R.id.editText_view);
        editView1 = (EditText)findViewById(R.id.editText_view1);
        button_submit = (Button)findViewById(R.id.button_SubmitView);
        AddData();
    }

    public void AddData(){
        button_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(editView.getText().toString(),
                                editView1.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(EnterReview.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EnterReview.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_review, menu);
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

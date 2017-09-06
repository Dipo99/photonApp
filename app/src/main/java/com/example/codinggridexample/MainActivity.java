package com.example.codinggridexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codinggridexample.shortestpath.MinCostPath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
Pattern p;
    Matcher m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* // set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set up floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // shortest path with grid show.

        //  Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final MinCostPath matrixClass = new MinCostPath();

        final EditText inputTV = (EditText) findViewById(R.id.input);
        inputTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        final TextView outputTV = (TextView) findViewById(R.id.output);
        outputTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        final TextView hint = (TextView) findViewById(R.id.Hint);
        hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(inputTV.getText().toString().trim())) {

                    outputTV.setText(matrixClass.normalMatrix(inputTV.getText().toString()));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Matrix", Toast.LENGTH_SHORT).show();
                }
            }
        });
      //  hint.setText("Each row seperated by Semi-colon(;) and Each Column sepereated by Comma(,)");
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

        /*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
            inputTV.setText("");

                int count = 0;

                while(m.find()) {
                    count++;
                    System.out.println("Match number "+count);
                    System.out.println("start(): "+m.start());
                    System.out.println("end(): "+m.end());

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
*/
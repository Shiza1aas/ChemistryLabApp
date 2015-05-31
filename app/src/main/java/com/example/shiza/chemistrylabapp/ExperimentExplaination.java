package com.example.shiza.chemistrylabapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ExperimentExplaination extends ActionBarActivity {
    TextView theory;
    TextView heading;
    TextView aim;
    TextView apparatus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_explaination);
        Intent i = getIntent();

        int position = i.getIntExtra("Position",0);

        theory = (TextView)findViewById(R.id.experiment_theory);
        heading = (TextView)findViewById(R.id.experiment_heading);
        aim = (TextView)findViewById(R.id.experiment_aim);
        apparatus = (TextView)findViewById(R.id.experiment_apparatus);
        theory.setText("The theory goes for " + position);
        heading.setText("The heading goes for " + position);
        aim.setText("The aim goes for " + position);
        apparatus.setText("The apparatus goes for " + position);
    }
}

package com.example.shiza.chemistrylabapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Experiments extends ActionBarActivity implements AdapterView.OnItemClickListener
{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiments);
        listView = (ListView)findViewById(R.id.listExperiments);
        Resources res = this.getResources();
        String[] experiments = res.getStringArray(R.array.experiments);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.experiment_list,R.id.list_item,experiments);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent i=new Intent(this, ExperimentExplaination.class);
        i.putExtra("Position",position);
        startActivity(i);
    }
}

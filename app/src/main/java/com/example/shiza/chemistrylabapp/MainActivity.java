package com.example.shiza.chemistrylabapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    GridView homeGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeGridView = (GridView)findViewById(R.id.gridViewHome);
        homeGridView.setAdapter(new homeAdapter(this));
        homeGridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        switch (position)
        {
            case 0:
                Intent intent_about = new Intent(this,About.class);
                startActivity(intent_about);
                break;
            case 1:
                Intent intent_experiments = new Intent(this,Experiments.class);
                startActivity(intent_experiments);
                break;
            default:
                Toast.makeText(this,"Hello from other area",Toast.LENGTH_LONG).show();
                break;

        }

    }

    public class homeList
    {
        int imageId;
        String homeName;

        homeList(int imageId,String homeName)
        {
            this.imageId = imageId;
            this.homeName = homeName;
        }
    }

    public class homeAdapter extends BaseAdapter
    {
        ArrayList<homeList> homeLists;
        Context context;
        homeAdapter(Context context)
        {
            this.context = context;
            homeLists = new ArrayList<homeList>();
            Resources res = context.getResources();


            String[] tempHomeContent = res.getStringArray(R.array.home_content);
            int[] tempHomeImage = {R.drawable.chemistrylablogo,
                    R.drawable.experiments,
                    R.drawable.viva,
                    R.drawable.contactus,
                    R.drawable.rate,
                    R.drawable.share};
            for (int i = 0 ; i < 6 ; i++)
            {
                homeList tempHomeList = new homeList(tempHomeImage[i],tempHomeContent[i]);
                homeLists.add(tempHomeList);
            }
        }

        @Override
        public int getCount() {
            return homeLists.size();
        }

        @Override
        public Object getItem(int i) {
            return homeLists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        class viewHolder
        {
            ImageView myContent;

            viewHolder(View v)
            {
                myContent = (ImageView)v.findViewById(R.id.imageView);
            }
        }

        @Override


        public View getView(int i, View view, ViewGroup viewGroup) {

            View row = view;
            viewHolder holder;
            if (row == null )
            {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_item,viewGroup,false);
                holder = new viewHolder(row);
                row.setTag(holder);
            }
            else
            {
                holder = (viewHolder)row.getTag();
            }

            homeList temp = homeLists.get(i);
            holder.myContent.setImageResource(temp.imageId);
            return row;
        }
    }



}
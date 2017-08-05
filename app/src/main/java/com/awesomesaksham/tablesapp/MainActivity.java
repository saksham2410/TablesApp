package com.awesomesaksham.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView newlistview;

    public void meowtable(int meow){

        ArrayList<String> meowcontent = new ArrayList<String>();
        for (int i=1; i<21; i++)
        {
            meowcontent.add(Integer.toString(i*meow));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meowcontent);
        newlistview.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar newseekbar = (SeekBar)findViewById(R.id.seekBar1);
        newlistview = (ListView) findViewById(R.id.gridLayout);
        newseekbar.setMax(20);
        newseekbar.setProgress(10);
        newseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int meow;

                if (i<min){
                    meow=min;
                    newseekbar.setProgress(min);
                }
                else {
                    meow=i;
                }
                meowtable(meow);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        meowtable(10);


    }
}

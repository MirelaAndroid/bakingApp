package com.baking.mirela.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.baking.mirela.bakingapp.ui.MainFragment;

public class MainActivity extends AppCompatActivity {


    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = new MainFragment();
        fragment.setActivity(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,fragment).commit();

    }


}

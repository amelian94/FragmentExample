package com.neonidapps.fragmentexample.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neonidapps.fragmentexample.R;
import com.neonidapps.fragmentexample.fragments.DataFragment;
import com.neonidapps.fragmentexample.fragments.DetailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataTransfer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendText(String text) {
        DetailsFragment details = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
        details.renderText(text);
    }
}

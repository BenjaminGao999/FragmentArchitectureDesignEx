package com.gaos.fragmentnestedex;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.gaos.fragmentnestedex.fragment.FragmentA;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmnet_container, new FragmentA()).commit();
    }
}

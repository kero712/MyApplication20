package com.example.kerobeeh.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;



public class Main extends Activity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragmentManager = getFragmentManager();

        if(savedInstanceState == null){
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.framCont,new Sign_in(),"sign_in")
                    .commit();
        }









    }
}


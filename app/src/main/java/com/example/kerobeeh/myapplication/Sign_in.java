package com.example.kerobeeh.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kero beeh on 10/20/2017.
 */

public class Sign_in extends Fragment {

    TextView txtnea,txtacc,txtsign;
    EditText txtuser , txtpassword;
    Button signin;
    FragmentManager fragmentManager;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sing_in,container,false);

        fragmentManager=getFragmentManager();


         txtnea = view.findViewById(R.id.txtNea);
         txtacc = view.findViewById(R.id.txtView);
        txtsign = view.findViewById(R.id.txtsignup);

         txtuser = view.findViewById(R.id.txtUser);
        txtpassword = view.findViewById(R.id.txtpass);

         signin =view.findViewById(R.id.btnsign);

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
   fragmentManager.beginTransaction().replace(R.id.framCont,new search(),"search").commit();
            }
        });


        txtsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.framCont, new Sign_UP(), " Sign_UP")
                        .commit();
            }
        });


















        return view;
    }
}


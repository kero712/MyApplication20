package com.example.kerobeeh.myapplication;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by kero beeh on 10/20/2017.
 */

public class Sign_UP extends Fragment {

    ImageView imgview;
    EditText txtfullname, txtemail, txt2password, txtbirthday;
    TextView txtalready, txtsigin2;
    Button btnsignup;


    FragmentManager fragmentManager;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sign_up, container, false);


        final int CAMERA_REQUEST;
        CAMERA_REQUEST = 100;


        fragmentManager = getFragmentManager();


        imgview = view.findViewById(R.id.img);


        txtfullname = view.findViewById(R.id.fullName);
        txtemail = view.findViewById(R.id.EmailId);
        txt2password = view.findViewById(R.id.txtpass2);
        txtbirthday = view.findViewById(R.id.txtbirth);

        txtalready = view.findViewById(R.id.txtHAV);
        txtsigin2 = view.findViewById(R.id.txtsigIN);


        btnsignup = view.findViewById(R.id.btnsignUp);


        txtsigin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                        .beginTransaction().
                        replace(R.id.framCont, new Sign_in(), "Sign_in").
                        commit();
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        txtbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                DateDialogFragment datepicker = new DateDialogFragment();
                datepicker.show(getFragmentManager(), "ShowDate");
            }
        });








     imgview.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(cameraIntent, CAMERA_REQUEST);


             }

     });



        return view;
    }


    public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        public DateDialogFragment() {
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            showSetDate(year, monthOfYear, dayOfMonth);
        }
        public void showSetDate(int year, int month, int day) {
            int mon  = month+1;
            txtbirthday.setText(year + "/" + mon + "/" + day);
        }
    }
}

package com.example.hp.findyourtechnician;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TechnicianProfileRegistration extends AppCompatActivity {

    Spinner ActivityCategory_Spinner;
    ArrayAdapter<CharSequence> ActivityCategory_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_profile_registration);
        ActivityCategory_Spinner = (Spinner)findViewById(R.id.LoginContent_Expertise);
        ActivityCategory_adapter = ArrayAdapter.createFromResource(this,R.array.technicians,android.R.layout.simple_spinner_item);
        ActivityCategory_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ActivityCategory_Spinner.setAdapter(ActivityCategory_adapter);



    }

}

package com.example.hp.findyourtechnician;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class UserRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);
    }

    public void Register(View view)
    {

        String FirstName = ((EditText)findViewById(R.id.LoginContent_FirstNameTextField)).getText().toString();
        String LastName = ((EditText)findViewById(R.id.LoginContent_LastNameTextField)).getText().toString();
        String EmailId = ((EditText)findViewById(R.id.LoginContent_EmailidTextField)).getText().toString();
        String Contact = ((EditText)findViewById(R.id.LoginContent_ContactTextField)).getText().toString();
        String UserName = ((EditText)findViewById(R.id.LoginContent_UserNameTextField)).getText().toString();
        String Password = ((EditText)findViewById(R.id.LoginContent_PasswordTextField)).getText().toString();
        String ConfirmPassword = ((EditText)findViewById(R.id.LoginContent_ConfirmPasswordTextField)).getText().toString();

        Firebase RegistrationRef = new Firebase("https://findyourtechnician.firebaseio.com/");
        Firebase RegistrationChildRef = RegistrationRef.child("Users").child(UserName);

        RegistrationChildRef.child("FirstName").setValue(FirstName);
        RegistrationChildRef.child("LastName").setValue(LastName);
        RegistrationChildRef.child("EmailId").setValue(EmailId);
        RegistrationChildRef.child("Phone").setValue(Contact);
        RegistrationChildRef.child("UserName").setValue(UserName);
        RegistrationChildRef.child("Password").setValue(Password);

        Intent intent = new Intent(UserRegistration.this, UserLogin.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.hp.findyourtechnician;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class UserLogin extends AppCompatActivity {

    EditText User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        Firebase.setAndroidContext(this);
        User = ((EditText)findViewById(R.id.LoginContent_UserNameTextField));
        Pass = ((EditText)findViewById(R.id.LoginContent_PasswordTextField));
    }

    public void Login(View view)
    {
        Firebase LoginRef = new Firebase("https://akhileshapp.firebaseio.com/Users");
        final String UserName = ((EditText)findViewById(R.id.LoginContent_UserNameTextField)).getText().toString();
        final String password = ((EditText)findViewById(R.id.LoginContent_PasswordTextField)).getText().toString();

        if (UserName.isEmpty()){
            User.setError("Username cannot be blank");
        }
        else if (password.isEmpty()){
            Pass.setError("Password cannot be blank");
        }
        else {
            LoginRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.hasChild(UserName)) {
                        DataSnapshot pass = dataSnapshot.child(UserName).child("Password");
                        if (password.equals(pass.getValue().toString())) {
                            Pass.setError(null);
                            Intent intent = new Intent(UserLogin.this, Home.class);
                            startActivity(intent);
                        } else {
                            Pass.setError("Enter Correct Password");
                        }
                    } else {
                        User.setError("Enter Correct Username");
                    }
                    String data = dataSnapshot.child(UserName).toString();
                    SharedPreferences preferences = getSharedPreferences("AUTH", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("profile", data);
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    public void Registration(View view)
    {
        Intent intent = new Intent(UserLogin.this, UserRegistration.class);
        startActivity(intent);
    }

}

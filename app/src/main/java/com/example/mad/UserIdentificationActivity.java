package com.example.mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mad.navigationLayouts.ForwardFormNavigation;

public class UserIdentificationActivity extends AppCompatActivity implements ForwardFormNavigation {

    EditText etName;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_identification);

        initializeElements();
    }

    @Override
    public void initializeElements() {
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

    }

    @Override
    public void nextTapped(View view) {
        if (validate()) {
            User user = new User();
            user.setEmail(etEmail.getText().toString());
            user.setName(etName.getText().toString());

            Intent btnNextIntent = new Intent(UserIdentificationActivity.this, UserDetailsActivity.class);
            btnNextIntent.putExtra(Constants.KEY_USER,user);
            startActivity(btnNextIntent);
        }
    }

    @Override
    public boolean validate() {
        boolean result = false;
        if (!etName.getText().toString().isEmpty()){
            if (!etEmail.getText().toString().isEmpty()){
                result = true;
            }else{
                etEmail.setError("Email cannot be empty..!");
            }
        }else{
            etName.setError("Name cannot be empty..!");
        }
        return result;
    }

}

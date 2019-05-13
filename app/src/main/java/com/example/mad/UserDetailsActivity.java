package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mad.navigationLayouts.FormNavigation;

public class UserDetailsActivity extends AppCompatActivity implements FormNavigation {

    EditText etHeightFt;
    EditText etHeightInch;
    EditText etWeight;
    RadioGroup rdgGender;
    RadioButton rdMale;
    RadioButton rdFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        initializeElements();

    }

    @Override
    public void initializeElements() {
        etHeightFt          = findViewById(R.id.etFeet);
        etHeightInch        = findViewById(R.id.etInch);
        etWeight            = findViewById(R.id.etWeight);
        rdgGender           = findViewById(R.id.rdgGender);
        rdMale              = findViewById(R.id.rdMale);
        rdFemale            = findViewById(R.id.rdFemale);
    }

    @Override
    public void nextTapped(View view) {
        if (validate()) {
            Intent thisIntent = getIntent();
            User user = (User) thisIntent.getSerializableExtra(Constants.KEY_USER);

            int heightFt = Integer.parseInt(etHeightFt.getText().toString());
            double weight = Double.parseDouble(etWeight.getText().toString());
            int heightInch = 0;
            if (!etHeightInch.getText().toString().isEmpty())
                heightInch = Integer.parseInt(etHeightInch.getText().toString());

            char gender = 'm';
            if (rdFemale.isChecked())
                gender = 'f';

            user.setHeightFt(heightFt);
            user.setWeight(weight);
            user.setHeightInch(heightInch);
            user.setGender(gender);

            user.calculateBmi();
            user.setBmiLevel();

            Intent btnNextIntent = new Intent(UserDetailsActivity.this, BMIResultsActivity.class);
            btnNextIntent.putExtra(Constants.KEY_USER, user);
            startActivity(btnNextIntent);

        }
    }

    @Override
    public boolean validate() {
        boolean result = false;
        if (!etHeightFt.getText().toString().isEmpty()) {
            if (!etWeight.getText().toString().isEmpty()) {
                if (rdMale.isChecked() || rdFemale.isChecked()) {
                    if (!etHeightInch.getText().toString().isEmpty()) {
                        if (Integer.parseInt(etHeightInch.getText().toString()) < 12) {
                            result = true;
                        } else {
                            etHeightInch.setError("Invalid height..!");
                        }
                    } else {
                        result = true;
                    }
                } else {
                    rdMale.setError("Please select a gender..!");
                    rdFemale.setError("Please select a gender..!");
                }
            } else {
                etWeight.setError("Weight cannot be empty..!");
            }
        } else {
            etHeightFt.setError("Height cannot be empty..!");
        }

        return result;
    }

    @Override
    public void backTapped(View view) {
        finish();
    }

}
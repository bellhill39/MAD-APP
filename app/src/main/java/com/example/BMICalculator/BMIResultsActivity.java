package com.example.BMICalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.BMICalculator.navigationLayouts.BackwardFormNavigation;

public class BMIResultsActivity extends AppCompatActivity implements BackwardFormNavigation {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresults);

        initializeElements();

        setResult();
    }

    private void setResult() {

        Intent recievedTntentData = getIntent();
        User user = (User) recievedTntentData.getSerializableExtra(Constants.KEY_USER);

        String message = "";

        switch (user.getBmiLevel()) {
            case UNDERWEIGHT:
                message = "You are underweight. Please consult a dietitian.";
                break;
            case NORMAL:
                message = "You have a healthy BMI. Please maintain.";
                break;
            case OVERWEIGHT:
                message = "You are overweight. Consider doing some exercise.";
                break;
            case OBESITY:
                message = "You are Obese. Please consider doing some exercise and consulting a dietitian.";
                break;
            default:
                break;
        }

        String resultStr = "Hi " + user.getName() + "\n" + message + "\n" + "We will send you an email on " + user.getEmail() + " with all the details.";

        if (user.getGender() == 'm') {
            tvResult.setBackgroundColor(Color.BLUE);
        } else {
            tvResult.setBackgroundColor(Color.MAGENTA);
        }

        tvResult.setText(resultStr);
    }

    @Override
    public void initializeElements() {
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    public void backTapped(View view) {
        finish();
    }
}

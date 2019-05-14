package com.example.BMICalculator.navigationLayouts;

import android.view.View;

public interface ForwardFormNavigation {
    void initializeElements();
    void nextTapped(View view);
    boolean validate();

}

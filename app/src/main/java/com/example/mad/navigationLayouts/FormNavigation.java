package com.example.mad.navigationLayouts;

import android.view.View;

public interface FormNavigation {

    void initializeElements();
    void nextTapped(View view);
    boolean validate();
    void backTapped(View view);
}

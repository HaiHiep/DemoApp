package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JavaCodeActivity extends AppCompatActivity {
    private LinearLayout linearLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        setContentView(linearLayoutRoot);
    }

    public void initLayout() {
        //linearLayoutRoot
        linearLayoutRoot = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParamsRoot = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayoutRoot.setGravity(Gravity.CENTER);
        linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
        linearLayoutRoot.setPadding(20,0,20,0);
        linearLayoutRoot.setLayoutParams(layoutParamsRoot);

        //TextView
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParamsTextView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(getResources().getString(R.string.title));
        textView.setTextSize(40);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setLayoutParams(layoutParamsTextView);

        linearLayoutRoot.addView(textView);
    }
}

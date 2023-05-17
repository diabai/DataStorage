package com.yiriba.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        // Check if any data is already stored
        DisplaySavedText();

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = et.getText().toString();
                DisplayAndSaveText(data);
            }
        });
    }

    private void DisplaySavedText() {
        // Retrieving the values from SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String userName = sharedPreferences.getString("user_name", "");
        tv.setText(userName);
    }

    private void DisplayAndSaveText(String enteredText) {
        tv.setText(enteredText);

        // Saving the text into Shared Preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name", enteredText);
        editor.commit();
    }
}
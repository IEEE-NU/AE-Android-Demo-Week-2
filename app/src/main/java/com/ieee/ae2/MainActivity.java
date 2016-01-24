package com.ieee.ae2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editText) EditText name;
    @Bind(R.id.bigText) EditText bigText;
    @Bind(R.id.submitButton) Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitIntent = new Intent(MainActivity.this, Main2Activity.class);
                submitIntent.putExtra(getString(R.string.nameKey), name.getText().toString());
                submitIntent.putExtra("bigText", bigText.getText().toString());
                startActivity(submitIntent);
            }
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String nameStr = sharedPreferences.getString(getString(R.string.nameKey), "");
        name.setText(nameStr);
    }
}

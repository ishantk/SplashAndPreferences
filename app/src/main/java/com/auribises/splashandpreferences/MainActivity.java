package com.auribises.splashandpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @InjectView(R.id.editTextUserName)
    EditText eTxtUserName;

    @InjectView(R.id.buttonSubmit)
    Button btnSubmit;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        sharedPreferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String userName = sharedPreferences.getString("keyUserName","NA");
        eTxtUserName.setText(userName);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.buttonSubmit){
            String userName = eTxtUserName.getText().toString().trim();

            // Write data in SP (XML File)
            editor.putString("keyUserName",userName);
            editor.commit(); // Save
            //editor.apply();

            Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
        }
    }
}

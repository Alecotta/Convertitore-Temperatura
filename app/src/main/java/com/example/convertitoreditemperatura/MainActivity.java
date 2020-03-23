package com.example.convertitoreditemperatura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.Objects;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    EditText temp;
    TextView result;
    TextView text1;
    TextView text2;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main_constraint);

        init();
    }

    private void init() {
        temp = findViewById(R.id.temp);
        result = findViewById(R.id.result);
        text1 = findViewById(R.id.celsius);
        text2 = findViewById(R.id.far);
    }

    double value;
    boolean cF = true;

    public static double calcolaTemperaturaC (double value){
        return (value*9/5)+32;
    }

    public static double calcolaTemperaturaF (double value){
        return (value-32)*5/9;
    }

    public void clicked(View view) {

        Log.d("clicked", "Converti clicked");


        if (temp.getText().toString().isEmpty()) {
            testoPopUp("Inserire una temperatura");
        }

        else if (cF){
            value = Double.parseDouble(temp.getText().toString());
            double ris = calcolaTemperaturaC(value);
            double risF = Math.floor(ris * 100) / 100;
            result.setText(String.valueOf(risF));
        }
        else{
            value = Double.parseDouble(temp.getText().toString());
            double ris = calcolaTemperaturaF(value);
            double risF = Math.floor(ris * 100) / 100;
            result.setText(String.valueOf(risF));
        }
    }

    private void testoPopUp(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    public void scambia(View view) {
        if(cF){
            temp.setText("");
            result.setText("");
            temp.setHint("°F");
            text1.setText("Fahrenheit°:");
            text2.setText("Celsius°:");
            cF = false;
        }
        else{
            temp.setText("");
            result.setText("");
            temp.setHint("°C");
            text2.setText("Fahrenheit°:");
            text1.setText("Celsius°:");
            cF = true;
        }
    }
}

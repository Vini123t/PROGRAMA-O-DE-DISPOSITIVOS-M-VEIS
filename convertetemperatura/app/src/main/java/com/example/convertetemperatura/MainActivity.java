package com.example.convertetemperatura;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText etTemperature;
    private Button btnToFahrenheit;
    private Button btnToCelsius;
    private TextView tvResult;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTemperature = findViewById(R.id.etTemperature);
        btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        btnToCelsius = findViewById(R.id.btnToCelsius);
        tvResult = findViewById(R.id.tvResult);
        tvError = findViewById(R.id.tvError);


        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });


        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });
    }

    private void convertToFahrenheit() {
        String input = etTemperature.getText().toString().trim();
        if (input.isEmpty()) {
            showError("Por favor, insira uma temperatura.");
            return;
        }

        try {
            double celsius = Double.parseDouble(input);
            double fahrenheit = (celsius * 9 / 5) + 32;
            tvResult.setText(String.format("%.2f °F", fahrenheit));
            tvError.setText("");
        } catch (NumberFormatException e) {
            showError("Valor inválido. Insira um número válido.");
        }
    }

    private void convertToCelsius() {
        String input = etTemperature.getText().toString().trim();
        if (input.isEmpty()) {
            showError("Por favor, insira uma temperatura.");
            return;
        }

        try {
            double fahrenheit = Double.parseDouble(input);
            double celsius = (fahrenheit - 32) * 5 / 9;
            tvResult.setText(String.format("%.2f °C", celsius));
            tvError.setText("");
        } catch (NumberFormatException e) {
            showError("Valor inválido. Insira um número válido.");
        }
    }

    private void showError(String message) {
        tvResult.setText("");
        tvError.setText(message);
    }
}
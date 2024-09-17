package com.example.calcuradoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etHeight, etWeight;
    private TextView tvResult;
    private Button btnMale, btnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvResult = findViewById(R.id.tvResult);
        btnMale = findViewById(R.id.btnMale);
        btnFemale = findViewById(R.id.btnFemale);


        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMCMale();
            }
        });

        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMCFemale();
            }
        });
    }


    private void calculateIMCMale() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();
        String classification;

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            float imc = weight / (height * height);


            if (imc < 20.7) {
                classification = "Abaixo do peso";
            } else if (imc >= 20.7 && imc <= 26.4) {
                classification = "No peso normal";
            } else if (imc > 26.4 && imc <= 31.1) {
                classification = "Marginalmente acima do peso";
            } else {
                classification = "Obeso";
            }

            tvResult.setText(String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classification));
        } else {
            tvResult.setText("Por favor, preencha todos os campos.");
        }
    }


    private void calculateIMCFemale() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();
        String classification;

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);


            float imc = weight / (height * height);


            if (imc < 19.1) {
                classification = "Abaixo do peso";
            } else if (imc >= 19.1 && imc <= 25.8) {
                classification = "No peso normal";
            } else if (imc > 25.8 && imc <= 32.3) {
                classification = "Marginalmente acima do peso";
            } else {
                classification = "Obeso";
            }


            tvResult.setText(String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classification));
        } else {
            tvResult.setText("Por favor, preencha todos os campos.");
        }
    }
}

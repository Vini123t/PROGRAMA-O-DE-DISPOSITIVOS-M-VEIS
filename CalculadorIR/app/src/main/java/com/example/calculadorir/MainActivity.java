package com.example.calculadorir;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText etRendaBrutaMensal, etDependentes, etTotalDeducoes;
    private TextView tvRendaBrutaAnual, tvBaseDeCalculo, tvImpostoDevido;
    private Button btnCalcularIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etRendaBrutaMensal = findViewById(R.id.etRendaBrutaMensal);
        etDependentes = findViewById(R.id.etDependentes);
        etTotalDeducoes = findViewById(R.id.etTotalDeducoes);
        tvRendaBrutaAnual = findViewById(R.id.tvRendaBrutaAnual);
        tvBaseDeCalculo = findViewById(R.id.tvBaseDeCalculo);
        tvImpostoDevido = findViewById(R.id.tvImpostoDevido);
        btnCalcularIR = findViewById(R.id.btnCalcularIR);


        btnCalcularIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImpostoDeRenda();
            }
        });
    }

    private void calcularImpostoDeRenda() {

        if (etRendaBrutaMensal.getText().toString().isEmpty() ||
                etDependentes.getText().toString().isEmpty() ||
                etTotalDeducoes.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        double rendaBrutaMensal;
        double totalDeducoes;
        int dependentes;
        double impostoDevido = 0.0;
        double rendaBrutaAnual;
        double deducaoDependentes;
        double baseDeCalculo;

        rendaBrutaMensal = Double.parseDouble(etRendaBrutaMensal.getText().toString());
        dependentes = Integer.parseInt(etDependentes.getText().toString());
        totalDeducoes = Double.parseDouble(etTotalDeducoes.getText().toString());

        rendaBrutaAnual = rendaBrutaMensal * 12;

        deducaoDependentes = dependentes * 300 * 12;

        baseDeCalculo = rendaBrutaAnual - deducaoDependentes - totalDeducoes;

        if (baseDeCalculo <= 18000) {

            impostoDevido = 0;
        } else if (baseDeCalculo <= 27000) {

            impostoDevido = (baseDeCalculo - 18000) * 0.15;
        } else {

            impostoDevido = 1350 + (baseDeCalculo - 27000) * 0.275;
        }

        tvRendaBrutaAnual.setText(String.format("%.2f", rendaBrutaAnual));
        tvBaseDeCalculo.setText(String.format("%.2f", baseDeCalculo));
        tvImpostoDevido.setText(String.format("%.2f", impostoDevido));
    }
}

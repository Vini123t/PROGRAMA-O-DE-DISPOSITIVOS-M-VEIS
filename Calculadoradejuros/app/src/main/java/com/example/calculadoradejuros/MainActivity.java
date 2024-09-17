package com.example.calculadoradejuros;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText etInvestimentoInicial, etTaxaJuros, etPeriodo;
    private TextView tvResultadoTotal, tvResultadoJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInvestimentoInicial = findViewById(R.id.et_investimento_inicial);
        etTaxaJuros = findViewById(R.id.et_taxa_juros);
        etPeriodo = findViewById(R.id.et_periodo);
        tvResultadoTotal = findViewById(R.id.tv_resultado_total);
        tvResultadoJuros = findViewById(R.id.tv_resultado_juros);
        Button btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularJuros();
            }
        });
    }

    private void calcularJuros() {
        try {
            double investimentoInicial;
            double taxaJuros;
            double valorTotal;
            double valorJuros;
            int periodo;

            investimentoInicial = Double.parseDouble(etInvestimentoInicial.getText().toString());
            taxaJuros = Double.parseDouble(etTaxaJuros.getText().toString()) / 100;
            periodo = Integer.parseInt(etPeriodo.getText().toString());

            valorTotal = investimentoInicial * Math.pow((1 + taxaJuros), periodo);
            valorJuros = valorTotal - investimentoInicial;

            tvResultadoTotal.setText(String.format("Valor total adquirido: %.2f", valorTotal));
            tvResultadoJuros.setText(String.format("Valor total dos juros: %.2f", valorJuros));
        } catch (NumberFormatException e) {

            tvResultadoTotal.setText("Por favor, insira todos os dados corretamente.");
            tvResultadoJuros.setText("");
        }
    }
}
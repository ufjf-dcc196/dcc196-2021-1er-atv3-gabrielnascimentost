package br.ufjf.dcc196.gabriel.ativ3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1;
    private EditText editTextNum2;
    private TextView textViewResultado;
    private RadioGroup radioGroupOperacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNum1 = findViewById(R.id.editTextNumber1);
        editTextNum2 = findViewById(R.id.editTextNumber2);
        textViewResultado = findViewById(R.id.textViewResultado);
        radioGroupOperacoes = findViewById(R.id.radioGroup);
    }

    public void calcularTotal(View view){
        Double operandoUm = 0.0;
        Double operandoDois = 0.0;
        Double resultadoOperacao = 0.0;

        try {
            operandoUm = Double.parseDouble(editTextNum1.getText().toString());
            operandoDois = Double.parseDouble(editTextNum2.getText().toString());
        }catch (Exception e){
            new Error("Ocorreu um erro");
        }

        Locale locale = new Locale("pt", "BR");

        switch (radioGroupOperacoes.getCheckedRadioButtonId()) {
            case R.id.radioButtonSoma:
                resultadoOperacao = operandoUm + operandoDois;
                break;

            case R.id.radioButtonDiv:
                resultadoOperacao = operandoUm/operandoDois;
                break;

            case R.id.radioButtonSub:
                resultadoOperacao = operandoUm - operandoDois;
                break;

            case R.id.radioButtonMult:
                resultadoOperacao = operandoUm * operandoDois;
                break;
        }

        textViewResultado.setText(NumberFormat.getNumberInstance(locale).format(resultadoOperacao));

    }
}
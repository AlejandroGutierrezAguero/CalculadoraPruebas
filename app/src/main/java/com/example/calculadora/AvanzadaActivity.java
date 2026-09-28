package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AvanzadaActivity extends AppCompatActivity {

    private TextView tvResult;
    private Calculadora calculadora;

    private String oper1 = "";
    private String oper2 = "";
    private String operacion;

    private boolean resultadoObtenido = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avanzada);

        tvResult = findViewById(R.id.tvResult);

        calculadora = new Calculadora();
    }

    public void numero (View view) {
        if (operacion == null && !resultadoObtenido) {
            oper1 += ((TextView) view).getText().toString();
            tvResult.setText(oper1);
        } else if (!resultadoObtenido){
            oper2 += ((TextView) view).getText().toString();
            tvResult.setText(oper2);
        }
    }

    public void operacion (View view) {
        if (!oper1.isEmpty() && oper2.isEmpty()) {
            operacion = ((TextView) view).getText().toString();
            tvResult.setText(operacion);
            resultadoObtenido = false;
        }
    }

    public void punto (View view) {
        if (operacion == null && !oper1.contains(".") && !resultadoObtenido) {
            if (oper1.isEmpty()) {
                oper1 = "0.";
            } else {
                oper1 += ".";
            }
            tvResult.setText(oper1);
        } else if (operacion != null && !oper2.contains(".") && !resultadoObtenido) {
            if (oper2.isEmpty()) {
                oper2 = "0.";
            } else {
                oper2 += ".";
            }
            tvResult.setText(oper2);
        }
    }

    public void borrar (View view) {
        oper1 = "";
        oper2 = "";
        operacion = null;
        resultadoObtenido = false;
        tvResult.setText("");
    }

    public void calcular (View view) {
        if (!oper1.isEmpty() && !oper2.isEmpty() && operacion != null) {
            calculadora.setOper1(Double.parseDouble(oper1));
            calculadora.setOper2(Double.parseDouble(oper2));
            calculadora.setOperacion(Calculadora.OPERACION.fromSymbol(operacion));

            double result = calculadora.opera();

            if (result == (long) result) {
                oper1 = String.format("%d", (long) result);
            } else {
                oper1 = String.valueOf(result);
            }

            oper2 = "";
            operacion = null;
            resultadoObtenido = true;

            tvResult.setText(oper1);
        }
    }
}
package br.ulbra.com.calcsalario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends Activity {
    RadioGroup rgopcoes;
    Button btcalcular;
    EditText edsalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edsalario = (EditText) findViewById(R.id.edtSalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgPercentual);
        btcalcular = (Button) findViewById(R.id.btnSalario);
        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double salario = Double.parseDouble(edsalario.getText().toString());
                int op = rgopcoes.getCheckedRadioButtonId();
                double novo_salario = 0;
                if (op == R.id.p40)
                    novo_salario = salario + (salario * 0.4);

                else if (op == R.id.p45)
                    novo_salario = salario + (salario * 0.45);
                else
                    novo_salario = salario + (salario * 0.5);
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo salário ");
                dialogo.setMessage("Seu novo salário é : R$" +String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
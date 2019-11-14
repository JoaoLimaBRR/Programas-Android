package com.example.balaiodalenha;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText editConsumo, editCouvert, editDividir;
    private EditText editTaxa, editTotal, editPessoa;
    private Button btnCalcular;
    private Double resultado ,valorconsumo, valorcouvert, valorpessoa, taxa, pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegando oque for colocado nos campos
        editConsumo = (EditText) findViewById(R.id.editConsumo);
         editCouvert = (EditText) findViewById(R.id.editCouvert);
        editDividir = (EditText) findViewById(R.id.editDividir);
        editTotal = (EditText) findViewById(R.id.editTotal);
        editTaxa = (EditText) findViewById(R.id.editTaxa);
        editPessoa = (EditText) findViewById(R.id.editPessoa);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
                        public void onClick(View v) {
                valorconsumo = Double.parseDouble(editConsumo.getText().toString());
                valorcouvert = Double.parseDouble(editCouvert.getText().toString());
                valorpessoa = Double.parseDouble(editDividir.getText().toString());


                taxa = (valorconsumo + valorcouvert) * 0.10;
                resultado = valorconsumo + valorcouvert + taxa;
                pessoa = resultado / valorpessoa;

                taxa = Double.valueOf(String.format(Locale.US,"%.3f",taxa));
                resultado = Double.valueOf(String.format(Locale.US,"%.3f", resultado));
                pessoa = Double.valueOf(String.format(Locale.US,"%.3f", pessoa));
                editTaxa.setText(String.valueOf(taxa.toString()));
                editTotal.setText(String.valueOf(resultado));
                editPessoa.setText(String.valueOf(pessoa));
            }
        });
    }
}

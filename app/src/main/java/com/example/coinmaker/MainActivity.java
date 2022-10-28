package com.example.coinmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder nViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nViewHolder.editValue = findViewById(R.id.edit_value);
        this.nViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.nViewHolder.textEuro = findViewById(R.id.text_euro);
        this.nViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.nViewHolder.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código
            }
        });

        this.nViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.nViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                //mostra mensagem pro usuario
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.nViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));

                this.nViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));

            }
        }
    }

    private void clearValues() {
        this.nViewHolder.textDolar.setText("");
        this.nViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
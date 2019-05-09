package com.example.lashcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText mlashLEngth;
    private EditText mlashWidth;
    private EditText mfakeLashLength;
    private EditText mfakeLashWidth;
    private Button mcalculate;
    private TextView mlashInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlashLEngth = findViewById(R.id.lashLength);
        mlashWidth = findViewById(R.id.lashWidth);
        mfakeLashLength = findViewById(R.id.fakeLashLength);
        mfakeLashWidth = findViewById(R.id.fakeLashWidth);
        mcalculate = findViewById(R.id.calculate);
        mlashInfo = findViewById(R.id.lashInfo);

        mcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mlashWidth.getText().toString().length()==0||mlashLEngth.getText().toString().length()==0||mfakeLashWidth.getText().toString().length()==0||mfakeLashLength.getText().toString().length()==0)
                {
                    mlashInfo.setText("Wprowadz wartosci wieksze od 0");
                }
                else
                    {
                    double lashLength = Double.parseDouble(mlashLEngth.getText().toString());
                    double lashWidth = Double.parseDouble(mlashWidth.getText().toString());
                    double fakeLashLength = Double.parseDouble(mfakeLashLength.getText().toString());
                    double fakeLashWidth = Double.parseDouble(mfakeLashWidth.getText().toString());
                    if (lashLength==0||lashWidth==0||fakeLashLength==0||fakeLashWidth==0)
                    {
                        mlashInfo.setText("Wprowadz wartosci wieksze od 0");
                    }
                    else
                    {
                        double vol1 = (Math.PI * Math.pow((0.5 * lashWidth), 2) * lashLength) / 3;
                        double vol2 = (Math.PI * Math.pow((0.5 * fakeLashWidth), 2) * fakeLashLength) / 3;

                        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.UK));
                        df.setMaximumFractionDigits(340);
                        mlashInfo.setText("Mozesz przykleic " + String.valueOf(df.format(Math.floor(vol1 / vol2))) + " rzesy");
                    }

                }
            }
        });

    }




}

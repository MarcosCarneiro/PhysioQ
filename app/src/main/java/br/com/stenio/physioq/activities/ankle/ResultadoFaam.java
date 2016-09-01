package br.com.stenio.physioq.activities.ankle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liulishuo.magicprogresswidget.MagicProgressBar;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoFaam extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_faam);

        TextView nomea = (TextView) findViewById(R.id.nomeaofas);
        nomea.setText(Dados.ednome.getText());

        TextView faam = (TextView) findViewById(R.id.ad);
        faam.setText(Faam.tv.getText() + " %");

        TextView faama = (TextView) findViewById(R.id.ae);
        faama.setText(Faam.tva.getText() + " %");

        TextView faamb = (TextView) findViewById(R.id.fad);
        faamb.setText(Faam.tvb.getText() + " %");

        TextView faamc = (TextView) findViewById(R.id.fae);
        faamc.setText(Faam.tvc.getText() + " %");

        TextView faamd = (TextView) findViewById(R.id.nfa);
        faamd.setText(Faam.nivel_func);

        String pada = Faam.tv.getText().toString();
        int idor = new Integer(pada).intValue();
        MagicProgressBar pad = (MagicProgressBar) findViewById(R.id.pad);
        pad.setPercent(idor / 100f);

        String stg = Faam.tva.getText().toString();
        int in = new Integer(stg).intValue();
        MagicProgressBar pae = (MagicProgressBar) findViewById(R.id.pae);
        pae.setPercent(in / 100f);

        String stga = Faam.tvb.getText().toString();
        int ina = new Integer(stga).intValue();
        MagicProgressBar pfad = (MagicProgressBar) findViewById(R.id.pfad);
        pfad.setPercent(ina / 100f);

        String stgb = Faam.tvc.getText().toString();
        int inb = new Integer(stgb).intValue();
        MagicProgressBar pfae = (MagicProgressBar) findViewById(R.id.pfae);
        pfae.setPercent(inb / 100f);


        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoFaam.this, HomeActivity.class);
                startActivity(it);

                finish();

            }
        });



        FrameLayout fp = (FrameLayout) findViewById(R.id.apdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoFaam.this, HomeActivity.class);
                startActivity(ita);
                Toast.makeText(ResultadoFaam.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }


}

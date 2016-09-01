package br.com.stenio.physioq.activities.lumbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoOswestry extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_oswestry);

        TextView nomeow = (TextView) findViewById(R.id.nomeow);
        nomeow.setText(Dados.ednome.getText());



        TextView pt = (TextView) findViewById(R.id.pontosow);
        pt.setText(Oswestry.tv.getText());

        String stg = Oswestry.tv.getText().toString();
        int nIntFromET = new Integer(stg).intValue();

        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.demo_mpcow);
        mgpc.setPercent(nIntFromET/100f);

        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoOswestry.this, HomeActivity.class);
                startActivity(it);
            }
        });

        FrameLayout fp = (FrameLayout) findViewById(R.id.fpdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoOswestry.this, HomeActivity.class);
                startActivity(ita);

                Toast.makeText(ResultadoOswestry.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });



//on
    }


}

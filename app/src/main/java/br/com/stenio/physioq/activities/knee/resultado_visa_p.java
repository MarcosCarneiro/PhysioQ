package br.com.stenio.physioq.activities.knee;

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

public class resultado_visa_p extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_visa_p);

        TextView nomevp = (TextView) findViewById(R.id.nomevp);
        nomevp.setText(Dados.ednome.getText());

        TextView pt = (TextView) findViewById(R.id.pontosvp);
        pt.setText(VisaP.edresulvp.getText());

        String stg = VisaP.edresulvp.getText().toString();
        int nIntFromET = new Integer(stg).intValue();
        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.demo_mpc);
        mgpc.setPercent(nIntFromET/100f);

        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(resultado_visa_p.this, HomeActivity.class);
                startActivity(it);
            }
        });

        FrameLayout fp = (FrameLayout) findViewById(R.id.fpdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(resultado_visa_p.this, HomeActivity.class);
                startActivity(ita);

                Toast.makeText(resultado_visa_p.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

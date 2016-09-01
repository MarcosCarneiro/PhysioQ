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

public class ResultadoCait extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cait);

        TextView nomea = (TextView) findViewById(R.id.nomecait);
        nomea.setText(Dados.ednome.getText());


        TextView tvtnzd = (TextView) findViewById(R.id.tvtnzd);
        tvtnzd.setText(Cait.tvdireita.getText() + " pontos");

        TextView tvtnze = (TextView) findViewById(R.id.tvtnze);
        tvtnze.setText(Cait.tvesquerda.getText() + " pontos");




        String dir = Cait.tvdireita.getText().toString();
        int idir = new Integer(dir).intValue();
        MagicProgressBar ptnzd = (MagicProgressBar) findViewById(R.id.ptnzd);
        ptnzd.setPercent(idir / 30f);

        String esq = Cait.tvesquerda.getText().toString();
        int iesq = new Integer(esq).intValue();
        MagicProgressBar ptnze = (MagicProgressBar) findViewById(R.id.ptnze);
        ptnze.setPercent(iesq / 30f);




        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoCait.this, HomeActivity.class);
                startActivity(it);

                finish();

            }
        });



        FrameLayout fp = (FrameLayout) findViewById(R.id.apdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoCait.this, HomeActivity.class);
                startActivity(ita);
                Toast.makeText(ResultadoCait.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }


}

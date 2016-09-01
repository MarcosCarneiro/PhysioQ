package br.com.stenio.physioq.activities.lumbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liulishuo.magicprogresswidget.MagicProgressBar;
import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoRolandMorris extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_roland_morris);

        TextView nomer = (TextView) findViewById(R.id.nomeroland);
        nomer.setText(Dados.ednome.getText());

        TextView pontosa = (TextView) findViewById(R.id.pontosroland);
        pontosa.setText(RolandMorris.tvroland.getText());

        TextView pdor = (TextView) findViewById(R.id.pdorroland);
        pdor.setText(RolandMorris.tvMor.getText() + " pontos");

        String stotal = RolandMorris.tvroland.getText().toString();
        int itotal = new Integer(stotal).intValue();
        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.rroland);
        mgpc.setPercent(itotal / 24f);

        String sdor = RolandMorris.tvMor.getText().toString();
        int idor = new Integer(sdor).intValue();
        MagicProgressBar mdor = (MagicProgressBar) findViewById(R.id.pgdorroland);
        mdor.setPercent(idor/10f);


        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoRolandMorris.this, HomeActivity.class);
                startActivity(it);

            }
        });



        FrameLayout fp = (FrameLayout) findViewById(R.id.apdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoRolandMorris.this, HomeActivity.class);
                startActivity(ita);
                Toast.makeText(ResultadoRolandMorris.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });




    }



}

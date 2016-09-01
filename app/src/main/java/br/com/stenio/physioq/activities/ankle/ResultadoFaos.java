package br.com.stenio.physioq.activities.ankle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.liulishuo.magicprogresswidget.MagicProgressBar;
import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoFaos extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_faos);

        TextView nomevp = (TextView) findViewById(R.id.nomefaos);
        nomevp.setText(Dados.ednome.getText());

       TextView pontosfaos = (TextView) findViewById(R.id.pontosfaos);
        pontosfaos.setText(Faos.tv.getText());

        TextView pdor = (TextView) findViewById(R.id.pdor);
        pdor.setText(Faos.tva.getText() + " %");

        TextView pos = (TextView) findViewById(R.id.pos);
        pos.setText(Faos.tvb.getText() + " %");

        TextView pavd = (TextView) findViewById(R.id.pavd);
        pavd.setText(Faos.tvc.getText() + " %");

        TextView per = (TextView) findViewById(R.id.per);
        per.setText(Faos.tvd.getText() + " %");

        TextView pqualidade = (TextView) findViewById(R.id.pqualidade);
        pqualidade.setText(Faos.tve.getText() + " %");

        String stg = Faos.tv.getText().toString();
        int nIntFromET = new Integer(stg).intValue();
        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.rfaos);
        mgpc.setPercent(nIntFromET / 100f);

        String sdor = Faos.tva.getText().toString();
        int idor = new Integer(sdor).intValue();
        MagicProgressBar mdor = (MagicProgressBar) findViewById(R.id.pgdor);
        mdor.setPercent(idor / 100f);

        String sos = Faos.tvb.getText().toString();
        int ios = new Integer(sos).intValue();
        MagicProgressBar mos = (MagicProgressBar) findViewById(R.id.pgos);
        mos.setPercent(ios / 100f);

        String savd = Faos.tvc.getText().toString();
        int iavd = new Integer(savd).intValue();
        MagicProgressBar mavd = (MagicProgressBar) findViewById(R.id.pgavd);
        mavd.setPercent(iavd / 100f);

        String ser = Faos.tvd.getText().toString();
        int ier = new Integer(ser).intValue();
        MagicProgressBar mer = (MagicProgressBar) findViewById(R.id.pger);
        mer.setPercent(ier / 100f);

        String squalidade = Faos.tve.getText().toString();
        int iqualidade = new Integer(squalidade).intValue();
        MagicProgressBar mqualidade = (MagicProgressBar) findViewById(R.id.pgqualidade);
        mqualidade.setPercent(iqualidade / 100f);

    }


}

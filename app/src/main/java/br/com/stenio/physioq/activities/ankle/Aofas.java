package br.com.stenio.physioq.activities.ankle;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v7.widget.Toolbar;

import br.com.stenio.physioq.R;

public class Aofas extends AppCompatActivity {

    RadioGroup rgdor, rgfuncional, rgdis_max, rgsup_cam, rgan_marc, rgmob_sag, rgmob_ret, rgestab, rgalin;
    public static RadioButton rbd1, rbd2, rbd3, rbd4,
            rbf1, rbf2, rbf3, rbf4,
            rbdm1, rbdm2, rbdm3, rbdm4,
            rbsc1, rbsc2, rbsc3,
            rbam1, rbam2, rbam3,
            rbms1, rbms2, rbms3,
            rbmr1, rbmr2, rbmr3,
            rbe1, rbe2,
            rba1, rba2, rba3;
    Button btok;
    int id_rgdor, id_rgfuncional, id_rgdis_max, id_rgsup_cam, id_rgan_marc, id_rgmob_sag, id_rgmob_ret, id_rgestab, id_rgalin;
    int p1, p2, p3, p4, p5, p6, p7, p8, p9, resultadodor, resultadofuncional, resultadoalinhamento,resultadototal;

    private Toolbar mToolbar;

    public static EditText edresuldor, edresulfuncional,edresulalinhamento,edresultotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aofas);

        setupToolbar();

        rgdor = (RadioGroup) findViewById(R.id.rgdor);
        rgfuncional = (RadioGroup) findViewById(R.id.rgfuncional);
        rgdis_max = (RadioGroup) findViewById(R.id.rgdist_max);
        rgsup_cam = (RadioGroup) findViewById(R.id.rgsup_cam);
        rgan_marc = (RadioGroup) findViewById(R.id.rgan_marc);
        rgmob_sag = (RadioGroup) findViewById(R.id.rgmob_sag);
        rgmob_ret = (RadioGroup) findViewById(R.id.rgmob_ret);
        rgestab = (RadioGroup) findViewById(R.id.rgestab);
        rgalin = (RadioGroup) findViewById(R.id.rgalin);

        rbd1 = (RadioButton) findViewById(R.id.rbd1);
        rbd2 = (RadioButton) findViewById(R.id.rbd2);
        rbd3 = (RadioButton) findViewById(R.id.rbd3);
        rbd4 = (RadioButton) findViewById(R.id.rbd4);

        rbf1 = (RadioButton) findViewById(R.id.rbf1);
        rbf2 = (RadioButton) findViewById(R.id.rbf2);
        rbf3 = (RadioButton) findViewById(R.id.rbf3);
        rbf4 = (RadioButton) findViewById(R.id.rbf4);

        rbdm1 = (RadioButton) findViewById(R.id.rbdm1);
        rbdm2 = (RadioButton) findViewById(R.id.rbdm2);
        rbdm3 = (RadioButton) findViewById(R.id.rbdm3);
        rbdm4 = (RadioButton) findViewById(R.id.rbdm4);

        rbsc1 = (RadioButton) findViewById(R.id.rbsc1);
        rbsc2 = (RadioButton) findViewById(R.id.rbsc2);
        rbsc3 = (RadioButton) findViewById(R.id.rbsc3);

        rbam1 = (RadioButton) findViewById(R.id.rbam1);
        rbam2 = (RadioButton) findViewById(R.id.rbam2);
        rbam3 = (RadioButton) findViewById(R.id.rbam3);

        rbms1 = (RadioButton) findViewById(R.id.rbms1);
        rbms2 = (RadioButton) findViewById(R.id.rbms2);
        rbms3 = (RadioButton) findViewById(R.id.rbms3);

        rbmr1 = (RadioButton) findViewById(R.id.rbmr1);
        rbmr2 = (RadioButton) findViewById(R.id.rbmr2);
        rbmr3 = (RadioButton) findViewById(R.id.rbmr3);

        rbe1 = (RadioButton) findViewById(R.id.rbe1);
        rbe2 = (RadioButton) findViewById(R.id.rbe2);

        rba1 = (RadioButton) findViewById(R.id.rba1);
        rba2 = (RadioButton) findViewById(R.id.rba2);
        rba3 = (RadioButton) findViewById(R.id.rba3);

        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgdor.getCheckedRadioButtonId() == -1|| rgfuncional.getCheckedRadioButtonId() == -1|| rgdis_max.getCheckedRadioButtonId() == -1
                        || rgsup_cam.getCheckedRadioButtonId() == -1|| rgan_marc.getCheckedRadioButtonId() == -1|| rgmob_sag.getCheckedRadioButtonId() == -1
                        || rgmob_ret.getCheckedRadioButtonId() == -1|| rgestab.getCheckedRadioButtonId() == -1|| rgalin.getCheckedRadioButtonId() == -1){


                    AlertDialog.Builder mensagem = new
                            AlertDialog.Builder(Aofas.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("Responda todas perguntas!");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                }else {
                    gera_resultado();
                }
                }
        });

    }

    public void gera_resultado(){
        id_rgdor = rgdor.getCheckedRadioButtonId();
        id_rgfuncional = rgfuncional.getCheckedRadioButtonId();
        id_rgdis_max = rgdis_max.getCheckedRadioButtonId();
        id_rgsup_cam = rgsup_cam.getCheckedRadioButtonId();
        id_rgan_marc = rgan_marc.getCheckedRadioButtonId();
        id_rgmob_sag = rgmob_sag.getCheckedRadioButtonId();
        id_rgmob_ret = rgmob_ret.getCheckedRadioButtonId();
        id_rgestab = rgestab.getCheckedRadioButtonId();
        id_rgalin = rgalin.getCheckedRadioButtonId();

        if(id_rgdor == rbd1.getId()) p1 = 40;
        else if(id_rgdor == rbd2.getId()) p1 = 30;
        else if(id_rgdor == rbd3.getId()) p1 = 20;
        else p1 = 0;

        if(id_rgfuncional == rbf1.getId()) p2 = 10;
        else if(id_rgfuncional == rbf2.getId()) p2 = 7;
        else if(id_rgfuncional == rbf3.getId()) p2 = 4;
        else p2 = 0;

        if(id_rgdis_max == rbdm1.getId()) p3 = 5;
        else if(id_rgdis_max == rbdm2.getId()) p3 = 4;
        else if(id_rgdis_max == rbdm3.getId()) p3 = 2;
        else p3 = 0;

        if(id_rgsup_cam == rbsc1.getId()) p4 = 5;
        else if(id_rgsup_cam == rbsc2.getId()) p4 = 3;
        else p4 = 0;

        if(id_rgan_marc == rbam1.getId()) p5 = 8;
        else if(id_rgan_marc == rbam2.getId()) p5 = 4;
        else p5 = 0;

        if(id_rgmob_sag == rbms1.getId()) p6 = 8;
        else if(id_rgmob_sag == rbms2.getId()) p6 = 4;
        else p6 = 0;

        if(id_rgmob_ret == rbmr1.getId()) p7 = 6;
        else if(id_rgmob_ret == rbmr2.getId()) p7 = 3;
        else p7 = 0;

        if(id_rgestab == rbe1.getId()) p8 = 8;
        else p8 = 0;

        if(id_rgalin == rba1.getId()) p9 = 10;
        else if(id_rgalin == rba2.getId()) p9 = 5;
        else p9 = 0;

        resultadodor = p1;
        resultadofuncional = p2+p3+p4+p5+p6+p7+p8;
        resultadoalinhamento = p9;
        resultadototal = p1+p2+p3+p4+p5+p6+p7+p8+p9;

        edresuldor = (EditText) findViewById(R.id.dor);
        edresuldor.setText(String.valueOf(resultadodor));

        edresulfuncional = (EditText) findViewById(R.id.funcional);
        edresulfuncional.setText(String.valueOf(resultadofuncional));

        edresulalinhamento = (EditText) findViewById(R.id.alinhamento);
        edresulalinhamento.setText(String.valueOf(resultadoalinhamento));

        edresultotal = (EditText) findViewById(R.id.total);
        edresultotal.setText(String.valueOf(resultadototal));

        Intent intent = new Intent(Aofas.this, ResultadoAofas.class);
        startActivity(intent);

        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aofas, menu);
        return true;
    }

    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_aofas);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.black));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}

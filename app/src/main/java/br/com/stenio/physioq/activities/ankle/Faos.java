package br.com.stenio.physioq.activities.ankle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.stenio.physioq.R;

public class Faos extends AppCompatActivity {

    Spinner sp[] = new Spinner[43];
    ArrayAdapter<CharSequence> adapter, adapter2, adapter3, adapter4;
    Button btok;
    int p[] = new int[43];
    double dor, os, avd, er, qualidade, total;



    private Toolbar mToolbar;

    public static TextView tv, tva, tvb, tvc, tvd, tve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faos);

        setupToolbar();

        adapter = ArrayAdapter.createFromResource(this, R.array.tempo, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.intensidade, R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        adapter3 = ArrayAdapter.createFromResource(this, R.array.frequencia, R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        adapter4 = ArrayAdapter.createFromResource(this, R.array.grau, R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);


        sp[0] = (Spinner) findViewById(R.id.sp_p1);
        sp[0].setAdapter(adapter);
        sp[1] = (Spinner) findViewById(R.id.sp_p2);
        sp[1].setAdapter(adapter2);
        sp[2] = (Spinner) findViewById(R.id.sp_p3);
        sp[2].setAdapter(adapter2);
        sp[3] = (Spinner) findViewById(R.id.sp_p4);
        sp[3].setAdapter(adapter2);
        sp[4] = (Spinner) findViewById(R.id.sp_p5);
        sp[4].setAdapter(adapter2);
        sp[5] = (Spinner) findViewById(R.id.sp_p6);
        sp[5].setAdapter(adapter2);
        sp[6] = (Spinner) findViewById(R.id.sp_p7);
        sp[6].setAdapter(adapter2);
        sp[7] = (Spinner) findViewById(R.id.sp_p8);
        sp[7].setAdapter(adapter2);
        sp[8] = (Spinner) findViewById(R.id.sp_p9);
        sp[8].setAdapter(adapter2);


        sp[9] = (Spinner) findViewById(R.id.sps1);
        sp[9].setAdapter(adapter2);
        sp[10] = (Spinner) findViewById(R.id.sps2);
        sp[10].setAdapter(adapter2);
        sp[11] = (Spinner) findViewById(R.id.sps3);
        sp[11].setAdapter(adapter3);
        sp[12] = (Spinner) findViewById(R.id.sps4);
        sp[12].setAdapter(adapter3);
        sp[13] = (Spinner) findViewById(R.id.sps5);
        sp[13].setAdapter(adapter3);
        sp[14] = (Spinner) findViewById(R.id.sps6);
        sp[14].setAdapter(adapter3);
        sp[15] = (Spinner) findViewById(R.id.sps7);
        sp[15].setAdapter(adapter3);

        sp[16] = (Spinner) findViewById(R.id.spa1);
        sp[16].setAdapter(adapter2);
        sp[17] = (Spinner) findViewById(R.id.spa2);
        sp[17].setAdapter(adapter2);
        sp[18] = (Spinner) findViewById(R.id.spa3);
        sp[18].setAdapter(adapter2);
        sp[19] = (Spinner) findViewById(R.id.spa4);
        sp[19].setAdapter(adapter2);
        sp[20] = (Spinner) findViewById(R.id.spa5);
        sp[20].setAdapter(adapter2);
        sp[21] = (Spinner) findViewById(R.id.spa6);
        sp[21].setAdapter(adapter2);
        sp[22] = (Spinner) findViewById(R.id.spa7);
        sp[22].setAdapter(adapter2);
        sp[23] = (Spinner) findViewById(R.id.spa8);
        sp[23].setAdapter(adapter2);
        sp[24] = (Spinner) findViewById(R.id.spa9);
        sp[24].setAdapter(adapter2);
        sp[25] = (Spinner) findViewById(R.id.spa10);
        sp[25].setAdapter(adapter2);
        sp[26] = (Spinner) findViewById(R.id.spa11);
        sp[26].setAdapter(adapter2);
        sp[27] = (Spinner) findViewById(R.id.spa12);
        sp[27].setAdapter(adapter2);
        sp[28] = (Spinner) findViewById(R.id.spa13);
        sp[28].setAdapter(adapter2);
        sp[29] = (Spinner) findViewById(R.id.spa14);
        sp[29].setAdapter(adapter2);
        sp[30] = (Spinner) findViewById(R.id.spa15);
        sp[30].setAdapter(adapter2);
        sp[31] = (Spinner) findViewById(R.id.spa16);
        sp[31].setAdapter(adapter2);
        sp[32] = (Spinner) findViewById(R.id.spa17);
        sp[32].setAdapter(adapter2);

        sp[33] = (Spinner) findViewById(R.id.spsp1);
        sp[33].setAdapter(adapter2);
        sp[34] = (Spinner) findViewById(R.id.spsp2);
        sp[34].setAdapter(adapter2);
        sp[35] = (Spinner) findViewById(R.id.spsp3);
        sp[35].setAdapter(adapter2);
        sp[36] = (Spinner) findViewById(R.id.spsp4);
        sp[36].setAdapter(adapter2);
        sp[37] = (Spinner) findViewById(R.id.spsp5);
        sp[37].setAdapter(adapter2);

        sp[38] = (Spinner) findViewById(R.id.spq1);
        sp[38].setAdapter(adapter2);
        sp[39] = (Spinner) findViewById(R.id.spq2);
        sp[39].setAdapter(adapter2);
        sp[40] = (Spinner) findViewById(R.id.spq3);
        sp[40].setAdapter(adapter2);
        sp[41] = (Spinner) findViewById(R.id.spq4);
        sp[41].setAdapter(adapter2);

        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostra_resultado();
            }
        });

    }

    public void mostra_resultado(){
        total = 0;
        dor= 0;
        os= 0;
        avd= 0;
        er= 0;
        qualidade= 0;


        for(int i = 0; i<42; i++){

            p[i] = sp[i].getSelectedItemPosition();
            total += p[i];
        }
         total = (total/210) * 100;

        for(int i = 0; i<9; i++){

            p[i] = sp[i].getSelectedItemPosition();
            dor += p[i];
        }
         dor = (dor/45) * 100;

        for(int i = 9; i<16; i++){

            p[i] = sp[i].getSelectedItemPosition();
            os += p[i];
        }
         os = (os/35) * 100;

        for(int i = 16; i<33; i++){

            p[i] = sp[i].getSelectedItemPosition();
            avd += p[i];
        }
         avd = (avd/85) * 100;


        for(int i = 33; i<38; i++){

            p[i] = sp[i].getSelectedItemPosition();
            er += p[i];
        }
         er = (er/25) * 100;

        for(int i = 38; i<42; i++){

            p[i] = sp[i].getSelectedItemPosition();
            qualidade += p[i];
        }
        qualidade = (qualidade/20) * 100;

        int in =(int) total;
        int ina =(int) dor;
        int inb =(int) os;
        int inc =(int) avd;
        int ind =(int) er;
        int ine =(int) qualidade;

        tv = new TextView(this);
        tv.setText(String.valueOf(in));

        tva = new TextView(this);
        tva.setText(String.valueOf(ina));

        tvb = new TextView(this);
        tvb.setText(String.valueOf(inb));

        tvc = new TextView(this);
        tvc.setText(String.valueOf(inc));

        tvd = new TextView(this);
        tvd.setText(String.valueOf(ind));

        tve = new TextView(this);
        tve.setText(String.valueOf(ine));

        Intent intent = new Intent(Faos.this, ResultadoFaos.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faos, menu);
        return true;
    }

    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_faos);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

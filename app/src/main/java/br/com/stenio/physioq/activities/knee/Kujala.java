package br.com.stenio.physioq.activities.knee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.com.stenio.physioq.R;


public class Kujala extends AppCompatActivity {

    private Toolbar mToolbar;

    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10, rg11, rg12, rg13;
    Button btok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kujala);

        setupToolbar();

        rg1 = (RadioGroup) findViewById(R.id.rg1_kuj);
        rg2 = (RadioGroup) findViewById(R.id.rg2_kuj);
        rg3 = (RadioGroup) findViewById(R.id.rg3_kuj);
        rg4 = (RadioGroup) findViewById(R.id.rg4_kuj);
        rg5 = (RadioGroup) findViewById(R.id.rg5_kuj);
        rg6 = (RadioGroup) findViewById(R.id.rg6_kuj);
        rg7 = (RadioGroup) findViewById(R.id.rg7_kuj);
        rg8 = (RadioGroup) findViewById(R.id.rg8_kuj);
        rg9 = (RadioGroup) findViewById(R.id.rg9_kuj);
        rg10 = (RadioGroup) findViewById(R.id.rg10_kuj);
        rg11 = (RadioGroup) findViewById(R.id.rg11_kuj);
        rg12 = (RadioGroup) findViewById(R.id.rg12_kuj);
        rg13 = (RadioGroup) findViewById(R.id.rg13_kuj);

        btok = (Button) findViewById(R.id.btok);


        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraResultado();
            }
        });

    }

    public void geraResultado(){
        int id_rg, resultado = 0;

        RadioButton rb1, rb2, rb3, rb4, rb5;


        id_rg = rg1.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p1_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p1_rb3_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 3;
        }
        else if(id_rg == rb3.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg2.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p2_rb3_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 3;
        }
        else if(id_rg == rb3.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg3.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p3_rb4_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 3;
        }
        else if(id_rg == rb3.getId()){
            resultado += 2;
        }
        else if(id_rg == rb4.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg4.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p4_rb4_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 8;
        }
        else if(id_rg == rb3.getId()){
            resultado += 5;
        }
        else if(id_rg == rb4.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg5.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p5_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p5_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 4;
        }
        else if(id_rg == rb3.getId()){
            resultado += 3;
        }
        else if(id_rg == rb4.getId()){
            resultado += 2;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg6.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p6_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p6_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 8;
        }
        else if(id_rg == rb3.getId()){
            resultado += 6;
        }
        else if(id_rg == rb4.getId()){
            resultado += 3;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg7.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p7_rb4_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 7;
        }
        else if(id_rg == rb3.getId()){
            resultado += 2;
        }
        else if(id_rg == rb4.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg8.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p8_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p8_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p8_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p8_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p8_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 8;
        }
        else if(id_rg == rb3.getId()){
            resultado += 6;
        }
        else if(id_rg == rb4.getId()){
            resultado += 4;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg9.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p9_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p9_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p9_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p9_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p9_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 8;
        }
        else if(id_rg == rb3.getId()){
            resultado += 6;
        }
        else if(id_rg == rb4.getId()){
            resultado += 3;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg10.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p10_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p10_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p10_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p10_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p10_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 8;
        }
        else if(id_rg == rb3.getId()){
            resultado += 6;
        }
        else if(id_rg == rb4.getId()){
            resultado += 4;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg11.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p11_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p11_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p11_rb3_kuj);
        rb4 = (RadioButton) findViewById(R.id.p11_rb4_kuj);
        rb5 = (RadioButton) findViewById(R.id.p11_rb5_kuj);

        if(id_rg == rb1.getId()){
            resultado += 10;
        }
        else if(id_rg == rb2.getId()){
            resultado += 6;
        }
        else if(id_rg == rb3.getId()){
            resultado += 4;
        }
        else if(id_rg == rb4.getId()){
            resultado += 2;
        }
        else if(id_rg == rb5.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg12.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p12_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p12_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p12_rb3_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 3;
        }
        else if(id_rg == rb3.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        id_rg = rg13.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p13_rb1_kuj);
        rb2 = (RadioButton) findViewById(R.id.p13_rb2_kuj);
        rb3 = (RadioButton) findViewById(R.id.p13_rb3_kuj);

        if(id_rg == rb1.getId()){
            resultado += 5;
        }
        else if(id_rg == rb2.getId()){
            resultado += 3;
        }
        else if(id_rg == rb3.getId()){
            resultado += 0;
        }
        else{
            //Log.i("info", "Nenhum");
        }


        Intent irParaResultado = new Intent(Kujala.this, ResultadoKujala.class);
        irParaResultado.putExtra("resultado", resultado);
        startActivity(irParaResultado);

    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_kujala);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kujala, menu);
        return true;
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

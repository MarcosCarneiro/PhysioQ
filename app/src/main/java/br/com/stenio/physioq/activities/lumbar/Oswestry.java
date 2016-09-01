package br.com.stenio.physioq.activities.lumbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.stenio.physioq.R;

public class Oswestry extends AppCompatActivity {

    Button btok;
    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10;

   public static TextView tv;

    private Toolbar mToolbar;

    double resultado = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oswestry);

        setupToolbar();

        rg1 = (RadioGroup) findViewById(R.id.rg1_osw);
        rg2 = (RadioGroup) findViewById(R.id.rg2_osw);
        rg3 = (RadioGroup) findViewById(R.id.rg3_osw);
        rg4 = (RadioGroup) findViewById(R.id.rg4_osw);
        rg5 = (RadioGroup) findViewById(R.id.rg5_osw);
        rg6 = (RadioGroup) findViewById(R.id.rg6_osw);
        rg7 = (RadioGroup) findViewById(R.id.rg7_osw);
        rg8 = (RadioGroup) findViewById(R.id.rg8_osw);
        rg9 = (RadioGroup) findViewById(R.id.rg9_osw);
        rg10 = (RadioGroup) findViewById(R.id.rg10_osw);

        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraResultado();
            }
        });

    }

    public void geraResultado(){
        int id_reg;



        RadioButton rb1, rb2, rb3, rb4, rb5, rb6;

        id_reg = rg1.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p1_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p1_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p1_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p1_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p1_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg2.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p2_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p2_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p2_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p2_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg3.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p3_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p3_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p3_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg4.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p4_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p4_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p4_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg5.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p5_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p5_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p5_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg6.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p6_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p6_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p6_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg7.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p7_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p7_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p7_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg8.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p8_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p8_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p8_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p8_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p8_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p8_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg9.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p9_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p9_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p9_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p9_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p9_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p9_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }


        id_reg = rg10.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p10_rb1_osw);
        rb2 = (RadioButton) findViewById(R.id.p10_rb2_osw);
        rb3 = (RadioButton) findViewById(R.id.p10_rb3_osw);
        rb4 = (RadioButton) findViewById(R.id.p10_rb4_osw);
        rb5 = (RadioButton) findViewById(R.id.p10_rb5_osw);
        rb6 = (RadioButton) findViewById(R.id.p10_rb6_osw);

        if(id_reg == rb1.getId()){
            resultado += 0;
        }
        else if(id_reg == rb2.getId()){
            resultado += 1;
        }
        else if(id_reg == rb3.getId()){
            resultado += 2;
        }
        else if(id_reg == rb4.getId()){
            resultado += 3;
        }
        else if(id_reg == rb5.getId()){
            resultado += 4;
        }
        else if(id_reg == rb6.getId()){
            resultado += 5;
        }
        else {
            //implementar a mensagem quando ficar desmarcado
        }



        resultado = (resultado/50)*100;

        int it = (int) resultado;

        tv = new TextView(this);
        tv.setText(String.valueOf(it));


        Intent irParaResultado = new Intent(Oswestry.this, ResultadoOswestry.class);
        startActivity(irParaResultado);

        finish();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_oswestry, menu);
        return true;
    }

    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_oswestry);
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

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

public class Lysholm extends AppCompatActivity {

    private Toolbar mToolbar;

    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8;
    Button btok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lysholm);

        setupToolbar();

        rg1 = (RadioGroup) findViewById(R.id.rg1_lysh);
        rg2 = (RadioGroup) findViewById(R.id.rg2_lysh);
        rg3 = (RadioGroup) findViewById(R.id.rg3_lysh);
        rg4 = (RadioGroup) findViewById(R.id.rg4_lysh);
        rg5 = (RadioGroup) findViewById(R.id.rg5_lysh);
        rg6 = (RadioGroup) findViewById(R.id.rg6_lysh);
        rg7 = (RadioGroup) findViewById(R.id.rg7_lysh);
        rg8 = (RadioGroup) findViewById(R.id.rg8_lysh);

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
        rb1 = (RadioButton) findViewById(R.id.p1_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2_lysh);

        if (id_rg == rb1.getId()){resultado += 5;}
        else if(id_rg == rb2.getId()){resultado += 3;}
        else{resultado += 0;}


        id_rg = rg2.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2_lysh);

        if (id_rg == rb1.getId()){resultado += 5;}
        else if(id_rg == rb2.getId()){resultado += 2;}
        else{resultado += 0;}


        id_rg = rg3.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3_lysh);
        rb4 = (RadioButton) findViewById(R.id.p3_rb4_lysh);

        if (id_rg == rb1.getId()){resultado += 15;}
        else if(id_rg == rb2.getId()){resultado += 10;}
        else if(id_rg == rb3.getId()){resultado += 6;}
        else if(id_rg == rb4.getId()){resultado += 2;}
        else{resultado += 0;}


        id_rg = rg4.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3_lysh);
        rb4 = (RadioButton) findViewById(R.id.p4_rb4_lysh);
        rb5 = (RadioButton) findViewById(R.id.p4_rb5_lysh);

        if (id_rg == rb1.getId()){resultado += 25;}
        else if(id_rg == rb2.getId()){resultado += 20;}
        else if(id_rg == rb3.getId()){resultado += 15;}
        else if(id_rg == rb4.getId()){resultado += 10;}
        else if(id_rg == rb5.getId()){resultado += 5;}
        else{resultado += 0;}


        id_rg = rg5.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3_lysh);
        rb4 = (RadioButton) findViewById(R.id.p5_rb4_lysh);
        rb5 = (RadioButton) findViewById(R.id.p5_rb5_lysh);

        if (id_rg == rb1.getId()){resultado += 25;}
        else if(id_rg == rb2.getId()){resultado += 20;}
        else if(id_rg == rb3.getId()){resultado += 15;}
        else if(id_rg == rb4.getId()){resultado += 10;}
        else if(id_rg == rb5.getId()){resultado += 5;}
        else{resultado += 0;}


        id_rg = rg6.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3_lysh);

        if (id_rg == rb1.getId()){resultado += 10;}
        else if(id_rg == rb2.getId()){resultado += 6;}
        else if(id_rg == rb3.getId()){resultado += 2;}
        else{resultado += 0;}


        id_rg = rg7.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3_lysh);

        if (id_rg == rb1.getId()){resultado += 10;}
        else if(id_rg == rb2.getId()){resultado += 6;}
        else if(id_rg == rb3.getId()){resultado += 2;}
        else{resultado += 0;}


        id_rg = rg8.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p8_rb1_lysh);
        rb2 = (RadioButton) findViewById(R.id.p8_rb2_lysh);
        rb3 = (RadioButton) findViewById(R.id.p8_rb3_lysh);

        if (id_rg == rb1.getId()){resultado += 5;}
        else if(id_rg == rb2.getId()){resultado += 4;}
        else if(id_rg == rb3.getId()){resultado += 2;}
        else{resultado += 0;}

        Intent irParaResultado = new Intent(Lysholm.this, ResultadoLysholm.class);
        irParaResultado.putExtra("resultado", resultado);
        startActivity(irParaResultado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lysholm, menu);
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

    public void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_lysholm);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

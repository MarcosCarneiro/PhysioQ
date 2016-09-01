package br.com.stenio.physioq.activities.knee;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.com.stenio.physioq.R;

public class Fulkerson extends AppCompatActivity {

    private Toolbar mToolbar;

    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7;

    Button btok;

    public static RadioButton p1_rb1_fulk, p1_rb2_fulk, p1_rb3_fulk, p2_rb1_fulk,p2_rb2_fulk, p2_rb3_fulk, p3_rb1_fulk, p3_rb2_fulk,
            p3_rb3_fulk, p3_rb4_fulk, p4_rb1_fulk, p4_rb2_fulk, p4_rb3_fulk, p4_rb4_fulk,p5_rb1_fulk, p5_rb2_fulk, p5_rb3_fulk,
            p5_rb4_fulk, p5_rb5_fulk, p6_rb6_fulk, p6_rb7_fulk,p6_rb5_fulk, p6_rb4_fulk, p6_rb3_fulk, p6_rb2_fulk, p6_rb1_fulk,
            p7_rb1_fulk,  p7_rb2_fulk,  p7_rb3_fulk,  p7_rb4_fulk, p7_rb5_fulk ;

   public static EditText edresul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulkerson);


        setupToolbar();

        rg1 = (RadioGroup) findViewById(R.id.rg1_fulk);
        rg2 = (RadioGroup) findViewById(R.id.rg2_fulk);
        rg3 = (RadioGroup) findViewById(R.id.rg3_fulk);
        rg4 = (RadioGroup) findViewById(R.id.rg4_fulk);
        rg5 = (RadioGroup) findViewById(R.id.rg5_fulk);
        rg6 = (RadioGroup) findViewById(R.id.rg6_fulk);
        rg7 = (RadioGroup) findViewById(R.id.rg7_fulk);

        p1_rb1_fulk = (RadioButton) findViewById(R.id.p1_rb1_fulk);
        p1_rb2_fulk = (RadioButton) findViewById(R.id.p1_rb2_fulk);
        p1_rb3_fulk = (RadioButton) findViewById(R.id.p1_rb3_fulk);
        p2_rb1_fulk = (RadioButton) findViewById(R.id.p2_rb1_fulk);
        p2_rb2_fulk = (RadioButton) findViewById(R.id.p2_rb2_fulk);
        p2_rb3_fulk = (RadioButton) findViewById(R.id.p2_rb3_fulk);
        p3_rb1_fulk = (RadioButton) findViewById(R.id.p3_rb1_fulk);
        p3_rb2_fulk = (RadioButton) findViewById(R.id.p3_rb2_fulk);
        p3_rb3_fulk = (RadioButton) findViewById(R.id.p3_rb3_fulk);
        p3_rb4_fulk = (RadioButton) findViewById(R.id.p3_rb4_fulk);
        p4_rb1_fulk = (RadioButton) findViewById(R.id.p4_rb1_fulk);
        p4_rb2_fulk = (RadioButton) findViewById(R.id.p4_rb2_fulk);
        p4_rb3_fulk = (RadioButton) findViewById(R.id.p4_rb3_fulk);
        p4_rb4_fulk = (RadioButton) findViewById(R.id.p4_rb4_fulk);
        p5_rb1_fulk = (RadioButton) findViewById(R.id.p5_rb1_fulk);
        p5_rb2_fulk = (RadioButton) findViewById(R.id.p5_rb2_fulk);
        p5_rb3_fulk = (RadioButton) findViewById(R.id.p5_rb3_fulk);
        p5_rb4_fulk = (RadioButton) findViewById(R.id.p5_rb4_fulk);
        p5_rb5_fulk = (RadioButton) findViewById(R.id.p5_rb5_fulk);
        p6_rb1_fulk = (RadioButton) findViewById(R.id.p6_rb1_fulk);
        p6_rb2_fulk = (RadioButton) findViewById(R.id.p6_rb2_fulk);
        p6_rb3_fulk = (RadioButton) findViewById(R.id.p6_rb3_fulk);
        p6_rb4_fulk = (RadioButton) findViewById(R.id.p6_rb4_fulk);
        p6_rb5_fulk = (RadioButton) findViewById(R.id.p6_rb5_fulk);
        p6_rb6_fulk = (RadioButton) findViewById(R.id.p6_rb6_fulk);
        p6_rb7_fulk = (RadioButton) findViewById(R.id.p6_rb7_fulk);
        p7_rb1_fulk = (RadioButton) findViewById(R.id.p7_rb1_fulk);
        p7_rb2_fulk = (RadioButton) findViewById(R.id.p7_rb2_fulk);
        p7_rb3_fulk = (RadioButton) findViewById(R.id.p7_rb3_fulk);
        p7_rb4_fulk = (RadioButton) findViewById(R.id.p7_rb4_fulk);
        p7_rb5_fulk = (RadioButton) findViewById(R.id.p7_rb5_fulk);




        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg1.getCheckedRadioButtonId() == -1|| rg2.getCheckedRadioButtonId() == -1|| rg3.getCheckedRadioButtonId() == -1
                        || rg4.getCheckedRadioButtonId() == -1|| rg5.getCheckedRadioButtonId() == -1|| rg6.getCheckedRadioButtonId() == -1
                        || rg7.getCheckedRadioButtonId() == -1){


                    AlertDialog.Builder mensagem = new
                            AlertDialog.Builder(Fulkerson.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("Responda todas perguntas!");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                }else{

                    geraResultado();
            }
            }
        });





        //chave do onCreate
    }



    public void geraResultado() {

        int id_rg, resultado = 0;
        RadioButton rb1, rb2, rb3, rb4, rb5, rb6;

        id_rg = rg1.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p1_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 10;
        } else if (id_rg == rb2.getId()) {
            resultado += 5;
        } else {
            resultado += 0;
        }


        id_rg = rg2.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 10;
        } else if (id_rg == rb2.getId()) {
            resultado += 3;
        } else {
            resultado += 0;

        }


        id_rg = rg3.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2_fulk);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 10;

        } else if (id_rg == rb2.getId()) {
            resultado += 6;
        } else if (id_rg == rb3.getId()) {
            resultado += 2;
        } else {
            resultado += 0;
        }


        id_rg = rg4.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2_fulk);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 5;
        } else if (id_rg == rb2.getId()) {
            resultado += 4;
        } else if (id_rg == rb3.getId()) {
            resultado += 2;
        } else {
            resultado += 0;
        }


        id_rg = rg5.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2_fulk);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3_fulk);
        rb4 = (RadioButton) findViewById(R.id.p5_rb4_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 10;
        } else if (id_rg == rb2.getId()) {
            resultado += 5;
        } else if (id_rg == rb3.getId()) {
            resultado += 5;
        } else if (id_rg == rb4.getId()) {
            resultado += 3;
        } else {
            resultado += 0;
        }


        id_rg = rg6.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2_fulk);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3_fulk);
        rb4 = (RadioButton) findViewById(R.id.p6_rb4_fulk);
        rb5 = (RadioButton) findViewById(R.id.p6_rb5_fulk);
        rb6 = (RadioButton) findViewById(R.id.p6_rb6_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 45;
        } else if (id_rg == rb2.getId()) {
            resultado += 40;
        } else if (id_rg == rb3.getId()) {
            resultado += 35;
        } else if (id_rg == rb4.getId()) {
            resultado += 25;
        } else if (id_rg == rb5.getId()) {
            resultado += 20;
        } else if (id_rg == rb6.getId()) {
            resultado += 10;
        } else {
            resultado += 2;
        }


        id_rg = rg7.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1_fulk);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2_fulk);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3_fulk);
        rb4 = (RadioButton) findViewById(R.id.p7_rb4_fulk);

        if (id_rg == rb1.getId()) {
            resultado += 10;
        } else if (id_rg == rb2.getId()) {
            resultado += 7;
        } else if (id_rg == rb3.getId()) {
            resultado += 5;
        } else if (id_rg == rb4.getId()) {
            resultado += 2;
        } else {
            resultado += 0;
        }


        edresul = (EditText) findViewById(R.id.edresul);
        edresul.setText(String.valueOf(resultado));


        Intent irParaResultado = new Intent(Fulkerson.this, ResultadoFulkerson.class);
        startActivity(irParaResultado);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fulkerson, menu);
        return true;
    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_fulkerson);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.black));
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





//chave da classe
}

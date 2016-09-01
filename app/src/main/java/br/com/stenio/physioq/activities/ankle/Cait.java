package br.com.stenio.physioq.activities.ankle;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.stenio.physioq.R;

public class Cait extends AppCompatActivity {

RadioGroup rg1_cait_d ,rg1_cait_e, rg2_cait_d,rg2_cait_e, rg3_cait_d, rg3_cait_e, rg4_cait_d, rg4_cait_e
    , rg5_cait_d, rg5_cait_e, rg6_cait_d, rg6_cait_e, rg7_cait_d, rg7_cait_e, rg8_cait_d, rg8_cait_e, rg9_cait_d, rg9_cait_e;



    Button btok_cait;

    public static TextView tvdireita, tvesquerda;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cait);

        rg1_cait_d = (RadioGroup) findViewById(R.id.rg1_cait_d);
        rg1_cait_e = (RadioGroup) findViewById(R.id.rg1_cait_e);
        rg2_cait_d = (RadioGroup) findViewById(R.id.rg2_cait_d);
        rg2_cait_e = (RadioGroup) findViewById(R.id.rg2_cait_e);
        rg3_cait_d = (RadioGroup) findViewById(R.id.rg3_cait_d);
        rg3_cait_e = (RadioGroup) findViewById(R.id.rg3_cait_e);
        rg4_cait_d = (RadioGroup) findViewById(R.id.rg4_cait_d);
        rg4_cait_e = (RadioGroup) findViewById(R.id.rg4_cait_e);
        rg5_cait_d = (RadioGroup) findViewById(R.id.rg5_cait_d);
        rg5_cait_e = (RadioGroup) findViewById(R.id.rg5_cait_e);
        rg6_cait_d = (RadioGroup) findViewById(R.id.rg6_cait_d);
        rg6_cait_e = (RadioGroup) findViewById(R.id.rg6_cait_e);
        rg7_cait_d = (RadioGroup) findViewById(R.id.rg7_cait_d);
        rg7_cait_e = (RadioGroup) findViewById(R.id.rg7_cait_e);
        rg8_cait_d = (RadioGroup) findViewById(R.id.rg8_cait_d);
        rg8_cait_e = (RadioGroup) findViewById(R.id.rg8_cait_e);
        rg9_cait_d = (RadioGroup) findViewById(R.id.rg9_cait_d);
        rg9_cait_e = (RadioGroup) findViewById(R.id.rg9_cait_e);




        btok_cait = (Button) findViewById(R.id.btok_cait);
        btok_cait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg1_cait_d.getCheckedRadioButtonId() == -1
                        || rg1_cait_e.getCheckedRadioButtonId() == -1
                        || rg2_cait_d.getCheckedRadioButtonId() == -1
                        || rg1_cait_e.getCheckedRadioButtonId() == -1){


                    AlertDialog.Builder mensagem = new
                            AlertDialog.Builder(Cait.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("Responda todas perguntas!");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                }else{

                    geraResultadoCait();
                }



            }
        });


//on
    }


    public void geraResultadoCait() {

        int id_rg;
        int resultadocaitd = 0;
        int resultadocaite = 0;
        RadioButton rb1, rb2, rb3, rb4, rb5, rb6;


        // questão 1 direito
        id_rg = rg1_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p1_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p1_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p1_rb4_cait);
        rb5 = (RadioButton) findViewById(R.id.p1_rb5_cait);
        rb6 = (RadioButton) findViewById(R.id.p1_rb6_cait);

        if (id_rg == rb1.getId()) {
            resultadocaitd +=5;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 4;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 3;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 2;
        }else if (id_rg == rb5.getId()){
            resultadocaitd += 1;
        } else if (id_rg == rb6.getId()){
            resultadocaitd += 0;
        }else{
            Toast.makeText(Cait.this, "Você deixou de marcar 1 questão", Toast.LENGTH_SHORT).show();
        }
//questão 2 direito
        id_rg = rg2_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p2_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p2_rb4_cait);
        rb5 = (RadioButton) findViewById(R.id.p2_rb5_cait);

        if (id_rg == rb1.getId()) {
            resultadocaitd += 4;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 2;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb5.getId()){
            resultadocaitd += 0;
        }





        //questão 1 esquerdo
        id_rg = rg1_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p1_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p1_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p1_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p1_rb4e_cait);
        rb5 = (RadioButton) findViewById(R.id.p1_rb5e_cait);
        rb6 = (RadioButton) findViewById(R.id.p1_rb6e_cait);

        if (id_rg == rb1.getId()) {
            resultadocaite+= 5;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 4;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 3;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 2;
        }else if (id_rg == rb5.getId()){
            resultadocaite += 1;
        } else if (id_rg == rb6.getId()){
            resultadocaite += 0;
        }else{
            Toast.makeText(Cait.this, "Você deixou de marcar 1 questão", Toast.LENGTH_SHORT).show();
        }

//questão 2 esquerdo

        id_rg = rg2_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p2_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p2_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p2_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p2_rb4e_cait);
        rb5 = (RadioButton) findViewById(R.id.p2_rb5e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 4;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 2;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb5.getId()){
            resultadocaite += 0;
        } else{
            Toast.makeText(Cait.this, "Você deixou de marcar questão 2", Toast.LENGTH_SHORT).show();
        }



        //questão 3 direito


        id_rg = rg3_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p3_rb4_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 0;
        }



        //questão 3 esquerdo
        id_rg = rg3_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p3_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p3_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p3_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p3_rb4e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 0;
        }else{
            Toast.makeText(Cait.this, "Você deixou de marcar questão 3", Toast.LENGTH_SHORT).show();
        }





        //questão 4

        //dir
        id_rg = rg4_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p4_rb4_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 0;
        }

        //esq
        id_rg = rg4_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p4_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p4_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p4_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p4_rb4e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 0;
        }

        //questão 5

        //dir
        id_rg = rg5_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 1;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 0;
        }

        //esq
        id_rg = rg5_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p5_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p5_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p5_rb3e_cait);



        if (id_rg == rb1.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 1;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 0;
        }

        //questão 6

        //dir
        id_rg = rg6_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p6_rb4_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 0;
        }

        //esq
        id_rg = rg6_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p6_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p6_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p6_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p6_rb4e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 0;
        }

        //questão 7

        //dir
        id_rg = rg7_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p7_rb4_cait);
        rb5 = (RadioButton) findViewById(R.id.p7_rb5_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 4;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 2;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb5.getId()){
            resultadocaitd += 0;
        }

        //esq
        id_rg = rg7_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p7_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p7_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p7_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p7_rb4e_cait);
        rb5 = (RadioButton) findViewById(R.id.p7_rb5e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 4;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 2;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb5.getId()){
            resultadocaite += 0;
        }


        //questão 8

        //dir
        id_rg = rg8_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p8_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p8_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p8_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p8_rb4_cait);
        rb5 = (RadioButton) findViewById(R.id.p8_rb5_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 0;
        }else if (id_rg == rb5.getId()){
            resultadocaitd += 3;
        }

        //esq
        id_rg = rg8_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p8_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p8_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p8_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p8_rb4e_cait);
        rb5 = (RadioButton) findViewById(R.id.p8_rb5e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 0;
        }else if (id_rg == rb5.getId()){
            resultadocaite += 3;
        }

        //questão 9

        //dir
        id_rg = rg9_cait_d.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p9_rb1_cait);
        rb2 = (RadioButton) findViewById(R.id.p9_rb2_cait);
        rb3 = (RadioButton) findViewById(R.id.p9_rb3_cait);
        rb4 = (RadioButton) findViewById(R.id.p9_rb4_cait);
        rb5 = (RadioButton) findViewById(R.id.p9_rb5_cait);


        if (id_rg == rb1.getId()) {
            resultadocaitd += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaitd += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaitd += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaitd += 0;
        }else if (id_rg == rb5.getId()){
            resultadocaitd += 3;
        }

        //esq
        id_rg = rg9_cait_e.getCheckedRadioButtonId();
        rb1 = (RadioButton) findViewById(R.id.p9_rb1e_cait);
        rb2 = (RadioButton) findViewById(R.id.p9_rb2e_cait);
        rb3 = (RadioButton) findViewById(R.id.p9_rb3e_cait);
        rb4 = (RadioButton) findViewById(R.id.p9_rb4e_cait);


        if (id_rg == rb1.getId()) {
            resultadocaite += 3;
        } else if (id_rg == rb2.getId()) {
            resultadocaite += 2;
        } else if (id_rg == rb3.getId()){
            resultadocaite += 1;
        }else if (id_rg == rb4.getId()){
            resultadocaite += 0;
        }else if (id_rg == rb5.getId()){
            resultadocaite += 3;
        }




        tvdireita = new TextView(this);
        tvdireita.setText(String.valueOf(resultadocaitd));

        tvesquerda = new TextView(this);
        tvesquerda.setText(String.valueOf(resultadocaite));

        Intent intent = new Intent(Cait.this, ResultadoCait.class);
        startActivity(intent);




//result
    }





//class
}

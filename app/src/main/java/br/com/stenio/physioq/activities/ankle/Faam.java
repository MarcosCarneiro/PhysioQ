package br.com.stenio.physioq.activities.ankle;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.text.DecimalFormat;

import br.com.stenio.physioq.R;

public class Faam extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter, adapter2;
    Spinner sp[] = new Spinner[30];
    Button btok;
    TextView tv1, tv2;
    int p[] = new int[30];
    int porcent1 = 0, porcent2 = 0;
    double avd, ave, n_a, ativ_dia = 0, ativ_esp = 0;
    DiscreteSeekBar sb1, sb2;
    public static String nivel_func;
    DecimalFormat df = new DecimalFormat("#0.00");

    private Toolbar mToolbar;

    public static TextView tv, tva, tvb,tvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faam);

        setupToolbar();

        adapter = ArrayAdapter.createFromResource(this, R.array.array_resp, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.array_resp2, R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);


        sp[0] = (Spinner) findViewById(R.id.sp1);
        sp[0].setAdapter(adapter);

        sp[1] = (Spinner) findViewById(R.id.sp2);
        sp[1].setAdapter(adapter);

        sp[2] = (Spinner) findViewById(R.id.sp3);
        sp[2].setAdapter(adapter);

        sp[3] = (Spinner) findViewById(R.id.sp4);
        sp[3].setAdapter(adapter);

        sp[4] = (Spinner) findViewById(R.id.sp5);
        sp[4].setAdapter(adapter);

        sp[5] = (Spinner) findViewById(R.id.sp6);
        sp[5].setAdapter(adapter);

        sp[6] = (Spinner) findViewById(R.id.sp7);
        sp[6].setAdapter(adapter);

        sp[7] = (Spinner) findViewById(R.id.sp8);
        sp[7].setAdapter(adapter);

        sp[8] = (Spinner) findViewById(R.id.sp9);
        sp[8].setAdapter(adapter);

        sp[9] = (Spinner) findViewById(R.id.sp10);
        sp[9].setAdapter(adapter);

        sp[10] = (Spinner) findViewById(R.id.sp11);
        sp[10].setAdapter(adapter);

        sp[11] = (Spinner) findViewById(R.id.sp12);
        sp[11].setAdapter(adapter);

        sp[12] = (Spinner) findViewById(R.id.sp13);
        sp[12].setAdapter(adapter);

        sp[13] = (Spinner) findViewById(R.id.sp14);
        sp[13].setAdapter(adapter);

        sp[14] = (Spinner) findViewById(R.id.sp15);
        sp[14].setAdapter(adapter);

        sp[15] = (Spinner) findViewById(R.id.sp16);
        sp[15].setAdapter(adapter);

        sp[16] = (Spinner) findViewById(R.id.sp17);
        sp[16].setAdapter(adapter);

        sp[17] = (Spinner) findViewById(R.id.sp18);
        sp[17].setAdapter(adapter);

        sp[18] = (Spinner) findViewById(R.id.sp19);
        sp[18].setAdapter(adapter);

        sp[19] = (Spinner) findViewById(R.id.sp20);
        sp[19].setAdapter(adapter);

        sp[20] = (Spinner) findViewById(R.id.sp21);
        sp[20].setAdapter(adapter);

        sp[21] = (Spinner) findViewById(R.id.sp22);
        sp[21].setAdapter(adapter);

        sp[22] = (Spinner) findViewById(R.id.sp23);
        sp[22].setAdapter(adapter);

        sp[23] = (Spinner) findViewById(R.id.sp24);
        sp[23].setAdapter(adapter);

        sp[24] = (Spinner) findViewById(R.id.sp25);
        sp[24].setAdapter(adapter);

        sp[25] = (Spinner) findViewById(R.id.sp26);
        sp[25].setAdapter(adapter);

        sp[26] = (Spinner) findViewById(R.id.sp27);
        sp[26].setAdapter(adapter);

        sp[27] = (Spinner) findViewById(R.id.sp28);
        sp[27].setAdapter(adapter);

        sp[28] = (Spinner) findViewById(R.id.sp29);
        sp[28].setAdapter(adapter);

        sp[29] = (Spinner) findViewById(R.id.sp30);
        sp[29].setAdapter(adapter2);




        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1.setText(porcent1 + "/100");
        tv2.setText(porcent2+"/100");

        sb1 = (DiscreteSeekBar) findViewById(R.id.sb1);
        sb2 = (DiscreteSeekBar) findViewById(R.id.sb2);

        sb1.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                porcent1 = progress;
                tv1.setText(porcent1 + "/100");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        sb2.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                porcent2 = progress;
                tv2.setText(porcent2 + "/100");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void  onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<29; i++){


                if ( sp[0].getSelectedItemPosition() == 0 || sp[1].getSelectedItemPosition() == 0 || sp[2].getSelectedItemPosition() == 0
                        || sp[3].getSelectedItemPosition() == 0|| sp[4].getSelectedItemPosition() == 0|| sp[5].getSelectedItemPosition() == 0
                        || sp[6].getSelectedItemPosition() == 0|| sp[14].getSelectedItemPosition() == 0|| sp[22].getSelectedItemPosition() == 0
                        || sp[7].getSelectedItemPosition() == 0|| sp[15].getSelectedItemPosition() == 0|| sp[23].getSelectedItemPosition() == 0
                        || sp[8].getSelectedItemPosition() == 0|| sp[16].getSelectedItemPosition() == 0|| sp[24].getSelectedItemPosition() == 0
                        || sp[9].getSelectedItemPosition() == 0|| sp[17].getSelectedItemPosition() == 0|| sp[25].getSelectedItemPosition() == 0
                        || sp[10].getSelectedItemPosition() == 0|| sp[18].getSelectedItemPosition() == 0|| sp[26].getSelectedItemPosition() == 0
                        || sp[11].getSelectedItemPosition() == 0|| sp[19].getSelectedItemPosition() == 0|| sp[27].getSelectedItemPosition() == 0
                        || sp[12].getSelectedItemPosition() == 0|| sp[20].getSelectedItemPosition() == 0|| sp[28].getSelectedItemPosition() == 0
                        || sp[13].getSelectedItemPosition() == 0|| sp[21].getSelectedItemPosition() == 0


                        )

                    {

                    AlertDialog.Builder mensagem = new
                            AlertDialog.Builder(Faam.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("Responda todas perguntas!");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                    return;
                }else {

                    resultado();

                }

            }
            }
        });

    }

    public void resultado(){

        n_a = 0;
        ativ_dia = 0;
        for (int i = 0; i<21; i++){
            p[i] = sp[i].getSelectedItemPosition();
            if(p[i] == 6){
                n_a += 1;
            }
            else{
                ativ_dia += (p[i]-1);

            }
        }

        avd = (ativ_dia/(84-n_a*4))*100;

        n_a = 0;
        ativ_esp = 0;

        for (int i = 21; i<29; i++){
            p[i] = sp[i].getSelectedItemPosition();
            if(p[i] == 6){
                n_a += 1;
            } else{
                ativ_esp += (p[i]-1);



            }
        }

        ave = (ativ_esp/(32-n_a*4))*100;

        nivel_func = String.valueOf(sp[29].getSelectedItem());



        Intent intent = new Intent(Faam.this, ResultadoFaam.class);
        startActivity(intent);

        //double avd, ave int porcent1 porcent2 String nivel_func

        int avde = (int) avd;
        int avee = (int) ave;

        tv = new TextView(this);
        tv.setText(String.valueOf(avde));

        tva = new TextView(this);
        tva.setText(String.valueOf(avee));

        tvb = new TextView(this);
        tvb.setText(String.valueOf(porcent1));

        tvc = new TextView(this);
        tvc.setText(String.valueOf(porcent2));



    }

    public String formata(double x){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(x);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faam, menu);
        return true;
    }

    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_faam);
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

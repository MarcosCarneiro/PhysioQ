package br.com.stenio.physioq.activities.ankle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.stenio.physioq.R;

public class Lefs extends AppCompatActivity {

    RadioGroup[] rg = new RadioGroup[20];
    Button btok;

    private Toolbar mToolbar;

    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lefs);

        setupToolbar();

        rg[0] =(RadioGroup) findViewById(R.id.rg1);
        rg[1] =(RadioGroup) findViewById(R.id.rg2);
        rg[2] =(RadioGroup) findViewById(R.id.rg3);
        rg[3] =(RadioGroup) findViewById(R.id.rg4);
        rg[4] =(RadioGroup) findViewById(R.id.rg5);
        rg[5] =(RadioGroup) findViewById(R.id.rg6);
        rg[6] =(RadioGroup) findViewById(R.id.rg7);
        rg[7] =(RadioGroup) findViewById(R.id.rg8);
        rg[8] =(RadioGroup) findViewById(R.id.rg9);
        rg[9] =(RadioGroup) findViewById(R.id.rg10);
        rg[10] =(RadioGroup) findViewById(R.id.rg11);
        rg[11] =(RadioGroup) findViewById(R.id.rg12);
        rg[12] =(RadioGroup) findViewById(R.id.rg13);
        rg[13] =(RadioGroup) findViewById(R.id.rg14);
        rg[14] =(RadioGroup) findViewById(R.id.rg15);
        rg[15] =(RadioGroup) findViewById(R.id.rg16);
        rg[16] =(RadioGroup) findViewById(R.id.rg17);
        rg[17] =(RadioGroup) findViewById(R.id.rg18);
        rg[18] =(RadioGroup) findViewById(R.id.rg19);
        rg[19] =(RadioGroup) findViewById(R.id.rg20);


        btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraResultado();
            }
        });

    }

    public void geraResultado(){

        RadioButton rb1, rb2, rb3, rb4;
        rb1 = (RadioButton) findViewById(R.id.rb11);
        rb2 = (RadioButton) findViewById(R.id.rb12);
        rb3 = (RadioButton) findViewById(R.id.rb13);
        rb4 = (RadioButton) findViewById(R.id.rb14);
        int resultado = 0;

        for(int i = 0; i <20; i++){
            RadioButton radioButton = (RadioButton)findViewById(rg[i].getCheckedRadioButtonId());

            if(radioButton.getText().equals(rb1.getText())){
                resultado+=0;
            }
            else if(radioButton.getText().equals(rb2.getText())){
                resultado+=1;
            }
            else if(radioButton.getText().equals(rb3.getText())){
                resultado+=2;
            }
            else if(radioButton.getText().equals(rb4.getText())){
                resultado+=3;
            }
            else{
                resultado+=4;
            }

            tv = new TextView(this);
            tv.setText(String.valueOf(resultado));

            Intent irParaResultado = new Intent(Lefs.this, ResultadoLefs.class);
            startActivity(irParaResultado);
        }
    }



    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_lefs);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

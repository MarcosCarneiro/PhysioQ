package br.com.stenio.physioq.activities.knee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import br.com.stenio.physioq.R;


public class VisaP extends AppCompatActivity {

    private Toolbar mToolbar;

    DiscreteSeekBar sb1, sb2, sb3, sb4, sb5, sb6;
    int p1, p2, p3, p4, p5, p6, p7, p8a, p8b, p8c;
    TextView tvMin;
    RadioGroup rg1, rg2, rg3, rg4;
    RadioButton rb1, rb2, rb3, rb4;
    int id_rb1, id_rb2, id_rb3, id_rb4, id_rad;
    Button btok;
    public static EditText edresulvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_p);

        setupToolbar();

        sb1 = (DiscreteSeekBar) findViewById(R.id.sbv1);
        sb2 = (DiscreteSeekBar) findViewById(R.id.sbv2);
        sb3 = (DiscreteSeekBar) findViewById(R.id.sbv3);
        sb4 = (DiscreteSeekBar) findViewById(R.id.sbv4);
        sb5 = (DiscreteSeekBar) findViewById(R.id.sbv5);
        sb6 = (DiscreteSeekBar) findViewById(R.id.sbv6);

        tvMin = (TextView) findViewById(R.id.tvMin);


        rg1 = (RadioGroup) findViewById(R.id.visa_rg1);
        rg2 = (RadioGroup) findViewById(R.id.visa_rg2);
        rg3 = (RadioGroup) findViewById(R.id.visa_rg3);
        rg4 = (RadioGroup) findViewById(R.id.visa_rg4);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);

        id_rb1 = rb1.getId();
        id_rb2 = rb2.getId();
        id_rb3 = rb3.getId();
        id_rb4 = rb4.getId();

        btok = (Button) findViewById(R.id.btok);

        sb1.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                p1 = progress ;
                tvMin.setText(progress * 10  + " min");
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
                p2 = progress;
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        sb3.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                p3 = progress;

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        sb4.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                p4 = progress;

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });


        sb5.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                p5 = progress;

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });


        sb6.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                p6 = progress;

            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });


        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraResultado();
            }
        });


    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_visa_p);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i("ASD", "ASD");
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    public void geraResultado(){
        id_rad = rg1.getCheckedRadioButtonId();
        int resultado = 0;

        if(id_rad == id_rb1){
            p7 = 0;
        }
        else if(id_rad == id_rb2){
            p7 = 4;
        }
        else if(id_rad == id_rb3){
            p7 = 7;
        }
        else{
            p7 = 10;
        }

        rb1 = (RadioButton) findViewById(R.id.rb1_visa);
        rb2 = (RadioButton) findViewById(R.id.rb2_visa);
        rb3 = (RadioButton) findViewById(R.id.rb3_visa);
        rb4 = (RadioButton) findViewById(R.id.rb4_visa);

        RadioButton botao = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());

        if(rb1.getText().equals(botao.getText())){
            p8a = 0;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8a = 7;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8a = 14;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8a = 21;
        }
        else{
            p8a = 30;
        }

        botao = (RadioButton) findViewById(rg3.getCheckedRadioButtonId());

        if(rb1.getText().equals(botao.getText())){
            p8b = 0;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8b = 4;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8b = 10;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8b = 14;
        }
        else{
            p8b = 20;
        }

        botao = (RadioButton) findViewById(rg4.getCheckedRadioButtonId());

        if(rb1.getText().equals(botao.getText())){
            p8c = 0;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8c = 2;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8c = 5;
        }
        else if(rb2.getText().equals(botao.getText())){
            p8c = 7;
        }
        else{
            p8c = 10;
        }

        resultado = p1+p2+p3+p4+p5+p6+p7+p8a+p8b+p8c;

        edresulvp = (EditText) findViewById(R.id.edresulvp);
        edresulvp.setText(String.valueOf(resultado));

        Intent irParaResultado = new Intent(VisaP.this, resultado_visa_p.class);
        startActivity(irParaResultado);
    }
}

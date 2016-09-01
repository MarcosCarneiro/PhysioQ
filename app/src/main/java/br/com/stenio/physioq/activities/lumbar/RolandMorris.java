package br.com.stenio.physioq.activities.lumbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import br.com.stenio.physioq.R;

public class RolandMorris extends AppCompatActivity {

    CheckBox[] cb = new CheckBox[24];
    public static TextView tvMor, tvroland;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roland_morris);

        setupToolbar();

        cb[0] = (CheckBox) findViewById(R.id.p1_cb_mor);
        cb[1] = (CheckBox) findViewById(R.id.p2_cb_mor);
        cb[2] = (CheckBox) findViewById(R.id.p3_cb_mor);
        cb[3] = (CheckBox) findViewById(R.id.p4_cb_mor);
        cb[4] = (CheckBox) findViewById(R.id.p5_cb_mor);
        cb[5] = (CheckBox) findViewById(R.id.p6_cb_mor);
        cb[6] = (CheckBox) findViewById(R.id.p7_cb_mor);
        cb[7] = (CheckBox) findViewById(R.id.p8_cb_mor);
        cb[8] = (CheckBox) findViewById(R.id.p9_cb_mor);
        cb[9] = (CheckBox) findViewById(R.id.p10_cb_mor);
        cb[9] = (CheckBox) findViewById(R.id.p10_cb_mor);
        cb[10] = (CheckBox) findViewById(R.id.p11_cb_mor);
        cb[11] = (CheckBox) findViewById(R.id.p12_cb_mor);
        cb[12] = (CheckBox) findViewById(R.id.p13_cb_mor);
        cb[13] = (CheckBox) findViewById(R.id.p14_cb_mor);
        cb[14] = (CheckBox) findViewById(R.id.p15_cb_mor);
        cb[15] = (CheckBox) findViewById(R.id.p16_cb_mor);
        cb[16] = (CheckBox) findViewById(R.id.p17_cb_mor);
        cb[17] = (CheckBox) findViewById(R.id.p18_cb_mor);
        cb[18] = (CheckBox) findViewById(R.id.p19_cb_mor);
        cb[19] = (CheckBox) findViewById(R.id.p20_cb_mor);
        cb[20] = (CheckBox) findViewById(R.id.p21_cb_mor);
        cb[21] = (CheckBox) findViewById(R.id.p22_cb_mor);
        cb[22] = (CheckBox) findViewById(R.id.p23_cb_mor);
        cb[23] = (CheckBox) findViewById(R.id.p24_cb_mor);

        SeekBar sb = (SeekBar) findViewById(R.id.sb_mor);
        tvMor = (TextView) findViewById(R.id.tvMor);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMor.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btok = (Button) findViewById(R.id.btok);

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraResultado();
            }
        });

    }

    public void geraResultado(){
        int resultado = 0;

        for(int i = 0; i < 24; i++){
            if(cb[i].isChecked()){
                resultado += 1;
            }
        }


         tvroland = new TextView(this);
        tvroland.setText(String.valueOf(resultado));

        Intent irParaResultado = new Intent(RolandMorris.this, ResultadoRolandMorris.class);
        startActivity(irParaResultado);

    }





    public void setupToolbar() {
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.titulo_roland_morris);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

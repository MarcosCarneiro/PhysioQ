package br.com.stenio.physioq.activities.knee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import br.com.stenio.physioq.R;

public class ResultadoKujala extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_kujala);

        setupToolbar();

        Bundle extras = getIntent().getExtras();
        int resultado = extras.getInt("resultado");

        TextView tv = (TextView) findViewById(R.id.tv2);
        tv.setText(String.valueOf(resultado));
    }

    public void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.kuj_result);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado_kujala, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent chooseKneeActivity = new Intent(ResultadoKujala.this, KneeQuestionaryActivity.class);
            startActivity(chooseKneeActivity);
        }
        return true;
    }
}

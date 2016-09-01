package br.com.stenio.physioq.activities.date;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.ankle.Aofas;
import br.com.stenio.physioq.activities.ankle.Cait;
import br.com.stenio.physioq.activities.ankle.Faam;
import br.com.stenio.physioq.activities.ankle.Faos;
import br.com.stenio.physioq.activities.ankle.Lefs;
import br.com.stenio.physioq.activities.knee.Fulkerson;
import br.com.stenio.physioq.activities.knee.Kujala;
import br.com.stenio.physioq.activities.knee.Lysholm;
import br.com.stenio.physioq.activities.knee.VisaP;
import br.com.stenio.physioq.activities.lumbar.Oswestry;
import br.com.stenio.physioq.activities.lumbar.RolandMorris;


public class Dados extends AppCompatActivity {

    private Toolbar mToolbar;
    private int sYear;
    private int sMonth;
    private int sDay;

    public static EditText ednome, edemail, edtto, edcirurgia;
    public static TextView eddata, txtdominate, txtviewsex;

    RelativeLayout btnsex, sexlayout;
    Switch switch1;

    DatePickerDialog datePickerDialog;
    RelativeLayout operadateLayout;

private String dados;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pct);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                 dados = params.getString("dados");
            }
        }

        setupToolbar();
        ednome = (EditText) findViewById(R.id.ednome);
        edemail = (EditText) findViewById(R.id.edemail);
        edtto = (EditText) findViewById(R.id.edtto);
        edcirurgia = (EditText) findViewById(R.id.edcirurgia);

        eddata = (TextView) findViewById(R.id.eddata);
        txtdominate = (TextView) findViewById(R.id.txtdominate);
        txtviewsex = (TextView) findViewById(R.id.txtviewsex);

        btnsex = (RelativeLayout) findViewById(R.id.btnsex);
        sexlayout = (RelativeLayout) findViewById(R.id.sexlayout);

        Calender ();
        Dialog();
        DialogSex();
        Switch();

        FrameLayout comecarQuestion = (FrameLayout) findViewById (R.id.comecarQuestion);
        comecarQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ednome.getText().length() == 0 ) {
                    AlertDialog.Builder mensagem = new
                            AlertDialog.Builder(Dados.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("Por favor digite o nome do avaliado");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();

                } else if(dados.equalsIgnoreCase("VisaP")) {
                    Intent irList = new Intent(Dados.this, VisaP.class);
                    startActivity(irList);

                }else if(dados.equalsIgnoreCase("Fulkerson")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);

                }else if(dados.equalsIgnoreCase("Lysholm")) {
                    Intent irList = new Intent(Dados.this, Lysholm.class);
                    startActivity(irList);

                }else if(dados.equalsIgnoreCase("Kujala")) {
                    Intent irList = new Intent(Dados.this, Kujala.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Aofas")) {
                    Intent irList = new Intent(Dados.this, Aofas.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Faam")) {
                    Intent irList = new Intent(Dados.this, Faam.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Faos")) {
                    Intent irList = new Intent(Dados.this, Faos.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Lefs")) {
                    Intent irList = new Intent(Dados.this, Lefs.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Oswestry")) {
                    Intent irList = new Intent(Dados.this, Oswestry.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Roland Morris")) {
                    Intent irList = new Intent(Dados.this, RolandMorris.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Dash")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Spadi")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Tso")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Ucla")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Worc")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Ases")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Ndi")) {
                    Intent irList = new Intent(Dados.this, Fulkerson.class);
                    startActivity(irList);
                }else if(dados.equalsIgnoreCase("Cait")) {
                    Intent irList = new Intent(Dados.this, Cait.class);
                    startActivity(irList);
                }
                }
        });



        //onCreate
    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle("Dados do Paciente");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.black));

    }


    public void Switch () {
        operadateLayout = (RelativeLayout) findViewById(R.id.operadateLayout);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setChecked(false);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    operadateLayout.setVisibility(View.VISIBLE);


                } else {
                    operadateLayout.setVisibility(View.GONE);
                    operadateLayout.postInvalidate();
                }

            }
        });

        if (switch1.isChecked()) {
            operadateLayout.setVisibility(View.VISIBLE);


        } else {
            operadateLayout.setVisibility(View.GONE);
            operadateLayout.postInvalidate();
        }

    }


    public void Calender () {
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_MONTH, -10);
        sYear = c1.get(Calendar.YEAR);
        sMonth = c1.get(Calendar.MONTH);
        sDay = c1.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                sYear = year;
                sMonth = monthOfYear;
                sDay = dayOfMonth;
                // Date set

                String dueDateString = (new StringBuilder().append(sDay )
                        .append("/").append(sMonth + 1).append("/").append(sYear)).toString();

                eddata.setText(dueDateString);


            }
        },
                2015, 12, 30
        );
        RelativeLayout btnShow = (RelativeLayout) this.findViewById(R.id.bithdateLayout);

        btnShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datePickerDialog.show();


            }
        });

    }


    //Dialogo
    public void Dialog () {


        btnsex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }


        });
    }

    //DialogoSex
    public void DialogSex () {


        sexlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSexDialogSex();
            }


        });
    }
//Continuação do Dialogo

    public void showDialog(){
        final CharSequence[] items = {"Direito", "Esquerdo","N/A"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Membro Avaliado");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection


                txtdominate.setText(items[item].toString());
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    //Continuação do DialogoSex

    public void showSexDialogSex(){
        final CharSequence[] items = {"Masculino", "Feminino"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolha o Sexo");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection

                txtviewsex.setText(items[item].toString());
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }






//CLASS
}


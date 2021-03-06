package br.com.stenio.physioq.activities.ankle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.List;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;
import br.com.stenio.physioq.adapters.QuestionariesSCardsAdapter;
import br.com.stenio.physioq.interfaces.RecyclerViewOnClickListener;
import br.com.stenio.physioq.views.RecyclerViewTouchListener;

public class AnkleQuestionaryActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private Toolbar mToolbar;
    private List<String> ankleQuestionariesNames;
    private QuestionariesSCardsAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public static final int CONSTANTE_TELA_5 = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankle_questionary);


        setupToolbar();
        setupRecyclerView();
        ankleQuestionariesNames = Arrays.asList(getResources().getStringArray(R.array.ankle_questionaries));
        mAdapter = new QuestionariesSCardsAdapter(this, ankleQuestionariesNames);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, mRecyclerView, this));




        ImageButton ibBack = (ImageButton) findViewById(R.id.ibBack);

        ibBack.setOnClickListener(new View.OnClickListener()

                                  {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(AnkleQuestionaryActivity.this, HomeActivity.class);
                                          startActivity(intent);
                                      }
                                  }

        );


//chave do onCreate
    }



        public void setupRecyclerView() {
            mRecyclerView = (RecyclerView) findViewById(R.id.ankle_recyclerView);
            LinearLayoutManager mLinearManager = new LinearLayoutManager(this);
            mLinearManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(mLinearManager);
        }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.ankle);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.black));




    }





    @Override
    public void onClickListener(int position) {
        Intent openQuestionary = null;
        Bundle params = new Bundle();
        switch (position) {
            case 0: openQuestionary = new Intent(AnkleQuestionaryActivity.this, Dados.class);
                params.putString("dados", "Aofas");
                openQuestionary.putExtras(params);
                break;

             case 1: openQuestionary = new Intent(AnkleQuestionaryActivity.this, Dados.class);
                 params.putString("dados", "Faam");
                 openQuestionary.putExtras(params);
                break;

             case 2: openQuestionary = new Intent(AnkleQuestionaryActivity.this, Dados.class);
                 params.putString("dados", "Faos");
                 openQuestionary.putExtras(params);
                break;

             case 3: openQuestionary = new Intent(AnkleQuestionaryActivity.this, Dados.class);
                 params.putString("dados", "Lefs");
                 openQuestionary.putExtras(params);
                break;

            case 4: openQuestionary = new Intent(AnkleQuestionaryActivity.this, Dados.class);
                 params.putString("dados", "Cait");
                 openQuestionary.putExtras(params);
                break;
        }
        startActivityForResult(openQuestionary, CONSTANTE_TELA_5);
    }
}

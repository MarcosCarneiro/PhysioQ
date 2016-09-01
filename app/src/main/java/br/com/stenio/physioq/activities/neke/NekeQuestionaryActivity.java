package br.com.stenio.physioq.activities.neke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
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

public class NekeQuestionaryActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private Toolbar mToolbar;
    private List<String> ankleQuestionariesNames;
    private QuestionariesSCardsAdapter mAdapter;
    private RecyclerView mRecyclerView;
    public static final int CONSTANTE_TELA_4 = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankle_questionary);


        setupToolbar();
        setupRecyclerView();
        ankleQuestionariesNames = Arrays.asList(getResources().getStringArray(R.array.neke_questionaries));
        mAdapter = new QuestionariesSCardsAdapter(this, ankleQuestionariesNames);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, mRecyclerView, this));




        ImageButton ibBack = (ImageButton) findViewById(R.id.ibBack);

        ibBack.setOnClickListener(new View.OnClickListener()

                                  {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(NekeQuestionaryActivity.this, HomeActivity.class);
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
        mToolbar.setTitle(R.string.neck);
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

    @Override
    public void onClickListener(int position) {
        Intent openQuestionary = null;
        Bundle params = new Bundle();
        switch (position) {
            case 0: openQuestionary = new Intent(NekeQuestionaryActivity.this, Dados.class);
                params.putString("dados", "Ndi");
                openQuestionary.putExtras(params);
                break;


        }
        startActivityForResult(openQuestionary,CONSTANTE_TELA_4);
    }
}

package br.com.stenio.physioq.activities.knee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class KneeQuestionaryActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    private Toolbar mToolbar;
    private List<String> kneeQuestionariesNames;
    private QuestionariesSCardsAdapter mAdapter;
    private RecyclerView mRecyclerView;
    public static final int CONSTANTE_TELA_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knee_questionary);

        setupToolbar();
        setupRecyclerView();
        kneeQuestionariesNames = Arrays.asList(getResources().getStringArray(R.array.knee_questionaries));
        mAdapter = new QuestionariesSCardsAdapter(this, kneeQuestionariesNames);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, mRecyclerView, this));

        ImageButton ibBack = (ImageButton) findViewById(R.id.ibBack);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KneeQuestionaryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.knee_recyclerView);
        LinearLayoutManager mLinearManager = new LinearLayoutManager(this);
        mLinearManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearManager);
    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.knee);
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

    @Override
    public void onClickListener(int position) {
        Intent openQuestionary = null;

        Bundle params = new Bundle();


        switch (position) {
            case 0: openQuestionary = new Intent(KneeQuestionaryActivity.this, Dados.class);
                params.putString("dados", "VisaP");
                openQuestionary.putExtras(params);
                break;

            case 1: openQuestionary = new Intent(KneeQuestionaryActivity.this, Dados.class);
                params.putString("dados", "Fulkerson");
                openQuestionary.putExtras(params);
                break;

            case 2: openQuestionary = new Intent(KneeQuestionaryActivity.this, Dados.class);
                params.putString("dados", "Lysholm");
                openQuestionary.putExtras(params);
                break;

            case 3: openQuestionary = new Intent(KneeQuestionaryActivity.this, Dados.class);
                params.putString("dados", "Kujala");
                openQuestionary.putExtras(params);
                break;
        }
        startActivityForResult(openQuestionary,CONSTANTE_TELA_1);
    }
}

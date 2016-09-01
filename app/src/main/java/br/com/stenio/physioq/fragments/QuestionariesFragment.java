package br.com.stenio.physioq.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.ankle.AnkleQuestionaryActivity;
import br.com.stenio.physioq.activities.elbow.ElbowQuestionaryActivity;
import br.com.stenio.physioq.activities.knee.KneeQuestionaryActivity;
import br.com.stenio.physioq.activities.lumbar.LumbarQuestionaryActivity;
import br.com.stenio.physioq.activities.neke.NekeQuestionaryActivity;
import br.com.stenio.physioq.activities.shoulder.ShoulderQuestionaryActivity;
import br.com.stenio.physioq.adapters.QuestionariesAdapter;
import br.com.stenio.physioq.interfaces.RecyclerViewOnClickListener;
import br.com.stenio.physioq.views.RecyclerViewTouchListener;

public class QuestionariesFragment extends Fragment implements RecyclerViewOnClickListener {
    private RecyclerView mRecyclerView;
    private List<String> mQuestionariesList;
    private QuestionariesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionaries, container, false);

        setupRecyclerView(view);


        return view;
    }

    public void setupRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity(), mRecyclerView, this));

        /*LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
        mLinearManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearManager);*/
        GridLayoutManager mLinerManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);



        mQuestionariesList = ((HomeActivity) getActivity()).getQuestionariesList();
        mAdapter = new QuestionariesAdapter(getActivity(), mQuestionariesList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLinerManager);

    }

    @Override
    public void onClickListener(int position) {
        Intent openQuestionary = null;

        switch(position) {
            case 0:
                openQuestionary = new Intent(getActivity(), AnkleQuestionaryActivity.class);
                break;
            case 1:
                openQuestionary = new Intent(getActivity(), KneeQuestionaryActivity.class);
                break;
            case 2:
                openQuestionary = new Intent(getActivity(), LumbarQuestionaryActivity.class);
                break;
            case 3:
                openQuestionary = new Intent(getActivity(), ShoulderQuestionaryActivity.class);
                break;
            case 4:
                openQuestionary = new Intent(getActivity(), ElbowQuestionaryActivity.class);
                break;
            case 5:
                openQuestionary = new Intent(getActivity(), NekeQuestionaryActivity.class);
                break;
        }
        startActivity(openQuestionary);
    }
}

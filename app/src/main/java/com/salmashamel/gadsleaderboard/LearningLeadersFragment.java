package com.salmashamel.gadsleaderboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.UI.MainViewModel;

import java.util.ArrayList;
import java.util.List;


public class LearningLeadersFragment extends Fragment {

    private static final String TAG = "LearningLeadersFragment";
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private ArrayList<LearningLeader> learningLeaderList = new ArrayList<>();
    private LearningLeaderRecycleAdapter mLearningLeaderRecycleAdapter;

    private MainViewModel mMainViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mMainViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), new Observer<List<LearningLeader>>() {
            @Override
            public void onChanged(List<LearningLeader> learningLeaders) {
                Log.d(TAG, "onChanged: received data" );
                for(LearningLeader learningLeader : learningLeaders){
                    learningLeaderList.add(learningLeader);
                    mLearningLeaderRecycleAdapter.setList(learningLeaderList);
                    mLearningLeaderRecycleAdapter.notifyDataSetChanged();
                }

            }
        });

        mMainViewModel.getLearningLeaders();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        mRecyclerView = view.findViewById(R.id.rvLearningLeaders);
        initRecycleView();

        return view;
    }

    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: recycleview started");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mLearningLeaderRecycleAdapter = new LearningLeaderRecycleAdapter(getActivity(),learningLeaderList);
        mRecyclerView.setAdapter(mLearningLeaderRecycleAdapter);
    }
}
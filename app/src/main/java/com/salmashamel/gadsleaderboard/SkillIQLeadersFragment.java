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

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;
import com.salmashamel.gadsleaderboard.UI.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class SkillIQLeadersFragment extends Fragment {

    private static final String TAG = "SkillIQLeadersFragment";
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private ArrayList<SkillIQLeader> skillIQLeaderList = new ArrayList<>();
    private SkillIQLeaderRecycleAdapter mSkillIQLeaderRecycleAdapter;

    private MainViewModel mMainViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mMainViewModel.getSkillIQLeaders().observe(getViewLifecycleOwner(), new Observer<List<SkillIQLeader>>() {
            @Override
            public void onChanged(List<SkillIQLeader> skillIQLeaders) {
                Log.d(TAG, "onChanged: received data" );
                for(SkillIQLeader skillIQLeader : skillIQLeaders){
                    skillIQLeaderList.add(skillIQLeader);
                    mSkillIQLeaderRecycleAdapter.setList(skillIQLeaderList);
                    mSkillIQLeaderRecycleAdapter.notifyDataSetChanged();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);

        mRecyclerView = view.findViewById(R.id.rvSkillLeaders);
        initRecycleView();

        return view;
    }

    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: recycleview started");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mSkillIQLeaderRecycleAdapter = new SkillIQLeaderRecycleAdapter(getActivity(),skillIQLeaderList);
        mRecyclerView.setAdapter(mSkillIQLeaderRecycleAdapter);
    }
}
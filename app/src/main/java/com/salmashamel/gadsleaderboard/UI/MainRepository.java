package com.salmashamel.gadsleaderboard.UI;

import android.util.Log;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;
import com.salmashamel.gadsleaderboard.services.Client;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    
    private MutableLiveData<List<LearningLeader>> learningLeadersLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SkillIQLeader>> skillIQLeadersLiveData = new MutableLiveData<>();
    private static MainRepository sMainRepository;

    private static final String TAG = "MainRepository";

    public MainRepository(){

    }

    public static MainRepository getInstance(){
        if(sMainRepository == null){
            sMainRepository = new MainRepository();
        }

        return sMainRepository;
    }

    public MutableLiveData<List<LearningLeader>> getLearningLeaders(){
        Client.getINSTANCE().getLearningLeaders().enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                assert response.body() != null;
                learningLeadersLiveData.setValue((List<LearningLeader>) response.body());
                Log.d(TAG, "onResponse: " + ((List<LearningLeader>) response.body()).get(0).getName());
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {

            }
        });

        return learningLeadersLiveData;
    }

    public MutableLiveData<List<SkillIQLeader>> getSkillIQLeaders(){
        Client.getINSTANCE().getSkillIQLeaders().enqueue(new Callback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeader>> call, Response<List<SkillIQLeader>> response) {
                skillIQLeadersLiveData.setValue((List<SkillIQLeader>) response.body());
                Log.d(TAG, "onResponse: " + ((List<SkillIQLeader>) response.body()).get(0).getScore());
            }

            @Override
            public void onFailure(Call<List<SkillIQLeader>> call, Throwable t) {

            }
        });

        return skillIQLeadersLiveData;
    }
}

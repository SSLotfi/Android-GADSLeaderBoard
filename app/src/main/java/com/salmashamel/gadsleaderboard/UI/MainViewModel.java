package com.salmashamel.gadsleaderboard.UI;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<List<LearningLeader>> learningLeadersLiveData = new MutableLiveData<>();
    public MutableLiveData<List<SkillIQLeader>> skillIQLeadersLiveData = new MutableLiveData<>();
    private final MainRepository mMainRepository;

    public MainViewModel(){
        mMainRepository = new MainRepository();

    }

    public MutableLiveData<List<LearningLeader>> getLearningLeaders(){
        learningLeadersLiveData = mMainRepository.getLearningLeaders();
        return learningLeadersLiveData;
    }

    public MutableLiveData<List<SkillIQLeader>> getSkillIQLeaders(){
        skillIQLeadersLiveData = mMainRepository.getSkillIQLeaders();
        return skillIQLeadersLiveData;
    }

}

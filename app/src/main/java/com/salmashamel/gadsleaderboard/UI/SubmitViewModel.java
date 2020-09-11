package com.salmashamel.gadsleaderboard.UI;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubmitViewModel extends ViewModel {

    public MutableLiveData<Boolean> submitDoneLiveData = new MutableLiveData<>();

    private final SubmitRepository mSubmitRepository;

    public SubmitViewModel(){
        mSubmitRepository = new SubmitRepository();

    }

    public MutableLiveData<Boolean> submitProject(String email, String firstName, String lastName, String githubLink){
        submitDoneLiveData = mSubmitRepository.submitProject(email, firstName, lastName, githubLink);
        return submitDoneLiveData;
    }

}

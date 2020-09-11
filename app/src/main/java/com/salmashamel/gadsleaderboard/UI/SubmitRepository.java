package com.salmashamel.gadsleaderboard.UI;

import android.util.Log;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;
import com.salmashamel.gadsleaderboard.services.Client;
import com.salmashamel.gadsleaderboard.services.PostClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitRepository {

    private MutableLiveData<Boolean> submitDoneLiveData = new MutableLiveData<>();

    private static SubmitRepository sSubmitRepository;

    private static final String TAG = "SubmitRepository";

    public SubmitRepository(){

    }

    public static SubmitRepository getInstance(){
        if(sSubmitRepository == null){
            sSubmitRepository = new SubmitRepository();
        }

        return sSubmitRepository;
    }

    public MutableLiveData<Boolean> submitProject(String email, String firstName, String lastName, String githubLink){
        PostClient.getINSTANCE().submitPorject(email, firstName, lastName, githubLink).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    submitDoneLiveData.setValue(true);
                }
                else{
                    submitDoneLiveData.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                submitDoneLiveData.setValue(false);
            }
        });

        return submitDoneLiveData;
    }

}

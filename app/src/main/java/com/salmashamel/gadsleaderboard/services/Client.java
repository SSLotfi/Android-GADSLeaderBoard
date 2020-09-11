package com.salmashamel.gadsleaderboard.services;

import android.util.Log;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private static final String TAG = "Client";
    private DataService DataService;
    private static Client INSTANCE;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataService = retrofit.create(DataService.class);
    }

    public static Client getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Client();
        }

        return INSTANCE;
    }

    public Call<List<LearningLeader>> getLearningLeaders(){
        Log.d(TAG, "getLearningLeaders: called");
        return DataService.getLearningLeaders();
    }

    public Call<List<SkillIQLeader>> getSkillIQLeaders(){
        return DataService.getSkillIQLeaders();
    }
}

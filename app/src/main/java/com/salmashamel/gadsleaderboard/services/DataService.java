package com.salmashamel.gadsleaderboard.services;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;
import com.salmashamel.gadsleaderboard.POJO.SkillIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @GET("api/hours")
    Call<List<LearningLeader>> getLearningLeaders();

    @GET("api/skilliq")
    Call<List<SkillIQLeader>> getSkillIQLeaders();
}

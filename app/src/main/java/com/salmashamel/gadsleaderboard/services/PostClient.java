package com.salmashamel.gadsleaderboard.services;

import android.util.Log;

import com.salmashamel.gadsleaderboard.POJO.LearningLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    private static final String TAG = "PostClient";
    private PostService postService;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postService = retrofit.create(PostService.class);
    }

    public static PostClient getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new PostClient();
        }

        return INSTANCE;
    }

    public Call<Void> submitPorject(String email, String firstName, String lastName, String githubLink){
        Log.d(TAG, "submit: called");
        return postService.submitProject(email, firstName, lastName, githubLink);
    }
}

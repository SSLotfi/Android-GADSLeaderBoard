package com.salmashamel.gadsleaderboard.services;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostService {

//    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
//    @FormUrlEncoded
//    Call<Void> submitProject(
//            @Field("entry.1824927963") String email,
//            @Field("entry.1877115667") String firstName,
//            @Field(("entry.2006916086")) String lastName,
//            @Field("entry.284483984") String githubLink
//    );

    @POST("1FAIpQLSdbp8X9R2X0yZRy1aghe5WiCofVaGu9IitAakGvk0Rj66cfCw/formResponse")
    @FormUrlEncoded
    Call<Void> submitProject(
            @Field("entry.762408655") String email,
            @Field("entry.1328434692") String firstName,
            @Field(("entry.1473510853")) String lastName,
            @Field("entry.653380810") String githubLink
    );
}

package com.jjunji.android.test_mml;

import android.content.ContentProvider;
import android.graphics.Movie;

import com.jjunji.android.test_mml.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jhjun on 2018-02-27.
 */

public interface iService {

    @GET("people/searchPeopleList.json")
    Call<MovieList> getList(
            @Query("key") String key,
            @Query("peopleNm") String name
    );
}

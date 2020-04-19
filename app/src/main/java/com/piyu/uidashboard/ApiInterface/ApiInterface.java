package com.piyu.uidashboard.ApiInterface;

import com.piyu.uidashboard.model.Application;
import com.piyu.uidashboard.model.Results;
import com.piyu.uidashboard.model.contest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("?sort")
    Observable<Application> getResults();


}

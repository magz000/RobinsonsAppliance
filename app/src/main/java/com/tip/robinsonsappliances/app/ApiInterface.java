package com.tip.robinsonsappliances.app;


import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.responses.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface ApiInterface {

    String do_action = "department_receiving_mobile.php?";

//    @POST(do_action)
//    @FormUrlEncoded
//    Call<User> login(@Field("do") String d,@Field("username") String username, @Field("password") String password, @Field("s") String s);

    @FormUrlEncoded
    @POST(Endpoints.LOGIN)
    Call<LoginResponse> login(@Field(Constants.USERNAME) String username,
                              @Field(Constants.PASSWORD) String password);

    @POST(Endpoints.GETAPPLIANCES)
    Call<List<Appliances>> getAppliances();


//    @POST(do_action)
//    @FormUrlEncoded
//    Call<ReceivedResponse> getAllReceived(@Field("do") String d);
//
//    @POST(do_action)
//    @FormUrlEncoded
//    Call<ReceivedItemsResponse> getReceivedItems(@Field("do") String a, @Field("receiving_no") String b);
//
//    @POST(do_action)
//    @FormUrlEncoded
//    Call<DeptReceivingResponse> deptReceived(@Field("p") String p);

}

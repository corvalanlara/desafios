package com.userInteractionsAndAndroidResourse.dogsapp.presenter;

import android.util.Log;

import com.userInteractionsAndAndroidResourse.dogsapp.api.APIResponse;
import com.userInteractionsAndAndroidResourse.dogsapp.api.RetrofitClient;
import com.userInteractionsAndAndroidResourse.dogsapp.model.BreedImageListResponse;
import com.userInteractionsAndAndroidResourse.dogsapp.model.BreedListResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {
    private static final String TAG = "Presenter";

    View view;

    public Presenter(View view) {
        this.view = view;
    }

    public void getDataForSpinner() {
        APIResponse service = RetrofitClient.getRetrofitInstance().create(APIResponse.class);
        Call<BreedListResponse> call = service.getBreedList();
        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {
                if (response.body() != null) {
                    ArrayList<String> dogs = response.body().getBreedList();
                    view.setSpinner(dogs);
                }
            }

            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {
                view.failedRequest();
            }
        });
    }

    public void whoLetTheDogsOut(String choosedbreed) {
        Log.d(TAG, "whoLetTheDogsOut: ENtra");
        APIResponse servicetwo = RetrofitClient.getRetrofitInstance().create(APIResponse.class);
        Call<BreedImageListResponse> callImages = servicetwo.getBreedImageList(choosedbreed);
        callImages.enqueue(new Callback<BreedImageListResponse>() {

            @Override
            public void onResponse(Call<BreedImageListResponse> call, Response<BreedImageListResponse> response) {
                ArrayList<String> imagesURL = response.body().getImageUrl();
                view.instanceFragment(imagesURL);
            }

            @Override
            public void onFailure(Call<BreedImageListResponse> call, Throwable t) {
                view.failedRequest();
            }
        });

    }

    public interface View {
        void instanceFragment(ArrayList<String> dogs);
        void failedRequest();
        void setSpinner(ArrayList<String> dogs);
    }
}

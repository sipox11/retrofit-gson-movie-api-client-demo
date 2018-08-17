package com.sipox11.retrofitgsonmoviesapiclientdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sipox11.retrofitgsonmoviesapiclientdemo.BuildConfig;
import com.sipox11.retrofitgsonmoviesapiclientdemo.R;
import com.sipox11.retrofitgsonmoviesapiclientdemo.data.models.Movie;
import com.sipox11.retrofitgsonmoviesapiclientdemo.data.network.ApiClient;
import com.sipox11.retrofitgsonmoviesapiclientdemo.data.network.MoviesApi;
import com.sipox11.retrofitgsonmoviesapiclientdemo.data.translation.response_models.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // Read README.md to learn where the API KEY comes from
    private final static String API_KEY = BuildConfig.ApiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Make sure the API KEY is set
        if (API_KEY.isEmpty()) {
            Log.e(TAG, "onCreate: API KEY not found. " +
                    "Please obtain your API KEY first from themoviedb.org");
            return;
        }

        // Generate Movies API instance with Retrofit Api Client
        MoviesApi moviesApi =
                ApiClient.getClient().create(MoviesApi.class);

        // Define network request
        Call<MoviesResponse> call = moviesApi.getTopRatedMovies(API_KEY);

        // Enqueue network request and define the handlers on error and on success
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Request failed, log the errors
                Log.e(TAG, "onFailure: Network request failed -> " + t.toString());
            }
        });
    }
}

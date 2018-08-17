package com.sipox11.retrofitgsonmoviesapiclientdemo.data.network;

import com.sipox11.retrofitgsonmoviesapiclientdemo.data.translation.response_models.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {

    /**
     * Define endpoint to retrieve the top rated movies.
     *
     * @param apiKey    The API key used to consume the endpoint.
     * @return          A parameterized {@link Call< MoviesResponse >} instance.
     */
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    /*
        Annotation definition:

        @Path – variable substitution for the API endpoint. In this case, the movie id will
                be swapped for {id} in the URL endpoint.

        @Query – specifies the query key name with the value of the annotated parameter. In this
                    case it will add at the end of the url "api_key=<the api key value>".

        @Body – payload for POST calls.

        @Header – specifies the header with the value of the annotated parameter. For example,
                    @Header("Content-type") String contentType will add the header
                    'Content-Type: application/json' when contentType is set to 'application/json'
     */

}

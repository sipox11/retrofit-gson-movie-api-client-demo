# TMDB Movies Api Client Demo Built with Retrofit & Gson
Basic demo that consumes TMDB Movies Api by using Retrofit and Gson

API Documentation can be found here (and API Key generation): https://www.themoviedb.org/documentation/api

API Key is stored in local environment (~/.gradle/gradle_properties) under the key: RetrofitGsonMoviesApiClientDemo_TMDBApiKey_Sipox11

It is retrieved in the app build.gradle file: 

buildTypes {
        debug {
            buildConfigField 'String', "ApiKey", RetrofitGsonMoviesApiClientDemo_TMDBApiKey_Sipox11
            resValue 'string', "api_key", RetrofitGsonMoviesApiClientDemo_TMDBApiKey_Sipox11
        }
        ...
}

This way it can be used as simply as: 

- In Java code: 

BuildConfig.ApiKey

- In XML Code: 

@string/api_key

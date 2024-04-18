package data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static ApiService getApiService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restaurant-api.dicoding.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient) // Menggunakan okHttpClient yang telah dibuat
                .build();

        return retrofit.create(ApiService.class);
    }
}

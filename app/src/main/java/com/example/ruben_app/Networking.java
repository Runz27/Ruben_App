package com.example.ruben_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networking extends AppCompatActivity {
private TextView txtViewR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
        txtViewR=findViewById(R.id.txtViewR);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Post>>(){
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                if (!response.isSuccessful()){
                    txtViewR.setText("Code: "+ response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts){
                    String content = "";
                    content += "id:" + post.getId() + "\n";
                    content += "User Id:" + post.getUserId() + "\n";
                    content += "Title:" + post.getTitle() + "\n";
                    content += "Text:" + post.getText() + "\n";

                    txtViewR.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txtViewR.setText(t.getMessage());
            }
        });
    }
}
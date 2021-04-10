package com.example.medicareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityValues extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainvalues);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thingspeak.com/channels/1352492/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceholder = retrofit.create(JSONPlaceHolder.class);
        Call<Feeds> call = jsonPlaceholder.getFeeds();
        call.enqueue(new Callback<Feeds>() {
            @Override
            public void onResponse(Call<Feeds> call, Response<Feeds> response) {
                if (!response.isSuccessful()) {
                    Log.e("Info", String.valueOf(response.code()));
                    return;
                }

                List<Feeds> feeds = response.body().getFeeds();
                Log.e("Info", feeds.get(0).getCreated_at());

                FieldAdapter fieldAdapter = new FieldAdapter(feeds);
                recyclerView.setAdapter(fieldAdapter);
            }

            @Override
            public void onFailure(Call<Feeds> call, Throwable t) {
                Toast.makeText(MainActivityValues.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser mAuth = FirebaseAuth.getInstance().getCurrentUser();
        if (mAuth == null) {
            Intent intent = new Intent(MainActivityValues.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}
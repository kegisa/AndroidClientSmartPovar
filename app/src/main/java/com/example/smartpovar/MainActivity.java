package com.example.smartpovar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.smartpovar.adapter.CategoryAdapter;
import com.example.smartpovar.entity.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private CategoryAdapter adapter;

    private void loadData(){
        Api api = ((App) getApplication()).getApi();

        api.categories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> categories = response.body();
                adapter.setCategoryList(categories);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("MainActivity","onFailure",t);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CategoryAdapter();
        loadData();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}

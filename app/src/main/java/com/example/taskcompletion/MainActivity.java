package com.example.taskcompletion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ResponseAdapter responseAdapter;

    public ArrayList<ResultsItem> resultsItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        responseAdapter = new ResponseAdapter(resultsItems, MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(responseAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        getallData();


    }

    private void getallData() {
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://quotable.io/quotes?page=1";

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Data", response);

                            GsonBuilder gsonBuilder = new GsonBuilder();
                            Gson gson = new Gson();

                            try {
                                JSONObject obj = new JSONObject(response);
                                JSONArray array = obj.getJSONArray("results");
                                for (int i = 0; i < array.length(); i++){
                                    JSONObject arrayObj = array.getJSONObject(i);
                                    ResultsItem results = new ResultsItem(arrayObj.getString("author"), arrayObj.getString("content"), arrayObj.getString("dateAdded"));
                                    resultsItems.add(results);
                                }
                                recyclerView.setAdapter(responseAdapter);
                                responseAdapter = new ResponseAdapter(resultsItems, MainActivity.this);
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);

    }
}
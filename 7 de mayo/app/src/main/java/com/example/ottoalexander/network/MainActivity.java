package com.example.ottoalexander.network;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
        String urlWeather = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10\n" +
                "d714a6e88b30761fae22";
        JSONObject resultWeather;
        JSONObject objRequest;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            RequestQueue queue  = Volley.newRequestQueue(this);

            JsonObjectRequest objRequest =
                    new JsonObjectRequest(DownloadManager.Request.Method.GET, urlWeather, null, new Response.Listener<JSONObject>() {

                        public void onResponse(JSONObject response) {
                            try {
                                resultWeather = (JSONObject) response.getJSONArray("weather").get(0);
                                System.out.println(resultWeather.getString("description"));
                                System.out.println(response.getJSONObject("main").getString("temp"));
                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {

                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.getMessage());
                        }
                    });

            queue.add(objRequest);
        }
    }



package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import com.example.displayjokelib.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void tellJoke(View view) {
//        Intent intent = new Intent(this, JokeActivity.class);
//        RetrieveJoke joker = new RetrieveJoke();
//        String joke = joker.getJoke();
//        intent.putExtra(JokeActivity.JOKE_KEY, joke);
//        startActivity(intent);
////      Toast.makeText(this, joker.getJoke(), Toast.LENGTH_SHORT).show();
//    }

    public void tellJoke(View view) {

        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String output) {
                Intent myIntent = new Intent(getApplicationContext(), JokeActivity.class);
                myIntent.putExtra(JokeActivity.JOKE_KEY, output);
                startActivity(myIntent);
            }
        }.execute();
    }
}

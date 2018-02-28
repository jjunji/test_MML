package com.jjunji.android.test_mml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setButtonListener();
    }

    private void init(){
        button = (Button) findViewById(R.id.button);
    }

    private void setButtonListener(){
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button :
                Intent intent = new Intent(this, SearchMovieActivity.class);
                startActivity(intent);
                break;
        }
    }
}

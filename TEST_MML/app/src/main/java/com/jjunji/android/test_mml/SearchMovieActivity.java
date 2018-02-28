package com.jjunji.android.test_mml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjunji.android.test_mml.model.MovieList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchMovieActivity extends AppCompatActivity implements View.OnClickListener{
    private final String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/";
    private final String KEY = "0d718085ff0598fc9f44b243668c3ef9";
    EditText etName;
    Button btnSearch;
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);

        init();
        setButtonClickListener();
    }

    private void init() {
        etName = (EditText) findViewById(R.id.etName);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        list = (RecyclerView) findViewById(R.id.list);
    }

    private void setButtonClickListener(){
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSearch :
                search();
                break;
        }
    }

    private void search(){
        String name = etName.getText().toString();
        setNetwork(name);
    }

    private void setNetwork(String name){
        // 레트로핏 객체 정의
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 실제 서비스 인터페이스 생성.
        iService service = retrofit.create(iService.class);
        // 서비스 호출
        Call<MovieList> call = service.getList(KEY, name);
        Log.i("test", "name ============ " + name);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                // 전송결과가 정상이면
                Log.e("Write","in ====== onResponse");
                if(response.isSuccessful()){
                    MovieList ml = response.body();
                    Log.i("SearchMovieActivity","영화 리스트 =========== " + response.body());
                }else{
                    int statusCode = response.code();
                    Log.i("MyTag", "응답코드 ============= "+statusCode);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.e("MyTag","error==========="+t.getMessage());
            }
        });
    }

}

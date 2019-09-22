package com.example.okhttp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button getBtn;
    private TextView result;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.getBtn);
         final ImageView imageView=findViewById (R.id.image);
        final RelativeLayout rel=findViewById (R.id.rel);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebservice();
                Picasso.get().load("https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg").into(imageView);


            }
        });
        client = new OkHttpClient();

    }



    private void getWebservice() {
        final Request request = new Request.Builder().url("http://www.zoftino.com/api/storeOffers").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("Failure !");
                    }
                });
                Log.i ("error",e.toString ());
                // عشان ميحصلش error لازم تضيف         android:usesCleartextTraffic="true"  لل mainfist بين application
            }
            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        earthquick earthquick=null;
                        try {
                            earthquick=utiles.parsejson (response.body().string());
                            result.setText(response.body ().string ());
                            Log.i ("___________",response.body ().string ());

//                            Log.i ("res",response.body ().string () );
                        } catch (IOException ioe) {
                            result.setText("Error during get body");
                        }




                    }
                });
            }
        });
    }
}

package com.example.okhttp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class anotherOkHttpMethod extends AppCompatActivity {
    TextView asdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_another_ok_http_method);
         asdf=findViewById (R.id.asdf);
      /*   if(getHttpResponse ()!=null){
         Object as=getHttpResponse ();
         asdf.setText (as.toString ());}
         else {asdf.setText ("another err");}*/
      getHttpResponse ();
    }

    public Object getHttpResponse() {
        OkHttpClient httpClient = new OkHttpClient();

        String url = "http://www.zoftino.com/api/storeOffers";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;

        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace ( );
            asdf.setText ("error");

        }


        return null;
    }
}

package com.example.okhttp2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Response;

public class utiles {
    private final static String mag_JSON_KEY = "mag";

    public static  earthquick parsejson(String json){
        earthquick earthquick=null;
        if(json!=null)
        {
            try {
                JSONObject Root= new JSONObject (json);

                String mag=Root.optString ("type");
                earthquick=new earthquick (mag);
            } catch (JSONException e) {
                e.printStackTrace ( );
            }



        }



        return earthquick;
    }
}

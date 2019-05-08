package com.example.asus.studcardportabil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetaliiStudent extends AppCompatActivity {
    final String server_url = "http://192.168.13.83:8080/LicentaServer/detaliistudent";
    ImageView pozastudent;
    LinearLayout linearLayout;
    LinearLayout detalii;
    private ArrayList<Student> studentlist = new ArrayList<>();
    private List<String> studentString = new ArrayList<>();

    public Integer idstudent=1;
    private ListView myListView;

    ServiceUser serviceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaliistudent);

        getAllDetalii();
    }
    public void getAllDetalii() {


        RequestQueue queue = Volley.newRequestQueue(DetaliiStudent.this);

        final JsonObjectRequest request_json = new JsonObjectRequest(
                Request.Method.GET,
                server_url+"/1",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response != null) {
                                studentlist.clear();
                                Integer i = 0;
                                while (i < response.length()) {
                                    System.out.println("______________________"+response);
                                    JSONObject object = response.getJSONObject(String.valueOf(i));
                                    System.out.println("___________1_____________"+object);

                                    JSONObject object2=response.getJSONObject("student");
                                    System.out.println("___________2___________"+object2);
                                    Student b = new Student();
                                    b.setStudentId(Integer.valueOf(object.getString("id")));
                                    //System.out.println(Integer.valueOf(object.getString("id")));
                                    i++;
                                }
                            } else {
                                System.out.println("========= Eror at request for listview items ============");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });
        queue.add(request_json);
    }
}

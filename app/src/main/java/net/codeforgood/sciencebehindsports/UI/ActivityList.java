package net.codeforgood.sciencebehindsports.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import net.codeforgood.sciencebehindsports.Adapter.ActivityAdapter;
import net.codeforgood.sciencebehindsports.App.AppConfig;
import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    int moduleId;
    ArrayList<Activity> mActivityList;
    ActivityAdapter mAdapter;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Gettin");

        mActivityList = new ArrayList<>();
        mAdapter = new ActivityAdapter(this, mActivityList);
        Bundle data = getIntent().getExtras();
        moduleId = data.getInt("moduleId");

        populateList();

        ListView listView = (ListView) this.findViewById(R.id.activity_list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityList.this, ActivityDetailActivity.class);
                intent.putExtra("ActivityDetail",  mActivityList.get(position));
                startActivity(intent);
            }
        });



    }

    private void populateList(){
        String tag_string_req = "req_module";
        showDialog();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = AppConfig.URL_ACTIVITY+"?module_id="+moduleId;


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray moduleArray = response.getJSONArray("activity");

                    for(int i = 0; i<moduleArray.length(); i++){
                        JSONObject activityObject = moduleArray.getJSONObject(i);

                        /*
                        (int id, int activity_number, String description,
                    int module_id, String activity_objective, String result,
                    int activity_time, String materials, String instruction)

                         */
                        Activity activity = new Activity(
                                activityObject.getInt("activity_id"),
                                activityObject.getInt("activity_number"),
                                activityObject.getString("description"),
                                moduleId,
                                activityObject.getString("activity_objective"),
                                activityObject.getString("result"),
                                activityObject.getInt("activity_time"),
                                activityObject.getString("materials"),
                                "No Instruction Yet"
                        );




                        mActivityList.add(activity);
                        mAdapter.notifyDataSetChanged();
                    }









                    hideDialog();
                    requestQueue.stop();



                } catch (JSONException e) {
                    e.printStackTrace();
                }

                hideDialog();
                requestQueue.stop();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityList.this, "some thing fishy", Toast.LENGTH_LONG).show();
                        hideDialog();
                        requestQueue.stop();
                    }
                }
        );
        requestQueue.add(jsonObjReq);
    }

    public void showDialog() {
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    public void hideDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

}

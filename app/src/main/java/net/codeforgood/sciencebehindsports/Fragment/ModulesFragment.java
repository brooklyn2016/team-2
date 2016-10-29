package net.codeforgood.sciencebehindsports.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import net.codeforgood.sciencebehindsports.Adapter.ModuleAdapter;
import net.codeforgood.sciencebehindsports.App.AppConfig;
import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;
import net.codeforgood.sciencebehindsports.UI.ModuleDetailActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModulesFragment extends Fragment {


    View mRoot;
    private ProgressDialog pDialog;

    ArrayList<Module> mModuleList;
    ModuleAdapter mAdapter;
    public ModulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        pDialog = new ProgressDialog(getContext());
        pDialog.setCancelable(false);
        pDialog.setMessage("Logging In");

        mModuleList = new ArrayList<>();


        mAdapter = new ModuleAdapter(getContext(), mModuleList);

        populateList();
        mModuleList.add(new Module(1, "module01", 100, 8, "ball", "no objective", "no content", "no process", 1));
        mModuleList.add(new Module(2, "module02", 100, 8, "ball", "no objective", "no content", "no process", 2));
        mModuleList.add(new Module(3, "module03", 100, 8, "ball", "no objective", "no content", "no process", 3));
        mModuleList.add(new Module(4, "module04", 100, 8, "ball", "no objective", "no content", "no process", 4));
        mModuleList.add(new Module(5, "module05", 100, 8, "ball", "no objective", "no content", "no process", 5));
        mModuleList.add(new Module(6, "module06", 100, 8, "ball", "no objective", "no content", "no process", 6));



        mRoot = inflater.inflate(R.layout.fragment_modules, container, false);

        ListView listView = (ListView) mRoot.findViewById(R.id.module_list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ModuleDetailActivity.class);
                intent.putExtra("ModuleDetail", mModuleList.get(position));
                startActivity(intent);
            }
        });

        return mRoot;
    }


    private void populateList(){
        String tag_string_req = "req_module";
        showDialog();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                AppConfig.URL_MODULE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
/*
(int id, String module_name, int module_time,
                  int num_of_activities, String materials,
                  String objective, String content,
                  String process, int module_number)

 */
                try {
                    JSONArray moduleArray = response.getJSONArray("module");

                    for(int i = 0; i<moduleArray.length(); i++){
                        JSONObject moduleObj = moduleArray.getJSONObject(i);
                        Module module = new Module(
                                moduleObj.getInt("module_id"),
                                moduleObj.getString("module_name"),
                                moduleObj.getInt("module_time"),
                                moduleObj.getInt("num_of_activities"),
                                moduleObj.getString("materials"),
                                moduleObj.getString("objective"),
                                moduleObj.getString("content"),
                                null,
                                moduleObj.getInt("module_number")
                        );
                        mModuleList.add(module);
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
                        Toast.makeText(getContext(), "some thing fishy", Toast.LENGTH_LONG).show();
                        hideDialog();
                        requestQueue.stop();
                    }
                }
        ){

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
//                params.put("email", username);
//                params.put("password", pass);

                return params;
            }

        };
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

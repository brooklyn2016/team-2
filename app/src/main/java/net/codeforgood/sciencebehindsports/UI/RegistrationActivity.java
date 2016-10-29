package net.codeforgood.sciencebehindsports.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import net.codeforgood.sciencebehindsports.App.AppConfig;
import net.codeforgood.sciencebehindsports.Helper.SessionManager;
import net.codeforgood.sciencebehindsports.Helper.Utility;
import net.codeforgood.sciencebehindsports.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    private final String LOG_TAG = getClass().getSimpleName();
    private ProgressDialog pDialog;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText userName = (EditText) findViewById(R.id.txtUserNameRegister);
        final EditText password = (EditText) findViewById(R.id.txtPasswordRegister);
        final EditText email = (EditText) findViewById(R.id.txtEmailRegister);
        final Button register = (Button) findViewById(R.id.btnRegister);

        final TextView signup = (TextView) findViewById(R.id.txtSigninNow);

        Utility.customView(register, ContextCompat.getColor(this, R.color.color_button));


        session = new SessionManager(getApplicationContext());

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Registering User");
        final String[] dataType = {""};
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nameuser = userName.getText().toString().toLowerCase().trim();
                final String emailAddr = email.getText().toString().toLowerCase().trim();
                final String pass = password.getText().toString().trim();



                if (nameuser.isEmpty() || emailAddr.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                } else {
                    String tag_string_req = "req_login";
                    final RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                            AppConfig.URL_REGISTER, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                if(response.getBoolean("error") == true){
                                    String message = response.getString("error-reason");
                                    Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();
                                }else{
//                                    session.setLogin(true);
//                                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
                                    Toast.makeText(RegistrationActivity.this, "Registration Success Full", Toast.LENGTH_SHORT).show();

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
                                    Toast.makeText(getApplicationContext(), "some thing fishy", Toast.LENGTH_LONG).show();
                                    hideDialog();
                                    requestQueue.stop();
                                }
                            }
                    ){

                        @Override
                        protected Map<String, String> getParams() {
                            // Posting parameters to login url
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("email", nameuser);
                            params.put("password", pass);
                            params.put("email", emailAddr);

                            return params;
                        }

                    };
                    requestQueue.add(jsonObjReq);
                }

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


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

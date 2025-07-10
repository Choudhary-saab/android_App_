package com.STc.socialtechnocrats;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;
    RelativeLayout loadingOverlay;

    String LOGIN_URL = "http://192.168.1.33/stc_backend/login.php";        // your local XAMPP URL
    String ROLE_CHECK_URL = "http://192.168.1.33/stc_backend/checkRole.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);
        loadingOverlay = findViewById(R.id.loadingOverlay);

        buttonLogin.setOnClickListener(v -> {
            if (!isConnected()) {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                return;
            }

            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                loginUser(email, password);
            }
        });
    }

    private void showLoading() {
        loadingOverlay.setVisibility(View.VISIBLE);
        buttonLogin.setEnabled(false);
    }

    private void hideLoading() {
        loadingOverlay.setVisibility(View.GONE);
        buttonLogin.setEnabled(true);
    }

    private void loginUser(String email, String password) {
        showLoading();

        StringRequest request = new StringRequest(Request.Method.POST, LOGIN_URL,
                response -> {
                    try {
                        JSONObject json = new JSONObject(response);
                        String status = json.getString("status");

                        if (status.equals("success")) {
                            checkRole(email);
                        } else {
                            hideLoading();
                            Toast.makeText(this, json.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        hideLoading();
                        e.printStackTrace();
                        Toast.makeText(this, "Invalid login response", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    hideLoading();
                    Toast.makeText(this, "Login Failed: " + error.toString(), Toast.LENGTH_SHORT).show();
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("email", email);
                map.put("password", password);
                return map;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }

    private void checkRole(String email) {
        StringRequest request = new StringRequest(Request.Method.POST, ROLE_CHECK_URL,
                response -> {
                    hideLoading();
                    try {
                        JSONObject obj = new JSONObject(response);
                        String role = obj.getString("status");

                        if (role.equals("admin") || role.equals("user")) {
                            startActivity(new Intent(this, stc_home.class));
                        } else {
                            Toast.makeText(this, "Unknown role", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(this, "Invalid server response", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    hideLoading();
                    Toast.makeText(this, "Server Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("email", email);
                return map;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                android.net.Network network = connectivityManager.getActiveNetwork();
                if (network == null) return false;

                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                return capabilities != null &&
                        (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));
            } else {
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnected();
            }
        }
        return false;
    }
}

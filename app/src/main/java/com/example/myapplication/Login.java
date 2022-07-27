package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.example.myapplication.model.Employee;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private static final int PERMISSION_REQUEST_CAMERA = 0;
    private PreviewView previewView;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    Button btn_scan_qr, btn_login;
    Employee obj_employee = new Employee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        obj_employee.setEmployee_No("1207");
        obj_employee.setEmployee_FullName("WICHIT TEANTHONG");
        obj_employee.setEmployee_Location("WH10");

        previewView = findViewById(R.id.activity_main_previewView);
        btn_scan_qr = findViewById(R.id.btn_scan_qr);
        btn_login = findViewById(R.id.btn_login);
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        btn_scan_qr.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent intents = new Intent(Login.this, ScanQr.class);

        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(intents, 0);
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void check_permission_camera() {
        Intent intents = new Intent(Login.this, ScanQr.class);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startActivityForResult(intents, 0);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(Login.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            }
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_scan_qr:
                check_permission_camera();
                break;
            case R.id.btn_login:
//                Intent intents = new Intent(Login.this, MainActivity.class);
//                startActivityForResult(intents, 0);

                Intent intent = new Intent(this, MainActivity.class);
//                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
//                String message = editText.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra("Full_Name", obj_employee.getEmployee_FullName());
                intent.putExtra("Location", obj_employee.getEmployee_Location());
                intent.putExtra("Employee_No", obj_employee.getEmployee_No());
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String barcode = intent.getStringExtra("SCAN_RESULT");
                Toast.makeText(this, barcode, Toast.LENGTH_LONG).show();
            }
        }
    }

}
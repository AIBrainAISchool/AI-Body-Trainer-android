package com.google.mlkit.vision.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import com.google.mlkit.vision.demo.java.LivePreviewActivity;

import java.util.ArrayList;
import java.util.List;
//
// StartActivity is the entry point of the application instead of LivePreviewActivity
//
public final class StartActivity extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String TAG = "StartActivity";
    private static final int PERMISSION_REQUESTS = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_start);

        //Check if all permissions are granted
        //if not, ask for permissions again
        if (!allPermissionsGranted()) {
            getRuntimePermissions();
        }
    }

    //When either squat button or push up button is clicked, this function is called
    public void BtnClicked(View v)
    {
        Intent intent = new Intent(this, LivePreviewActivity.class); //setup Intent that connects current
                                                                                    //to the desired activity

        switch(v.getId()) //From View, get the id of widget that is clicked
        {
            case R.id.squatBtn: //If the id matches the id of squatBtn
                intent.putExtra("type", "Squat"); //Put some data into Intent
                break;

            case R.id.pushupBtn:
                intent.putExtra("type", "Push up");
                break;
        }

        startActivity(intent); //start Intent that connects StartActivity to LivePreviewActivity, with some string data ("type")
    }

    //System Initializations FROM HERE
    private String[] getRequiredPermissions() {
        try {
            PackageInfo info =
                    this.getPackageManager()
                            .getPackageInfo(this.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] ps = info.requestedPermissions;
            if (ps != null && ps.length > 0) {
                return ps;
            } else {
                return new String[0];
            }
        } catch (Exception e) {
            return new String[0];
        }
    }

    private boolean allPermissionsGranted() {
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                return false;
            }
        }
        return true;
    }

    private void getRuntimePermissions() {
        List<String> allNeededPermissions = new ArrayList<>();
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission)) {
                allNeededPermissions.add(permission);
            }
        }

        if (!allNeededPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(
                    this, allNeededPermissions.toArray(new String[0]), PERMISSION_REQUESTS);
        }
    }

    private static boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission granted: " + permission);
            return true;
        }
        Log.i(TAG, "Permission NOT granted: " + permission);
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    //System Initializations UPTO HERE

}

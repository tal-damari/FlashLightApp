package com.example.myflashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraID = cameraManager.getCameraIdList()[0];  //back camera
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private CameraManager cameraManager;
    private String cameraID;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void FlashlightVal(View view) {
        Switch s = (Switch) view; //sets s to be the switch mode
        if (s.isActivated()) //if the switch is activated the deactivate the switch
        {
            s.setActivated(false); //setting flashlight switch to be off
            try {
                cameraManager.setTorchMode(cameraID, false); //turning off the flashlight. need to be initialized with try and catch
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            s.setActivated(true); //setting flashlight switch to be true
            try {
                cameraManager.setTorchMode(cameraID,true); //turning on the flashlight
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
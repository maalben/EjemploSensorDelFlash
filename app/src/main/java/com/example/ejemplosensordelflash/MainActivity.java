package com.example.ejemplosensordelflash;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private Button encender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encender = findViewById(R.id.btnencender);

        encender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera = Camera.open();
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        camera.stopPreview();
        camera.release();
    }
}

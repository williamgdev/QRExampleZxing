package com.github.williamgdev.example.qrexamplezxing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "QRScan ->";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onScan();
    }

    private void onScan() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null){
            if (intentResult.getContents() != null){
                Log.d(TAG, "onActivityResult: Result -> " + intentResult.getContents().toString());
            } else {
                Log.d(TAG, "onActivityResult: Result NULL");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

package com.patronas.material_design_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSnackbar();
    }

    private void initSnackbar() {
        Button btn_snackbar = findViewById(R.id.btn_snackbar);
        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SnackbarActivity.class);
                startActivity(i);
            }
        });
    }
}

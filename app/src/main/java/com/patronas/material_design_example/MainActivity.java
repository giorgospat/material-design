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

        initBottomSheet();

    }

    private void initBottomSheet() {
        Button btn_bottom_sheet = findViewById(R.id.btn_bottom_sheet);
        btn_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BottomSheetActivity.class);
                startActivity(i);
            }
        });

    }
}

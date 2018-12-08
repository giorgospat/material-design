package com.patronas.material_design_example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BottomSheetActivity extends AppCompatActivity {

    private BottomSheetBehavior sheetBehavior;
    private TextView text_sheet_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        initViews();

    }

    private void initViews() {
        View layoutBottomSheet = findViewById(R.id.nested_scroll_bottom_sheet);
        text_sheet_title = findViewById(R.id.text_sheet_title);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        setUpSheetListener();
        setUpManuallySheetOpening();
    }


    private void setUpSheetListener() {
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //TODO custom behavior
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        text_sheet_title.setText(getString(R.string.bottom_sheet_close));
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        text_sheet_title.setText(getString(R.string.bottom_sheet_open));
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //TODO custom behavior
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //TODO custom behavior
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //TODO custom behavior
            }
        });
    }

    private void setUpManuallySheetOpening() {
        text_sheet_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();
            }
        });
    }

    /**
     * manually opening / closing bottom sheet on text click
     */
    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            text_sheet_title.setText(getString(R.string.bottom_sheet_close));
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            text_sheet_title.setText(getString(R.string.bottom_sheet_open));
        }
    }

}


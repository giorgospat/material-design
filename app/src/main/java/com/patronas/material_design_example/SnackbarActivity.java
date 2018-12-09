package com.patronas.material_design_example;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout costraint_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_activity);

        initViews();
    }

    private void initViews() {
        Button btn_simple_snack = findViewById(R.id.btn_simple_snack);
        btn_simple_snack.setOnClickListener(this);
        Button btn_custom_snack = findViewById(R.id.btn_custom_snack);
        btn_custom_snack.setOnClickListener(this);
        Button btn_simple_snack_customize = findViewById(R.id.btn_simple_snack_customize);
        btn_simple_snack_customize.setOnClickListener(this);
        costraint_parent = findViewById(R.id.costraint_parent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_snack:
                displaySimpleSnack();
                break;
            case R.id.btn_custom_snack:
                displayCustomSnack();
                break;
            case R.id.btn_simple_snack_customize:
                displaySimpleSnackCustomized();
                break;
        }
    }


    private void displaySimpleSnack() {
        Snackbar snackbar = Snackbar
                .make(costraint_parent, R.string.snackbar_simple_message, Snackbar.LENGTH_LONG)
                /*
                 optional actions on snackbar
                 */
                .setAction(getString(R.string.close), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SnackbarActivity.this, getString(R.string.simple_snackbar_click_toast), Toast.LENGTH_SHORT).show();
                    }
                });
        snackbar.show();
    }


    private void displaySimpleSnackCustomized() {
        Snackbar snackbar = Snackbar
                .make(costraint_parent, R.string.snackbar_simple_message, Snackbar.LENGTH_SHORT);

        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        snackbar.show();
    }


    private void displayCustomSnack() {
        /*
         *  Inflating custom layouts to snackbar are discouraged by Android though.
         *  Snackbar's intended use is to show a message and an action.
         *  They're essentially like interactive toasts.
         */

        final Snackbar customSnackbar = Snackbar.make(costraint_parent, "", Snackbar.LENGTH_INDEFINITE);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) customSnackbar.getView();

        LayoutInflater mInflater = (LayoutInflater) SnackbarActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View snackView = mInflater.inflate(R.layout.custom_layout_snackbar, costraint_parent, false);
        LinearLayout linear_custom_snack_container = snackView.findViewById(R.id.linear_custom_snack_container);
        linear_custom_snack_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SnackbarActivity.this, getString(R.string.custom_snackbar_click_toast), Toast.LENGTH_SHORT).show();
                customSnackbar.dismiss();
            }
        });
        layout.setPadding(0, 0, 0, 0);
        layout.addView(snackView, 0);
        customSnackbar.show();
    }

}

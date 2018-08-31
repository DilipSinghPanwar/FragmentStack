package com.androiddevs.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.androiddevs.R;

/**
 * Created by Syacraft on 19-Sep-16.
 */
public class ForgetPassActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private TextInputLayout tilEmail;
    private EditText etEmail;
    private TextView tvToolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(ForgetPassActivity.this, R.color.colorPrimaryDark));
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        tvToolBarTitle = (TextView)findViewById(R.id.toolbar_title);
        tvToolBarTitle.setText("Forget Password");
        setSupportActionBar(toolbar);

        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etEmail.addTextChangedListener(new MyTextWatcher(etEmail));
        findViewById(R.id.btnForgetPassword).setOnClickListener(this);
    }

    private boolean validateEmail() {
        String email = etEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            tilEmail.setError(getString(R.string.err_msg_email));
            requestFocus(etEmail);
            return false;
        } else {
            tilEmail.setErrorEnabled(false);
        }
        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvSignUp:
                startActivity(new Intent(ForgetPassActivity.this, SignUpActivity.class));
                break;
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.etEmail:
                    validateEmail();
                    break;
            }
        }
    }
}
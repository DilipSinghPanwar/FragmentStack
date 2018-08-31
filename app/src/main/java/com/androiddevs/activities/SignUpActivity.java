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
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextInputLayout tilName, tilEmail, tilPhone, tilCompany, tilPassword, tilConfirmPassword;
    private EditText etName,etEmail,etPhone,etCompany,etPassword,etConPass;
    private TextView tvToolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(SignUpActivity.this, R.color.colorPrimaryDark));
        }

        findViewById();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        tvToolBarTitle = (TextView)findViewById(R.id.toolbar_title);
        tvToolBarTitle.setText("Sign Up");
        setSupportActionBar(toolbar);
    }

    public void findViewById(){
        tilName = (TextInputLayout) findViewById(R.id.tilName);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilPhone = (TextInputLayout) findViewById(R.id.tilPhoneno);
        tilCompany = (TextInputLayout) findViewById(R.id.tilCompany);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilConfirmPassword = (TextInputLayout) findViewById(R.id.tilConfirmPassword);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhoneno);
        etCompany = (EditText) findViewById(R.id.etCompany);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConPass = (EditText) findViewById(R.id.etConfirmpassword);
        findViewById(R.id.btnSignup).setOnClickListener(this);

        etName.addTextChangedListener(new MyTextWatcher(etName));
        etEmail.addTextChangedListener(new MyTextWatcher(etEmail));
        etPhone.addTextChangedListener(new MyTextWatcher(etPhone));
        etCompany.addTextChangedListener(new MyTextWatcher(etCompany));
        etPassword.addTextChangedListener(new MyTextWatcher(etPassword));
        etConPass.addTextChangedListener(new MyTextWatcher(etConPass));
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignup:
                startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                SignUpActivity.this.finish();
                break;
        }
    }

    private boolean validateName() {
        if (etName.getText().toString().trim().isEmpty()) {
            tilName.setError(getString(R.string.signup_err_msg_name));
            requestFocus(etName);
            return false;
        } else {
            tilName.setErrorEnabled(false);
        }

        return true;
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



    private boolean validatePhone() {
        if (etPhone.getText().toString().trim().isEmpty()) {
            tilPhone.setError(getString(R.string.signup_err_msg_phoneno));
            requestFocus(etPhone);
            return false;
        } else {
            tilPhone.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateCompany() {
        if (etCompany.getText().toString().trim().isEmpty()) {
            tilCompany.setError(getString(R.string.signup_err_msg_company));
            requestFocus(etCompany);
            return false;
        } else {
            tilCompany.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePassword() {
        if (etPassword.getText().toString().trim().isEmpty()) {
            tilPassword.setError(getString(R.string.err_msg_password));
            requestFocus(etPassword);
            return false;
        } else {
            tilPassword.setErrorEnabled(false);
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
                case R.id.etPassword:
                    validatePassword();
                    break;
            }
        }
    }
}
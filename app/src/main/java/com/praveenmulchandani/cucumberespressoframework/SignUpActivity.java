/*
 * Copyright (C) 2015 emmasuzuki <emma11suzuki@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.praveenmulchandani.cucumberespressoframework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Demo SignUp activity class
 */
public class SignUpActivity extends Activity {

    private static final String DEMO_EMAIL = "praveen@test.com";
    private static final String DEMO_PASSWORD = "praveen";

    private EditText mEmailEditText, mPasswordEditText;
    private View mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        mEmailEditText = findViewById(R.id.email);
        mPasswordEditText = findViewById(R.id.password);

        View submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validateFields();

                if (mEmailEditText.getError() == null && mPasswordEditText.getError() == null) {
                    validateAccount();
                }
            }
        });
    }

    private void validateFields() {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailEditText.getText().toString()).matches()) {
            mEmailEditText.setError(getString(R.string.msg_email_error));
        } else {
            mEmailEditText.setError(null);
        }

        if (mPasswordEditText.getText().toString().isEmpty()) {
            mPasswordEditText.setError(getString(R.string.msg_password_error));
        } else {
            mPasswordEditText.setError(null);
        }
    }

    private void validateAccount() {
        if (mErrorView == null) {
            mErrorView = findViewById(R.id.error);
        }

        if (!mEmailEditText.getText().toString().equals(DEMO_EMAIL) || !mPasswordEditText.getText().toString().equals(DEMO_PASSWORD)) {
            mErrorView.setVisibility(View.VISIBLE);
        } else {
            mErrorView.setVisibility(View.GONE);
        }
    }
}

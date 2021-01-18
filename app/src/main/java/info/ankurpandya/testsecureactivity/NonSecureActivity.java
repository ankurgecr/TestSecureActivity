package info.ankurpandya.testsecureactivity;

import android.os.Bundle;

public class NonSecureActivity extends BaseFormActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.action_non_secure_activity);
        }
    }
}
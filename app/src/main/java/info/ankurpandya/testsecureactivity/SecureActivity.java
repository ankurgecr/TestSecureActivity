package info.ankurpandya.testsecureactivity;

import android.os.Bundle;
import android.view.WindowManager;

public class SecureActivity extends BaseFormActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.action_secure_activity);
        }
    }
}
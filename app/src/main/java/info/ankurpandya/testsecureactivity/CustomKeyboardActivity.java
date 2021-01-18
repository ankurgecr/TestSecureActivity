package info.ankurpandya.testsecureactivity;

import android.os.Bundle;

public class CustomKeyboardActivity extends BaseKeyboardActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.action_keyboard_activity);
        }
    }
}
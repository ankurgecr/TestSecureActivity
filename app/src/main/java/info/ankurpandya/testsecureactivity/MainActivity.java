package info.ankurpandya.testsecureactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_non_secure).setOnClickListener(v1 -> launchNonSecure());
        findViewById(R.id.btn_secure).setOnClickListener(v1 -> launchSecure());
    }

    private void launchNonSecure() {
        startActivity(
                new Intent(this, NonSecureActivity.class)
        );
    }

    private void launchSecure() {
        startActivity(
                new Intent(this, SecureActivity.class)
        );
    }
}
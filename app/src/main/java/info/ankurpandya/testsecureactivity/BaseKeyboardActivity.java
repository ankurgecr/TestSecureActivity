package info.ankurpandya.testsecureactivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import info.ankurpandya.testsecureactivity.customerviews.NumericKeyPadView;

public abstract class BaseKeyboardActivity extends AppCompatActivity
        implements
        NumericKeyPadView.OnTextChangeListener {

    NumericKeyPadView numericKeyPadView;
    EditText edtPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_custom_keyboard);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.action_secure_keyboard_activity);
        }

        numericKeyPadView = findViewById(R.id.numericKeyPadView);
        edtPin = findViewById(R.id.edt_pin);

        numericKeyPadView.setOnTextChangeListener(this);
        numericKeyPadView.setFingerPrintAuthEnabled(false);
    }

    @Override
    public void onTextChanged(@NonNull String text) {
        edtPin.setText(text);
        if (text.length() >= 6) {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
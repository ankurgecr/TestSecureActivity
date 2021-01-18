package info.ankurpandya.testsecureactivity.customerviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import info.ankurpandya.testsecureactivity.R;

/**
 * Create by Ankur @ Worktable.sg
 */
public class NumericKeyPadView extends FrameLayout implements View.OnClickListener {

    View button0;
    View button1;
    View button2;
    View button3;
    View button4;
    View button5;
    View button6;
    View button7;
    View button8;
    View button9;
    View fingerPrintImageView;
    View buttonDelete;

    private String pinNumber = "";

    private OnTextChangeListener listener;
    private OnFingerPrintListener fingerPrintListener;

    public NumericKeyPadView(@NonNull Context context) {
        super(context);
        initView();
    }

    public NumericKeyPadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NumericKeyPadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public NumericKeyPadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_numeric_keypad, this, true);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        fingerPrintImageView = findViewById(R.id.fingerPrintImageView);
        buttonDelete = findViewById(R.id.buttonDelete);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        fingerPrintImageView.setOnClickListener(this);

        setFingerPrintAuthEnabled(false);
        setFocusable(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_1:
            case KeyEvent.KEYCODE_NUMPAD_1:
                appendCharacter("1");
                return true;
            case KeyEvent.KEYCODE_2:
            case KeyEvent.KEYCODE_NUMPAD_2:
                appendCharacter("2");
                return true;
            case KeyEvent.KEYCODE_3:
            case KeyEvent.KEYCODE_NUMPAD_3:
                appendCharacter("3");
                return true;
            case KeyEvent.KEYCODE_4:
            case KeyEvent.KEYCODE_NUMPAD_4:
                appendCharacter("4");
                return true;
            case KeyEvent.KEYCODE_5:
            case KeyEvent.KEYCODE_NUMPAD_5:
                appendCharacter("5");
                return true;
            case KeyEvent.KEYCODE_6:
            case KeyEvent.KEYCODE_NUMPAD_6:
                appendCharacter("6");
                return true;
            case KeyEvent.KEYCODE_7:
            case KeyEvent.KEYCODE_NUMPAD_7:
                appendCharacter("7");
                return true;
            case KeyEvent.KEYCODE_8:
            case KeyEvent.KEYCODE_NUMPAD_8:
                appendCharacter("8");
                return true;
            case KeyEvent.KEYCODE_9:
            case KeyEvent.KEYCODE_NUMPAD_9:
                appendCharacter("9");
                return true;
            case KeyEvent.KEYCODE_0:
            case KeyEvent.KEYCODE_NUMPAD_0:
                appendCharacter("0");
                return true;
            case KeyEvent.KEYCODE_DEL:
                applyBackSpace();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                appendCharacter("1");
                break;
            case R.id.button2:
                appendCharacter("2");
                break;
            case R.id.button3:
                appendCharacter("3");
                break;
            case R.id.button4:
                appendCharacter("4");
                break;
            case R.id.button5:
                appendCharacter("5");
                break;
            case R.id.button6:
                appendCharacter("6");
                break;
            case R.id.button7:
                appendCharacter("7");
                break;
            case R.id.button8:
                appendCharacter("8");
                break;
            case R.id.button9:
                appendCharacter("9");
                break;
            case R.id.button0:
                appendCharacter("0");
                break;
            case R.id.buttonDelete:
                applyBackSpace();
                break;
            case R.id.fingerPrintImageView:
                handleFingerPrintClicked();
                break;
        }
    }

    private void appendCharacter(String character) {
        pinNumber += character;
        checkSecurityPin();
    }

    private void applyBackSpace() {
        if (pinNumber.length() > 0) {
            pinNumber = pinNumber.substring(0, pinNumber.length() - 1);
            checkSecurityPin();
        }
    }

    public void clear() {
        clearSilently();
        checkSecurityPin();
    }

    public void clearSilently() {
        pinNumber = "";
    }

    public void setOnTextChangeListener(OnTextChangeListener listener) {
        this.listener = listener;
    }

    public void setFingerPrintListener(OnFingerPrintListener fingerPrintListener) {
        this.fingerPrintListener = fingerPrintListener;
    }

    public void setFingerPrintAuthEnabled(boolean enabled) {
        fingerPrintImageView.setVisibility(enabled ? VISIBLE : INVISIBLE);
    }

    private void checkSecurityPin() {
        if (listener != null) {
            listener.onTextChanged(pinNumber);
        }
    }

    private void handleFingerPrintClicked() {
        if (fingerPrintListener != null) {
            fingerPrintListener.onFingerPrintClicked();
        }
    }

    public interface OnTextChangeListener {
        void onTextChanged(@NonNull String text);
    }

    public interface OnFingerPrintListener {
        void onFingerPrintClicked();
    }
}

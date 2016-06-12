package customerror.devdeeds.com.customeerror;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextView = (EditText) findViewById(R.id.editTextView);


        int errorColor;
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {

             errorColor = ContextCompat.getColor(getApplicationContext(), R.color.errorColor);
        } else {
             errorColor = getResources().getColor(R.color.errorColor);
        }


        String errorString = "This field cannot be empty";  // your error message
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(errorColor);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(errorString);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, errorString.length(), 0);
        editTextView.setError(spannableStringBuilder);
    }
}

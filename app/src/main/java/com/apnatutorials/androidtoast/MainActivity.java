package com.apnatutorials.androidtoast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View toastLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnDefault:
                Toast.makeText(MainActivity.this, getString(R.string.default_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnError:
                showToast(R.drawable.ic_error_black_48dp, getString(R.string.error_message), getColor(R.color.error));
                break;
            case R.id.btnSuccess:
                showToast(R.drawable.ic_check_circle_black_48dp, getString(R.string.success_message), getColor(R.color.success));
                break;
            case R.id.btnWarning:
                showToast(R.drawable.ic_warning_black_48dp, getString(R.string.warning_message), getColor(R.color.warning));
                break;

        }
    }

    public void showToast(int icon, String message, int textColor) {
        message = message + " ";
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);

        if (toastLayout == null)
            toastLayout = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customToastLayout));

        toastLayout.setBackgroundColor(textColor);
        ImageView ivToastIcon = (ImageView) toastLayout.findViewById(R.id.ivToastIcon);
        TextView tvToastMessage = (TextView) toastLayout.findViewById(R.id.tvToastMessage);
        ivToastIcon.setImageResource(icon);
        tvToastMessage.setText(message);

        toast.setView(toastLayout);

        toast.show();

    }

}

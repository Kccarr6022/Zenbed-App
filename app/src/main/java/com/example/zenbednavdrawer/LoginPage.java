package com.example.zenbednavdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        String text = "<font color=#afa8a8>By signing in you are agreeing\nour</font> <font color=#76bee5>Term and privacy policy</font>";
        ((TextView)findViewById(R.id.terms)).setText(Html.fromHtml(text)); // Gives terms textview
        // a multicolored text

        // sets status bar color to white and icons to gray
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                // We want to change tint color to white again.
                // You can also record the flags in advance so that you can turn UI back completely if
                // you have set other flags before, such as translucent or full screen.
                decor.setSystemUiVisibility(0);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.btnlogin)) {
            openHome();
        }
    }

    public void openHome() {
        Intent intent_main = new Intent(this, MainActivity.class );
        intent_main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent_main);
    }

}
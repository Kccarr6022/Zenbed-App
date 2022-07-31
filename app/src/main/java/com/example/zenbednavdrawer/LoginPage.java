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
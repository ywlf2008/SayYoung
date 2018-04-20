package com.yw.sayyoung.sayyoung;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = this.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        textView = (TextView) findViewById(R.id.textView);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("density").append(displayMetrics.density).append(",densityDpi").append(displayMetrics.densityDpi).append(",heightPixels")
                .append(displayMetrics.heightPixels).append(",widthPixels").append(displayMetrics.widthPixels);
        textView.setText(stringBuilder.toString());
    }
}

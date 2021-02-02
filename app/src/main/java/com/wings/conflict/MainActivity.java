package com.wings.conflict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.wings.conflict.example1.FiveActivity;
import com.wings.conflict.example1.FourActivity;
import com.wings.conflict.example1.SecondActivity;
import com.wings.conflict.example1.ThreeActivity;
import com.wings.conflict.example2.EightActivity;
import com.wings.conflict.example2.SevenActivity;
import com.wings.conflict.example2.SixActivity;
import com.wings.conflict.example3.NineActivity;
import com.wings.conflict.example3.TenActivity;

/**
 * @author AI
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, ThreeActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, FourActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, FiveActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, SixActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this, SevenActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this, EightActivity.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(this, NineActivity.class));
                break;
            case R.id.btn9:
                startActivity(new Intent(this, TenActivity.class));
                break;
        }
    }
}
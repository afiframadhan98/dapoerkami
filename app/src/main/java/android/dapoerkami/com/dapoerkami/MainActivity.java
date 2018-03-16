package android.dapoerkami.com.dapoerkami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by SPY-SUPPORT on 3/5/2018.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOrder(View view) {

        if (((RadioButton)findViewById(R.id.rbt_CookingActivity)).isChecked()){
            Intent intent = new Intent(this, CookingActivity.class);
            Toast.makeText(this, "Go Cooking", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }else if (((RadioButton)findViewById(R.id.rbt_PostingActivity)).isChecked()){
            Intent intent = new Intent(this, PostingActivity.class);
            Toast.makeText(this, "Go Posting", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }else{
            Toast.makeText(this,"Pilih aktivitas yang ingin kamu lakukan",Toast.LENGTH_SHORT).show();
        }
    }
}


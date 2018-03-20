package android.dapoerkami.com.dapoerkami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG_ACTIVITY = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void onRadioButtonClicked(View view) {
        // apakah radiobutton di ceklis?
        boolean checked = ((RadioButton) view).isChecked();
        // Check radiobutton mana yang dipilih
        switch(view.getId()) {
            case R.id.rbt_GoCooking:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.cooking));
                break;
            case R.id.rbt_GoPosting:
                if (checked)
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.posting));
                break;
            default:
                Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
                break;
        }
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onGo(View view) {
        // apabila memilih Go Cooking dan klik Go akan menampilkan pesan Go Cooking
        if (((RadioButton)findViewById(R.id.rbt_GoCooking)).isChecked()){
            Intent intent = new Intent(this, CookingActivity.class);
            Toast.makeText(this, "Go Cooking", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            // apabila memilih Go Posting dan klik Go akan menampilkan pesan Go Posting
        }else if (((RadioButton)findViewById(R.id.rbt_GoPosting)).isChecked()){
            Intent intent = new Intent(this, PostingActivity.class);
            Toast.makeText(this, "Go Posting", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(this,"Pilih salah satu terlebih dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}

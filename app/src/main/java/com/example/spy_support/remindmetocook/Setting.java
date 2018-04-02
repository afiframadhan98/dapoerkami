package com.example.spy_support.remindmetocook;

/**
 * Created by SPY-SUPPORT on 3/31/2018.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    TextView shapeclr;
    int colorid;
    AlertDialog.Builder alert;
    SharedPreferences.Editor spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Pengaturan");

        //membuat alert dialog baru bernama alert
        alert = new AlertDialog.Builder(this);

        //menginisialisasi shared preference
        SharedPreferences sharedP = getApplicationContext().getSharedPreferences("Preferences", 0);
        spe = sharedP.edit();
    }

    //apabila tombol back di tekan
    @Override
    public void onBackPressed() {
        //intent baru dari pengaturan menuju list to do
        Intent intent = new Intent(Setting.this, ListToDo.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivity setelah intent di jalanlan
        finish();
    }

    //method yang dijalankan ketika pilihan pada menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            //menjalankan method onbackpressed
            this.onBackPressed();
        }
        return true;
        }
    }

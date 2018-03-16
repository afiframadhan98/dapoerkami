package android.dapoerkami.com.dapoerkami;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PostingActivity extends AppCompatActivity {

    private Button btCamera;
    private ImageView ivCamera;
    private static final String TAG = PostingActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        btCamera = (Button) findViewById(R.id.bt_camera);
        ivCamera = (ImageView) findViewById(R.id.iv_camera);

        btCamera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent khusus untuk menangkap foto lewat kamera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (CAMERA_REQUEST_CODE):
                if (resultCode == Activity.RESULT_OK) {
                    // result code sama, save gambar ke bitmap
                    Bitmap bitmap;
                    bitmap = (Bitmap) data.getExtras().get("data");
                    ivCamera.setImageBitmap(bitmap);
                }
                break;
        }
    }

    public void onButton(View view){

    }
}


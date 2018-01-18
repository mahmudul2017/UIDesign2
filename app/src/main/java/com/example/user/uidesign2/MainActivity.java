package com.example.user.uidesign2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickClick;
import com.vansuita.pickimage.listeners.IPickResult;

public class MainActivity extends AppCompatActivity implements IPickResult{
    ImageView mShowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowImage = (ImageView) findViewById(R.id.upload_image);
    }


    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            //If you want the Uri.
            //Mandatory to refresh image from Uri.
            //getImageView().setImageURI(null);

            //Setting the real returned image.
            //getImageView().setImageURI(r.getUri());

            //If you want the Bitmap.
            getImageView().setImageBitmap(r.getBitmap());

            //Image path
            //r.getPath();
        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, r.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    PickImageDialog.build(setup)
            .setOnClick(new IPickClick() {
        @Override
        public void onGalleryClick() {
            Toast.makeText(SampleActivity.this, "Gallery Click!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCameraClick() {
            Toast.makeText(SampleActivity.this, "Camera Click!", Toast.LENGTH_LONG).show();
        }
    }).show(this);
}

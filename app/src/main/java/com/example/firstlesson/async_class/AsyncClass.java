package com.example.firstlesson.async_class;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.InputStream;
import java.net.URL;

public class AsyncClass extends AsyncTask<String, Void, Bitmap> {

    private ImageView photoIV;
    private ProgressBar progressBar;

    public AsyncClass(ImageView photoIV, ProgressBar progressBar) {
        this.photoIV = photoIV;
        this.progressBar = progressBar;
    }

    @Override
    protected Bitmap doInBackground(String... pictureUrls) {
        Bitmap bit = null;
        try {
            InputStream picUrl = new URL(pictureUrls[0]).openStream();
            bit = BitmapFactory.decodeStream(picUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bit;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        photoIV.setImageBitmap(bitmap);
        photoIV.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}

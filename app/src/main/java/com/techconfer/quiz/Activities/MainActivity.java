package com.techconfer.quiz.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.techconfer.quiz.LoginActivity;
import com.techconfer.quiz.R;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static GoogleSignInClient mGoogleSignInClient;
    public static GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (account == null) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            TextView name = findViewById(R.id.name);
            name.setText(account.getDisplayName());
            /*Loading and Showing Profile Photo*/
            new LoadAndShowPhoto((ImageView) findViewById(R.id.photo)).execute(account.getPhotoUrl().toString());
            findViewById(R.id.sign_out).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_out:
                signOut();
                break;
        }
    }

    private void signOut() {
        if (mGoogleSignInClient != null) {
            mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });
        }
    }

    private class LoadAndShowPhoto extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public LoadAndShowPhoto(ImageView imageView) {
            this.imageView = imageView;
            Toast.makeText(getApplicationContext(), "Loading Photo..", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("LoadAndShowPhoto", e.getMessage());
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}
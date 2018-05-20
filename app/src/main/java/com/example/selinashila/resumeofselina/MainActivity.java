package com.example.selinashila.resumeofselina;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_facebook;
    Button btn_tweet;
    Button btn_linkedin;
    Button btn_git;
    //Button btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.propic);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.propic);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
        btn_facebook = (Button) findViewById(R.id.btn_fb);
        btn_tweet = (Button) findViewById(R.id.btn_tweet);
        btn_linkedin = (Button) findViewById(R.id.btn_linkedin);
        btn_git = (Button) findViewById(R.id.btn_git);
        //btn_next = (Button)findViewById(R.id.btn_next);

        btn_facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent facebookIntent = getOpenFacebookIntent(MainActivity.this);
                startActivity(facebookIntent);

            }
        });
        btn_tweet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent twitterIntent = getOpenTwitterIntent(MainActivity.this);
                startActivity(twitterIntent);

            }
        });
        btn_linkedin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent linkdinIntent = getOpenLinkdinIntent(MainActivity.this);
                startActivity(linkdinIntent);
            }
        });

        btn_git.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent githubIntent = getOpenGithubIntent(MainActivity.this);
                startActivity(githubIntent);
            }
        });

    }
    public void onButtonClick(View view){
        if(view.getId()==R.id.btn_next){
            Intent intent;
            intent = new Intent(MainActivity.this,Education.class);
            startActivity(intent);
        }


    }




    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://m.facebook.com/selina.shila.7")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/selina.shila.7")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenTwitterIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.twitter.android", 0); //Checks if Twitter is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/SelinaShila")); //Trys to make intent with Twitter's's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/SelinaShila")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenLinkdinIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.linkedin.android", 0); //Checks if Linkdin is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/selina-akter-shila-386a15131/")); //Trys to make intent with Linkdin's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/selina-akter-shila-386a15131/")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenGithubIntent(Context context)  {
        try {
            context.getPackageManager().getPackageInfo("com.github.pockethub.android", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SelinaShila"));
        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SelinaShila"));
        }


    }
}
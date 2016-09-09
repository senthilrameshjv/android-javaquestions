package com.a1195.java_interviewquestions;

import android.app.Activity;
import android.content.Intent;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.File;

public class MainActivity extends Activity {

    Button button;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button2);
        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, JavaActivity.class);
                startActivity(myIntent);
            }
        });

        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, SpringActivity.class);
                startActivity(myIntent);
            }
        });
    }

@Override
    public boolean onCreateOptionsMenu(Menu menu){


    ApplicationInfo app = getApplicationContext().getApplicationInfo();
    String filePath = app.sourceDir;

    getMenuInflater().inflate(R.menu.menu_java_page,menu);
    MenuItem shareItem=(MenuItem)menu.findItem(R.id.action_share);
    ShareActionProvider mShare = (ShareActionProvider)shareItem.getActionProvider();

    Intent shareIntent = new Intent(Intent.ACTION_SEND);
    shareIntent.setAction(Intent.ACTION_SEND);
    shareIntent.setType("application/vnd.android.package-archive");
   // shareIntent.putExtra(Intent.EXTRA_TEXT, "text to share");

    shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
    mShare.setShareIntent(shareIntent);
    return true;
    }
}

package com.example.nguyendinh.content_provider;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class Test extends ActionBarActivity {
    ImageView imageView;
    PhotoViewAttacher attacher;
    int actionbarHeight;
    int statusBarHeight;
    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher);
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        imageView = (ImageView) findViewById(R.id.imageView);
//
//        TypedValue typedValue = new TypedValue();
//        if(getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)){
//            actionbarHeight = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
//        }
//
//        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
//        }
        photoView = (PhotoView) findViewById(R.id.photoView);
        Picasso.with(this)
                .load("http://172.245.22.156:8080/TestImageApp/ORIGINAL/1422072240.jpg")
                .into(photoView);
//        attacher = new PhotoViewAttacher(imageView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

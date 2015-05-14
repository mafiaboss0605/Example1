package com.example.nguyendinh.content_provider;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.readystatesoftware.viewbadger.BadgeView;

public class TabActivity extends ActionBarActivity {

    public TabHost tabHost;
    public TabWidget tabWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabHost.setup();
//        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("t1");
//        tabSpec1.setContent(R.id.tab1);
//        tabSpec1.setIndicator("Tab 1", getResources().getDrawable(R.drawable.ic_launcher));
//        tabHost.addTab(tabSpec1);
//        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("t2");
//        tabSpec2.setContent(R.id.tab2);
//        tabSpec2.setIndicator("Tab 2", getResources().getDrawable(R.drawable.ic_launcher));
//        tabHost.addTab(tabSpec2);
        setTabs();
        tabHost.setCurrentTab(0);
        BadgeView badgeView = new BadgeView(this, tabWidget.getChildTabViewAt(2).findViewById(R.id.icon));
        badgeView.setText("1");
        badgeView.setBadgeMargin(0);
        badgeView.setPadding(7,0,7,0);
        badgeView.show();

    }

    private void setTabs()
    {
        addTab(R.drawable.menu_tab, R.id.tab1, "Menu");
        addTab(R.drawable.past_order_tab, R.id.tab2, "Đã Đặt");
        addTab(R.drawable.basket_tab, R.id.tab3, "Giỏ Hàng");
    }

    private void addTab(int drawableId, int layoutID, String labelId)
    {
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, tabWidget, false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(labelId);

        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setBackgroundResource(drawableId);

        spec.setIndicator(tabIndicator);
        spec.setContent(layoutID);
        tabHost.addTab(spec);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
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

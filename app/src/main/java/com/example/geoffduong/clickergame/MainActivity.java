package com.example.geoffduong.clickergame;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView counterText;
    CounterThread counter;
    ImageButton clickBtn;
    BottomBar bottomBar;
    StringBuilder money;
    ArrayList<UpgradeData> upgradeListData;
    ListView upgradeListView;
    UpgradeListAdapter upgradeListAdapter;
    Resources res;
    final int[] upgradeImages = {R.drawable.ic_fitness_center, R.drawable.ic_fitness_center,
            R.drawable.ic_fitness_center, R.drawable.ic_fitness_center};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate upgrade list view-----------------------------------
        res = getResources();
        String[] upgrades = res.getStringArray(R.array.upgrades_stringArray);
        upgradeListData = new ArrayList<>();
//        for (int image : upgradeImages) {
//            upgradeListData.add(new UpgradeData(image, "Peasant", true));
//        }
        for (String upgrade : upgrades) {
            upgradeListData.add(new UpgradeData(upgradeImages[0], upgrade, true));
        }
        upgradeListAdapter = new UpgradeListAdapter(this, upgradeListData);
        upgradeListView = (ListView) findViewById(R.id.upgrade_listView);
        upgradeListView.setAdapter(upgradeListAdapter);
        //--------------------------------------------------------------

        counterText = (TextView) findViewById(R.id.counterText);
        money = new StringBuilder();
        money.append("Money:");
        money.append(" ");
        money.append(count);
        counterText.setText(money.toString());
        counter = new CounterThread("counterThread");
        counter.start();

        clickBtn = (ImageButton) findViewById(R.id.clickBtn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 3;
                money.replace(7, money.length(), Integer.toString(count));
                counterText.setText(money.toString());
            }
        });


        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        BottomBarTab kingdomTab = bottomBar.getTabWithId(R.id.tab_kingdom);
        bottomBar.setDefaultTab(kingdomTab.getId());
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_map:
                        Intent toMapIntent = new Intent(MainActivity.this, Map.class);
                        startActivity(toMapIntent);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
                        break;
                    case R.id.tab_settings:
                        Intent toSettingsIntent = new Intent(MainActivity.this, Settings.class);
                        startActivity(toSettingsIntent);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // Counter Thread
    class CounterThread implements Runnable {
        private Thread thread;
        private String threadName;
        private volatile boolean running;

        public CounterThread(String threadName) {
            this.threadName = threadName;
            running = true;
        }

        public void terminate() {
            running = false;
        }

        public void run() {
            try {
                while (running) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            count++;
                            money.replace(7, money.length(), Integer.toString(count));
                            counterText.setText(money.toString());
                        }
                    });
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }

        public void start() {
            if (thread == null) {
                thread = new Thread(this, threadName);
                thread.start();
            }
        }
    }
}

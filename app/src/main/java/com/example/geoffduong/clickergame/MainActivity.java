package com.example.geoffduong.clickergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int count = 0, cost = 0;
    TextView counterText;
    CounterThread counter;
    ImageButton clickBtn;
    BottomBar bottomBar;
    StringBuilder money;
    ArrayList<UpgradeData> upgradeListData;
    ListView upgradeListView;
    UpgradeListAdapter upgradeListAdapter;
    Resources res;
    String[] upgradeNames, upgradeDescriptions;
    final int[] upgradeImages = {R.drawable.ic_fitness_center, R.drawable.ic_fitness_center,
            R.drawable.ic_fitness_center, R.drawable.ic_fitness_center};
    Upgrades upgrades;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upgrades = new Upgrades();

        // Populate upgrade list view-----------------------------------
        res = getResources();
        upgradeNames = res.getStringArray(R.array.upgradeNames_stringArray);
        upgradeListData = new ArrayList<>();
        for (String upgrade : upgradeNames) {
            upgradeListData.add(new UpgradeData(upgradeImages[0], upgrade, true));
        }
        upgradeListAdapter = new UpgradeListAdapter(this, upgradeListData);
        upgradeListView = (ListView) findViewById(R.id.upgrade_listView);
        upgradeListView.setAdapter(upgradeListAdapter);
        //--------------------------------------------------------------

        // OnItemClickListener
        upgradeDescriptions = res.getStringArray(R.array.upgradeDescriptions_stringArray);
        upgradeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // Create AlertDialog.Builder instance
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                // Build dialog title
                StringBuilder titleStringBuilder = new StringBuilder();
                titleStringBuilder.append(upgradeNames[position]);
                titleStringBuilder.append(" ");
                titleStringBuilder.append("Upgrade");
                alertDialogBuilder.setTitle(titleStringBuilder.toString());

                // Confirm, cancel?
                StringBuilder descriptionStringBuilder = new StringBuilder();
                descriptionStringBuilder.append(upgradeDescriptions[position]);
                descriptionStringBuilder.append("\n\n");
                descriptionStringBuilder.append("Do you want to upgrade?");
                alertDialogBuilder
                        .setMessage(descriptionStringBuilder.toString())
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (position) {
                                    // Tower, increases passive click
                                    case 0:
                                        cost = upgrades.increasePassiveClick(count);
                                        if (cost != 0) {
                                            upgradeListData.get(position).increaseUpgradeLevel();
                                            count -= cost;
                                            updateMoney();
                                            StringBuilder upgradedBuilder = new StringBuilder();
                                            upgradedBuilder.append("Upgraded Tower to level");
                                            upgradedBuilder.append(" ");
                                            upgradedBuilder.append(upgradeListData.get(position).getUpgradeLevel());
                                            Toast.makeText(getApplicationContext(),
                                                    upgradedBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            StringBuilder notEnoughMoneyBuilder = new StringBuilder();
                                            notEnoughMoneyBuilder.append("Not enough money to upgrade Tower.");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("This upgrade costs");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("$");
                                            notEnoughMoneyBuilder.append(upgrades.getTowerUpgradeCost());
                                            Toast.makeText(getApplicationContext(),
                                                    notEnoughMoneyBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        break;
                                    // Barracks, increase number of recruits to work on Farm
                                    case 5:
                                        cost = upgrades.increaseNumberOfRecruits(count);
                                        if (cost != 0) {
                                            upgradeListData.get(position).increaseUpgradeLevel();
                                            count -= cost;
                                            updateMoney();
                                            StringBuilder upgradedBuilder = new StringBuilder();
                                            upgradedBuilder.append("Upgraded Barracks to level");
                                            upgradedBuilder.append(" ");
                                            upgradedBuilder.append(upgradeListData.get(position).getUpgradeLevel());
                                            Toast.makeText(getApplicationContext(),
                                                    upgradedBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            StringBuilder notEnoughMoneyBuilder = new StringBuilder();
                                            notEnoughMoneyBuilder.append("Not enough money to upgrade Barracks.");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("This upgrade costs");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("$");
                                            notEnoughMoneyBuilder.append(upgrades.getBarracksUpgradeCost());
                                            Toast.makeText(getApplicationContext(),
                                                    notEnoughMoneyBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        break;
                                    // Farm, increase recruit click power
                                    case 3:
                                        cost = upgrades.increasePointsPerRecruitClick(count);
                                        if (cost != 0) {
                                            upgradeListData.get(position).increaseUpgradeLevel();
                                            count -= cost;
                                            updateMoney();
                                            StringBuilder upgradedBuilder = new StringBuilder();
                                            upgradedBuilder.append("Upgraded Farm to level");
                                            upgradedBuilder.append(" ");
                                            upgradedBuilder.append(upgradeListData.get(position).getUpgradeLevel());
                                            Toast.makeText(getApplicationContext(),
                                                    upgradedBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            StringBuilder notEnoughMoneyBuilder = new StringBuilder();
                                            notEnoughMoneyBuilder.append("Not enough money to upgrade Farm.");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("This upgrade costs");
                                            notEnoughMoneyBuilder.append(" ");
                                            notEnoughMoneyBuilder.append("$");
                                            notEnoughMoneyBuilder.append(upgrades.getFarmUpgradeCost());
                                            Toast.makeText(getApplicationContext(),
                                                    notEnoughMoneyBuilder.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                upgradeListAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                // Build alertDialog and show
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        //--------------------------------------------------------------

        counterText = (TextView) findViewById(R.id.counterText);
        money = new StringBuilder();
        money.append("Money:");
        money.append(" ");
        money.append("$");
        money.append(count);
        counterText.setText(money.toString());
        counter = new CounterThread("counterThread");
        counter.start();

        clickBtn = (ImageButton) findViewById(R.id.clickBtn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += upgrades.getPointsPerUserClick();
                updateMoney();
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
                            count += calculateMoney(upgrades);
                            updateMoney();
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

    // Calculate how much to increment money based on upgrades
    public int calculateMoney(Upgrades upgrades) {
        return upgrades.getNumberOfRecruits()*upgrades.getPointsPerRecruitClick()+
                upgrades.getPassiveClick();
    }

    // Update money counter
    private void updateMoney() {
        money.replace(8, money.length(), Integer.toString(count));
        counterText.setText(money.toString());
    }
}

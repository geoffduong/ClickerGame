package com.example.geoffduong.clickergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by geoffduong on 3/19/17.
 */

public class Settings extends AppCompatActivity {

    BottomBar bottomBar;
    Button resetProgressBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_settings);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        BottomBarTab settingsTab = bottomBar.getTabWithId(R.id.tab_settings);
        bottomBar.setDefaultTab(settingsTab.getId());
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_map:
                        Intent toMapIntent = new Intent(Settings.this, Map.class);
                        startActivity(toMapIntent);
                        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                        break;
                    case R.id.tab_kingdom:
                        Intent toKingdomIntent = new Intent(Settings.this, MainActivity.class);
                        toKingdomIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(toKingdomIntent);
                        finish();
                        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                        break;
                }
            }
        });

        resetProgressBtn = (Button) findViewById(R.id.settings_resetProgress);
        resetProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create AlertDialog.Builder instance
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Settings.this);

                // Build dialog title
                alertDialogBuilder.setTitle("Reset Progress");

                // Confirm, cancel?
                alertDialogBuilder
                        .setMessage("Are you sure you want to reset progress?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent toKingdomIntent = new Intent(Settings.this, MainActivity.class);
                                toKingdomIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(toKingdomIntent);
                                finish();
                                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
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

    }
}

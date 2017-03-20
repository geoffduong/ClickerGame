package com.example.geoffduong.clickergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by geoffduong on 3/19/17.
 */

public class Settings extends AppCompatActivity {

    BottomBar bottomBar;
    int count = 0;

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
                    case R.id.tab_battle:
                        break;
                    case R.id.tab_kingdom:
                        finish();
                        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                        break;
                }
            }
        });

    }
}

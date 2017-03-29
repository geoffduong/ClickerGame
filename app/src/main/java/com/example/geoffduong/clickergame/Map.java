package com.example.geoffduong.clickergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by geoffduong on 3/20/17.
 */

public class Map extends AppCompatActivity {

    BottomBar bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_map);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        BottomBarTab battleTab = bottomBar.getTabWithId(R.id.tab_map);
        bottomBar.setDefaultTab(battleTab.getId());
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_settings:
                        Intent toSettingsIntent = new Intent(Map.this, Settings.class);
                        startActivity(toSettingsIntent);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
                        break;
                    case R.id.tab_kingdom:
                        Intent toKingdomIntent = new Intent(Map.this, MainActivity.class);
                        toKingdomIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(toKingdomIntent);
                        finish();
                        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                        break;
                }
            }
        });
    }
}

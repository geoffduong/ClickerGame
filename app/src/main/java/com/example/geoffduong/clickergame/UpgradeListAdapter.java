package com.example.geoffduong.clickergame;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by geoffduong on 3/27/17.
 */

public class UpgradeListAdapter extends BaseAdapter {
    private Context upgrade_context;
    private ArrayList<UpgradeData> upgrade_listdata;

    public UpgradeListAdapter(Context context, ArrayList<UpgradeData> listData) {
        upgrade_context = context;
        upgrade_listdata = listData;
    }

    @Override
    public int getCount() {
        return upgrade_listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return upgrade_listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflate layout for upgrade list cell
        if (convertView == null) {
            LayoutInflater mInflater =
                    (LayoutInflater) upgrade_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.upgrade_listcell, null);
        }

        ImageView upgradeImage = (ImageView) convertView.findViewById(R.id.upgrade_listcell_image);
        TextView upgradeName = (TextView) convertView.findViewById(R.id.upgrade_listcell_name);
        TextView upgradeLevel = (TextView) convertView.findViewById(R.id.upgrade_listcell_level);

        upgradeImage.setImageResource(upgrade_listdata.get(position).getUpgradeImage());
        upgradeName.setText(upgrade_listdata.get(position).getUpgradeName());
        upgradeLevel.setText(Integer.toString(upgrade_listdata.get(position).getUpgradeLevel()));

        return convertView;
    }
}

package net.codeforgood.sciencebehindsports.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import net.codeforgood.sciencebehindsports.Object.Activity;

import java.util.List;

/**
 * Created by mofi on 10/29/16.
 */

public class ActivityAdapter extends ArrayAdapter<Activity> {
    public ActivityAdapter(Context context, List<Activity> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}

package net.codeforgood.sciencebehindsports.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.R;

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
        Activity activity = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_list_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.activity_list_activity);
        TextView time = (TextView) convertView.findViewById(R.id.activity_list_time);
        TextView materials = (TextView) convertView.findViewById(R.id.activity_list_material);


        String activityName = "Activity " + activity.getActivity_number();
        String activityTime = activity.getActivity_time() + " minute";
        String activityMaterial = activity.getMaterials();

        name.setText(activityName);
        time.setText(activityTime);
        materials.setText(activityMaterial);

        return convertView;
    }
}

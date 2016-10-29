package net.codeforgood.sciencebehindsports.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;

import java.util.List;

/**
 * Created by mofi on 10/29/16.
 */

public class ModuleAdapter extends ArrayAdapter<Module> {

    public ModuleAdapter(Context context, List<Module> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Module module = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_list_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.module_list_name);
        TextView time = (TextView) convertView.findViewById(R.id.module_list_time);
        TextView activities = (TextView) convertView.findViewById(R.id.module_list_activity);

        String moduleName = module.getModule_name();
        String moduleTime = String.valueOf(module.getModule_time());
        String moduleActivities = String.valueOf(module.getNum_of_activities());

        name.setText(moduleName);
        time.setText(moduleTime);
        activities.setText(moduleActivities);

        return convertView;
    }
}

package net.codeforgood.sciencebehindsports.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.codeforgood.sciencebehindsports.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment {


    View activityRoot;
    ArrayList<String> tempList;
    ArrayAdapter<String> tempAdapter;

    public ActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tempList = new ArrayList<>();

        tempList.add("activity01");
        tempList.add("activity02");
        tempList.add("activity03");
        tempList.add("activity04");
        tempList.add("activity05");
        tempList.add("activity06");
        tempList.add("activity07");

        tempAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, tempList);
        activityRoot = inflater.inflate(R.layout.fragment_activity, container, false);
        ListView listView = (ListView) activityRoot.findViewById(R.id.activity_list);
        listView.setAdapter(tempAdapter);
        return activityRoot;
    }

}

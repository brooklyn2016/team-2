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
public class ModulesFragment extends Fragment {


    View mRoot;
    ArrayList<String> tempData;
    ArrayAdapter<String> tempAdapter;
    public ModulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tempData = new ArrayList<>();

        tempData.add("science");
        tempData.add("more science");
        tempData.add("good science");
        tempData.add("bad science");
        tempData.add("science");
        tempData.add("science");
        tempData.add("science");
        tempData.add("science");



        tempAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, tempData);

        mRoot = inflater.inflate(R.layout.fragment_modules, container, false);

        ListView listView = (ListView) mRoot.findViewById(R.id.module_list);
        listView.setAdapter(tempAdapter);



        return mRoot;
    }

}

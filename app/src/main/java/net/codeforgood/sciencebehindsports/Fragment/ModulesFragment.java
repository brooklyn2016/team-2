package net.codeforgood.sciencebehindsports.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import net.codeforgood.sciencebehindsports.Adapter.ModuleAdapter;
import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModulesFragment extends Fragment {


    View mRoot;

    ArrayList<Module> mModuleList;
    ModuleAdapter mAdapter;
    public ModulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        mModuleList = new ArrayList<>();






        mAdapter = new ModuleAdapter(getContext(), mModuleList);

        mModuleList.add(new Module(1, "module01", 100, 8, "ball", "no objective", "no content", "no process", 1));
        mModuleList.add(new Module(2, "module02", 100, 8, "ball", "no objective", "no content", "no process", 2));
        mModuleList.add(new Module(3, "module03", 100, 8, "ball", "no objective", "no content", "no process", 3));
        mModuleList.add(new Module(4, "module04", 100, 8, "ball", "no objective", "no content", "no process", 4));
        mModuleList.add(new Module(5, "module05", 100, 8, "ball", "no objective", "no content", "no process", 5));
        mModuleList.add(new Module(6, "module06", 100, 8, "ball", "no objective", "no content", "no process", 6));

        mRoot = inflater.inflate(R.layout.fragment_modules, container, false);

        ListView listView = (ListView) mRoot.findViewById(R.id.module_list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModuleDetailFragment fragment = new ModuleDetailFragment();
                Bundle args = new Bundle();
                args.putParcelable("ModuleDetail", mModuleList.get(position));
                fragment.setArguments(args);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        return mRoot;
    }

}

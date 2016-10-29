package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.codeforgood.sciencebehindsports.Adapter.ActivityAdapter;
import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.R;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {


    ArrayList<Activity> mActivityList;
    ActivityAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mActivityList = new ArrayList<>();
        mAdapter = new ActivityAdapter(this, mActivityList);
        Bundle data = getIntent().getExtras();
        int moduleID = data.getInt("moduleId");
        mActivityList.add(new Activity(1, 1, "get out",moduleID,"no obj", "no result", 100, "no material", "no instruction" ));
        mActivityList.add(new Activity(2, 2, "get out",moduleID,"no obj", "no result", 100, "no material", "no instruction" ));
        mActivityList.add(new Activity(3, 3, "get out",moduleID,"no obj", "no result", 100, "no material", "no instruction" ));
        mActivityList.add(new Activity(4, 4, "get out",moduleID,"no obj", "no result", 100, "no material", "no instruction" ));
        mActivityList.add(new Activity(5, 5, "get out",moduleID,"no obj", "no result", 100, "no material", "no instruction" ));

        ListView listView = (ListView) this.findViewById(R.id.activity_list);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityList.this, Test.class);
                intent.putExtra("ActivityDetail",  mActivityList.get(position));
                startActivity(intent);
            }
        });

    }
}

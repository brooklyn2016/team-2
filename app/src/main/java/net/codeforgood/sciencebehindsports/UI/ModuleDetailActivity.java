package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;

public class ModuleDetailActivity extends AppCompatActivity {



    Button startActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);

        Bundle data = getIntent().getExtras();
        final Module mModule = data.getParcelable("ModuleDetail");



        final int moduleId = mModule.getId();
        String moduleName = mModule.getModule_name();
        int moduleTime = mModule.getModule_time();
        int moduleNumOfActivity = mModule.getNum_of_activities();
        String material = mModule.getMaterials();
        String objective = mModule.getObjective();
        String content = mModule.getContent();
        String process = mModule.getContent();
        int moduleNumber = mModule.getModule_number();





        TextView textView = (TextView)findViewById(R.id.module_detail_activity_name);
        textView.setText(mModule.getModule_name());














        startActivity = (Button) findViewById(R.id.module_detail_activity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuleDetailActivity.this, ActivityList.class);
                intent.putExtra("moduleId", moduleId);
                startActivity(intent);

                finish();
            }
        });
    }
}

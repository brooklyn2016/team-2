package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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


        //creates objects included in activity
        final int moduleId = mModule.getId();
        String moduleName = mModule.getModule_name();
        int moduleTime = mModule.getModule_time();
        int moduleNumOfActivity = mModule.getNum_of_activities();
        String material = mModule.getMaterials();
        String objective = mModule.getObjective();
        String content = mModule.getContent();
        String process = mModule.getContent();
        int moduleNumber = mModule.getModule_number();


        String[] splice = material.split(":");
        String materialList="";
        for (int i = 0; i < splice.length; i++) {
            materialList+=(i+1)+". "+splice[i]+"\n";
        }



        TextView nameView = (TextView)findViewById(R.id.module_detail_activity_name);
        nameView.setText(mModule.getModule_name());


        TextView timeView = (TextView) findViewById(R.id.module_detail_activity_time);
        timeView.setText(moduleTime+" Minute");

        ImageView imageOne = (ImageView) findViewById(R.id.module_detail_activity_imageView);






        TextView materialView = (TextView) findViewById(R.id.module_detail_activity_materials);
        materialView.setText(materialList);

        TextView objectiveView = (TextView) findViewById(R.id.module_detail_activity_objective);
        objectiveView.setText(objective);

        ImageView imageTwo = (ImageView) findViewById(R.id.module_detail_activity_imageView_2);

        switch (moduleNumber){
            case 1:
                imageOne.setImageResource(R.drawable.projectilemotion);
                imageTwo.setImageResource(R.drawable.football_projectile_motion);
                break;
            case 2:
                imageOne.setImageResource(R.drawable.projectilemotion);
                imageTwo.setImageResource(R.drawable.football_projectile_motion);
                break;
            case 3:
                imageOne.setImageResource(R.drawable.kinesiology);
                imageTwo.setImageResource(R.drawable.kinesiology2);
                break;
            case 4:
                imageOne.setImageResource(R.drawable.soundwave_pic);
                imageTwo.setImageResource(R.drawable.soundwave);
                break;
            case 5:
                imageOne.setImageResource(R.drawable.material_science);
                imageTwo.setImageResource(R.drawable.material);
                break;
            case 6:
                imageOne.setImageResource(R.drawable.body_systems);
                imageTwo.setImageResource(R.drawable.bodysystems);
                break;
            default:
                imageOne.setImageResource(R.drawable.soundwave_pic);
        }








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

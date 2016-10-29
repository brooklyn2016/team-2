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
        TextView textView = (TextView)findViewById(R.id.module_detail_test);
        textView.setText(mModule.getModule_name());

        startActivity = (Button) findViewById(R.id.module_detail_activity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuleDetailActivity.this, ActivityList.class);
                intent.putExtra("moduleId", mModule.getId());
                startActivity(intent);

                finish();
            }
        });
    }
}

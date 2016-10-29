package net.codeforgood.sciencebehindsports.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;

public class ModuleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);

        Bundle data = getIntent().getExtras();
        Module mModule = data.getParcelable("ModuleDetail");
        TextView textView = (TextView)findViewById(R.id.module_detail_test);
        textView.setText(mModule.getModule_name());
    }
}

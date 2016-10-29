package net.codeforgood.sciencebehindsports.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.R;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle data = getIntent().getExtras();
        final Activity mActivity = data.getParcelable("ActivityDetail");
        TextView textView = (TextView)findViewById(R.id.test_text_box);
        textView.setText(mActivity.getActivity_objective());

    }
}

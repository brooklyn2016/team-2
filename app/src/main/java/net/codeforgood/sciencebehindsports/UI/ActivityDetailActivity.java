package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.Object.Module;
import net.codeforgood.sciencebehindsports.R;

public class ActivityDetailActivity extends AppCompatActivity {

    Button startQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle data = getIntent().getExtras();
        final Activity mActivity = data.getParcelable("ActivityDetail");
        TextView textView = (TextView)findViewById(R.id.activity_detail_activity_num);
        textView.setText(mActivity.getActivity_objective());



        startQuiz = (Button) findViewById(R.id.module_detail_activity);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDetailActivity.this, QuizActivity.class);
                intent.putExtra("activityId",mActivity.getId() );
                startActivity(intent);

                finish();
            }
        });
    }
}

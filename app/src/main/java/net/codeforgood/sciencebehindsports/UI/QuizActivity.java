package net.codeforgood.sciencebehindsports.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import net.codeforgood.sciencebehindsports.R;

public class QuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

    //quiz activity goes here
        Bundle data = getIntent().getExtras();
        //quiz questions are generated and populated by activityID
        int activityID = data.getInt("activityId");

    }
}

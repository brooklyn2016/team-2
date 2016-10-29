package net.codeforgood.sciencebehindsports.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import net.codeforgood.sciencebehindsports.R;

public class QuizActivity extends AppCompatActivity {

    Button choiceA,choiceB,choiceC, choiceD,hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        choiceA = (Button) findViewById(R.id.activity_quiz_choiceA);
        choiceB = (Button) findViewById(R.id.activity_quiz_choiceB);
        choiceC = (Button) findViewById(R.id.activity_quiz_choiceC);
        choiceD = (Button) findViewById(R.id.activity_quiz_choiceD);
        hint = (Button) findViewById(R.id.activity_quiz_hint);

    //quiz activity goes here
        Bundle data = getIntent().getExtras();
        //quiz questions are generated and populated by activityID
        int activityID = data.getInt("activityId");


    }
}

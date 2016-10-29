package net.codeforgood.sciencebehindsports.UI;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.R;

public class QuizActivity extends AppCompatActivity {

    Button choiceA,choiceB,choiceC, choiceD,hint;
    TextView question;
    public int rightAns;
    public String tempQuestion;
    public String tempAnswer1;
    public String tempAnswer2;
    public String tempAnswer3;
    public String tempAnswer4;
    public String tempHint;
    public String tempExplanation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView) findViewById(R.id.activity_quiz_question);
        choiceA = (Button) findViewById(R.id.activity_quiz_choiceA);
        choiceB = (Button) findViewById(R.id.activity_quiz_choiceB);
        choiceC = (Button) findViewById(R.id.activity_quiz_choiceC);
        choiceD = (Button) findViewById(R.id.activity_quiz_choiceD);
        hint = (Button) findViewById(R.id.activity_quiz_hint);

    //quiz activity goes here
        Bundle data = getIntent().getExtras();
        //quiz questions are generated and populated by activityID
        int activityID = data.getInt("activityId");

        tempQuestion = "What is the speed of the football right before it lands if it is thrown " +
                "at an angle of 45 degree above horizon and at the speed of 80m/s (assume ideal trajectory motion)?";
        tempAnswer1 = "56m/s";
        tempAnswer2 = "80m/s";
        tempAnswer3 = "40m/s";
        tempAnswer4 = "0m/s";
        tempHint = "the starting point and the end point of trajectory is at the same level";
        tempExplanation = "When ideal trajectory is assumed and the start and end points are at same level, rhe kinetic energy is identical right after" +
                "throwing and right before landing";
        rightAns = 2;

        question.setText("Question: "+tempQuestion);
        choiceA.setText("A. "+tempAnswer1);
        choiceB.setText("B. "+tempAnswer2);
        choiceC.setText("C. "+tempAnswer3);
        choiceD.setText("D. "+tempAnswer4);

        choiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightAns == 1)
                    choiceA.setBackgroundColor(Color.GREEN);
                else
                    choiceA.setBackgroundColor(Color.RED);
                showCorrectAns(rightAns);
                disableAll();
            }
        });
        choiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightAns == 2)
                    choiceB.setBackgroundColor(Color.GREEN);
                else
                    choiceB.setBackgroundColor(Color.RED);
                showCorrectAns(rightAns);
                disableAll();

            }
        });
        choiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightAns == 3)
                    choiceC.setBackgroundColor(Color.GREEN);
                else
                    choiceC.setBackgroundColor(Color.RED);
                showCorrectAns(rightAns);
                disableAll();
            }
        });
        choiceD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightAns == 4)
                    choiceD.setBackgroundColor(Color.GREEN);
                else
                    choiceD.setBackgroundColor(Color.RED);
                showCorrectAns(rightAns);
                disableAll();
            }
        });
        hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                hint.setTextSize(12);
                hint.setText(tempHint);
            }

        });

    }

    private void disableAll()
    {
        choiceA.setEnabled(false);
        choiceB.setEnabled(false);
        choiceC.setEnabled(false);
        choiceD.setEnabled(false);
    }
    private void showCorrectAns(int rightAns)
    {
        if (rightAns == 1)
            choiceA.setBackgroundColor(Color.GREEN);
        else if(rightAns == 2)
            choiceB.setBackgroundColor(Color.GREEN);
        else if(rightAns == 3)
            choiceC.setBackgroundColor(Color.GREEN);
        else if(rightAns == 4)
            choiceD.setBackgroundColor(Color.GREEN);
        question.setText("Explanation: "+tempExplanation);
        hint.setText("BACK");
    }
}

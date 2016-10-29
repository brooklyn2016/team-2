package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import net.codeforgood.sciencebehindsports.Object.Activity;
import net.codeforgood.sciencebehindsports.R;

public class ActivityDetailActivity extends AppCompatActivity {

    Button startQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle data = getIntent().getExtras();
        final Activity mActivity = data.getParcelable("ActivityDetail");

        final int activityId = mActivity.getId();
        int activityNumber = mActivity.getActivity_number();
        String description = mActivity.getDescription();
        int moduleId = mActivity.getModule_id();
        String activityObjective = mActivity.getActivity_objective();
        String result = mActivity.getResult();
        int activityTime = mActivity.getActivity_time();
        String materials = mActivity.getMaterials();
        String instruction = mActivity.getInstruction();

        String[] splice = materials.split(":");
        String materialList="";
        for (int i = 0; i < splice.length; i++) {
            materialList+=(i+1)+". "+splice[i]+"\n";
        }

        TextView nameView = (TextView)findViewById(R.id.activity_detail_activity_num);
        nameView.setText("Activity No."+ String.valueOf(mActivity.getActivity_number()));


        TextView timeView = (TextView) findViewById(R.id.activity_detail_time);
        timeView.setText(activityTime+" Minute");

        TextView descriptionView = (TextView) findViewById(R.id.activity_detail_description);
        descriptionView.setText("Description: \n "+description);

        TextView instructionView = (TextView) findViewById(R.id.activity_detail_instruction);
            instructionView.setText("Instructions: \n");
        if (instruction != null)
            instructionView.append(instruction);

        TextView resultView = (TextView) findViewById(R.id.activity_detail_result);
            resultView.setText("Outcome: \n");
        if (instruction != null)
            resultView.append(result);


        VideoView videoView = (VideoView) findViewById(R.id.activity_detail_video);
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.projectile_demo);



//        VideoView videoView = (VideoView) findViewById(R.id.activity_detail_video);
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.projectile_demo);




        switch (moduleId){
            case 1:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.first_law_demo);
                break;
            case 2:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.projectile_demo);
                break;
            case 3:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.kinesiology);
                break;
            case 4:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sound_wave_demo);
                break;
            case 5:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.material_demo);
                break;
            case 6:
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.body_demo);
                break;
            default:
                break;

        }


//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();
        //ImageView imageOne = (ImageView) findViewById(R.id.module_detail_activity_imageView);
        //TextView textView = (TextView)findViewById(R.id.activity_detail_activity_num);
        //textView.setText(mActivity.getActivity_objective());

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();



        startQuiz = (Button) findViewById(R.id.activity_detail_quiz);
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

package net.codeforgood.sciencebehindsports.Object;

/**
 * Created by VAIO-Jun on 10/29/2016.
 */

public class Quiz {
    private int id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int rightAnswer;
    private int activityId;

    public Quiz(int id, String question, String answer1, String answer2,
                String answer3, String answer4, int rightAnswer, int activityId) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.rightAnswer = rightAnswer;
        this.activityId = activityId;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public int getActivityId() {
        return activityId;
    }

}

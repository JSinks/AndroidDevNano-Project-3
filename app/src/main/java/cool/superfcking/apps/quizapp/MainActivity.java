package cool.superfcking.apps.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResponses(View view){
        int totalScore = 0;
        totalScore += checkAnswerOne();
        totalScore += checkAnswerTwo();
        totalScore += checkAnswerThree();
        totalScore += checkAnswerFour();

        String outcome = buildResult(totalScore);
        displayMessage(outcome);
    }

    private int checkAnswerOne(){
        String responseText = "";

        RadioGroup questionOneResponse = (RadioGroup) findViewById(R.id.answer_q_1);
        if (questionOneResponse.getCheckedRadioButtonId() != -1) {
            RadioButton selectedResponse = (RadioButton) findViewById(questionOneResponse.getCheckedRadioButtonId());
            responseText = selectedResponse.getText().toString();
        }

        //Charlie is the company mascot
        if (responseText.equals("Charlie")){
            return 1;
        } else {
            return 0;
        }
    }

    private int checkAnswerTwo(){
        CheckBox questionTwoTim = (CheckBox) findViewById(R.id.answer_q_2_tim);
        CheckBox questionTwoMike = (CheckBox) findViewById(R.id.answer_q_2_mike);
        CheckBox questionTwoBrian = (CheckBox) findViewById(R.id.answer_q_2_brian);
        CheckBox questionTwoScott = (CheckBox) findViewById(R.id.answer_q_2_scott);

        //Mike and scott are the founders
        if ((questionTwoMike.isChecked() && questionTwoScott.isChecked()) &&
                !(questionTwoBrian.isChecked() && questionTwoTim.isChecked())) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkAnswerThree(){
        EditText questionThree = (EditText) findViewById(R.id.answer_q_3);
        String questionThreeResponse = questionThree.getText().toString().toLowerCase().trim();

        if (questionThreeResponse.equals("www.atlassian.com")) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkAnswerFour(){
        EditText questionFour = (EditText) findViewById(R.id.answer_q_4);
        String questionFourResponse = questionFour.getText().toString().toLowerCase().trim();

        if (questionFourResponse.equals("statuspage.io")) {
            return 1;
        } else {
            return 0;
        }
    }

    private String buildResult(int totalScore) {
        String message = "";

        message += "You scored " + totalScore + " out of 4!";

        if(totalScore <= 1){
            message += "\nBetter luck next time :'(";
        } else if (totalScore < 4) {
            message += "\nKeep up the good work :-)";
        } else {
            message += "\nYou're awesome :-D";
        }

        return message;
    }

    private void displayMessage(String message){
        Context context = getApplicationContext();

        CharSequence text = message;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

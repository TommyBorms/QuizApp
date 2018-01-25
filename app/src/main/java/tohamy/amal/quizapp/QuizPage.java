package tohamy.amal.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizPage extends AppCompatActivity {

    public static int result = 0;
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

    }



    private int answers()
    {
        RadioButton answerOne = findViewById(R.id.question1_choice3);
        RadioButton answerTwo = findViewById(R.id.question2_choice2);
        RadioButton answerThree = findViewById(R.id.question3_choice2);
        RadioButton answerFour = findViewById(R.id.question4_choice2);
        RadioButton answerFive = findViewById(R.id.question5_choice2);
        RadioButton answerSix = findViewById(R.id.question6_choice1);
        RadioButton answerSeven = findViewById(R.id.question7_choice2);
        RadioButton answerEight = findViewById(R.id.question8_choice3);
        RadioButton answerNine = findViewById(R.id.question9_choice1);
        CheckBox firstAnswerTen =  findViewById(R.id.question10_choice1);
        CheckBox secondAnswerTen = findViewById(R.id.qustion10_choice3);
        CheckBox secondChoiceTen = findViewById(R.id.question10_choice2);

        if (answerOne.isChecked())
        {
            result = result + 1;
        }

        if (answerTwo.isChecked())
        {
            result = result + 1;
        }

        if (answerThree.isChecked())
        {
            result = result + 1;
        }

        if(answerFour.isChecked())
        {
            result = result + 1;
        }

        if (answerFive.isChecked())
        {
            result = result + 1;
        }

        if (answerSix.isChecked())
        {
            result = result + 1;
        }

        if(answerSeven.isChecked())
        {
            result = result + 1;
        }

        if (answerEight.isChecked())
        {
            result = result + 1;
        }

        if (answerNine.isChecked())
        {
            result = result + 1;
        }

        if ((firstAnswerTen.isChecked() && secondAnswerTen.isChecked()) && (!secondChoiceTen.isChecked()))
        {
            result = result + 1;
        }

        return result;
    }

    public void summitAnswers(View view) {
        int finalResult = answers();

        EditText nameEditText = findViewById(R.id.name_edit_text);
        name = nameEditText.getText().toString();
        if(name.isEmpty())
        {
            Toast.makeText(this, "Please enter you name first", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, ResultPage.class);
            Resources resources = getResources();
            String key  = resources.getString(R.string.key_name);
            String keyResult = resources.getString(R.string.key_result);
            intent.putExtra(key, name);
            startActivity(intent);
            intent.putExtra(keyResult, finalResult);
            startActivity(intent);
        }
    }

}

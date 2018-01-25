package tohamy.amal.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    private String name;
    public String finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        name = bundle.getString(getResources().getString(R.string.key_name));
        finalResult =  bundle.getString(getResources().getString(R.string.key_result));
        setResult();

    }

    private void setResult()
    {
        ImageView resultImage = findViewById(R.id.result_image);
        TextView resultText = findViewById(R.id.result_text);
        TextView scoreResult = findViewById(R.id.score_text);
        if(QuizPage.result >= 5) {
            resultImage.setImageResource(R.drawable.happy);
            String winMsg = getString(R.string.you_win) + " " + name;
            resultText.setText(winMsg);
        }
        else if (QuizPage.result < 5)
        {
            resultImage.setImageResource(R.drawable.sad);
            String loseMsg = getString(R.string.you_lose) + " " + name;
            resultText.setText(loseMsg);
        }

        String resultMsg = QuizPage.result + "/10";
        scoreResult.setText(resultMsg);
    }

    public void exit(View view)
    {
        this.finishAffinity();
    }

    public void tryAgain(View view)
    {
        TextView resultText = findViewById(R.id.result_text);
        TextView scoreResult = findViewById(R.id.score_text);

        name = " ";
        QuizPage.result = 0;
        resultText.setText(" ");
        scoreResult.setText(" ");

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}

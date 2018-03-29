package codeclan.com.yatzee.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import codeclan.com.yatzee.R;

public class WelcomeActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void onWelcomeButtonClick(View clickView) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

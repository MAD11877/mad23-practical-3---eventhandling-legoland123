package sg.edu.np.mad.madpractical;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User myUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");
        myUser = new User("Walter Tan", "this is a random text that is not as distracting, unpopular oppinion thiem vs tsitpas thiem will win 10/10 ", 1, false);
        TextView wlctext = findViewById(R.id.textView);
        TextView longtext = findViewById(R.id.textView2);
        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("randomint");
        wlctext.setText(String.format("%s %s", myUser.name, message));
        longtext.setText(myUser.description);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume!");

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Follow Button is pressed");
                if (myUser.followed) {
                    myUser.followed = false;
                    myButton.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "UNFOLLWED", Toast.LENGTH_SHORT).show();
                }
                else {
                    myUser.followed = true;
                    myButton.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(), "FOLLOWED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button myButton2 = findViewById(R.id.button2);
        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Message Button is pressed");
                Intent activityName = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activityName);
            }

        });

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy!");
    }
}
package app.fisac.triporg;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
* mainproject class
* */
public class tc extends AppCompatActivity {

    FloatingActionButton ab;
    Button btnt;
    Button btnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ab=(FloatingActionButton)findViewById(R.id.about);
        btnd=(Button)findViewById(R.id.btnday);
        btnt=(Button)findViewById(R.id.btntrip);
        setTitle("Tripcount");
        OnClickButtonListener();
        OnButtonTransClicked();
        OnaboutClicked();
        /*
        Intent intent = new Intent(tc.this, LoginPage.class);
        startActivity(intent); 
        */

    }
    //dialog box to display aboutus
    public void OnaboutClicked(){
        ab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder adb=new AlertDialog.Builder(tc.this);
                        adb.setMessage("Thank you for using our App");
                        adb.setTitle("Trip Org");
                        adb.show();
                    }
                }
        );
    }

    //activity to add new trip
    public void OnClickButtonListener(){
        btnt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(tc.this,AddPlace.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }

    //function call for transactions with friends
    public void OnButtonTransClicked(){
        btnd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),Display_friend.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }

    //when back pressed to confirm whether accidently pressed or not
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        } else {
            Toast.makeText(this, "Press Back again to Exit",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}

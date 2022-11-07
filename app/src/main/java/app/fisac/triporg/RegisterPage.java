package app.fisac.triporg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    EditText email, password; 
    Button submit;
    DBHelper MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        submit = (Button) findViewById(R.id.submit);

        MyDB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emaill = email.getText().toString();
                String passwordd = password.getText().toString();
                

                if(emaill.equals("") || passwordd.equals(""))
                {
                    Toast.makeText(RegisterPage.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                   Boolean result = MyDB.checkemail(emaill);
                   if(result == false)
                   {
                       Boolean res = MyDB.insertData(emaill, passwordd);
                       if(res==true)
                       {
                           Toast.makeText(RegisterPage.this,"Registration Succesful!", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(), Vaccinatorr.class);
                           startActivity(intent);
                       }
                       else
                       {
                           Toast.makeText(RegisterPage.this,"Registration Failed!", Toast.LENGTH_SHORT).show();
                       }
                   }
                   else{
                       Toast.makeText(RegisterPage.this, "User already exists.\n Please Login", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                       startActivity(intent);
                   }

                }
            }
        });
    }



}

package coin.bit.shaareprepearencs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etName,etEmail;
Button saveBtn,retriveBtn,clearBtn;

    SharedPreferences sharedPreferences;
    public static final String name="namekey";
    public static final String email = "emailkey";
    public static final String file= "myfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=findViewById(R.id.editEmail);
        etName=findViewById(R.id.editName);

        saveBtn=findViewById(R.id.BtnSave);
        clearBtn=findViewById(R.id.BtnClear);
        retriveBtn=findViewById(R.id.BtnRetrive);

        sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(name))
        {
            etName.setText(sharedPreferences.getString(name,""));
        }

        if(sharedPreferences.contains(email))
        {
            etEmail.setText(sharedPreferences.getString(email,""));
        }



    }

    public void save(View view) {
        String getName = etName.getText().toString();
        String getEmail = etEmail.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(name,getName);
        editor.putString(email,getEmail);
        editor.commit();
    }

    public void Get(View view) {
        if(sharedPreferences.contains(name))
        {
            etName.setText(sharedPreferences.getString(name,""));
        }
        if(sharedPreferences.contains(email))
        {
            etEmail.setText(sharedPreferences.getString(email,""));
        }

    }

    public void clear(View view) {

        etEmail.setText("");
        etName.setText("");
    }
}

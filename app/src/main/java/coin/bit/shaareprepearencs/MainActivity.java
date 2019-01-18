package coin.bit.shaareprepearencs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail;
    Button saveBtn, retriveBtn, clearBtn;

    SharedPreferences sharedPreferences;
    public static final String name = "namekey";
    public static final String email = "emailkey";
    public static final String file = "myfile";
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkBox = findViewById(R.id.checkboxID);
        etEmail = findViewById(R.id.editEmail);
        etName = findViewById(R.id.editName);

        //  int a =  checkBox.setChecked(true);

        saveBtn = findViewById(R.id.BtnSave);
        clearBtn = findViewById(R.id.BtnClear);
        retriveBtn = findViewById(R.id.BtnRetrive);

        sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(name)) {
            etName.setText(sharedPreferences.getString(name, ""));
        }
        else
        {
            startActivity(new Intent(this,login.class));
        }

        if (sharedPreferences.contains(email)) {
            etEmail.setText(sharedPreferences.getString(email, ""));
        }
    }

    public void save(View view) {
        String getName = etName.getText().toString();
        String getEmail = etEmail.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(name, getName);
        editor.putString(email, getEmail);
        editor.commit();
    }

    public void Get(View view) {
        if (sharedPreferences.contains(name)) {
            etName.setText(sharedPreferences.getString(name, ""));
        }
        if (sharedPreferences.contains(email)) {
            etEmail.setText(sharedPreferences.getString(email, ""));
        }

    }

    public void clear(View view) {
sharedPreferences.edit().clear().commit();
       /* etEmail.setText("");
        etName.setText("");*/
    }
}

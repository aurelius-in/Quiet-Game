import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get references to the UI elements
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);

        // Set an OnClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the username and password are valid
                if (isValidCredentials()) {
                    // If the credentials are valid, start the MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // If the credentials are not valid, show an error message
                    Toast.makeText(LoginActivity.this, R.string.login_failed_message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Check if the username and password are valid
    private boolean isValidCredentials() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if the username and password are not empty
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return false;
        }

        // Check if the username and password match the saved credentials
        return username.equals(Constants.DEFAULT_USERNAME) && password.equals(Constants.DEFAULT_PASSWORD);
    }
}

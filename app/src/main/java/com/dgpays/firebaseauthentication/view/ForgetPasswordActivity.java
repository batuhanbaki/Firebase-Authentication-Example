package com.dgpays.firebaseauthentication.view;


import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.dgpays.firebaseauthentication.databinding.ActivityForgetPasswordBinding;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {
    ActivityForgetPasswordBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener((v -> finish()));

        binding.resetBtn.setOnClickListener(v -> {
            if (!binding.username.getText().toString().equals("") && binding.username.getText().length() > 5) {
                String emailAddress = "user@example.com";
                FirebaseAuth.getInstance().sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Şifre sıfırlama maili başarıyla gönderildi!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                try {
                                    Toast.makeText(this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                binding.username.setError("Zorunlu alan!");
                Toast.makeText(ForgetPasswordActivity.this, "Zorunlu alanları doldurunuz!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

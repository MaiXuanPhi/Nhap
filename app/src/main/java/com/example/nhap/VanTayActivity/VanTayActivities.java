package com.example.nhap.VanTayActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Toast;

import com.example.nhap.MainActivity;
import com.example.nhap.R;

import java.util.concurrent.Executor;

public class VanTayActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_tay_activities);

        Executor executor = ContextCompat.getMainExecutor(this);

//        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor,
//                new BiometricPrompt.AuthenticationCallback() {
//            @Override
//            public void onAuthenticationSucceeded(
//                    @NonNull BiometricPrompt.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//                Toast.makeText(VanTayActivities.this, "Xác thực sinh trắc thành công", Toast.LENGTH_LONG).show(); }
//                @Override
//                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
//                    super.onAuthenticationError(errorCode, errString);
//                    Toast.makeText(VanTayActivities.this, errString, Toast.LENGTH_LONG).show();
//                    VanTayActivities.this.finish();
//            }
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed(); Toast.makeText(VanTayActivities.this, "Xác thực không thành công", Toast.LENGTH_LONG).show();
//            } });
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor,
                new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        Toast.makeText(VanTayActivities.this, "Xac thuc thanh cong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                        Toast.makeText(VanTayActivities.this, "Xac thuc that bai", Toast.LENGTH_SHORT).show();
                    }
                });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Xác thực người dùng")
                .setDescription("Quét vân tay để xác thực danh tính của bạn")
                .setNegativeButtonText("Thoát") .build();
        biometricPrompt.authenticate(promptInfo);
    }
}
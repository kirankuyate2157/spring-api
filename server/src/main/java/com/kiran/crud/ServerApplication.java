package com.kiran.crud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        try {
            String firebaseConfig = System.getenv("FIREBASE_CONFIG");
            if (firebaseConfig == null) {
                throw new IllegalArgumentException("Environment variable FIREBASE_CONFIG is not set.");
            }

            InputStream serviceAccount = new ByteArrayInputStream(Base64.getDecoder().decode(firebaseConfig));

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SpringApplication.run(ServerApplication.class, args);
    }
}

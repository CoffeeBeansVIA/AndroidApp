package com.example.smartfarmandroidapp.MVVM.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartfarmandroidapp.R;
//import com.facebook.AccessToken;
//import com.facebook.CallbackManager;
//import com.facebook.FacebookCallback;
//import com.facebook.FacebookException;
//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;
//import com.facebook.login.LoginResult;
//import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

//    private LoginButton loginButton;
//
//    private static final int SIGN_IN = 42;
//
//    private FirebaseAuth mAuth;
//    private CallbackManager mCallbackManager;
//
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    private static final String TAG = "LoginActivity";
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        FirebaseApp.initializeApp(this);
//
//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//        mCallbackManager = CallbackManager.Factory.create();
//
//        setContentView(R.layout.activity_login);
//        initializeFragmentsValues();
//
//        Log.d(TAG, "onCreate was called");
//    }
//
//    private void initializeFragmentsValues() {
//        loginButton = (LoginButton) findViewById(R.id.button_sign_in);
//
//        loginButton.setPermissions("email", "public_profile");
//        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Log.d(TAG, "facebook:onSuccess:" + loginResult);
//                handleFacebookAccessToken(loginResult.getAccessToken());
//            }
//
//            @Override
//            public void onCancel() {
//                Log.d(TAG, "facebook:onCancel");
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Log.d(TAG, "facebook:onError", error);
//            }
//        });
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // Check if user is signed in (non-null) and update UI accordingly.
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = mAuth.getCurrentUser();
//
//                if (user != null) {
//                    Log.d("state", " = definitely signed out");
//                    updateUI(user);
//                } else {
//                    Log.d("state", " = definitely signed in");
//                }
//            }
//        };
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    private void goToMainActivity() {
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
//    }
//
//    public void signIn(View v) {
//        List<AuthUI.IdpConfig> providers = Arrays.asList(
//                new AuthUI.IdpConfig.FacebookBuilder().build());
//
//        Intent signInIntent = AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAvailableProviders(providers)
//                .setLogo(R.mipmap.ic_launcher)
//                .build();
//
//        startActivityForResult(signInIntent, SIGN_IN);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == SIGN_IN) {
//            handleSignInRequest(resultCode);
//        }
//        // Pass the activity result back to the Facebook SDK
//        mCallbackManager.onActivityResult(requestCode, resultCode, data);
//    }
//
//    private void handleSignInRequest(int resultCode) {
//        if (resultCode == RESULT_OK)
//            goToMainActivity();
//        else
//            Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
//    }
//
//    private void handleFacebookAccessToken(AccessToken token) {
//        Log.d(TAG, "handleFacebookAccessToken:" + token);
//
//        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//    }
//
//    private void updateUI(FirebaseUser user) {
//        goToMainActivity();
//    }
//
//    public void signOut() {
//        FirebaseAuth.getInstance().signOut();
//    }

    private static final int SIGN_IN = 42;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkIfSignedIn();
        setContentView(R.layout.activity_login);
    }

    private void checkIfSignedIn() {

        // FirebaseApp is not initialized in this process - Error #1
        Log.d(TAG, "Verifying if the default FirebaseApp was initialized.");
        if(FirebaseApp.getInstance() == null) {
            Log.d(TAG, "Initializing the default FirebaseApp ");
            FirebaseApp.initializeApp(this);
        }
        //TODO FUCKING HELL IT DOES NOT WORK
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            goToMainActivity();
        }
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, DrawerActivity.class));
        finish();
    }

    public void signIn(View v) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.mipmap.ic_launcher)
                .build();

        startActivityForResult(signInIntent, SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN) {
            handleSignInRequest(resultCode);
        }
    }

    private void handleSignInRequest(int resultCode) {
        if (resultCode == RESULT_OK)
            goToMainActivity();
        else
            Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
    }
}

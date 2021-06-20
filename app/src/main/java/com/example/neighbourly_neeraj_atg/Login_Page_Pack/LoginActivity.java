package com.example.neighbourly_neeraj_atg.Login_Page_Pack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.neighbourly_neeraj_atg.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {


    private SignInButton googleSigninbtn;
    private int RC_SIGN_IN = 1;
    private GoogleSignInClient getSignInIntent;
    private GoogleSignInClient googleSignInClient;
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.neighbourly_neeraj_atg.R.layout.activity_login);

        googleSigninbtn = findViewById(com.example.neighbourly_neeraj_atg.R.id.google_button);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){

//                    Toast.makeText(login_activity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }

            }
        };


        GoogleSignInOptions googleSignInOptions  = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(com.example.neighbourly_neeraj_atg.R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = (GoogleSignInClient) GoogleSignIn.getClient(this,googleSignInOptions);

        googleSigninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SigIn();

            }
        });


    }


    private void SigIn(){
        Intent GsignIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(GsignIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                handleSignInResult(task);
            }
            catch (Exception e){
            }
        }



    }
    private void handleSignInResult(Task <GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText( LoginActivity.this,"Signed In Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);

        }
        catch (ApiException e){
            Toast.makeText( LoginActivity.this,"Signed In Failed", Toast.LENGTH_SHORT).show();

        }
    }

    private void FirebaseGoogleAuth (GoogleSignInAccount acct){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        mFirebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    FirebaseUser user = mFirebaseAuth.getCurrentUser();
                    String  emailS = user.getEmail();
                    String uid = user.getUid();
                    String image = user.getPhotoUrl().toString();
                    String displayS = user.getDisplayName();
                    String location = "Not Available";
                    if (task.getResult().getAdditionalUserInfo().isNewUser()) {


                        HashMap<String, String> hashmapbasic = new HashMap<>();
                        hashmapbasic.put("name",displayS);
                        hashmapbasic.put("email", emailS);
                        hashmapbasic.put("image", image);
                        hashmapbasic.put("uid", uid);
                        hashmapbasic.put("location", location);



                        DatabaseReference db_ref = FirebaseDatabase.getInstance().getReference();

                        db_ref.child("Users").child(emailS).setValue(hashmapbasic);


                    }

                    Toast.makeText(LoginActivity.this, "User Signed In", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);

    }


}
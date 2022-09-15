package com.example.letschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.letschat.databinding.ActivityChatDetailBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChatDetailActivity extends AppCompatActivity {
    ActivityChatDetailBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);
        binding= ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        database= FirebaseDatabase.getInstance();
        auth= FirebaseAuth.getInstance();

        final String senderId= auth.getUid();
        String recieverId= getIntent().getStringExtra("userId");
        String userName= getIntent().getStringExtra("userName");
        String profilePic= getIntent().getStringExtra("profilePic");

        binding.userName.setText(userName);


        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ChatDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
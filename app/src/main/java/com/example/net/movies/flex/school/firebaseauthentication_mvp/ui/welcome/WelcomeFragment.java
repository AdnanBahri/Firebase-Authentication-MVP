package com.example.net.movies.flex.school.firebaseauthentication_mvp.ui.welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.net.movies.flex.school.firebaseauthentication_mvp.R;
import com.example.net.movies.flex.school.firebaseauthentication_mvp.databinding.FragmentWelcomeBinding;
import com.example.net.movies.flex.school.firebaseauthentication_mvp.ui.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;


public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    private NavController controller;

    private FirebaseAuth auth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null)
            startActivity((new Intent(getContext(), HomeActivity.class)).putExtra("user",auth.getCurrentUser()));
        else
            Toast.makeText(getContext(), "No User yet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentWelcomeBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller= Navigation.findNavController(view);
        binding
                .btnGetStarted
                .setOnClickListener(v-> controller.navigate(R.id.action_welcomeFragment_to_registerFragment));
        binding
                .btnSignIn
                .setOnClickListener(v-> controller.navigate(R.id.action_welcomeFragment_to_loginFragment));
    }
}
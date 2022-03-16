package com.example.net.movies.flex.school.firebaseauthentication_mvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.net.movies.flex.school.firebaseauthentication_mvp.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    private NavController controller;

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
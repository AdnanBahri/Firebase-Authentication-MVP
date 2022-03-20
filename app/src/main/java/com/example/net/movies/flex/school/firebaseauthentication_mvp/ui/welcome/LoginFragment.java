package com.example.net.movies.flex.school.firebaseauthentication_mvp.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.net.movies.flex.school.firebaseauthentication_mvp.databinding.FragmentLoginBinding;
import com.example.net.movies.flex.school.firebaseauthentication_mvp.ui.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);

        binding.btnSignIn.setOnClickListener(v -> Login());
    }

    private void Login() {
        String email = binding.inputEmail.getText().toString();
        String password = binding.inputPassword.getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(
                email,
                password
        ).addOnCompleteListener(
                task -> {
                    if (task.isSuccessful())
                        startActivity((new Intent(getContext(), HomeActivity.class)).putExtra("user", auth.getCurrentUser()));
                    else
                        Toast.makeText(getContext(), "User " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                });

    }
}
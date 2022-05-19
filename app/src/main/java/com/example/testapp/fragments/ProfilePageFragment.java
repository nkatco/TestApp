package com.example.testapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testapp.MainActivity;
import com.example.testapp.R;

public class ProfilePageFragment extends Fragment {

    private TextView UserNicknameProfile, UserLoginProfile;
    private ImageView ProfileIconImageView;
    private Button leaveButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_page, container, false);

        UserNicknameProfile = v.findViewById(R.id.UserNicknameProfile);
        UserLoginProfile = v.findViewById(R.id.UserLoginProfile);
        ProfileIconImageView = v.findViewById(R.id.ProfileIconImageView);
        leaveButton = v.findViewById(R.id.LeaveButton);

        UserNicknameProfile.setText(String.valueOf(MainActivity.user.getNickname()));
        UserLoginProfile.setText(String.valueOf(MainActivity.user.getLogin()));
        int imageId = getContext().getResources().getIdentifier("avatar_icon", "drawable", getContext().getPackageName());
        ProfileIconImageView.setImageResource(imageId);

        leaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        return v;
    }
}

package com.learn.shreesarasvatisisumandeer.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.learn.shreesarasvatisisumandeer.R;

public class SignInFragment extends Fragment {

    Context context;
    Button mButtonGetOtp;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_sign_in, container, false);


        mButtonGetOtp = root.findViewById(R.id.sign_in_btn_get_otp);
        mButtonGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtpVarificationFragment fragment = new OtpVarificationFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.commit();

            }
        });
        return root;
    }
}

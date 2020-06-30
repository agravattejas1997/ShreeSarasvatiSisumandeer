package com.learn.shreesarasvatisisumandeer.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.learn.shreesarasvatisisumandeer.Activity.HomeActivity;
import com.learn.shreesarasvatisisumandeer.R;

import static android.content.Context.MODE_PRIVATE;
import static com.learn.shreesarasvatisisumandeer.Activity.HomeActivity.HOME_ACTIVITY;

public class SignInFragment extends Fragment {


    SharedPreferences mSharedPreferencesSignIn;
    SharedPreferences.Editor mEditorSignIn;
    Context context;
    View root;
    EditText mEditTextPhoneNo;
    Button mButtonGetOtp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferencesSignIn = HOME_ACTIVITY.getSharedPreferences("SIGN_IN", MODE_PRIVATE);

        mEditorSignIn = mSharedPreferencesSignIn.edit();

    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_sign_in, container, false);
        context = container.getContext();

        mButtonGetOtp = root.findViewById(R.id.sign_in_btn_get_otp);
        mEditTextPhoneNo = root.findViewById(R.id.sign_in_ed_phone_number);

        mButtonGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mEditTextPhoneNo.getText().toString().equals("")) {
                    mEditTextPhoneNo.setError("Please Input Phone Number");
                } else {
                    if (mEditTextPhoneNo.getText().toString().length()!= 10) {
                        mEditTextPhoneNo.setError("Please Input 10 Digit Number");
                    }
                    if (mEditTextPhoneNo.getText().toString().length()==10)
                    {

                        mEditorSignIn.putString("sign_in_phone_no","+91 "+mEditTextPhoneNo.getText().toString());
                        mEditorSignIn.putBoolean("sign_in",true);
                        mEditorSignIn.commit();

                        changeFragment();
                    }

                }


            }
        });
        return root;
    }

    private void changeFragment() {
        OtpVarificationFragment fragment = new OtpVarificationFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.commit();

    }
}

package org.o7planning.giuaky_221121514234.ui.Day2_Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private FragmentLoginBinding binding;
    private EditText edUser;
    private EditText edPassword;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        edUser = binding.edUser;
        edPassword = binding.edPassword;

        binding.btLogin.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btLogin){
            onLogin();
        }
    }

    private void onLogin(){
        String user = edUser.getText().toString().trim();
        String password = edPassword.getText().toString().trim();

        if (user.isEmpty() || password.isEmpty()){
            Toast.makeText(requireContext(),"Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            if (user.equals("admin") && password.equals("123")) {
                Bundle bundle = new Bundle();
                bundle.putString("USER_NAME", user);

                NavController navController = NavHostFragment.findNavController(this);
                navController.navigate(R.id.action_nav_day2_activity_login_to_nav_day2_activity_profile, bundle);
            } else {
                Toast.makeText(requireContext(), "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}

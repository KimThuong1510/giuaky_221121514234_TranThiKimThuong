package org.o7planning.giuaky_221121514234.ui.Day2_Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment implements  View.OnClickListener{
    private FragmentProfileBinding binding;
    private TextView tvUser;
    private static final int REQUEST_CODE = 1;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tvUser = binding.tvUserName;

        if (getArguments() != null){
            String user = getArguments().getString("USER_NAME");
            tvUser.setText(user);
        }
        binding.btEdit.setOnClickListener(this);

        getParentFragmentManager().setFragmentResultListener("edit_request_key",getViewLifecycleOwner(),(requestKey,bundle)->{
            String result = bundle.getString("RESULT");
            if (result != null){
                tvUser.setText(result);
            }
        });
        return root;
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btEdit){
            onEdit();
        }
    }
    private void onEdit(){
        Bundle bundle = new Bundle();
        bundle.putString("USER_NAME",tvUser.getText().toString());

        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_nav_day2_activity_profile_to_nav_day2_activity_edit_user,bundle);
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}

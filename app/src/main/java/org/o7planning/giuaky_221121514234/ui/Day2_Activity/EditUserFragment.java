package org.o7planning.giuaky_221121514234.ui.Day2_Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.databinding.FragmentEditUserBinding;


public class EditUserFragment extends Fragment implements View.OnClickListener {
    private FragmentEditUserBinding binding;
    private EditText edUser;
    private Button btDone;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        edUser = binding.edUser;
        btDone = binding.btDone;
        btDone.setOnClickListener(this);

        String username = getArguments().getString("USER_NAME");
        edUser.setText(username);
        return root;
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btDone){
            onDone();
        }
    }
    private void onDone() {
        String user = edUser.getText().toString().trim();

        Bundle result = new Bundle();
        result.putString("RESULT", user);

        getParentFragmentManager().setFragmentResult("edit_request_key", result);
        requireActivity().getSupportFragmentManager().popBackStack();
    }
}
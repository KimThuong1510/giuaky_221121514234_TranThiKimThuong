package org.o7planning.giuaky_221121514234.ui.Day2_ListView_Advanced;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.databinding.FragmentListviewAdvancedBinding;
import org.o7planning.giuaky_221121514234.ui.Day2_ListView.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdvancedFragment extends Fragment implements IOnChildItemClick {

    private FragmentListviewAdvancedBinding binding;
    private List<ContactModel> listContact;
    private ContactAdapter mAdapter;

    public ListViewAdvancedFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListviewAdvancedBinding.inflate(inflater, container, false);

        initData();
        initView();

        return binding.getRoot();
    }

    private void initView() {
        mAdapter = new ContactAdapter(requireContext(), listContact);
        binding.lvContact.setAdapter(mAdapter);
        mAdapter.registerChildItemClick(this);

        binding.lvContact.setOnItemClickListener((parent, view, position, id) -> {
            ContactModel model = listContact.get(position);
            Toast.makeText(requireContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initData() {
        listContact = new ArrayList<>();
        listContact.add(new ContactModel("Nguyễn Đình Việt", "0123456789", R.drawable.anh_1));
        listContact.add(new ContactModel("Trần Thị Kim Thương", "0123456789", R.drawable.anh_2));
        listContact.add(new ContactModel("Trần Võ Thiên Anh", "0123456789", R.drawable.anh_3));
        listContact.add(new ContactModel("Nguyễn Đình Cảnh", "0123456789", R.drawable.anh_4));
        listContact.add(new ContactModel("Nguyễn Hoàng Duy", "0123456789", R.drawable.anh_5));
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContact.get(position);
        binding.ivUser.setImageResource(contact.getImage());
        binding.tvName.setText(contact.getName());
    }

    @Override
    public void onCallClick(ContactModel contact) {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone()));
        startActivity(intent);
    }

    @Override
    public void onEditClick(ContactModel contact) {
        binding.ivUser.setImageResource(contact.getImage());
        binding.tvName.setText(contact.getName());
        Toast.makeText(requireContext(), "Đã cập nhật thông tin!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mAdapter != null) {
            mAdapter.unRegisterChildItemClick();
        }
        binding = null;
    }
}

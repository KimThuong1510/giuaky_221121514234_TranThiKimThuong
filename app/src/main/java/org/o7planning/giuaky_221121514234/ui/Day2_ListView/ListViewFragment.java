package org.o7planning.giuaky_221121514234.ui.Day2_ListView;

import android.widget.ImageView;
import android.widget.ListView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.databinding.FragmentListviewBinding;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {
    private FragmentListviewBinding binding;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        binding = FragmentListviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initData();
        initView();

        mAdapter = new ContactAdapter(requireContext(), listContact);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContact.get(position);
                Toast.makeText(requireContext(), model.getName() + ": " +model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
    private void initView(){
        lvContact = binding.lvContact;
    }
    private void initData() {;
        listContact.add(new ContactModel("Nguyễn Đình Việt", "0123456789", R.drawable.anh_1));
        listContact.add(new ContactModel("Trần Thị Kim Thương", "0123456789", R.drawable.anh_2));
        listContact.add(new ContactModel("Trần Võ Thiên Anh", "0123456789", R.drawable.anh_3));
        listContact.add(new ContactModel("Nguyễn Đình Cảnh", "0123456789", R.drawable.anh_4));
        listContact.add(new ContactModel("Nguyễn Hoàng Duy", "0123456789", R.drawable.anh_5));
        listContact.add(new ContactModel("Nguyễn Văn A", "0123456789", R.drawable.anh_3));
        listContact.add(new ContactModel("Nguyễn Văn B", "0123456789", R.drawable.anh_2));
        listContact.add(new ContactModel("Nguyễn Văn C", "0123456789", R.drawable.anh_1));


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}

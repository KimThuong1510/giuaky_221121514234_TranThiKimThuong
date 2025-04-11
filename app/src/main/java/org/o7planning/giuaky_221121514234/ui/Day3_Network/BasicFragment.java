package org.o7planning.giuaky_221121514234.ui.Day3_Network;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.o7planning.giuaky_221121514234.databinding.FragmentNetworkBasicBinding;
import org.o7planning.giuaky_221121514234.ui.Day3_Network.model.Item;
import org.o7planning.giuaky_221121514234.ui.Day3_Network.network.APIManager;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicFragment extends Fragment {
    private FragmentNetworkBasicBinding binding;
    private TextView tvDate, tvTitle, tvContent;
    private ImageView ivCover;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNetworkBasicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initView();
        getData();
        return root;
    }
    private void initView(){
        tvDate = binding.tvDate;
        tvTitle = binding.tvTitle;
        tvContent = binding.tvContent;
        ivCover = binding.ivCover;
    }
    private void getData(){
        APIManager.apiService.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() == null){
                    return;
                }
                List<Item> models = response.body();
                Item model = models.get(0);

                tvDate.setText(model.getDate());
                tvTitle.setText(model.getTitle());
                tvContent.setText(model.getDescription());

                Glide.with(BasicFragment.this)
                        .load(model.getImage())
                        .into(ivCover);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("Day3_Network_Basic", "onFailure: " + t);
            }
        });
    }
}

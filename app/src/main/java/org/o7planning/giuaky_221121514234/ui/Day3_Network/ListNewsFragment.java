package org.o7planning.giuaky_221121514234.ui.Day3_Network;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.giuaky_221121514234.databinding.FragmentNetworkListnewsBinding;
import org.o7planning.giuaky_221121514234.ui.Day3_Network.adapter.NewsAdapter;
import org.o7planning.giuaky_221121514234.ui.Day3_Network.model.Item;
import org.o7planning.giuaky_221121514234.ui.Day3_Network.network.APIManager;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsFragment extends Fragment {
    private FragmentNetworkListnewsBinding binding;
    private RecyclerView rvListNews;
    private List<Item> listData;
    private NewsAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNetworkListnewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getListData();

        listData = new ArrayList<>();
        adapter = new NewsAdapter(requireActivity(),listData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false);

        rvListNews = binding.rvListNews;
        rvListNews.setLayoutManager(layoutManager);
        rvListNews.setAdapter(adapter);
        return root;
    }
    private void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() != null) {
                    listData = response.body();
                    adapter.reloadData(listData);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(requireActivity(), "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

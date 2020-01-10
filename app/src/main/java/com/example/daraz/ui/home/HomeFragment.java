package com.example.daraz.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daraz.R;
import com.example.daraz.Url.Url;
import com.example.daraz.adapter.ItemAdapter;
import com.example.daraz.adapter.SlideAdapter;
import com.example.daraz.api.ItemApi;
import com.example.daraz.model.Item;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
SliderView slide_image;
    private HomeViewModel homeViewModel;
    RecyclerView recycler_view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        slide_image = root.findViewById(R.id.slide_image);
        recycler_view = root.findViewById(R.id.recycler_view);

        final SlideAdapter adapter = new SlideAdapter(getContext());
        adapter.setCount(5);
        slide_image.setSliderAdapter(adapter);

        slide_image.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        slide_image.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        slide_image.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        slide_image.setIndicatorSelectedColor(Color.WHITE);
        slide_image.setIndicatorUnselectedColor(Color.GRAY);
        slide_image.startAutoCycle();

        getProduct();
        return root;

    }

        //set item list in recycler view
        //List<Item> itemList=new ArrayList<>();
        //itemList.add(new Item(R.drawable.imagesshopping1,"Item description",1200));
        //itemList.add(new Item(R.drawable.shoppingimages2,"Item description",1300));
        //itemList.add(new Item(R.drawable.shoppingimages3,"Item description",1400));
        //itemList.add(new Item(R.drawable.menclothing,"Item description",1500));

        //final ItemAdapter itemAdapter=new ItemAdapter(getContext(),itemList);
       // recycler_view.setAdapter(itemAdapter);
        //recycler_view.setLayoutManager(new GridLayoutManager(getActivity(),2));
        //return root;

        private void getProduct(){
            ItemApi productApi= Url.getInstance().create(ItemApi.class);
            Call<List<Item>> listCall= productApi.getProduct();
            listCall.enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

                    if(!response.isSuccessful()){
                        Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ItemAdapter itemAdapter=new ItemAdapter(getActivity(),response.body());
                    recycler_view.setAdapter(itemAdapter);
                    recycler_view.setHasFixedSize(true);
                    recycler_view.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    itemAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {

                    Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


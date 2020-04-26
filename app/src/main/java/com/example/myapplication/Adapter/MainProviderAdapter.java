package com.example.myapplication.Adapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Model.MainProvider;
import com.example.myapplication.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MainProviderAdapter extends RecyclerView.Adapter<MainProviderAdapter.Main_ProviderViewHolder> {
    ArrayList<MainProvider> mainproviders;

    public MainProviderAdapter(ArrayList<MainProvider> mainproviders) {
        this.mainproviders = mainproviders;
    }

    @NonNull
    @Override
    public Main_ProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_item,null,false);
        Main_ProviderViewHolder viewHolder=new Main_ProviderViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Main_ProviderViewHolder holder, int position) {
        MainProvider p = mainproviders.get(position);
        holder.bind(p);


    }
    @Override
    public int getItemCount() {
        return mainproviders.size();
    }
    class Main_ProviderViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_image;
        TextView tv_proudect, tv_shop;
        ViewPager mPager;
        int currentPage = 0;
        CircleIndicator indicator;
        MainProvider mainProvider;

        public Main_ProviderViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.img_show);
            tv_proudect = itemView.findViewById(R.id.txt_proudect_name);
            tv_shop = itemView.findViewById(R.id.txt_shop_name);
            mPager = (ViewPager) itemView.findViewById(R.id.pager);
            indicator = (CircleIndicator)itemView.findViewById(R.id.indicator);
            iv_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Toast.makeText(iv_image.getContext(), "hiii", Toast.LENGTH_SHORT).show();

                    PopupMenu popup = new PopupMenu(iv_image.getContext(), v);
                    popup.inflate(R.menu.popup_menu);
                    popup.show();
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            switch (item.getItemId()) {
                                case R.id.edit:
                                    Toast.makeText(iv_image.getContext(), "تعديل", Toast.LENGTH_SHORT).show();
                                    return true;
                                case R.id.delete:
                                    Toast.makeText(iv_image.getContext(), "حذف", Toast.LENGTH_SHORT).show();

                                    return true;
                            }
                            return false;
                        }
                    });

                }
            });
        }

        public void bind(final MainProvider main) {
            // iv_image.setImageResource(main.getMenu_img());
            tv_proudect.setText(main.getProudect_name());
            tv_shop.setText(main.getShop_name());
            mPager.setAdapter(new SliderAdapter(iv_image.getContext(), main.getMenu_img()));
            indicator.setViewPager(mPager);

            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage == main.getMenu_img().size()){
                        currentPage = 0;
                    }
                    mPager.setCurrentItem(currentPage++, true);

                }
            };
            mainProvider = main;

        }

    }
}
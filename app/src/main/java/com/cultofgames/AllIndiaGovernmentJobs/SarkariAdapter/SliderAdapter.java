package com.cultofgames.AllIndiaGovernmentJobs.SarkariAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

//import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;
import com.cultofgames.AllIndiaGovernmentJobs.R;
import com.cultofgames.AllIndiaGovernmentJobs.SarkariModal.Slider;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

   private ArrayList<Slider> list;
   private Context context;


    public SliderAdapter(ArrayList<Slider> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_layout, parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

   Slider slider=     list.get(position);


        Glide.with(context)
                .load(slider.getImageUrl())
                .into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(v -> {


           // Toast.makeText(context, ""+slider.getImageUrl(), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(slider.getImageLink()));
            context.startActivity(i);
        });

    }

    @Override
    public int getCount() {
        return list.size();
    }

    public class SliderViewHolder extends ViewHolder {
        ImageView imageView;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_auto_image_slider);
        }
    }
}

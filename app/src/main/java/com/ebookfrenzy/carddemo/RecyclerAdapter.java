package com.ebookfrenzy.carddemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"President and Vice-President of the United States",
            "Governor",
            "United States Senator",
            "Representative in Congress",
            "Executive Councillor",
            "State Senator",
            "State Representative Rockingham District 25",
            "State Representative Rockingham District 30"};

    private String[] details = {"Joseph R. Biden  Kamala D. Harris",
            "Jo Jorgensen  Jeremy Cohen",
            "Donald J. Trump  Michael R. Pence",
            "Item Four details",
            "Item Five details",
            "Item Six details",
            "Item Seven details",
            "Item Eight details",
    };
    private int[] images = {
            R.drawable.archie_button,
            R.drawable.betty_button,
            R.drawable.jughead_button,
            R.drawable.veronica_button,
            R.drawable.cheryl_banner,
            R.drawable.kevin_banner,
            R.drawable.reggie_banner,
            R.drawable.sabrina_banner1
    };


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                int position = getAdapterPosition() ;

                Snackbar.make(v,"Click detected on item " + (position +1),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}


package com.example.mitchell.navigationdrawer;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mitchell on 8/04/2015.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();

    public InformationAdapter(Context context, List<Information> data)
    {
        inflater = LayoutInflater.from(context);
        this.data=data;
    }

    //Called every time a new row needs to be displayed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       //Get current information object form list of data
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);


        //Listener for when item is clicked on
       /* holder.icon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), "Item clicked at "+position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item clicked at "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}

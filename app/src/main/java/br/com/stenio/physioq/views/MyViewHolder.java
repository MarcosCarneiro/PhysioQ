package br.com.stenio.physioq.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.interfaces.RecyclerViewOnClickListener;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView item_category_textView;
    public ImageView ivCar;
    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);
        item_category_textView = (TextView) itemView.findViewById(R.id.category_textView);
        ivCar = (ImageView) itemView.findViewById(R.id.iv_car);
        item_category_textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mRecyclerViewOnClickListener != null) {
            mRecyclerViewOnClickListener.onClickListener(getAdapterPosition());
        }
    }
}

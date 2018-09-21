package io.github.dalwadi2.techround.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.dalwadi2.techround.BR;
import io.github.dalwadi2.techround.R;
import io.github.dalwadi2.techround.databinding.RowProductBinding;
import io.github.dalwadi2.techround.models.RespProducts;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private Context mContext;
    private List<RespProducts> modelList;
    private Picasso picasso;

    private OnItemClickListener mItemClickListener;


    public ProductListAdapter(Context context, Picasso picasso) {
        this.mContext = context;
        this.picasso = picasso;
    }

    public void updateList(List<RespProducts> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.row_product, viewGroup, false);

        return new ProductListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        RespProducts model = modelList.get(position);

        holder.getmBinding().setVariable(BR.product, model);
        holder.getmBinding().executePendingBindings();

        picasso.load(model.getImageUrl())
                .error(R.mipmap.ic_launcher_round)
                .into(holder.getmBinding().imgProduct);
    }


    @Override
    public int getItemCount() {
        return modelList == null ? 0 : modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private RespProducts getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, RespProducts model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RowProductBinding mBinding;

        ViewHolder(final View itemView) {
            super(itemView);

            mBinding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition()
                            , modelList.get(getAdapterPosition()));
                }
            });
        }

        RowProductBinding getmBinding() {
            return mBinding;
        }

    }

}


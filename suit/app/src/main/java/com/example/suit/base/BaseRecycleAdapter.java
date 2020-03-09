package com.example.suit.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suit.adapter.OnItemClickListener;

import java.util.List;

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseRecycleAdapter.BaseViewHolder> {
    protected List<T> mDatas;
    protected Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public BaseRecycleAdapter(List<T> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public BaseRecycleAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(getItemLayout(), parent, false);
        BaseViewHolder holder = new BaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecycleAdapter.BaseViewHolder holder, final int position) {
        bindData(holder, mDatas.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, position);
                }
            }
        });
    }

    abstract protected int getItemLayout();
    abstract protected void bindData(BaseViewHolder holder, T data);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void updateList(List<T> newDatas) {
        mDatas.clear();
        mDatas.addAll(newDatas);
        notifyDataSetChanged();
    }

    //设置监听的执行者
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    protected class BaseViewHolder extends RecyclerView.ViewHolder {
        SparseArray<View> views;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            views = new SparseArray<>();
        }

        public View getViewById(int id) {
            View view = views.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                views.append(id, view);
            }
            return view;
        }
    }

}

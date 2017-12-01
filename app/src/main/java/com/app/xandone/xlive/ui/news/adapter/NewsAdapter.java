package com.app.xandone.xlive.ui.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.xandone.xlive.R;
import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.model.bean.news.NewsSummary;

import java.util.List;

import butterknife.ButterKnife;

/**
 * author: xandone
 * created on: 2017/11/29 9:47
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsSummary> list;

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_PHOTO = 1;

    public NewsAdapter(List list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL) {
            View view = LayoutInflater.from(App.getInstance()).inflate(R.layout.item_news_normal, parent, false);
            return new NormalHolder(view);
        } else {
            View view = LayoutInflater.from(App.getInstance()).inflate(R.layout.item_news_photo, parent, false);
            return new PhotoHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalHolder) {
            NormalHolder normalHolder = (NormalHolder) holder;
            normalHolder.bindView(position);
        } else if (holder instanceof PhotoHolder) {
            PhotoHolder normalHolder = (PhotoHolder) holder;
            normalHolder.bindView(position);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (!TextUtils.isEmpty(list.get(position).getDigest())) {
        if (!TextUtils.isEmpty(list.get(position).getT1348649145984().get(position).getDigest())) {
            return TYPE_NORMAL;
        } else {
            return TYPE_PHOTO;
        }
    }

    class NormalHolder extends RecyclerView.ViewHolder {

        public NormalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(int position) {

        }
    }

    class PhotoHolder extends RecyclerView.ViewHolder {

        public PhotoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(int position) {

        }
    }
}

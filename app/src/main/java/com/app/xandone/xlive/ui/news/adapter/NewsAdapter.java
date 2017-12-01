package com.app.xandone.xlive.ui.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.xandone.xlive.R;
import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.utils.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: xandone
 * created on: 2017/11/29 9:47
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsSummary.T1348649145984Bean> list;

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
        if (!TextUtils.isEmpty(list.get(position).getDigest())) {
            return TYPE_NORMAL;
        } else {
            return TYPE_PHOTO;
        }
    }

    class NormalHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_news_image)
        ImageView img;
        @BindView(R.id.item_news_title_tv)
        TextView tvTitle;
        @BindView(R.id.item_news_content_tv)
        TextView tvContent;
        @BindView(R.id.item_news_date_tv)
        TextView tvDate;

        public NormalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(int position) {
            NewsSummary.T1348649145984Bean bean = list.get(position);
            if (bean != null) {
                tvTitle.setText(bean.getTitle());
                tvContent.setText(bean.getDigest());
                tvDate.setText(bean.getMtime());
                ImageLoader.display(App.getInstance(), img, bean.getImgsrc());
            }

        }
    }

    class PhotoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_title)
        TextView tvTitle;
        @BindView(R.id.photo_img)
        ImageView img;

        public PhotoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(int position) {
            NewsSummary.T1348649145984Bean bean = list.get(position);
            if (bean != null) {
                tvTitle.setText(bean.getTitle());
                ImageLoader.display(App.getInstance(), img, bean.getImgsrc());
            }

        }
    }
}

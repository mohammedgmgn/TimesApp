package com.mahmoud.mohammed.timesapp.presentation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.mahmoud.mohammed.timesapp.R;
import com.mahmoud.mohammed.timesapp.data.models.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TimesAdapter extends RecyclerView.Adapter<TimesAdapter.ArticlesViewHolder> {
    @Inject
    Picasso picasso;
    @Inject
    Context context;
    private List<Article> articles = new ArrayList<>();
    private ItemClickListener<Article> itemClickListener;
    private int lastPosition = -1;

    @Inject
    public TimesAdapter() {

    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticlesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.bindViews(article);
        setAnimation(holder.itemView, position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    public void updateTimes(List<Article> articles) {
        this.articles.clear();
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }

    public void setItemClickListenr(ItemClickListener<Article> itemClickListenr) {
        this.itemClickListener = itemClickListenr;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ArticlesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        public TextView tvTitle;
        @BindView(R.id.image)
        public CircleImageView image;
        @BindView(R.id.created_by)
        public TextView tvCreatedBy;
        @BindView(R.id.source)
        public TextView tvSource;
        @BindView(R.id.date)
        public TextView tvDate;

        public ArticlesViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(getAdapterPosition(), articles.get(getAdapterPosition()));
                }
            });

        }

        void bindViews(Article article) {
            tvTitle.setText(article.getTitle());
            tvCreatedBy.setText(article.getByline());
            tvSource.setText(article.getSource());
            tvDate.setText(article.getPublishedDate());
            picasso.load(article.getMedia().get(0).getMediaMetadata().get(0).getUrl()).into(image);

        }
    }


}



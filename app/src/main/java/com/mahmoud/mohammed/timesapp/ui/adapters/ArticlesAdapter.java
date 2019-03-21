package com.mahmoud.mohammed.timesapp.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    @Inject
    Picasso picasso;

    private List<Article> articles = new ArrayList<>();
    private ItemClickListener<Article> itemClickListener;

    @Inject
    public ArticlesAdapter() {

    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticlesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvCreatedBy.setText(article.getByline());
        holder.tvSource.setText(article.getSource());
        holder.tvDate.setText(article.getPublishedDate());
        picasso.load(article.getMedia().get(0).getMediaMetadata().get(2).getUrl()).into(holder.image);
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(getAdapterPosition(), articles.get(getAdapterPosition()));
                    }
                }
            });

        }
    }


}




package com.example.secondnewsappmvp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.secondnewsappmvp.R;
import com.example.secondnewsappmvp.model.ArticlesItem;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private final List<ArticlesItem> articlesItemList;
    private final Context context;

    public ArticleListAdapter(
            List<ArticlesItem> articlesItemList,
            Context context,
            RecyclerViewInterface recyclerViewInterface
    ) {
        this.articlesItemList = articlesItemList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_article_row,
                        parent,
                        false
                );
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (articlesItemList.get(position).getTitle() != null) {
            holder.articleHeading.setText(articlesItemList.get(position).getTitle());
            holder.articleAuthor.setText("Author: " + articlesItemList.get(position).getAuthor());
            holder.articleDescription.setText(articlesItemList.get(position).getDescription());
            holder.articlePostedDate.setText(articlesItemList.get(position).getPublishedAt());

            Glide.with(context).load(articlesItemList.get(position).getUrlToImage()).into(holder.articleImage);

            holder.articleHeading.setVisibility(View.VISIBLE);
            holder.articleAuthor.setVisibility(View.VISIBLE);
            holder.articleDescription.setVisibility(View.VISIBLE);
            holder.articleImage.setVisibility(View.VISIBLE);
            holder.articlePostedDate.setVisibility(View.VISIBLE);
        } else {
            holder.articleHeading.setVisibility(View.GONE);
            holder.articleAuthor.setVisibility(View.GONE);
            holder.articleDescription.setVisibility(View.GONE);
            holder.articleImage.setVisibility(View.GONE);
            holder.articlePostedDate.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImage;
        TextView articleHeading, articleAuthor, articleDescription, articlePostedDate;

        public MyViewHolder(
                @NonNull View itemView,
                RecyclerViewInterface recyclerViewInterface
        ) {
            super(itemView);
            articleImage = itemView.findViewById(R.id.articleImage);
            articleHeading = itemView.findViewById(R.id.articleHeading);
            articleAuthor = itemView.findViewById(R.id.articleAuthor);
            articleDescription = itemView.findViewById(R.id.articleDescription);
            articlePostedDate = itemView.findViewById(R.id.date_posted);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}
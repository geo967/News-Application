package com.example.secondnewsappmvp.view;

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
import com.example.secondnewsappmvp.network.ApiClient;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.MyViewHolder> {

    private final List<ArticlesItem> articlesItemList;
    private final Context context;

    public ArticleListAdapter(List<ArticlesItem> articlesItemList, Context context) {
        this.articlesItemList = articlesItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_movie_list, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvMovietitle.setText(articlesItemList.get(position).getTitle());
        holder.tvReleaseDate.setText(articlesItemList.get(position).getAuthor());
        holder.tvOverview.setText(articlesItemList.get(position).getContent());


        Glide.with(context).load(articlesItemList.get(position).getUrlToImage()).into(holder.ivMovie);

    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }


    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        ImageView ivMovie;
        TextView tvMovietitle, tvReleaseDate, tvOverview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvMovietitle = itemView.findViewById(R.id.tvTitleMovie);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseMovie);
            tvOverview = itemView.findViewById(R.id.tvOverviewMovie);

        }
    }


}


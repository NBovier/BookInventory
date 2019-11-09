package com.example.nathan_almin_bookinventory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.util.AdapterListener;

import java.util.List;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder> {

    private final LayoutInflater mInflater;
    private List<AutorEntity> mAuthors; // Cached copy of words

    private final AdapterListener listener;

    public AuthorListAdapter(Context context, AdapterListener listener, List<AutorEntity> data) {
        mInflater = LayoutInflater.from(context);
        this.listener = listener;
        this.mAuthors = data;
    }

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        final AuthorViewHolder viewHolder = new AuthorViewHolder(itemView);
        itemView.setOnClickListener(view -> listener.onItemClick(view, viewHolder.getAdapterPosition()));
        return new AuthorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AuthorListAdapter.AuthorViewHolder holder, int position) {
        if (mAuthors != null) {
            AutorEntity current = mAuthors.get(position);
            holder.authorItemView.setText(current.getAutorName());
        } else {
            // Covers the case of data not being ready yet.
            holder.authorItemView.setText("No Word");
        }
    }


    public AutorEntity getItem(int position) {
        return mAuthors.get(position);
    }

    public void setAuthors(List<AutorEntity> books){
        mAuthors = books;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mAuthors has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mAuthors != null)
            return mAuthors.size();
        else return 0;
    }

    static class AuthorViewHolder extends RecyclerView.ViewHolder {
        private final TextView authorItemView;

        private AuthorViewHolder(View itemView) {
            super(itemView);
            authorItemView = itemView.findViewById(R.id.textView);
        }
    }
}

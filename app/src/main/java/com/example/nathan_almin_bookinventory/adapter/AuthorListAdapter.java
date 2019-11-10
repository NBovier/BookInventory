package com.example.nathan_almin_bookinventory.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.model.authorViewModel;
import com.example.nathan_almin_bookinventory.ui.main.author_details;
import com.example.nathan_almin_bookinventory.util.AdapterListener;

import java.util.List;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder> {

    private final LayoutInflater mInflater;
    private List<AutorEntity> mAuthors; // Cached copy of words

    private AdapterListener listener;

    private Context mContext;

    private com.example.nathan_almin_bookinventory.model.authorViewModel authorViewModel;

    public AuthorListAdapter(Context context, AdapterListener listener, List<AutorEntity> data) {
        mInflater = LayoutInflater.from(context);
        this.listener = listener;
        this.mAuthors = data;
        this.mContext = context;
    }

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AuthorViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(AuthorListAdapter.AuthorViewHolder holder, int position) {
        if (mAuthors != null) {
            final AutorEntity current = mAuthors.get(position);
            holder.authorItemView.setText(current.getAutorName());
            holder.authorItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, author_details.class);
                    intent.putExtra("authorName", current.getAutorName());
                    intent.putExtra("idAuthor", current.getId());
                    intent.putExtra("pos", position);
                    mContext.startActivity(intent);
                }
            });
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

    public class AuthorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView authorItemView;

        AdapterListener adapterListener;

        private AuthorViewHolder(View itemView, AdapterListener adapterListener) {
            super(itemView);
            authorItemView = itemView.findViewById(R.id.textView);

            this.adapterListener=adapterListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            adapterListener.onItemClick(getAdapterPosition());
        }
    }
}

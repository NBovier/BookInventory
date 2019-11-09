package com.example.nathan_almin_bookinventory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

import java.util.List;

public class BookListAdapter  extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    private final LayoutInflater mInflater;
    private List<BookEntity> mBooks; // Cached copy of words

    public BookListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        if (mBooks != null) {
            BookEntity current = mBooks.get(position);
            holder.bookItemView.setText(current.getTitle());
        } else {
            // Covers the case of data not being ready yet.
            holder.bookItemView.setText("No Word");
        }
    }

    public void setBooks(List<BookEntity> books){
        mBooks = books;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mBooks has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mBooks != null)
            return mBooks.size();
        else return 0;
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        private final TextView bookItemView;

        private BookViewHolder(View itemView) {
            super(itemView);
            bookItemView = itemView.findViewById(R.id.textView);
        }
    }
}

package com.example.nathan_almin_bookinventory.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.ui.main.book_details;
import com.example.nathan_almin_bookinventory.util.AdapterListener;

import java.util.List;

/**
 * Classe BookListAdapter extends RecyclerView
 * Utilisée pour l'affichage des livres
 */
public class BookListAdapter  extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    //Components
    private final LayoutInflater mInflater;
    private List<BookEntity> mBooks; // Cached copy of words

    private AdapterListener listener;

    private Context mContext;

    /**
     * Constructor
     * @param context
     * @param listener
     * @param data
     */
    public BookListAdapter(Context context, AdapterListener listener, List<BookEntity> data) {
        mInflater = LayoutInflater.from(context);
        this.listener = listener;
        this.mBooks = data;
        this.mContext = context;
    }

    /*
    Holder perso
     */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new BookViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        if (mBooks != null) {
            final BookEntity current = mBooks.get(position);
            holder.bookItemView.setText(current.getTitle());
            holder.bookItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //send DATA
                    Intent intent = new Intent(mContext, book_details.class);
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("date", current.getDate());
                    intent.putExtra("author", current.getIdAutor());
                    intent.putExtra("category", current.getIdCategory());
                    intent.putExtra("loc", current.getIdLoc());
                    intent.putExtra("summary", current.getSummary());
                    intent.putExtra("pos", position);
                    mContext.startActivity(intent);
                }
            });
        } else {
            // Covers the case of data not being ready yet.
            holder.bookItemView.setText("No Word");
        }
    }

    /*
    méthodes qui va mettre à jour la liste des livres
     */
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

    //class HolderPerso
    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView bookItemView;

        AdapterListener adapterListener;

        private BookViewHolder(View itemView, AdapterListener adapterListener) {
            super(itemView);
            bookItemView = itemView.findViewById(R.id.textView);

            this.adapterListener=adapterListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            adapterListener.onItemClick(getAdapterPosition());
        }
    }
}

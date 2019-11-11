package com.example.nathan_almin_bookinventory.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.ui.main.author_details;
import com.example.nathan_almin_bookinventory.util.AdapterListener;

import java.util.List;

/**
 * AuthorListAdapter est une classe que nous utilisons pour l'affichage des auteurs
 * extends RecyclerView
 */

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder> {

    //Components
    private final LayoutInflater mInflater;
    private List<AutorEntity> mAuthors; // Cached copy of words

    private AdapterListener listener;

    private Context mContext;

    /**
     * Constructor of AuthorListAdapter
     * @param context
     * @param listener
     * @param data
     */

    public AuthorListAdapter(Context context, AdapterListener listener, List<AutorEntity> data) {
        mInflater = LayoutInflater.from(context);
        this.listener = listener;
        this.mAuthors = data;
        this.mContext = context;
    }

    /*
    Personnalize Holder
     */

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
            //Action onClick
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

    /*
    Méthode utilisé pour modifier la liste des auteurs
     */
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

    //Classe Holder qui extend ViewHolder et implements OnClickListener
    //Nous avons décidé de la mettre directement dans la classe AuthorListAdapter
    public class AuthorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Components
        private final TextView authorItemView;

        AdapterListener adapterListener;

        /**
         * Constructor
         * @param itemView
         * @param adapterListener
         */
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

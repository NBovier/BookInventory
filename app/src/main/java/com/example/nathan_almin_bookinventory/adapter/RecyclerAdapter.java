package com.example.nathan_almin_bookinventory.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.util.AdapterListener;

import java.util.List;
import java.util.Objects;

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<T> mData;
    private AdapterListener mListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTextView;
        ViewHolder(TextView textView) {
            super(textView);
            mTextView = textView;
        }
    }

    public RecyclerAdapter(AdapterListener listener) {
        mListener = listener;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(view -> mListener.onItemClick(view, viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        T item = mData.get(position);
        if (item.getClass().equals(AutorEntity.class))
            holder.mTextView.setText(((AutorEntity) item).getAutorName());
        if (item.getClass().equals(BookEntity.class))
            holder.mTextView.setText(((BookEntity) item).getTitle());
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else {
            return 0;
        }
    }

    public void setData(final List<T> data) {
        if (mData == null) {
            mData = data;
            notifyItemRangeInserted(0, data.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mData.size();
                }

                @Override
                public int getNewListSize() {
                    return data.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    if (mData instanceof AutorEntity) {
                        return ((AutorEntity) mData.get(oldItemPosition)).getId()==(((AutorEntity) data.get(newItemPosition)).getId());
                    }
                    if (mData instanceof BookEntity) {
                        return ((BookEntity) mData.get(oldItemPosition)).getDate().equals(
                                ((BookEntity) data.get(newItemPosition)).getDate());
                    }
                    return false;
                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    if (mData instanceof AutorEntity) {
                        AutorEntity newAccount = (AutorEntity) data.get(newItemPosition);
                        AutorEntity oldAccount = (AutorEntity) mData.get(newItemPosition);
                        return newAccount.getId()==(oldAccount.getId())
                                && Objects.equals(newAccount.getAutorName(), oldAccount.getAutorName());
                    }
                    if (mData instanceof BookEntity) {
                        BookEntity newClient = (BookEntity) data.get(newItemPosition);
                        BookEntity oldClient = (BookEntity) mData.get(newItemPosition);
                        return Objects.equals(newClient.getTitle(), oldClient.getTitle())
                                && Objects.equals(newClient.getDate(), oldClient.getDate())
                                && Objects.equals(newClient.getSummary(), oldClient.getSummary())
                                && newClient.getIdAutor()==(oldClient.getIdAutor());
                    }
                    return false;
                }
            });
            mData = data;
            result.dispatchUpdatesTo(this);
        }
    }
}

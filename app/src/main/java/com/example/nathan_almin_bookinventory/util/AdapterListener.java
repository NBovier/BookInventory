package com.example.nathan_almin_bookinventory.util;

import android.view.View;

public interface AdapterListener {
    void onItemClick(View v, int position);

    void onItemLongClick(View v, int position);
}

package com.softjourn.practise.library_aos.utils;

import android.view.View;


public interface OnClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}

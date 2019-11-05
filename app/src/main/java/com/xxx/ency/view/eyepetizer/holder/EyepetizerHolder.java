package com.xxx.ency.view.eyepetizer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * 类职责描述
 *
 * @author mzj
 * @since 1.0
 * 19-11-5
 */
public class EyepetizerHolder extends BaseViewHolder {
    public EyepetizerHolder(View view) {
        super(view);
    }

    public void setVisibility(boolean isVisible) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        if (isVisible) {
            param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            itemView.setVisibility(View.VISIBLE);
        } else {
            itemView.setVisibility(View.GONE);
            param.height = 0;
            param.width = 0;
        }
        itemView.setLayoutParams(param);
    }
}

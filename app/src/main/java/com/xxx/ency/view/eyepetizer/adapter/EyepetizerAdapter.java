package com.xxx.ency.view.eyepetizer.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xxx.ency.R;
import com.xxx.ency.model.bean.VideoBean;
import com.xxx.ency.util.ImageLoader;
import com.xxx.ency.util.SystemUtil;
import com.xxx.ency.view.eyepetizer.holder.EyepetizerHolder;

/**
 * Created by xiarh on 2018/2/7.
 */

public class EyepetizerAdapter extends BaseQuickAdapter<VideoBean.ItemListBean, EyepetizerHolder> {

    public EyepetizerAdapter() {
        super(R.layout.item_eyepetizer_daily);
    }

    @Override
    protected void convert(EyepetizerHolder helper, VideoBean.ItemListBean item) {
        VideoBean.ItemListBean.DataBeanX itemData = item.getData();
        VideoBean.ItemListBean.DataBeanX.ContentBean content = itemData.getContent();

        if (content != null) {
            helper.setVisibility(true);

            VideoBean.ItemListBean.DataBeanX.ContentBean.DataBean data = content.getData();

            helper.setText(R.id.txt_video_duration, SystemUtil.second2Minute(data.getDuration()));
            helper.setText(R.id.txt_video_title, data.getTitle());

            VideoBean.ItemListBean.DataBeanX.HeaderBean header = itemData.getHeader();
            if (header != null) {
                helper.setText(R.id.txt_video_content, header.getTitle() + " / "
                        + header.getDescription());
                ImageLoader.loadAllNoPlaceHolder(mContext, header.getIcon()
                        , (RoundedImageView) helper.getView(R.id.img_video_author));
                ImageView imgDaily = helper.getView(R.id.img_dialy);
                if (header.getDescription().contains("每日编辑精选")) {
                    imgDaily.setVisibility(View.VISIBLE);
                } else {
                    imgDaily.setVisibility(View.GONE);
                }
            }

            VideoBean.ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean cover = data.getCover();
            if (cover != null) {
                ImageLoader.loadAllNoPlaceHolder(mContext, cover.getDetail()
                        , (RoundedImageView) helper.getView(R.id.img_video));
            }

        } else {
            helper.setVisibility(false);
        }
    }
}
package stark.recyclerview.demo.ui.adapter.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import stark.recyclerview.demo.R;
import stark.recyclerview.demo.ui.adapter.Sample;

/**
 * Created by jihongwen on 16/9/24.
 */

public class VideoItem extends DefaultItem {

    ImageView item_icon;

    public VideoItem(ViewGroup parent, int viewType) {
        super(parent, viewType);
    }

    @Override
    public int getRes() {
        return R.layout.view_video_list_item;
    }

    @Override
    public void onCreateView(View rootView) {
        super.onCreateView(rootView);
        item_icon = (ImageView) rootView.findViewById(R.id.item_icon);

    }

    @Override
    public void onBindView(final Sample sample, final RecyclerView.ViewHolder viewHolder) {
        super.onBindView(sample, viewHolder);
        item_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                item_icon.setImageResource(R.drawable.video_pause_btn);
//                sample.isPlay = true;
            }
        });
        if (sample.isPlay) {
            item_icon.setImageResource(R.drawable.video_pause_btn);
        } else {
            item_icon.setImageResource(R.drawable.video_play_btn);
        }
    }
}

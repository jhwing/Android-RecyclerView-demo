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

public class ImageItem extends DefaultItem {


    ImageView item_icon;

    public ImageItem(ViewGroup parent, int viewType) {
        super(parent, viewType);
    }

    @Override
    public int getRes() {
        return R.layout.view_image_list_item;
    }

    @Override
    public void onCreateView(View rootView) {
        super.onCreateView(rootView);
        item_icon = (ImageView) rootView.findViewById(R.id.item_icon);
    }

    @Override
    public void onBindView(Sample sample, RecyclerView.ViewHolder viewHolder) {
        super.onBindView(sample, viewHolder);
    }
}

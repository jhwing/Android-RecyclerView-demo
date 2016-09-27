package stark.recyclerview.demo.ui.adapter.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import stark.android.appbase.widget.recyclerview.BaseItem;
import stark.recyclerview.demo.R;
import stark.recyclerview.demo.ui.adapter.Sample;

/**
 * Created by jihongwen on 16/9/24.
 */

public class DefaultItem extends BaseItem<Sample> {

    protected View item_bg;

    protected TextView content;

    public DefaultItem(ViewGroup parent, int viewType) {
        super(parent, viewType);
    }

    @Override
    public int getRes() {
        return R.layout.view_multi_list_item;
    }

    @Override
    public void onCreateView(View rootView) {
        item_bg = rootView.findViewById(R.id.item_bg);
        content = (TextView) rootView.findViewById(R.id.content);
    }

    @Override
    public void onBindView(Sample sample, RecyclerView.ViewHolder viewHolder) {
        content.setText(sample.toString());
    }

    @Override
    public void onActive(View view, int position) {
        item_bg.setVisibility(View.GONE);
    }

    @Override
    public void onDeactivate(View view, int position) {
        item_bg.setVisibility(View.VISIBLE);
    }

}

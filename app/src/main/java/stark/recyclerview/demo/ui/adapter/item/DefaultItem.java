package stark.recyclerview.demo.ui.adapter.item;

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

    protected TextView content;

    public DefaultItem(ViewGroup parent) {
        super(parent);
    }

    @Override
    public int getRes() {
        return R.layout.view_multi_list_item;
    }

    @Override
    public void onCreateView(View rootView) {
        content = (TextView) rootView.findViewById(R.id.content);
    }

    @Override
    public void onBindView(Sample sample) {
        content.setText(sample.toString());
    }
}

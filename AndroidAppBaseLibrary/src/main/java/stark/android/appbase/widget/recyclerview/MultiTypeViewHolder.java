package stark.android.appbase.widget.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jihongwen on 16/9/24.
 */

public class MultiTypeViewHolder<T> extends RecyclerView.ViewHolder {

    protected BaseItem baseItem;

    public MultiTypeViewHolder(BaseItem baseItem) {
        super(baseItem.getRootView());
        this.baseItem = baseItem;
        onCreateView(baseItem.getRootView());
    }


    protected void onCreateView(View rootView) {
        if (baseItem != null) {
            baseItem.onCreateView(rootView);
        }
    }

    protected void onBindView(T t) {
        if (baseItem != null) {
            baseItem.onBindView(t, this);
        }
    }
}

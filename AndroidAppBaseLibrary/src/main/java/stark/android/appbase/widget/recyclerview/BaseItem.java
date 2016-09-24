package stark.android.appbase.widget.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jihongwen on 16/9/24.
 */

public abstract class BaseItem<T> implements ItemInterface<T> {

    protected View rootView;

    protected LayoutInflater mInflater;

    public BaseItem(ViewGroup parent) {
        mInflater = LayoutInflater.from(parent.getContext());
        rootView = mInflater.inflate(getRes(), parent, false);
    }

    @Override
    public View getRootView() {
        return rootView;
    }
}

package stark.android.appbase.widget.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stark.android.appbase.R;

/**
 * Created by jihongwen on 16/9/24.
 */

public abstract class BaseItem<T> implements ItemInterface<T>, ActiveItem {

    private final Rect mCurrentViewRect = new Rect();

    protected View rootView;

    protected LayoutInflater mInflater;

    protected int viewType;

    protected Context mContext;

    public BaseItem(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        this.viewType = viewType;
        mInflater = LayoutInflater.from(parent.getContext());
        rootView = mInflater.inflate(getRes(), parent, false);
        rootView.setTag(this);
        rootView.setTag(R.id.base_item_tag, this);
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                BaseItem.this.onViewAttachedToWindow(v);
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                BaseItem.this.onViewDetachedFromWindow(v);
            }
        });
    }

    public void onViewAttachedToWindow(View v) {

    }

    public void onViewDetachedFromWindow(View v) {

    }

    @Override
    public int getViewType() {
        return viewType;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public int getVisibilityPercents(View view) {
        int percents = 100;

        view.getLocalVisibleRect(mCurrentViewRect);

        int height = view.getHeight();

        if (mCurrentViewRect.top > 0) {
            percents = (height - mCurrentViewRect.top) * 100 / height;
        } else if (mCurrentViewRect.bottom > 0 && mCurrentViewRect.bottom < height) {
            percents = mCurrentViewRect.bottom * 100 / height;
        }

        return percents;
    }
}

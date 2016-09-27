package stark.android.appbase.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by jihongwen on 16/9/24.
 */

public abstract class MultiTypeListAdapter<T> extends RecyclerView.Adapter<MultiTypeViewHolder> {

    @Override
    public MultiTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MultiTypeViewHolder(createItemView(parent, viewType));
    }

    @Override
    public void onBindViewHolder(MultiTypeViewHolder holder, int position) {
        holder.onBindView(getItem(getItemViewType(position), position));
    }

    @Override
    public void onViewRecycled(MultiTypeViewHolder holder) {
        super.onViewRecycled(holder);
    }

    public abstract T getItem(int viewType, int position);

    public abstract BaseItem<?> createItemView(ViewGroup parent, int viewType);

    public abstract void unbind(Context context);

}

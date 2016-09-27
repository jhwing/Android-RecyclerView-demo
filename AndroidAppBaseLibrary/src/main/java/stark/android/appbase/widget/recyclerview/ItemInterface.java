package stark.android.appbase.widget.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jihongwen on 16/9/24.
 */

public interface ItemInterface<T> {

    int getRes();

    void onCreateView(View rootView);

    void onBindView(T t, RecyclerView.ViewHolder viewHolder);

    View getRootView();

    int getViewType();
}

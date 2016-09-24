package stark.android.appbase.widget.recyclerview;

import android.view.View;

/**
 * Created by jihongwen on 16/9/24.
 */

public interface ItemInterface<T> {

    int getRes();

    void onCreateView(View rootView);

    void onBindView(T t);

    View getRootView();
}

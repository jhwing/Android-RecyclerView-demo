package stark.android.appbase.widget.recyclerview;

import android.view.View;

/**
 * Created by jihongwen on 16/9/26.
 */

public interface ActiveItem {

    void onActive(View view, int position);

    void onDeactivate(View view, int position);

    int getVisibilityPercents(View view);
}

package stark.recyclerview.demo.ui.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import stark.android.appbase.widget.recyclerview.BaseItem;

/**
 * Created by jihongwen on 16/9/26.
 */

public class ActiveItemManager {

    public enum ScrollDirection {
        UP, DOWN
    }

    ScrollDirection scrollDirection;

    int mPosition = -1;
    int mNewState = RecyclerView.SCROLL_STATE_IDLE;
    int firstVisiblePosition;
    int lastVisiblePosition;

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            scrollDirection = ScrollDirection.UP;
        } else {
            scrollDirection = ScrollDirection.DOWN;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        firstVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        lastVisiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();


        mNewState = newState;
        switch (mNewState) {
            case RecyclerView.SCROLL_STATE_IDLE:
                Log.d("jihongwen", "mNewState: SCROLL_STATE_IDLE");
                View firstView = linearLayoutManager.findViewByPosition(firstVisiblePosition);
                if (firstView.getTag() != null) {
                    BaseItem baseItem = (BaseItem) firstView.getTag();
                    int percents = baseItem.getVisibilityPercents(firstView);
                    if (baseItem.getViewType() == ViewType.VIDEO) {
                        if (percents < 50) {
                            baseItem.onDeactivate(firstView, firstVisiblePosition);
                        } else {
                            baseItem.onActive(firstView, firstVisiblePosition);
                        }
                    }
                    Log.d("jihongwen", "firstView baseItem:" + baseItem);
                    Log.d("jihongwen", "firstView percents:" + percents);
                } else {
                    Log.d("jihongwen", "firstView baseItem: is null");
                }

                switch (scrollDirection) {
                    case UP:
                        // 底部视频显示超过一半
                        Log.d("jihongwen", "底部视频显示超过一半 up");
                        break;
                    case DOWN:
                        // 顶部视频显示超过一半
                        Log.d("jihongwen", "顶部视频显示超过一半 down");
                        break;
                }
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                Log.d("jihongwen", "mNewState: SCROLL_STATE_DRAGGING");
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                Log.d("jihongwen", "mNewState: SCROLL_STATE_SETTLING");
                break;
        }
    }
}

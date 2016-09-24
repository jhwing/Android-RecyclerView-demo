package stark.recyclerview.demo.ui.adapter;

import android.view.ViewGroup;

import stark.android.appbase.widget.recyclerview.BaseItem;
import stark.recyclerview.demo.ui.adapter.item.DefaultItem;
import stark.recyclerview.demo.ui.adapter.item.ImageItem;
import stark.recyclerview.demo.ui.adapter.item.TextItem;
import stark.recyclerview.demo.ui.adapter.item.VideoItem;

/**
 * Created by jihongwen on 16/9/24.
 */

public class ItemViewFactory {

    public static BaseItem createItem(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.TEXT:
                return new TextItem(parent);
            case ViewType.IMAGE:
                return new ImageItem(parent);
            case ViewType.VIDEO:
                return new VideoItem(parent);
        }
        return new DefaultItem(parent);
    }
}

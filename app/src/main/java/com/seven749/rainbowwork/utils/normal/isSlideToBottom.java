package com.seven749.rainbowwork.utils.normal;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 行云流水
 * @date 2020/4/27
 * @description 判断是否是否滑倒底部的工具
 */
public class isSlideToBottom {
    private isSlideToBottom() {};
    /**
     *
     * @param recyclerView
     * @return true or false
     */
    public static boolean get(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }
}

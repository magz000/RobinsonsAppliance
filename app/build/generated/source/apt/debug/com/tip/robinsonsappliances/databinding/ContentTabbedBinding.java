package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentTabbedBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(9);
        sIncludes.setIncludes(1, 
            new String[] {"no_result", "no_query"},
            new int[] {2, 3},
            new int[] {R.layout.no_result, R.layout.no_query});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.swipe_refresh_layout, 4);
        sViewsWithIds.put(R.id.viewPager, 5);
        sViewsWithIds.put(R.id.search_layout, 6);
        sViewsWithIds.put(R.id.spinner, 7);
        sViewsWithIds.put(R.id.recycler_view, 8);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.FrameLayout mboundView1;
    @Nullable
    public final com.tip.robinsonsappliances.databinding.NoQueryBinding noQuery;
    @Nullable
    public final com.tip.robinsonsappliances.databinding.NoResultBinding noResult;
    @NonNull
    public final android.support.v7.widget.RecyclerView recyclerView;
    @NonNull
    public final android.widget.LinearLayout searchLayout;
    @NonNull
    public final com.tip.robinsonsappliances.ui.Tabbed.activity.NDSpinner spinner;
    @NonNull
    public final android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    @NonNull
    public final android.support.v4.view.ViewPager viewPager;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ContentTabbedBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.FrameLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.noQuery = (com.tip.robinsonsappliances.databinding.NoQueryBinding) bindings[3];
        setContainedBinding(this.noQuery);
        this.noResult = (com.tip.robinsonsappliances.databinding.NoResultBinding) bindings[2];
        setContainedBinding(this.noResult);
        this.recyclerView = (android.support.v7.widget.RecyclerView) bindings[8];
        this.searchLayout = (android.widget.LinearLayout) bindings[6];
        this.spinner = (com.tip.robinsonsappliances.ui.Tabbed.activity.NDSpinner) bindings[7];
        this.swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) bindings[4];
        this.viewPager = (android.support.v4.view.ViewPager) bindings[5];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        noResult.invalidateAll();
        noQuery.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (noResult.hasPendingBindings()) {
            return true;
        }
        if (noQuery.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNoQuery((com.tip.robinsonsappliances.databinding.NoQueryBinding) object, fieldId);
            case 1 :
                return onChangeNoResult((com.tip.robinsonsappliances.databinding.NoResultBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNoQuery(com.tip.robinsonsappliances.databinding.NoQueryBinding NoQuery, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNoResult(com.tip.robinsonsappliances.databinding.NoResultBinding NoResult, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(noResult);
        executeBindingsOn(noQuery);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ContentTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ContentTabbedBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.content_tabbed, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ContentTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.content_tabbed, null, false), bindingComponent);
    }
    @NonNull
    public static ContentTabbedBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentTabbedBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/content_tabbed_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ContentTabbedBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): noQuery
        flag 1 (0x2L): noResult
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AppBarTabbedBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"content_tabbed"},
            new int[] {1},
            new int[] {R.layout.content_tabbed});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.search_view, 3);
        sViewsWithIds.put(R.id.tabs, 4);
    }
    // views
    @Nullable
    public final com.tip.robinsonsappliances.databinding.ContentTabbedBinding contentTabbed;
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    @NonNull
    public final com.miguelcatalan.materialsearchview.MaterialSearchView searchView;
    @NonNull
    public final android.support.design.widget.TabLayout tabs;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AppBarTabbedBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.contentTabbed = (com.tip.robinsonsappliances.databinding.ContentTabbedBinding) bindings[1];
        setContainedBinding(this.contentTabbed);
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.searchView = (com.miguelcatalan.materialsearchview.MaterialSearchView) bindings[3];
        this.tabs = (android.support.design.widget.TabLayout) bindings[4];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[2];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        contentTabbed.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (contentTabbed.hasPendingBindings()) {
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
                return onChangeContentTabbed((com.tip.robinsonsappliances.databinding.ContentTabbedBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentTabbed(com.tip.robinsonsappliances.databinding.ContentTabbedBinding ContentTabbed, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        executeBindingsOn(contentTabbed);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static AppBarTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static AppBarTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<AppBarTabbedBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.app_bar_tabbed, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static AppBarTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static AppBarTabbedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.app_bar_tabbed, null, false), bindingComponent);
    }
    @NonNull
    public static AppBarTabbedBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static AppBarTabbedBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/app_bar_tabbed_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new AppBarTabbedBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): contentTabbed
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
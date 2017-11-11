package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentAppliancesListBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"empty"},
            new int[] {1},
            new int[] {R.layout.empty});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.promo, 2);
        sViewsWithIds.put(R.id.swipe_refresh_layout, 3);
        sViewsWithIds.put(R.id.recycler_view, 4);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    public final com.tip.robinsonsappliances.databinding.EmptyBinding noContent;
    @NonNull
    public final android.widget.ImageView promo;
    @NonNull
    public final android.support.v7.widget.RecyclerView recyclerView;
    @NonNull
    public final android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ContentAppliancesListBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.noContent = (com.tip.robinsonsappliances.databinding.EmptyBinding) bindings[1];
        setContainedBinding(this.noContent);
        this.promo = (android.widget.ImageView) bindings[2];
        this.recyclerView = (android.support.v7.widget.RecyclerView) bindings[4];
        this.swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        noContent.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (noContent.hasPendingBindings()) {
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
                return onChangeNoContent((com.tip.robinsonsappliances.databinding.EmptyBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNoContent(com.tip.robinsonsappliances.databinding.EmptyBinding NoContent, int fieldId) {
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
        executeBindingsOn(noContent);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ContentAppliancesListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentAppliancesListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ContentAppliancesListBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.content_appliances_list, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ContentAppliancesListBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentAppliancesListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.content_appliances_list, null, false), bindingComponent);
    }
    @NonNull
    public static ContentAppliancesListBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ContentAppliancesListBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/content_appliances_list_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ContentAppliancesListBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): noContent
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWishlistBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(3);
        sIncludes.setIncludes(0, 
            new String[] {"app_bar_wishlist"},
            new int[] {1},
            new int[] {R.layout.app_bar_wishlist});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nav_view, 2);
    }
    // views
    @Nullable
    public final com.tip.robinsonsappliances.databinding.AppBarWishlistBinding appBarWishlist;
    @NonNull
    public final android.support.v4.widget.DrawerLayout drawerLayout;
    @NonNull
    public final android.support.design.widget.NavigationView navView;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWishlistBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.appBarWishlist = (com.tip.robinsonsappliances.databinding.AppBarWishlistBinding) bindings[1];
        setContainedBinding(this.appBarWishlist);
        this.drawerLayout = (android.support.v4.widget.DrawerLayout) bindings[0];
        this.drawerLayout.setTag(null);
        this.navView = (android.support.design.widget.NavigationView) bindings[2];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        appBarWishlist.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (appBarWishlist.hasPendingBindings()) {
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
                return onChangeAppBarWishlist((com.tip.robinsonsappliances.databinding.AppBarWishlistBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAppBarWishlist(com.tip.robinsonsappliances.databinding.AppBarWishlistBinding AppBarWishlist, int fieldId) {
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
        executeBindingsOn(appBarWishlist);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityWishlistBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityWishlistBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityWishlistBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.activity_wishlist, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityWishlistBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityWishlistBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.activity_wishlist, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityWishlistBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityWishlistBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_wishlist_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityWishlistBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): appBarWishlist
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentApplicationDetailsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.up, 1);
        sViewsWithIds.put(R.id.relative_layout, 2);
        sViewsWithIds.put(R.id.product_image, 3);
        sViewsWithIds.put(R.id.perc_discount, 4);
        sViewsWithIds.put(R.id.name, 5);
        sViewsWithIds.put(R.id.price, 6);
        sViewsWithIds.put(R.id.actual_price, 7);
        sViewsWithIds.put(R.id.specs, 8);
        sViewsWithIds.put(R.id.nearest, 9);
        sViewsWithIds.put(R.id.distance, 10);
        sViewsWithIds.put(R.id.addCompare, 11);
        sViewsWithIds.put(R.id.addWishlist, 12);
        sViewsWithIds.put(R.id.down, 13);
    }
    // views
    @NonNull
    public final android.widget.TextView actualPrice;
    @NonNull
    public final android.widget.Button addCompare;
    @NonNull
    public final android.widget.Button addWishlist;
    @NonNull
    public final android.widget.TextView distance;
    @NonNull
    public final android.widget.Button down;
    @NonNull
    public final android.widget.RelativeLayout layout;
    @NonNull
    public final android.widget.TextView name;
    @NonNull
    public final android.widget.TextView nearest;
    @NonNull
    public final android.widget.TextView percDiscount;
    @NonNull
    public final android.widget.TextView price;
    @NonNull
    public final android.widget.ImageView productImage;
    @NonNull
    public final android.widget.RelativeLayout relativeLayout;
    @NonNull
    public final android.widget.TextView specs;
    @NonNull
    public final android.widget.Button up;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentApplicationDetailsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.actualPrice = (android.widget.TextView) bindings[7];
        this.addCompare = (android.widget.Button) bindings[11];
        this.addWishlist = (android.widget.Button) bindings[12];
        this.distance = (android.widget.TextView) bindings[10];
        this.down = (android.widget.Button) bindings[13];
        this.layout = (android.widget.RelativeLayout) bindings[0];
        this.layout.setTag(null);
        this.name = (android.widget.TextView) bindings[5];
        this.nearest = (android.widget.TextView) bindings[9];
        this.percDiscount = (android.widget.TextView) bindings[4];
        this.price = (android.widget.TextView) bindings[6];
        this.productImage = (android.widget.ImageView) bindings[3];
        this.relativeLayout = (android.widget.RelativeLayout) bindings[2];
        this.specs = (android.widget.TextView) bindings[8];
        this.up = (android.widget.Button) bindings[1];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentApplicationDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentApplicationDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentApplicationDetailsBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.fragment_application_details, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentApplicationDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentApplicationDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.fragment_application_details, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentApplicationDetailsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentApplicationDetailsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_application_details_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentApplicationDetailsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}
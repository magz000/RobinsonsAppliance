package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCompareBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.remove, 1);
        sViewsWithIds.put(R.id.product_image, 2);
        sViewsWithIds.put(R.id.perc_discount, 3);
        sViewsWithIds.put(R.id.name, 4);
        sViewsWithIds.put(R.id.specs, 5);
        sViewsWithIds.put(R.id.price, 6);
        sViewsWithIds.put(R.id.actual_price, 7);
    }
    // views
    @NonNull
    public final android.widget.TextView actualPrice;
    @NonNull
    public final android.widget.TextView name;
    @NonNull
    public final android.widget.TextView percDiscount;
    @NonNull
    public final android.widget.TextView price;
    @NonNull
    public final android.widget.ImageView productImage;
    @NonNull
    public final android.widget.RelativeLayout relativeLayout;
    @NonNull
    public final android.widget.Button remove;
    @NonNull
    public final android.widget.TextView specs;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCompareBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.actualPrice = (android.widget.TextView) bindings[7];
        this.name = (android.widget.TextView) bindings[4];
        this.percDiscount = (android.widget.TextView) bindings[3];
        this.price = (android.widget.TextView) bindings[6];
        this.productImage = (android.widget.ImageView) bindings[2];
        this.relativeLayout = (android.widget.RelativeLayout) bindings[0];
        this.relativeLayout.setTag(null);
        this.remove = (android.widget.Button) bindings[1];
        this.specs = (android.widget.TextView) bindings[5];
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
    public static ItemCompareBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemCompareBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemCompareBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.item_compare, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemCompareBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemCompareBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.item_compare, null, false), bindingComponent);
    }
    @NonNull
    public static ItemCompareBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemCompareBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_compare_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemCompareBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}
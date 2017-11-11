package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemApplianceBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.product_image, 1);
        sViewsWithIds.put(R.id.product_name, 2);
        sViewsWithIds.put(R.id.product_price, 3);
    }
    // views
    @NonNull
    private final android.support.v7.widget.CardView mboundView0;
    @NonNull
    public final android.widget.ImageView productImage;
    @NonNull
    public final android.widget.TextView productName;
    @NonNull
    public final android.widget.TextView productPrice;
    // variables
    @Nullable
    private com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView mView;
    @Nullable
    private com.tip.robinsonsappliances.models.data.Appliances mAppliances;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemApplianceBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.productImage = (android.widget.ImageView) bindings[1];
        this.productName = (android.widget.TextView) bindings[2];
        this.productPrice = (android.widget.TextView) bindings[3];
        setRootTag(root);
        // listeners
        mCallback4 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.view == variableId) {
            setView((com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView) variable);
        }
        else if (BR.appliances == variableId) {
            setAppliances((com.tip.robinsonsappliances.models.data.Appliances) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setView(@Nullable com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView View) {
        this.mView = View;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }
    @Nullable
    public com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView getView() {
        return mView;
    }
    public void setAppliances(@Nullable com.tip.robinsonsappliances.models.data.Appliances Appliances) {
        this.mAppliances = Appliances;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.appliances);
        super.requestRebind();
    }
    @Nullable
    public com.tip.robinsonsappliances.models.data.Appliances getAppliances() {
        return mAppliances;
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
        com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView view = mView;
        com.tip.robinsonsappliances.models.data.Appliances appliances = mAppliances;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback4);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // view
        com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListView view = mView;
        // view != null
        boolean viewJavaLangObjectNull = false;
        // appliances
        com.tip.robinsonsappliances.models.data.Appliances appliances = mAppliances;



        viewJavaLangObjectNull = (view) != (null);
        if (viewJavaLangObjectNull) {



            view.onApplianceClicked(appliances);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemApplianceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemApplianceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemApplianceBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.item_appliance, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemApplianceBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemApplianceBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.item_appliance, null, false), bindingComponent);
    }
    @NonNull
    public static ItemApplianceBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemApplianceBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_appliance_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemApplianceBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): view
        flag 1 (0x2L): appliances
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
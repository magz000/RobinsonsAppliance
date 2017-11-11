package com.tip.robinsonsappliances.databinding;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.username, 2);
        sViewsWithIds.put(R.id.password, 3);
    }
    // views
    @NonNull
    public final android.widget.LinearLayout activityMain;
    @NonNull
    public final android.widget.Button loginButton;
    @NonNull
    public final android.widget.EditText password;
    @NonNull
    public final android.widget.EditText username;
    // variables
    @Nullable
    private com.tip.robinsonsappliances.ui.Login.LoginView mView;
    @Nullable
    private com.tip.robinsonsappliances.models.data.User mUser;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.activityMain = (android.widget.LinearLayout) bindings[0];
        this.activityMain.setTag(null);
        this.loginButton = (android.widget.Button) bindings[1];
        this.loginButton.setTag(null);
        this.password = (android.widget.EditText) bindings[3];
        this.username = (android.widget.EditText) bindings[2];
        setRootTag(root);
        // listeners
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
            setView((com.tip.robinsonsappliances.ui.Login.LoginView) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.tip.robinsonsappliances.models.data.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setView(@Nullable com.tip.robinsonsappliances.ui.Login.LoginView View) {
        this.mView = View;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }
    @Nullable
    public com.tip.robinsonsappliances.ui.Login.LoginView getView() {
        return mView;
    }
    public void setUser(@Nullable com.tip.robinsonsappliances.models.data.User User) {
        this.mUser = User;
    }
    @Nullable
    public com.tip.robinsonsappliances.models.data.User getUser() {
        return mUser;
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
        com.tip.robinsonsappliances.ui.Login.LoginView view = mView;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.loginButton.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // view
        com.tip.robinsonsappliances.ui.Login.LoginView view = mView;
        // view != null
        boolean viewJavaLangObjectNull = false;



        viewJavaLangObjectNull = (view) != (null);
        if (viewJavaLangObjectNull) {


            view.onLoginButtonClicked();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.tip.robinsonsappliances.R.layout.activity_login, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tip.robinsonsappliances.R.layout.activity_login, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityLoginBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): view
        flag 1 (0x2L): user
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
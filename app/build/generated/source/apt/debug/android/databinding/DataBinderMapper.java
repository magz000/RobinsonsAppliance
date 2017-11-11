
package android.databinding;
import com.tip.robinsonsappliances.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 21;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.tip.robinsonsappliances.R.layout.app_bar_main:
                    return com.tip.robinsonsappliances.databinding.AppBarMainBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.content_tabbed:
                    return com.tip.robinsonsappliances.databinding.ContentTabbedBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.content_wishlist:
                    return com.tip.robinsonsappliances.databinding.ContentWishlistBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_appliance_details:
                    return com.tip.robinsonsappliances.databinding.ItemApplianceDetailsBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.content_compare:
                    return com.tip.robinsonsappliances.databinding.ContentCompareBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.empty:
                    return com.tip.robinsonsappliances.databinding.EmptyBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_appliances_list:
                    return com.tip.robinsonsappliances.databinding.ActivityAppliancesListBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_main:
                    return com.tip.robinsonsappliances.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.spinner_item:
                    return com.tip.robinsonsappliances.databinding.SpinnerItemBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_wishlist:
                    return com.tip.robinsonsappliances.databinding.ItemWishlistBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.content_appliances_list:
                    return com.tip.robinsonsappliances.databinding.ContentAppliancesListBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_compare:
                    return com.tip.robinsonsappliances.databinding.ActivityCompareBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.app_bar_appliances_list:
                    return com.tip.robinsonsappliances.databinding.AppBarAppliancesListBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_appliances_detail2:
                    return com.tip.robinsonsappliances.databinding.ActivityAppliancesDetail2Binding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.no_result:
                    return com.tip.robinsonsappliances.databinding.NoResultBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_tabbed_fragment:
                    return com.tip.robinsonsappliances.databinding.ItemTabbedFragmentBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_wishlist:
                    return com.tip.robinsonsappliances.databinding.ActivityWishlistBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.app_bar_compare:
                    return com.tip.robinsonsappliances.databinding.AppBarCompareBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_tabbed:
                    return com.tip.robinsonsappliances.databinding.ItemTabbedBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.fragment_tabbed:
                    return com.tip.robinsonsappliances.databinding.FragmentTabbedBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_contact_us:
                    return com.tip.robinsonsappliances.databinding.ActivityContactUsBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_stores:
                    return com.tip.robinsonsappliances.databinding.ItemStoresBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_compare:
                    return com.tip.robinsonsappliances.databinding.ItemCompareBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.no_query:
                    return com.tip.robinsonsappliances.databinding.NoQueryBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.content_main:
                    return com.tip.robinsonsappliances.databinding.ContentMainBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_login:
                    return com.tip.robinsonsappliances.databinding.ActivityLoginBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_appliances_detail:
                    return com.tip.robinsonsappliances.databinding.ActivityAppliancesDetailBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.fragment_application_details:
                    return com.tip.robinsonsappliances.databinding.FragmentApplicationDetailsBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_main:
                    return com.tip.robinsonsappliances.databinding.ItemMainBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.activity_tabbed:
                    return com.tip.robinsonsappliances.databinding.ActivityTabbedBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.item_appliance:
                    return com.tip.robinsonsappliances.databinding.ItemApplianceBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.app_bar_tabbed:
                    return com.tip.robinsonsappliances.databinding.AppBarTabbedBinding.bind(view, bindingComponent);
                case com.tip.robinsonsappliances.R.layout.app_bar_wishlist:
                    return com.tip.robinsonsappliances.databinding.AppBarWishlistBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -85764295: {
                if(tag.equals("layout/app_bar_main_0")) {
                    return com.tip.robinsonsappliances.R.layout.app_bar_main;
                }
                break;
            }
            case 1603032776: {
                if(tag.equals("layout/content_tabbed_0")) {
                    return com.tip.robinsonsappliances.R.layout.content_tabbed;
                }
                break;
            }
            case 1550676673: {
                if(tag.equals("layout/content_wishlist_0")) {
                    return com.tip.robinsonsappliances.R.layout.content_wishlist;
                }
                break;
            }
            case -375435910: {
                if(tag.equals("layout/item_appliance_details_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_appliance_details;
                }
                break;
            }
            case -983951509: {
                if(tag.equals("layout/content_compare_0")) {
                    return com.tip.robinsonsappliances.R.layout.content_compare;
                }
                break;
            }
            case 1635246041: {
                if(tag.equals("layout/empty_0")) {
                    return com.tip.robinsonsappliances.R.layout.empty;
                }
                break;
            }
            case -1307058275: {
                if(tag.equals("layout/activity_appliances_list_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_appliances_list;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_main;
                }
                break;
            }
            case 515901551: {
                if(tag.equals("layout/spinner_item_0")) {
                    return com.tip.robinsonsappliances.R.layout.spinner_item;
                }
                break;
            }
            case 352962557: {
                if(tag.equals("layout/item_wishlist_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_wishlist;
                }
                break;
            }
            case 1791896029: {
                if(tag.equals("layout/content_appliances_list_0")) {
                    return com.tip.robinsonsappliances.R.layout.content_appliances_list;
                }
                break;
            }
            case -40530645: {
                if(tag.equals("layout/activity_compare_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_compare;
                }
                break;
            }
            case 1703050073: {
                if(tag.equals("layout/app_bar_appliances_list_0")) {
                    return com.tip.robinsonsappliances.R.layout.app_bar_appliances_list;
                }
                break;
            }
            case -1146481692: {
                if(tag.equals("layout/activity_appliances_detail2_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_appliances_detail2;
                }
                break;
            }
            case -1596639769: {
                if(tag.equals("layout/no_result_0")) {
                    return com.tip.robinsonsappliances.R.layout.no_result;
                }
                break;
            }
            case -1835811411: {
                if(tag.equals("layout/item_tabbed_fragment_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_tabbed_fragment;
                }
                break;
            }
            case 731952385: {
                if(tag.equals("layout/activity_wishlist_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_wishlist;
                }
                break;
            }
            case -658135833: {
                if(tag.equals("layout/app_bar_compare_0")) {
                    return com.tip.robinsonsappliances.R.layout.app_bar_compare;
                }
                break;
            }
            case -1334523132: {
                if(tag.equals("layout/item_tabbed_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_tabbed;
                }
                break;
            }
            case 852939495: {
                if(tag.equals("layout/fragment_tabbed_0")) {
                    return com.tip.robinsonsappliances.R.layout.fragment_tabbed;
                }
                break;
            }
            case 604921241: {
                if(tag.equals("layout/activity_contact_us_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_contact_us;
                }
                break;
            }
            case 1287304298: {
                if(tag.equals("layout/item_stores_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_stores;
                }
                break;
            }
            case -1853871441: {
                if(tag.equals("layout/item_compare_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_compare;
                }
                break;
            }
            case -1325232640: {
                if(tag.equals("layout/no_query_0")) {
                    return com.tip.robinsonsappliances.R.layout.no_query;
                }
                break;
            }
            case 731091765: {
                if(tag.equals("layout/content_main_0")) {
                    return com.tip.robinsonsappliances.R.layout.content_main;
                }
                break;
            }
            case -237232145: {
                if(tag.equals("layout/activity_login_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_login;
                }
                break;
            }
            case 2041228048: {
                if(tag.equals("layout/activity_appliances_detail_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_appliances_detail;
                }
                break;
            }
            case 1358593050: {
                if(tag.equals("layout/fragment_application_details_0")) {
                    return com.tip.robinsonsappliances.R.layout.fragment_application_details;
                }
                break;
            }
            case -1488722319: {
                if(tag.equals("layout/item_main_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_main;
                }
                break;
            }
            case -1691670264: {
                if(tag.equals("layout/activity_tabbed_0")) {
                    return com.tip.robinsonsappliances.R.layout.activity_tabbed;
                }
                break;
            }
            case -1533423817: {
                if(tag.equals("layout/item_appliance_0")) {
                    return com.tip.robinsonsappliances.R.layout.item_appliance;
                }
                break;
            }
            case -1711593012: {
                if(tag.equals("layout/app_bar_tabbed_0")) {
                    return com.tip.robinsonsappliances.R.layout.app_bar_tabbed;
                }
                break;
            }
            case -1233939259: {
                if(tag.equals("layout/app_bar_wishlist_0")) {
                    return com.tip.robinsonsappliances.R.layout.app_bar_wishlist;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"appliances"
            ,"user"
            ,"view"};
    }
}
package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        modelClasses.add(com.tip.robinsonsappliances.models.data.Appliances.class);
        modelClasses.add(com.tip.robinsonsappliances.models.data.User.class);
        modelClasses.add(com.tip.robinsonsappliances.models.data.Wishlist.class);
        modelClasses.add(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        modelClasses.add(com.tip.robinsonsappliances.models.data.Stores.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return io.realm.ComparedAppliancesRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return io.realm.AppliancesRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return io.realm.UserRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return io.realm.WishlistRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return io.realm.CurrentLocationRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return io.realm.StoresRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return io.realm.ComparedAppliancesRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return io.realm.AppliancesRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return io.realm.UserRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return io.realm.WishlistRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return io.realm.CurrentLocationRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return io.realm.StoresRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return io.realm.ComparedAppliancesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return io.realm.AppliancesRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return io.realm.UserRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return io.realm.WishlistRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return io.realm.CurrentLocationRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return io.realm.StoresRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return io.realm.ComparedAppliancesRealmProxy.getFieldNames();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return io.realm.AppliancesRealmProxy.getFieldNames();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return io.realm.UserRealmProxy.getFieldNames();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return io.realm.WishlistRealmProxy.getFieldNames();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return io.realm.CurrentLocationRealmProxy.getFieldNames();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return io.realm.StoresRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return io.realm.ComparedAppliancesRealmProxy.getTableName();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return io.realm.AppliancesRealmProxy.getTableName();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return io.realm.UserRealmProxy.getTableName();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return io.realm.WishlistRealmProxy.getTableName();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return io.realm.CurrentLocationRealmProxy.getTableName();
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return io.realm.StoresRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
                return clazz.cast(new io.realm.ComparedAppliancesRealmProxy());
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
                return clazz.cast(new io.realm.AppliancesRealmProxy());
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
                return clazz.cast(new io.realm.UserRealmProxy());
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
                return clazz.cast(new io.realm.WishlistRealmProxy());
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
                return clazz.cast(new io.realm.CurrentLocationRealmProxy());
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
                return clazz.cast(new io.realm.StoresRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return clazz.cast(io.realm.ComparedAppliancesRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.ComparedAppliances) obj, update, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return clazz.cast(io.realm.AppliancesRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Appliances) obj, update, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.User) obj, update, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return clazz.cast(io.realm.WishlistRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Wishlist) obj, update, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return clazz.cast(io.realm.CurrentLocationRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.CurrentLocation) obj, update, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return clazz.cast(io.realm.StoresRealmProxy.copyOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Stores) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            io.realm.ComparedAppliancesRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.ComparedAppliances) object, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            io.realm.AppliancesRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Appliances) object, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            io.realm.UserRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.User) object, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            io.realm.WishlistRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Wishlist) object, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            io.realm.CurrentLocationRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.CurrentLocation) object, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            io.realm.StoresRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Stores) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
                io.realm.ComparedAppliancesRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.ComparedAppliances) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
                io.realm.AppliancesRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Appliances) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
                io.realm.UserRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.User) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
                io.realm.WishlistRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Wishlist) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
                io.realm.CurrentLocationRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.CurrentLocation) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
                io.realm.StoresRealmProxy.insert(realm, (com.tip.robinsonsappliances.models.data.Stores) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
                    io.realm.ComparedAppliancesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
                    io.realm.AppliancesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
                    io.realm.UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
                    io.realm.WishlistRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
                    io.realm.CurrentLocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
                    io.realm.StoresRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            io.realm.ComparedAppliancesRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.ComparedAppliances) obj, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            io.realm.AppliancesRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Appliances) obj, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            io.realm.UserRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.User) obj, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            io.realm.WishlistRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Wishlist) obj, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            io.realm.CurrentLocationRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.CurrentLocation) obj, cache);
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            io.realm.StoresRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Stores) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
                io.realm.ComparedAppliancesRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.ComparedAppliances) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
                io.realm.AppliancesRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Appliances) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
                io.realm.UserRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.User) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
                io.realm.WishlistRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Wishlist) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
                io.realm.CurrentLocationRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.CurrentLocation) object, cache);
            } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
                io.realm.StoresRealmProxy.insertOrUpdate(realm, (com.tip.robinsonsappliances.models.data.Stores) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
                    io.realm.ComparedAppliancesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
                    io.realm.AppliancesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
                    io.realm.UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
                    io.realm.WishlistRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
                    io.realm.CurrentLocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
                    io.realm.StoresRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return clazz.cast(io.realm.ComparedAppliancesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return clazz.cast(io.realm.AppliancesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return clazz.cast(io.realm.WishlistRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return clazz.cast(io.realm.CurrentLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return clazz.cast(io.realm.StoresRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return clazz.cast(io.realm.ComparedAppliancesRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return clazz.cast(io.realm.AppliancesRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return clazz.cast(io.realm.WishlistRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return clazz.cast(io.realm.CurrentLocationRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return clazz.cast(io.realm.StoresRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.tip.robinsonsappliances.models.data.ComparedAppliances.class)) {
            return clazz.cast(io.realm.ComparedAppliancesRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.ComparedAppliances) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Appliances.class)) {
            return clazz.cast(io.realm.AppliancesRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.Appliances) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.User) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Wishlist.class)) {
            return clazz.cast(io.realm.WishlistRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.Wishlist) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.CurrentLocation.class)) {
            return clazz.cast(io.realm.CurrentLocationRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.CurrentLocation) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.tip.robinsonsappliances.models.data.Stores.class)) {
            return clazz.cast(io.realm.StoresRealmProxy.createDetachedCopy((com.tip.robinsonsappliances.models.data.Stores) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}

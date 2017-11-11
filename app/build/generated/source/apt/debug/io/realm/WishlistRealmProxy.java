package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WishlistRealmProxy extends com.tip.robinsonsappliances.models.data.Wishlist
    implements RealmObjectProxy, WishlistRealmProxyInterface {

    static final class WishlistColumnInfo extends ColumnInfo
        implements Cloneable {

        public long appliancesIndex;

        WishlistColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(1);
            this.appliancesIndex = getValidColumnIndex(path, table, "Wishlist", "appliances");
            indicesMap.put("appliances", this.appliancesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final WishlistColumnInfo otherInfo = (WishlistColumnInfo) other;
            this.appliancesIndex = otherInfo.appliancesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final WishlistColumnInfo clone() {
            return (WishlistColumnInfo) super.clone();
        }

    }
    private WishlistColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("appliances");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    WishlistRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (WishlistColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.Wishlist.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    public com.tip.robinsonsappliances.models.data.Appliances realmGet$appliances() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.appliancesIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.tip.robinsonsappliances.models.data.Appliances.class, proxyState.getRow$realm().getLink(columnInfo.appliancesIndex), false, Collections.<String>emptyList());
    }

    public void realmSet$appliances(com.tip.robinsonsappliances.models.data.Appliances value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("appliances")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.appliancesIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.appliancesIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.appliancesIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.appliancesIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Wishlist")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Wishlist");
            if (!realmSchema.contains("Appliances")) {
                AppliancesRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("appliances", RealmFieldType.OBJECT, realmSchema.get("Appliances")));
            return realmObjectSchema;
        }
        return realmSchema.get("Wishlist");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Wishlist")) {
            Table table = sharedRealm.getTable("class_Wishlist");
            if (!sharedRealm.hasTable("class_Appliances")) {
                AppliancesRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "appliances", sharedRealm.getTable("class_Appliances"));
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_Wishlist");
    }

    public static WishlistColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Wishlist")) {
            Table table = sharedRealm.getTable("class_Wishlist");
            final long columnCount = table.getColumnCount();
            if (columnCount != 1) {
                if (columnCount < 1) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 1 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 1 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 1 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final WishlistColumnInfo columnInfo = new WishlistColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("appliances")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'appliances' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("appliances") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Appliances' for field 'appliances'");
            }
            if (!sharedRealm.hasTable("class_Appliances")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Appliances' for field 'appliances'");
            }
            Table table_0 = sharedRealm.getTable("class_Appliances");
            if (!table.getLinkTarget(columnInfo.appliancesIndex).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'appliances': '" + table.getLinkTarget(columnInfo.appliancesIndex).getName() + "' expected - was '" + table_0.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Wishlist' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Wishlist";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.Wishlist createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("appliances")) {
            excludeFields.add("appliances");
        }
        com.tip.robinsonsappliances.models.data.Wishlist obj = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Wishlist.class, true, excludeFields);
        if (json.has("appliances")) {
            if (json.isNull("appliances")) {
                ((WishlistRealmProxyInterface) obj).realmSet$appliances(null);
            } else {
                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = AppliancesRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("appliances"), update);
                ((WishlistRealmProxyInterface) obj).realmSet$appliances(appliancesObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.Wishlist createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.tip.robinsonsappliances.models.data.Wishlist obj = new com.tip.robinsonsappliances.models.data.Wishlist();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("appliances")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((WishlistRealmProxyInterface) obj).realmSet$appliances(null);
                } else {
                    com.tip.robinsonsappliances.models.data.Appliances appliancesObj = AppliancesRealmProxy.createUsingJsonStream(realm, reader);
                    ((WishlistRealmProxyInterface) obj).realmSet$appliances(appliancesObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.tip.robinsonsappliances.models.data.Wishlist copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Wishlist object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Wishlist) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.tip.robinsonsappliances.models.data.Wishlist copy(Realm realm, com.tip.robinsonsappliances.models.data.Wishlist newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Wishlist) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.Wishlist realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Wishlist.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((WishlistRealmProxyInterface) newObject).realmGet$appliances();
            if (appliancesObj != null) {
                com.tip.robinsonsappliances.models.data.Appliances cacheappliances = (com.tip.robinsonsappliances.models.data.Appliances) cache.get(appliancesObj);
                if (cacheappliances != null) {
                    ((WishlistRealmProxyInterface) realmObject).realmSet$appliances(cacheappliances);
                } else {
                    ((WishlistRealmProxyInterface) realmObject).realmSet$appliances(AppliancesRealmProxy.copyOrUpdate(realm, appliancesObj, update, cache));
                }
            } else {
                ((WishlistRealmProxyInterface) realmObject).realmSet$appliances(null);
            }
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.Wishlist object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long tableNativePtr = table.getNativeTablePointer();
        WishlistColumnInfo columnInfo = (WishlistColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((WishlistRealmProxyInterface) object).realmGet$appliances();
        if (appliancesObj != null) {
            Long cacheappliances = cache.get(appliancesObj);
            if (cacheappliances == null) {
                cacheappliances = AppliancesRealmProxy.insert(realm, appliancesObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.appliancesIndex, rowIndex, cacheappliances, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long tableNativePtr = table.getNativeTablePointer();
        WishlistColumnInfo columnInfo = (WishlistColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Wishlist.class);
        com.tip.robinsonsappliances.models.data.Wishlist object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Wishlist) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((WishlistRealmProxyInterface) object).realmGet$appliances();
                if (appliancesObj != null) {
                    Long cacheappliances = cache.get(appliancesObj);
                    if (cacheappliances == null) {
                        cacheappliances = AppliancesRealmProxy.insert(realm, appliancesObj, cache);
                    }
                    table.setLink(columnInfo.appliancesIndex, rowIndex, cacheappliances, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Wishlist object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long tableNativePtr = table.getNativeTablePointer();
        WishlistColumnInfo columnInfo = (WishlistColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((WishlistRealmProxyInterface) object).realmGet$appliances();
        if (appliancesObj != null) {
            Long cacheappliances = cache.get(appliancesObj);
            if (cacheappliances == null) {
                cacheappliances = AppliancesRealmProxy.insertOrUpdate(realm, appliancesObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.appliancesIndex, rowIndex, cacheappliances, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.appliancesIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Wishlist.class);
        long tableNativePtr = table.getNativeTablePointer();
        WishlistColumnInfo columnInfo = (WishlistColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Wishlist.class);
        com.tip.robinsonsappliances.models.data.Wishlist object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Wishlist) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((WishlistRealmProxyInterface) object).realmGet$appliances();
                if (appliancesObj != null) {
                    Long cacheappliances = cache.get(appliancesObj);
                    if (cacheappliances == null) {
                        cacheappliances = AppliancesRealmProxy.insertOrUpdate(realm, appliancesObj, cache);
                    }
                    Table.nativeSetLink(tableNativePtr, columnInfo.appliancesIndex, rowIndex, cacheappliances, false);
                } else {
                    Table.nativeNullifyLink(tableNativePtr, columnInfo.appliancesIndex, rowIndex);
                }
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.Wishlist createDetachedCopy(com.tip.robinsonsappliances.models.data.Wishlist realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.Wishlist unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.Wishlist)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.Wishlist)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.Wishlist();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }

        // Deep copy of appliances
        ((WishlistRealmProxyInterface) unmanagedObject).realmSet$appliances(AppliancesRealmProxy.createDetachedCopy(((WishlistRealmProxyInterface) realmObject).realmGet$appliances(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Wishlist = [");
        stringBuilder.append("{appliances:");
        stringBuilder.append(realmGet$appliances() != null ? "Appliances" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistRealmProxy aWishlist = (WishlistRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aWishlist.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aWishlist.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aWishlist.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}

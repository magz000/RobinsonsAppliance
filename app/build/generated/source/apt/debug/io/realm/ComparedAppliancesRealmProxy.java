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

public class ComparedAppliancesRealmProxy extends com.tip.robinsonsappliances.models.data.ComparedAppliances
    implements RealmObjectProxy, ComparedAppliancesRealmProxyInterface {

    static final class ComparedAppliancesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long appliancesIndex;

        ComparedAppliancesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(1);
            this.appliancesIndex = getValidColumnIndex(path, table, "ComparedAppliances", "appliances");
            indicesMap.put("appliances", this.appliancesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ComparedAppliancesColumnInfo otherInfo = (ComparedAppliancesColumnInfo) other;
            this.appliancesIndex = otherInfo.appliancesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ComparedAppliancesColumnInfo clone() {
            return (ComparedAppliancesColumnInfo) super.clone();
        }

    }
    private ComparedAppliancesColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("appliances");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ComparedAppliancesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ComparedAppliancesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.ComparedAppliances.class, this);
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
        if (!realmSchema.contains("ComparedAppliances")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ComparedAppliances");
            if (!realmSchema.contains("Appliances")) {
                AppliancesRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("appliances", RealmFieldType.OBJECT, realmSchema.get("Appliances")));
            return realmObjectSchema;
        }
        return realmSchema.get("ComparedAppliances");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ComparedAppliances")) {
            Table table = sharedRealm.getTable("class_ComparedAppliances");
            if (!sharedRealm.hasTable("class_Appliances")) {
                AppliancesRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "appliances", sharedRealm.getTable("class_Appliances"));
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_ComparedAppliances");
    }

    public static ComparedAppliancesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ComparedAppliances")) {
            Table table = sharedRealm.getTable("class_ComparedAppliances");
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

            final ComparedAppliancesColumnInfo columnInfo = new ComparedAppliancesColumnInfo(sharedRealm.getPath(), table);

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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ComparedAppliances' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ComparedAppliances";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.ComparedAppliances createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("appliances")) {
            excludeFields.add("appliances");
        }
        com.tip.robinsonsappliances.models.data.ComparedAppliances obj = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.ComparedAppliances.class, true, excludeFields);
        if (json.has("appliances")) {
            if (json.isNull("appliances")) {
                ((ComparedAppliancesRealmProxyInterface) obj).realmSet$appliances(null);
            } else {
                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = AppliancesRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("appliances"), update);
                ((ComparedAppliancesRealmProxyInterface) obj).realmSet$appliances(appliancesObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.ComparedAppliances createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.tip.robinsonsappliances.models.data.ComparedAppliances obj = new com.tip.robinsonsappliances.models.data.ComparedAppliances();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("appliances")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ComparedAppliancesRealmProxyInterface) obj).realmSet$appliances(null);
                } else {
                    com.tip.robinsonsappliances.models.data.Appliances appliancesObj = AppliancesRealmProxy.createUsingJsonStream(realm, reader);
                    ((ComparedAppliancesRealmProxyInterface) obj).realmSet$appliances(appliancesObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.tip.robinsonsappliances.models.data.ComparedAppliances copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.ComparedAppliances object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.ComparedAppliances) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.tip.robinsonsappliances.models.data.ComparedAppliances copy(Realm realm, com.tip.robinsonsappliances.models.data.ComparedAppliances newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.ComparedAppliances) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.ComparedAppliances realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.ComparedAppliances.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((ComparedAppliancesRealmProxyInterface) newObject).realmGet$appliances();
            if (appliancesObj != null) {
                com.tip.robinsonsappliances.models.data.Appliances cacheappliances = (com.tip.robinsonsappliances.models.data.Appliances) cache.get(appliancesObj);
                if (cacheappliances != null) {
                    ((ComparedAppliancesRealmProxyInterface) realmObject).realmSet$appliances(cacheappliances);
                } else {
                    ((ComparedAppliancesRealmProxyInterface) realmObject).realmSet$appliances(AppliancesRealmProxy.copyOrUpdate(realm, appliancesObj, update, cache));
                }
            } else {
                ((ComparedAppliancesRealmProxyInterface) realmObject).realmSet$appliances(null);
            }
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.ComparedAppliances object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        ComparedAppliancesColumnInfo columnInfo = (ComparedAppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((ComparedAppliancesRealmProxyInterface) object).realmGet$appliances();
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
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        ComparedAppliancesColumnInfo columnInfo = (ComparedAppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        com.tip.robinsonsappliances.models.data.ComparedAppliances object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.ComparedAppliances) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((ComparedAppliancesRealmProxyInterface) object).realmGet$appliances();
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

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.ComparedAppliances object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        ComparedAppliancesColumnInfo columnInfo = (ComparedAppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((ComparedAppliancesRealmProxyInterface) object).realmGet$appliances();
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
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        ComparedAppliancesColumnInfo columnInfo = (ComparedAppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.ComparedAppliances.class);
        com.tip.robinsonsappliances.models.data.ComparedAppliances object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.ComparedAppliances) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                com.tip.robinsonsappliances.models.data.Appliances appliancesObj = ((ComparedAppliancesRealmProxyInterface) object).realmGet$appliances();
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

    public static com.tip.robinsonsappliances.models.data.ComparedAppliances createDetachedCopy(com.tip.robinsonsappliances.models.data.ComparedAppliances realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.ComparedAppliances unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.ComparedAppliances)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.ComparedAppliances)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.ComparedAppliances();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }

        // Deep copy of appliances
        ((ComparedAppliancesRealmProxyInterface) unmanagedObject).realmSet$appliances(AppliancesRealmProxy.createDetachedCopy(((ComparedAppliancesRealmProxyInterface) realmObject).realmGet$appliances(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ComparedAppliances = [");
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
        ComparedAppliancesRealmProxy aComparedAppliances = (ComparedAppliancesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aComparedAppliances.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aComparedAppliances.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aComparedAppliances.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}

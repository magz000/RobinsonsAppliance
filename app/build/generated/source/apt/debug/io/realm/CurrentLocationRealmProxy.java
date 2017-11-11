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

public class CurrentLocationRealmProxy extends com.tip.robinsonsappliances.models.data.CurrentLocation
    implements RealmObjectProxy, CurrentLocationRealmProxyInterface {

    static final class CurrentLocationColumnInfo extends ColumnInfo
        implements Cloneable {

        public long latitudeIndex;
        public long longitudeIndex;

        CurrentLocationColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.latitudeIndex = getValidColumnIndex(path, table, "CurrentLocation", "latitude");
            indicesMap.put("latitude", this.latitudeIndex);
            this.longitudeIndex = getValidColumnIndex(path, table, "CurrentLocation", "longitude");
            indicesMap.put("longitude", this.longitudeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CurrentLocationColumnInfo otherInfo = (CurrentLocationColumnInfo) other;
            this.latitudeIndex = otherInfo.latitudeIndex;
            this.longitudeIndex = otherInfo.longitudeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CurrentLocationColumnInfo clone() {
            return (CurrentLocationColumnInfo) super.clone();
        }

    }
    private CurrentLocationColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("latitude");
        fieldNames.add("longitude");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CurrentLocationRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CurrentLocationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.CurrentLocation.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public double realmGet$latitude() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudeIndex);
    }

    public void realmSet$latitude(double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitudeIndex, value);
    }

    @SuppressWarnings("cast")
    public double realmGet$longitude() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudeIndex);
    }

    public void realmSet$longitude(double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitudeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("CurrentLocation")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CurrentLocation");
            realmObjectSchema.add(new Property("latitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("longitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("CurrentLocation");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_CurrentLocation")) {
            Table table = sharedRealm.getTable("class_CurrentLocation");
            table.addColumn(RealmFieldType.DOUBLE, "latitude", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "longitude", Table.NOT_NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_CurrentLocation");
    }

    public static CurrentLocationColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_CurrentLocation")) {
            Table table = sharedRealm.getTable("class_CurrentLocation");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CurrentLocationColumnInfo columnInfo = new CurrentLocationColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("latitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'latitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("latitude") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'latitude' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.latitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'latitude' does support null values in the existing Realm file. Use corresponding boxed type for field 'latitude' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("longitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'longitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("longitude") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'longitude' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.longitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'longitude' does support null values in the existing Realm file. Use corresponding boxed type for field 'longitude' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CurrentLocation' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CurrentLocation";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.CurrentLocation createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tip.robinsonsappliances.models.data.CurrentLocation obj = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.CurrentLocation.class, true, excludeFields);
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
            } else {
                ((CurrentLocationRealmProxyInterface) obj).realmSet$latitude((double) json.getDouble("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
            } else {
                ((CurrentLocationRealmProxyInterface) obj).realmSet$longitude((double) json.getDouble("longitude"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.CurrentLocation createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.tip.robinsonsappliances.models.data.CurrentLocation obj = new com.tip.robinsonsappliances.models.data.CurrentLocation();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("latitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
                } else {
                    ((CurrentLocationRealmProxyInterface) obj).realmSet$latitude((double) reader.nextDouble());
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
                } else {
                    ((CurrentLocationRealmProxyInterface) obj).realmSet$longitude((double) reader.nextDouble());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.tip.robinsonsappliances.models.data.CurrentLocation copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.CurrentLocation object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.CurrentLocation) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.tip.robinsonsappliances.models.data.CurrentLocation copy(Realm realm, com.tip.robinsonsappliances.models.data.CurrentLocation newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.CurrentLocation) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.CurrentLocation realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.CurrentLocation.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CurrentLocationRealmProxyInterface) realmObject).realmSet$latitude(((CurrentLocationRealmProxyInterface) newObject).realmGet$latitude());
            ((CurrentLocationRealmProxyInterface) realmObject).realmSet$longitude(((CurrentLocationRealmProxyInterface) newObject).realmGet$longitude());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.CurrentLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long tableNativePtr = table.getNativeTablePointer();
        CurrentLocationColumnInfo columnInfo = (CurrentLocationColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$latitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$longitude(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long tableNativePtr = table.getNativeTablePointer();
        CurrentLocationColumnInfo columnInfo = (CurrentLocationColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        com.tip.robinsonsappliances.models.data.CurrentLocation object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.CurrentLocation) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$latitude(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$longitude(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.CurrentLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long tableNativePtr = table.getNativeTablePointer();
        CurrentLocationColumnInfo columnInfo = (CurrentLocationColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$latitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$longitude(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        long tableNativePtr = table.getNativeTablePointer();
        CurrentLocationColumnInfo columnInfo = (CurrentLocationColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.CurrentLocation.class);
        com.tip.robinsonsappliances.models.data.CurrentLocation object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.CurrentLocation) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$latitude(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, ((CurrentLocationRealmProxyInterface)object).realmGet$longitude(), false);
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.CurrentLocation createDetachedCopy(com.tip.robinsonsappliances.models.data.CurrentLocation realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.CurrentLocation unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.CurrentLocation)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.CurrentLocation)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.CurrentLocation();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CurrentLocationRealmProxyInterface) unmanagedObject).realmSet$latitude(((CurrentLocationRealmProxyInterface) realmObject).realmGet$latitude());
        ((CurrentLocationRealmProxyInterface) unmanagedObject).realmSet$longitude(((CurrentLocationRealmProxyInterface) realmObject).realmGet$longitude());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CurrentLocation = [");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude());
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
        CurrentLocationRealmProxy aCurrentLocation = (CurrentLocationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCurrentLocation.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCurrentLocation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCurrentLocation.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}

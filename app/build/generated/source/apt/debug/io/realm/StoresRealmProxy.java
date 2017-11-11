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

public class StoresRealmProxy extends com.tip.robinsonsappliances.models.data.Stores
    implements RealmObjectProxy, StoresRealmProxyInterface {

    static final class StoresColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long contactIndex;
        public long addressIndex;

        StoresColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(3);
            this.nameIndex = getValidColumnIndex(path, table, "Stores", "name");
            indicesMap.put("name", this.nameIndex);
            this.contactIndex = getValidColumnIndex(path, table, "Stores", "contact");
            indicesMap.put("contact", this.contactIndex);
            this.addressIndex = getValidColumnIndex(path, table, "Stores", "address");
            indicesMap.put("address", this.addressIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final StoresColumnInfo otherInfo = (StoresColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.contactIndex = otherInfo.contactIndex;
            this.addressIndex = otherInfo.addressIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final StoresColumnInfo clone() {
            return (StoresColumnInfo) super.clone();
        }

    }
    private StoresColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("contact");
        fieldNames.add("address");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    StoresRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (StoresColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.Stores.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$contact() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contactIndex);
    }

    public void realmSet$contact(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contactIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contactIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contactIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contactIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$address() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    public void realmSet$address(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Stores")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Stores");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contact", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Stores");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Stores")) {
            Table table = sharedRealm.getTable("class_Stores");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contact", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "address", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_Stores");
    }

    public static StoresColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Stores")) {
            Table table = sharedRealm.getTable("class_Stores");
            final long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                if (columnCount < 3) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final StoresColumnInfo columnInfo = new StoresColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("contact")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contact' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("contact") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contact' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.contactIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contact' is required. Either set @Required to field 'contact' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("address")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("address") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.addressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address' is required. Either set @Required to field 'address' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Stores' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Stores";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.Stores createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tip.robinsonsappliances.models.data.Stores obj = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Stores.class, true, excludeFields);
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((StoresRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((StoresRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("contact")) {
            if (json.isNull("contact")) {
                ((StoresRealmProxyInterface) obj).realmSet$contact(null);
            } else {
                ((StoresRealmProxyInterface) obj).realmSet$contact((String) json.getString("contact"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                ((StoresRealmProxyInterface) obj).realmSet$address(null);
            } else {
                ((StoresRealmProxyInterface) obj).realmSet$address((String) json.getString("address"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.Stores createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.tip.robinsonsappliances.models.data.Stores obj = new com.tip.robinsonsappliances.models.data.Stores();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((StoresRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((StoresRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("contact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((StoresRealmProxyInterface) obj).realmSet$contact(null);
                } else {
                    ((StoresRealmProxyInterface) obj).realmSet$contact((String) reader.nextString());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((StoresRealmProxyInterface) obj).realmSet$address(null);
                } else {
                    ((StoresRealmProxyInterface) obj).realmSet$address((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.tip.robinsonsappliances.models.data.Stores copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Stores object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Stores) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.tip.robinsonsappliances.models.data.Stores copy(Realm realm, com.tip.robinsonsappliances.models.data.Stores newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Stores) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.Stores realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Stores.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((StoresRealmProxyInterface) realmObject).realmSet$name(((StoresRealmProxyInterface) newObject).realmGet$name());
            ((StoresRealmProxyInterface) realmObject).realmSet$contact(((StoresRealmProxyInterface) newObject).realmGet$contact());
            ((StoresRealmProxyInterface) realmObject).realmSet$address(((StoresRealmProxyInterface) newObject).realmGet$address());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.Stores object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Stores.class);
        long tableNativePtr = table.getNativeTablePointer();
        StoresColumnInfo columnInfo = (StoresColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Stores.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$name = ((StoresRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$contact = ((StoresRealmProxyInterface)object).realmGet$contact();
        if (realmGet$contact != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactIndex, rowIndex, realmGet$contact, false);
        }
        String realmGet$address = ((StoresRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Stores.class);
        long tableNativePtr = table.getNativeTablePointer();
        StoresColumnInfo columnInfo = (StoresColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Stores.class);
        com.tip.robinsonsappliances.models.data.Stores object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Stores) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$name = ((StoresRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$contact = ((StoresRealmProxyInterface)object).realmGet$contact();
                if (realmGet$contact != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactIndex, rowIndex, realmGet$contact, false);
                }
                String realmGet$address = ((StoresRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Stores object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Stores.class);
        long tableNativePtr = table.getNativeTablePointer();
        StoresColumnInfo columnInfo = (StoresColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Stores.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$name = ((StoresRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$contact = ((StoresRealmProxyInterface)object).realmGet$contact();
        if (realmGet$contact != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactIndex, rowIndex, realmGet$contact, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactIndex, rowIndex, false);
        }
        String realmGet$address = ((StoresRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Stores.class);
        long tableNativePtr = table.getNativeTablePointer();
        StoresColumnInfo columnInfo = (StoresColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Stores.class);
        com.tip.robinsonsappliances.models.data.Stores object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Stores) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$name = ((StoresRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$contact = ((StoresRealmProxyInterface)object).realmGet$contact();
                if (realmGet$contact != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactIndex, rowIndex, realmGet$contact, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactIndex, rowIndex, false);
                }
                String realmGet$address = ((StoresRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.Stores createDetachedCopy(com.tip.robinsonsappliances.models.data.Stores realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.Stores unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.Stores)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.Stores)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.Stores();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((StoresRealmProxyInterface) unmanagedObject).realmSet$name(((StoresRealmProxyInterface) realmObject).realmGet$name());
        ((StoresRealmProxyInterface) unmanagedObject).realmSet$contact(((StoresRealmProxyInterface) realmObject).realmGet$contact());
        ((StoresRealmProxyInterface) unmanagedObject).realmSet$address(((StoresRealmProxyInterface) realmObject).realmGet$address());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Stores = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact:");
        stringBuilder.append(realmGet$contact() != null ? realmGet$contact() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
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
        StoresRealmProxy aStores = (StoresRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aStores.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aStores.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aStores.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}

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

public class UserRealmProxy extends com.tip.robinsonsappliances.models.data.User
    implements RealmObjectProxy, UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long fbIdIndex;
        public long userNameIndex;
        public long firstNameIndex;
        public long lastNameIndex;
        public long contactNoIndex;
        public long imageLinkIndex;

        UserColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.idIndex = getValidColumnIndex(path, table, "User", "id");
            indicesMap.put("id", this.idIndex);
            this.fbIdIndex = getValidColumnIndex(path, table, "User", "fbId");
            indicesMap.put("fbId", this.fbIdIndex);
            this.userNameIndex = getValidColumnIndex(path, table, "User", "userName");
            indicesMap.put("userName", this.userNameIndex);
            this.firstNameIndex = getValidColumnIndex(path, table, "User", "firstName");
            indicesMap.put("firstName", this.firstNameIndex);
            this.lastNameIndex = getValidColumnIndex(path, table, "User", "lastName");
            indicesMap.put("lastName", this.lastNameIndex);
            this.contactNoIndex = getValidColumnIndex(path, table, "User", "contactNo");
            indicesMap.put("contactNo", this.contactNoIndex);
            this.imageLinkIndex = getValidColumnIndex(path, table, "User", "imageLink");
            indicesMap.put("imageLink", this.imageLinkIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UserColumnInfo otherInfo = (UserColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.fbIdIndex = otherInfo.fbIdIndex;
            this.userNameIndex = otherInfo.userNameIndex;
            this.firstNameIndex = otherInfo.firstNameIndex;
            this.lastNameIndex = otherInfo.lastNameIndex;
            this.contactNoIndex = otherInfo.contactNoIndex;
            this.imageLinkIndex = otherInfo.imageLinkIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final UserColumnInfo clone() {
            return (UserColumnInfo) super.clone();
        }

    }
    private UserColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("fbId");
        fieldNames.add("userName");
        fieldNames.add("firstName");
        fieldNames.add("lastName");
        fieldNames.add("contactNo");
        fieldNames.add("imageLink");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UserRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.User.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    public void realmSet$id(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$fbId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fbIdIndex);
    }

    public void realmSet$fbId(String value) {
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
                row.getTable().setNull(columnInfo.fbIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fbIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fbIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fbIdIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$userName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userNameIndex);
    }

    public void realmSet$userName(String value) {
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
                row.getTable().setNull(columnInfo.userNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$firstName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstNameIndex);
    }

    public void realmSet$firstName(String value) {
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
                row.getTable().setNull(columnInfo.firstNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$lastName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastNameIndex);
    }

    public void realmSet$lastName(String value) {
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
                row.getTable().setNull(columnInfo.lastNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$contactNo() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contactNoIndex);
    }

    public void realmSet$contactNo(String value) {
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
                row.getTable().setNull(columnInfo.contactNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contactNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contactNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contactNoIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$imageLink() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageLinkIndex);
    }

    public void realmSet$imageLink(String value) {
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
                row.getTable().setNull(columnInfo.imageLinkIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageLinkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageLinkIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageLinkIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("User")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("User");
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("fbId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("userName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("firstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("lastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("contactNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("imageLink", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("User");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "fbId", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "userName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "firstName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "lastName", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "contactNo", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "imageLink", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_User");
    }

    public static UserColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            final long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UserColumnInfo columnInfo = new UserColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("fbId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fbId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("fbId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fbId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.fbIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fbId' is required. Either set @Required to field 'fbId' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("userName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'userName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("userName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'userName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.userNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'userName' is required. Either set @Required to field 'userName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("firstName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'firstName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("firstName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'firstName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.firstNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'firstName' is required. Either set @Required to field 'firstName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("lastName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lastName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("lastName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'lastName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.lastNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'lastName' is required. Either set @Required to field 'lastName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("contactNo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contactNo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("contactNo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contactNo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.contactNoIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contactNo' is required. Either set @Required to field 'contactNo' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("imageLink")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'imageLink' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("imageLink") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'imageLink' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.imageLinkIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'imageLink' is required. Either set @Required to field 'imageLink' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'User' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_User";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tip.robinsonsappliances.models.data.User obj = null;
        if (update) {
            Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.tip.robinsonsappliances.models.data.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.tip.robinsonsappliances.models.data.User.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("fbId")) {
            if (json.isNull("fbId")) {
                ((UserRealmProxyInterface) obj).realmSet$fbId(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$fbId((String) json.getString("fbId"));
            }
        }
        if (json.has("userName")) {
            if (json.isNull("userName")) {
                ((UserRealmProxyInterface) obj).realmSet$userName(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$userName((String) json.getString("userName"));
            }
        }
        if (json.has("firstName")) {
            if (json.isNull("firstName")) {
                ((UserRealmProxyInterface) obj).realmSet$firstName(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$firstName((String) json.getString("firstName"));
            }
        }
        if (json.has("lastName")) {
            if (json.isNull("lastName")) {
                ((UserRealmProxyInterface) obj).realmSet$lastName(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$lastName((String) json.getString("lastName"));
            }
        }
        if (json.has("contactNo")) {
            if (json.isNull("contactNo")) {
                ((UserRealmProxyInterface) obj).realmSet$contactNo(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$contactNo((String) json.getString("contactNo"));
            }
        }
        if (json.has("imageLink")) {
            if (json.isNull("imageLink")) {
                ((UserRealmProxyInterface) obj).realmSet$imageLink(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$imageLink((String) json.getString("imageLink"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.tip.robinsonsappliances.models.data.User obj = new com.tip.robinsonsappliances.models.data.User();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("fbId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$fbId(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$fbId((String) reader.nextString());
                }
            } else if (name.equals("userName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$userName(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$userName((String) reader.nextString());
                }
            } else if (name.equals("firstName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$firstName(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$firstName((String) reader.nextString());
                }
            } else if (name.equals("lastName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$lastName(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$lastName((String) reader.nextString());
                }
            } else if (name.equals("contactNo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$contactNo(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$contactNo((String) reader.nextString());
                }
            } else if (name.equals("imageLink")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$imageLink(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$imageLink((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.tip.robinsonsappliances.models.data.User copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.User) cachedRealmObject;
        } else {
            com.tip.robinsonsappliances.models.data.User realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((UserRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.UserRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.User copy(Realm realm, com.tip.robinsonsappliances.models.data.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.User) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.User realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.User.class, ((UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((UserRealmProxyInterface) realmObject).realmSet$fbId(((UserRealmProxyInterface) newObject).realmGet$fbId());
            ((UserRealmProxyInterface) realmObject).realmSet$userName(((UserRealmProxyInterface) newObject).realmGet$userName());
            ((UserRealmProxyInterface) realmObject).realmSet$firstName(((UserRealmProxyInterface) newObject).realmGet$firstName());
            ((UserRealmProxyInterface) realmObject).realmSet$lastName(((UserRealmProxyInterface) newObject).realmGet$lastName());
            ((UserRealmProxyInterface) realmObject).realmSet$contactNo(((UserRealmProxyInterface) newObject).realmGet$contactNo());
            ((UserRealmProxyInterface) realmObject).realmSet$imageLink(((UserRealmProxyInterface) newObject).realmGet$imageLink());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$fbId = ((UserRealmProxyInterface)object).realmGet$fbId();
        if (realmGet$fbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fbIdIndex, rowIndex, realmGet$fbId, false);
        }
        String realmGet$userName = ((UserRealmProxyInterface)object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
        }
        String realmGet$firstName = ((UserRealmProxyInterface)object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
        }
        String realmGet$lastName = ((UserRealmProxyInterface)object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
        }
        String realmGet$contactNo = ((UserRealmProxyInterface)object).realmGet$contactNo();
        if (realmGet$contactNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactNoIndex, rowIndex, realmGet$contactNo, false);
        }
        String realmGet$imageLink = ((UserRealmProxyInterface)object).realmGet$imageLink();
        if (realmGet$imageLink != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, realmGet$imageLink, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.tip.robinsonsappliances.models.data.User object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$fbId = ((UserRealmProxyInterface)object).realmGet$fbId();
                if (realmGet$fbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fbIdIndex, rowIndex, realmGet$fbId, false);
                }
                String realmGet$userName = ((UserRealmProxyInterface)object).realmGet$userName();
                if (realmGet$userName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
                }
                String realmGet$firstName = ((UserRealmProxyInterface)object).realmGet$firstName();
                if (realmGet$firstName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
                }
                String realmGet$lastName = ((UserRealmProxyInterface)object).realmGet$lastName();
                if (realmGet$lastName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
                }
                String realmGet$contactNo = ((UserRealmProxyInterface)object).realmGet$contactNo();
                if (realmGet$contactNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactNoIndex, rowIndex, realmGet$contactNo, false);
                }
                String realmGet$imageLink = ((UserRealmProxyInterface)object).realmGet$imageLink();
                if (realmGet$imageLink != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, realmGet$imageLink, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$fbId = ((UserRealmProxyInterface)object).realmGet$fbId();
        if (realmGet$fbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fbIdIndex, rowIndex, realmGet$fbId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fbIdIndex, rowIndex, false);
        }
        String realmGet$userName = ((UserRealmProxyInterface)object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userNameIndex, rowIndex, false);
        }
        String realmGet$firstName = ((UserRealmProxyInterface)object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstNameIndex, rowIndex, false);
        }
        String realmGet$lastName = ((UserRealmProxyInterface)object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastNameIndex, rowIndex, false);
        }
        String realmGet$contactNo = ((UserRealmProxyInterface)object).realmGet$contactNo();
        if (realmGet$contactNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contactNoIndex, rowIndex, realmGet$contactNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contactNoIndex, rowIndex, false);
        }
        String realmGet$imageLink = ((UserRealmProxyInterface)object).realmGet$imageLink();
        if (realmGet$imageLink != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, realmGet$imageLink, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.tip.robinsonsappliances.models.data.User object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$fbId = ((UserRealmProxyInterface)object).realmGet$fbId();
                if (realmGet$fbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fbIdIndex, rowIndex, realmGet$fbId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fbIdIndex, rowIndex, false);
                }
                String realmGet$userName = ((UserRealmProxyInterface)object).realmGet$userName();
                if (realmGet$userName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.userNameIndex, rowIndex, false);
                }
                String realmGet$firstName = ((UserRealmProxyInterface)object).realmGet$firstName();
                if (realmGet$firstName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.firstNameIndex, rowIndex, realmGet$firstName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.firstNameIndex, rowIndex, false);
                }
                String realmGet$lastName = ((UserRealmProxyInterface)object).realmGet$lastName();
                if (realmGet$lastName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.lastNameIndex, rowIndex, realmGet$lastName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.lastNameIndex, rowIndex, false);
                }
                String realmGet$contactNo = ((UserRealmProxyInterface)object).realmGet$contactNo();
                if (realmGet$contactNo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contactNoIndex, rowIndex, realmGet$contactNo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contactNoIndex, rowIndex, false);
                }
                String realmGet$imageLink = ((UserRealmProxyInterface)object).realmGet$imageLink();
                if (realmGet$imageLink != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, realmGet$imageLink, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imageLinkIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.User createDetachedCopy(com.tip.robinsonsappliances.models.data.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.User unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.User)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.User)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((UserRealmProxyInterface) unmanagedObject).realmSet$id(((UserRealmProxyInterface) realmObject).realmGet$id());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$fbId(((UserRealmProxyInterface) realmObject).realmGet$fbId());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$userName(((UserRealmProxyInterface) realmObject).realmGet$userName());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$firstName(((UserRealmProxyInterface) realmObject).realmGet$firstName());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$lastName(((UserRealmProxyInterface) realmObject).realmGet$lastName());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$contactNo(((UserRealmProxyInterface) realmObject).realmGet$contactNo());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$imageLink(((UserRealmProxyInterface) realmObject).realmGet$imageLink());
        return unmanagedObject;
    }

    static com.tip.robinsonsappliances.models.data.User update(Realm realm, com.tip.robinsonsappliances.models.data.User realmObject, com.tip.robinsonsappliances.models.data.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UserRealmProxyInterface) realmObject).realmSet$fbId(((UserRealmProxyInterface) newObject).realmGet$fbId());
        ((UserRealmProxyInterface) realmObject).realmSet$userName(((UserRealmProxyInterface) newObject).realmGet$userName());
        ((UserRealmProxyInterface) realmObject).realmSet$firstName(((UserRealmProxyInterface) newObject).realmGet$firstName());
        ((UserRealmProxyInterface) realmObject).realmSet$lastName(((UserRealmProxyInterface) newObject).realmGet$lastName());
        ((UserRealmProxyInterface) realmObject).realmSet$contactNo(((UserRealmProxyInterface) newObject).realmGet$contactNo());
        ((UserRealmProxyInterface) realmObject).realmSet$imageLink(((UserRealmProxyInterface) newObject).realmGet$imageLink());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fbId:");
        stringBuilder.append(realmGet$fbId() != null ? realmGet$fbId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userName:");
        stringBuilder.append(realmGet$userName() != null ? realmGet$userName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstName:");
        stringBuilder.append(realmGet$firstName() != null ? realmGet$firstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastName:");
        stringBuilder.append(realmGet$lastName() != null ? realmGet$lastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contactNo:");
        stringBuilder.append(realmGet$contactNo() != null ? realmGet$contactNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imageLink:");
        stringBuilder.append(realmGet$imageLink() != null ? realmGet$imageLink() : "null");
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
        UserRealmProxy aUser = (UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}

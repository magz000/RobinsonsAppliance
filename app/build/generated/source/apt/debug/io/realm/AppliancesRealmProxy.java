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

public class AppliancesRealmProxy extends com.tip.robinsonsappliances.models.data.Appliances
    implements RealmObjectProxy, AppliancesRealmProxyInterface {

    static final class AppliancesColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nameIndex;
        public long priceIndex;
        public long actualPriceIndex;
        public long specsIndex;
        public long brandIndex;
        public long typeIndex;
        public long barcodeIndex;
        public long imageIndex;

        AppliancesColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(9);
            this.idIndex = getValidColumnIndex(path, table, "Appliances", "id");
            indicesMap.put("id", this.idIndex);
            this.nameIndex = getValidColumnIndex(path, table, "Appliances", "name");
            indicesMap.put("name", this.nameIndex);
            this.priceIndex = getValidColumnIndex(path, table, "Appliances", "price");
            indicesMap.put("price", this.priceIndex);
            this.actualPriceIndex = getValidColumnIndex(path, table, "Appliances", "actualPrice");
            indicesMap.put("actualPrice", this.actualPriceIndex);
            this.specsIndex = getValidColumnIndex(path, table, "Appliances", "specs");
            indicesMap.put("specs", this.specsIndex);
            this.brandIndex = getValidColumnIndex(path, table, "Appliances", "brand");
            indicesMap.put("brand", this.brandIndex);
            this.typeIndex = getValidColumnIndex(path, table, "Appliances", "type");
            indicesMap.put("type", this.typeIndex);
            this.barcodeIndex = getValidColumnIndex(path, table, "Appliances", "barcode");
            indicesMap.put("barcode", this.barcodeIndex);
            this.imageIndex = getValidColumnIndex(path, table, "Appliances", "image");
            indicesMap.put("image", this.imageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final AppliancesColumnInfo otherInfo = (AppliancesColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.priceIndex = otherInfo.priceIndex;
            this.actualPriceIndex = otherInfo.actualPriceIndex;
            this.specsIndex = otherInfo.specsIndex;
            this.brandIndex = otherInfo.brandIndex;
            this.typeIndex = otherInfo.typeIndex;
            this.barcodeIndex = otherInfo.barcodeIndex;
            this.imageIndex = otherInfo.imageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final AppliancesColumnInfo clone() {
            return (AppliancesColumnInfo) super.clone();
        }

    }
    private AppliancesColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("price");
        fieldNames.add("actualPrice");
        fieldNames.add("specs");
        fieldNames.add("brand");
        fieldNames.add("type");
        fieldNames.add("barcode");
        fieldNames.add("image");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    AppliancesRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AppliancesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.tip.robinsonsappliances.models.data.Appliances.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
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
    public double realmGet$price() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.priceIndex);
    }

    public void realmSet$price(double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.priceIndex, value);
    }

    @SuppressWarnings("cast")
    public double realmGet$actualPrice() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.actualPriceIndex);
    }

    public void realmSet$actualPrice(double value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.actualPriceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.actualPriceIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$specs() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.specsIndex);
    }

    public void realmSet$specs(String value) {
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
                row.getTable().setNull(columnInfo.specsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.specsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.specsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.specsIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$brand() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.brandIndex);
    }

    public void realmSet$brand(String value) {
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
                row.getTable().setNull(columnInfo.brandIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.brandIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.brandIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.brandIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$type() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    public void realmSet$type(String value) {
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
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$barcode() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.barcodeIndex);
    }

    public void realmSet$barcode(String value) {
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
                row.getTable().setNull(columnInfo.barcodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.barcodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.barcodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.barcodeIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$image() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    public void realmSet$image(String value) {
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
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Appliances")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Appliances");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("actualPrice", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("specs", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("brand", RealmFieldType.STRING, !Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("barcode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Appliances");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Appliances")) {
            Table table = sharedRealm.getTable("class_Appliances");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "price", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "actualPrice", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "specs", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "brand", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "type", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "barcode", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "image", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.addSearchIndex(table.getColumnIndex("brand"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_Appliances");
    }

    public static AppliancesColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Appliances")) {
            Table table = sharedRealm.getTable("class_Appliances");
            final long columnCount = table.getColumnCount();
            if (columnCount != 9) {
                if (columnCount < 9) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 9 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 9 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 9 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final AppliancesColumnInfo columnInfo = new AppliancesColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("price")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'price' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("price") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'price' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.priceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'price' does support null values in the existing Realm file. Use corresponding boxed type for field 'price' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("actualPrice")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'actualPrice' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("actualPrice") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'actualPrice' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.actualPriceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'actualPrice' does support null values in the existing Realm file. Use corresponding boxed type for field 'actualPrice' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("specs")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'specs' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("specs") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'specs' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.specsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'specs' is required. Either set @Required to field 'specs' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("brand")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'brand' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("brand") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'brand' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.brandIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'brand' is required. Either set @Required to field 'brand' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("brand"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'brand' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("type")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("type") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'type' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.typeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' is required. Either set @Required to field 'type' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("barcode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'barcode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("barcode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'barcode' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.barcodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'barcode' is required. Either set @Required to field 'barcode' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("image")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'image' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("image") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'image' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.imageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'image' is required. Either set @Required to field 'image' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Appliances' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Appliances";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.tip.robinsonsappliances.models.data.Appliances createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tip.robinsonsappliances.models.data.Appliances obj = null;
        if (update) {
            Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class), false, Collections.<String> emptyList());
                    obj = new io.realm.AppliancesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.AppliancesRealmProxy) realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Appliances.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.AppliancesRealmProxy) realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Appliances.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("actualPrice")) {
            if (json.isNull("actualPrice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'actualPrice' to null.");
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$actualPrice((double) json.getDouble("actualPrice"));
            }
        }
        if (json.has("specs")) {
            if (json.isNull("specs")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$specs(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$specs((String) json.getString("specs"));
            }
        }
        if (json.has("brand")) {
            if (json.isNull("brand")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$brand(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$brand((String) json.getString("brand"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$type(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("barcode")) {
            if (json.isNull("barcode")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$barcode(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$barcode((String) json.getString("barcode"));
            }
        }
        if (json.has("image")) {
            if (json.isNull("image")) {
                ((AppliancesRealmProxyInterface) obj).realmSet$image(null);
            } else {
                ((AppliancesRealmProxyInterface) obj).realmSet$image((String) json.getString("image"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tip.robinsonsappliances.models.data.Appliances createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.tip.robinsonsappliances.models.data.Appliances obj = new com.tip.robinsonsappliances.models.data.Appliances();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$price((double) reader.nextDouble());
                }
            } else if (name.equals("actualPrice")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'actualPrice' to null.");
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$actualPrice((double) reader.nextDouble());
                }
            } else if (name.equals("specs")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$specs(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$specs((String) reader.nextString());
                }
            } else if (name.equals("brand")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$brand(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$brand((String) reader.nextString());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$type(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$type((String) reader.nextString());
                }
            } else if (name.equals("barcode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$barcode(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$barcode((String) reader.nextString());
                }
            } else if (name.equals("image")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AppliancesRealmProxyInterface) obj).realmSet$image(null);
                } else {
                    ((AppliancesRealmProxyInterface) obj).realmSet$image((String) reader.nextString());
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

    public static com.tip.robinsonsappliances.models.data.Appliances copyOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Appliances object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Appliances) cachedRealmObject;
        } else {
            com.tip.robinsonsappliances.models.data.Appliances realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((AppliancesRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.AppliancesRealmProxy();
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

    public static com.tip.robinsonsappliances.models.data.Appliances copy(Realm realm, com.tip.robinsonsappliances.models.data.Appliances newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tip.robinsonsappliances.models.data.Appliances) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.tip.robinsonsappliances.models.data.Appliances realmObject = realm.createObjectInternal(com.tip.robinsonsappliances.models.data.Appliances.class, ((AppliancesRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((AppliancesRealmProxyInterface) realmObject).realmSet$name(((AppliancesRealmProxyInterface) newObject).realmGet$name());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$price(((AppliancesRealmProxyInterface) newObject).realmGet$price());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$actualPrice(((AppliancesRealmProxyInterface) newObject).realmGet$actualPrice());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$specs(((AppliancesRealmProxyInterface) newObject).realmGet$specs());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$brand(((AppliancesRealmProxyInterface) newObject).realmGet$brand());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$type(((AppliancesRealmProxyInterface) newObject).realmGet$type());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$barcode(((AppliancesRealmProxyInterface) newObject).realmGet$barcode());
            ((AppliancesRealmProxyInterface) realmObject).realmSet$image(((AppliancesRealmProxyInterface) newObject).realmGet$image());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.tip.robinsonsappliances.models.data.Appliances object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppliancesColumnInfo columnInfo = (AppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((AppliancesRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AppliancesRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((AppliancesRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((AppliancesRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.actualPriceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$actualPrice(), false);
        String realmGet$specs = ((AppliancesRealmProxyInterface)object).realmGet$specs();
        if (realmGet$specs != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.specsIndex, rowIndex, realmGet$specs, false);
        }
        String realmGet$brand = ((AppliancesRealmProxyInterface)object).realmGet$brand();
        if (realmGet$brand != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.brandIndex, rowIndex, realmGet$brand, false);
        }
        String realmGet$type = ((AppliancesRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        String realmGet$barcode = ((AppliancesRealmProxyInterface)object).realmGet$barcode();
        if (realmGet$barcode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.barcodeIndex, rowIndex, realmGet$barcode, false);
        }
        String realmGet$image = ((AppliancesRealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppliancesColumnInfo columnInfo = (AppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.tip.robinsonsappliances.models.data.Appliances object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Appliances) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((AppliancesRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AppliancesRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((AppliancesRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((AppliancesRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.actualPriceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$actualPrice(), false);
                String realmGet$specs = ((AppliancesRealmProxyInterface)object).realmGet$specs();
                if (realmGet$specs != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.specsIndex, rowIndex, realmGet$specs, false);
                }
                String realmGet$brand = ((AppliancesRealmProxyInterface)object).realmGet$brand();
                if (realmGet$brand != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.brandIndex, rowIndex, realmGet$brand, false);
                }
                String realmGet$type = ((AppliancesRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                }
                String realmGet$barcode = ((AppliancesRealmProxyInterface)object).realmGet$barcode();
                if (realmGet$barcode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.barcodeIndex, rowIndex, realmGet$barcode, false);
                }
                String realmGet$image = ((AppliancesRealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tip.robinsonsappliances.models.data.Appliances object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppliancesColumnInfo columnInfo = (AppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((AppliancesRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AppliancesRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((AppliancesRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((AppliancesRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.actualPriceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$actualPrice(), false);
        String realmGet$specs = ((AppliancesRealmProxyInterface)object).realmGet$specs();
        if (realmGet$specs != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.specsIndex, rowIndex, realmGet$specs, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.specsIndex, rowIndex, false);
        }
        String realmGet$brand = ((AppliancesRealmProxyInterface)object).realmGet$brand();
        if (realmGet$brand != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.brandIndex, rowIndex, realmGet$brand, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.brandIndex, rowIndex, false);
        }
        String realmGet$type = ((AppliancesRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        String realmGet$barcode = ((AppliancesRealmProxyInterface)object).realmGet$barcode();
        if (realmGet$barcode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.barcodeIndex, rowIndex, realmGet$barcode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.barcodeIndex, rowIndex, false);
        }
        String realmGet$image = ((AppliancesRealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tip.robinsonsappliances.models.data.Appliances.class);
        long tableNativePtr = table.getNativeTablePointer();
        AppliancesColumnInfo columnInfo = (AppliancesColumnInfo) realm.schema.getColumnInfo(com.tip.robinsonsappliances.models.data.Appliances.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.tip.robinsonsappliances.models.data.Appliances object = null;
        while (objects.hasNext()) {
            object = (com.tip.robinsonsappliances.models.data.Appliances) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((AppliancesRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AppliancesRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((AppliancesRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((AppliancesRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.actualPriceIndex, rowIndex, ((AppliancesRealmProxyInterface)object).realmGet$actualPrice(), false);
                String realmGet$specs = ((AppliancesRealmProxyInterface)object).realmGet$specs();
                if (realmGet$specs != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.specsIndex, rowIndex, realmGet$specs, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.specsIndex, rowIndex, false);
                }
                String realmGet$brand = ((AppliancesRealmProxyInterface)object).realmGet$brand();
                if (realmGet$brand != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.brandIndex, rowIndex, realmGet$brand, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.brandIndex, rowIndex, false);
                }
                String realmGet$type = ((AppliancesRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
                }
                String realmGet$barcode = ((AppliancesRealmProxyInterface)object).realmGet$barcode();
                if (realmGet$barcode != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.barcodeIndex, rowIndex, realmGet$barcode, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.barcodeIndex, rowIndex, false);
                }
                String realmGet$image = ((AppliancesRealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.tip.robinsonsappliances.models.data.Appliances createDetachedCopy(com.tip.robinsonsappliances.models.data.Appliances realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tip.robinsonsappliances.models.data.Appliances unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tip.robinsonsappliances.models.data.Appliances)cachedObject.object;
            } else {
                unmanagedObject = (com.tip.robinsonsappliances.models.data.Appliances)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.tip.robinsonsappliances.models.data.Appliances();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$id(((AppliancesRealmProxyInterface) realmObject).realmGet$id());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$name(((AppliancesRealmProxyInterface) realmObject).realmGet$name());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$price(((AppliancesRealmProxyInterface) realmObject).realmGet$price());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$actualPrice(((AppliancesRealmProxyInterface) realmObject).realmGet$actualPrice());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$specs(((AppliancesRealmProxyInterface) realmObject).realmGet$specs());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$brand(((AppliancesRealmProxyInterface) realmObject).realmGet$brand());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$type(((AppliancesRealmProxyInterface) realmObject).realmGet$type());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$barcode(((AppliancesRealmProxyInterface) realmObject).realmGet$barcode());
        ((AppliancesRealmProxyInterface) unmanagedObject).realmSet$image(((AppliancesRealmProxyInterface) realmObject).realmGet$image());
        return unmanagedObject;
    }

    static com.tip.robinsonsappliances.models.data.Appliances update(Realm realm, com.tip.robinsonsappliances.models.data.Appliances realmObject, com.tip.robinsonsappliances.models.data.Appliances newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((AppliancesRealmProxyInterface) realmObject).realmSet$name(((AppliancesRealmProxyInterface) newObject).realmGet$name());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$price(((AppliancesRealmProxyInterface) newObject).realmGet$price());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$actualPrice(((AppliancesRealmProxyInterface) newObject).realmGet$actualPrice());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$specs(((AppliancesRealmProxyInterface) newObject).realmGet$specs());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$brand(((AppliancesRealmProxyInterface) newObject).realmGet$brand());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$type(((AppliancesRealmProxyInterface) newObject).realmGet$type());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$barcode(((AppliancesRealmProxyInterface) newObject).realmGet$barcode());
        ((AppliancesRealmProxyInterface) realmObject).realmSet$image(((AppliancesRealmProxyInterface) newObject).realmGet$image());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Appliances = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{actualPrice:");
        stringBuilder.append(realmGet$actualPrice());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{specs:");
        stringBuilder.append(realmGet$specs() != null ? realmGet$specs() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{brand:");
        stringBuilder.append(realmGet$brand() != null ? realmGet$brand() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{barcode:");
        stringBuilder.append(realmGet$barcode() != null ? realmGet$barcode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
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

}

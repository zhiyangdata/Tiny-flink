/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated

 *  Sunlly0 2022.8.20
 *  编译 thrift 文件后自动生成，定义了传输对象结构体
 *  更新：JsonString: 以字符串形式传输 StreamResult
 */
package org.team3090.simple.Worker.rpcClass;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)", date = "2022-08-20")
public class JsonString implements org.apache.thrift.TBase<JsonString, JsonString._Fields>, java.io.Serializable, Cloneable, Comparable<JsonString> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("JsonString");

  private static final org.apache.thrift.protocol.TField STREAM_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("StreamResult", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new JsonStringStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new JsonStringTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String StreamResult; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STREAM_RESULT((short)1, "StreamResult");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STREAM_RESULT
          return STREAM_RESULT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.STREAM_RESULT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STREAM_RESULT, new org.apache.thrift.meta_data.FieldMetaData("StreamResult", org.apache.thrift.TFieldRequirementType.OPTIONAL,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(JsonString.class, metaDataMap);
  }

  public JsonString() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public JsonString(JsonString other) {
    if (other.isSetStreamResult()) {
      this.StreamResult = other.StreamResult;
    }
  }

  public JsonString deepCopy() {
    return new JsonString(this);
  }

  @Override
  public void clear() {
    this.StreamResult = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getStreamResult() {
    return this.StreamResult;
  }

  public JsonString setStreamResult(@org.apache.thrift.annotation.Nullable java.lang.String StreamResult) {
    this.StreamResult = StreamResult;
    return this;
  }

  public void unsetStreamResult() {
    this.StreamResult = null;
  }

  /** Returns true if field StreamResult is set (has been assigned a value) and false otherwise */
  public boolean isSetStreamResult() {
    return this.StreamResult != null;
  }

  public void setStreamResultIsSet(boolean value) {
    if (!value) {
      this.StreamResult = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
      case STREAM_RESULT:
        if (value == null) {
          unsetStreamResult();
        } else {
          setStreamResult((java.lang.String)value);
        }
        break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
      case STREAM_RESULT:
        return getStreamResult();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
      case STREAM_RESULT:
        return isSetStreamResult();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof JsonString)
      return this.equals((JsonString)that);
    return false;
  }

  public boolean equals(JsonString that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_StreamResult = true && this.isSetStreamResult();
    boolean that_present_StreamResult = true && that.isSetStreamResult();
    if (this_present_StreamResult || that_present_StreamResult) {
      if (!(this_present_StreamResult && that_present_StreamResult))
        return false;
      if (!this.StreamResult.equals(that.StreamResult))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStreamResult()) ? 131071 : 524287);
    if (isSetStreamResult())
      hashCode = hashCode * 8191 + StreamResult.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(JsonString other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetStreamResult(), other.isSetStreamResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStreamResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.StreamResult, other.StreamResult);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("JsonString(");
    boolean first = true;

    if (isSetStreamResult()) {
      sb.append("StreamResult:");
      if (this.StreamResult == null) {
        sb.append("null");
      } else {
        sb.append(this.StreamResult);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class JsonStringStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public JsonStringStandardScheme getScheme() {
      return new JsonStringStandardScheme();
    }
  }

  private static class JsonStringStandardScheme extends org.apache.thrift.scheme.StandardScheme<JsonString> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, JsonString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // STREAM_RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.StreamResult = iprot.readString();
              struct.setStreamResultIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, JsonString struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.StreamResult != null) {
        if (struct.isSetStreamResult()) {
          oprot.writeFieldBegin(STREAM_RESULT_FIELD_DESC);
          oprot.writeString(struct.StreamResult);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class JsonStringTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public JsonStringTupleScheme getScheme() {
      return new JsonStringTupleScheme();
    }
  }

  private static class JsonStringTupleScheme extends org.apache.thrift.scheme.TupleScheme<JsonString> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, JsonString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStreamResult()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetStreamResult()) {
        oprot.writeString(struct.StreamResult);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, JsonString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.StreamResult = iprot.readString();
        struct.setStreamResultIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}


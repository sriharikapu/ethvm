/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.enkrypt.bolt.models.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Trace extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2922310203447165448L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Trace\",\"namespace\":\"io.enkrypt.bolt.models.avro\",\"fields\":[{\"name\":\"error\",\"type\":\"int\",\"desc\":\"Returns an error code if the transaction has failed, otherwise will return 0\"},{\"name\":\"transfers\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Transfer\",\"fields\":[{\"name\":\"op\",\"type\":\"int\",\"doc\":\"Type of op executed inside the transaction\"},{\"name\":\"value\",\"type\":\"bytes\",\"doc\":\"Raw value of the transaction\"},{\"name\":\"from\",\"type\":\"bytes\",\"doc\":\"Address of the sender\"},{\"name\":\"fromBalance\",\"type\":\"bytes\",\"doc\":\"Balance of the sender\"},{\"name\":\"to\",\"type\":\"bytes\",\"doc\":\"Address of the receiver\"},{\"name\":\"toBalance\",\"type\":\"bytes\",\"doc\":\"Balance of the receiver\"},{\"name\":\"input\",\"type\":\"bytes\",\"doc\":\"Raw input data\"}]}},\"desc\":\"An array describing transfers\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Trace> ENCODER =
      new BinaryMessageEncoder<Trace>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Trace> DECODER =
      new BinaryMessageDecoder<Trace>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Trace> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Trace> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Trace>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Trace to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Trace from a ByteBuffer. */
  public static Trace fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int error;
  @Deprecated public java.util.List<io.enkrypt.bolt.models.avro.Transfer> transfers;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Trace() {}

  /**
   * All-args constructor.
   * @param error The new value for error
   * @param transfers The new value for transfers
   */
  public Trace(java.lang.Integer error, java.util.List<io.enkrypt.bolt.models.avro.Transfer> transfers) {
    this.error = error;
    this.transfers = transfers;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return error;
    case 1: return transfers;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: error = (java.lang.Integer)value$; break;
    case 1: transfers = (java.util.List<io.enkrypt.bolt.models.avro.Transfer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'error' field.
   * @return The value of the 'error' field.
   */
  public java.lang.Integer getError() {
    return error;
  }

  /**
   * Sets the value of the 'error' field.
   * @param value the value to set.
   */
  public void setError(java.lang.Integer value) {
    this.error = value;
  }

  /**
   * Gets the value of the 'transfers' field.
   * @return The value of the 'transfers' field.
   */
  public java.util.List<io.enkrypt.bolt.models.avro.Transfer> getTransfers() {
    return transfers;
  }

  /**
   * Sets the value of the 'transfers' field.
   * @param value the value to set.
   */
  public void setTransfers(java.util.List<io.enkrypt.bolt.models.avro.Transfer> value) {
    this.transfers = value;
  }

  /**
   * Creates a new Trace RecordBuilder.
   * @return A new Trace RecordBuilder
   */
  public static io.enkrypt.bolt.models.avro.Trace.Builder newBuilder() {
    return new io.enkrypt.bolt.models.avro.Trace.Builder();
  }

  /**
   * Creates a new Trace RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Trace RecordBuilder
   */
  public static io.enkrypt.bolt.models.avro.Trace.Builder newBuilder(io.enkrypt.bolt.models.avro.Trace.Builder other) {
    return new io.enkrypt.bolt.models.avro.Trace.Builder(other);
  }

  /**
   * Creates a new Trace RecordBuilder by copying an existing Trace instance.
   * @param other The existing instance to copy.
   * @return A new Trace RecordBuilder
   */
  public static io.enkrypt.bolt.models.avro.Trace.Builder newBuilder(io.enkrypt.bolt.models.avro.Trace other) {
    return new io.enkrypt.bolt.models.avro.Trace.Builder(other);
  }

  /**
   * RecordBuilder for Trace instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Trace>
    implements org.apache.avro.data.RecordBuilder<Trace> {

    private int error;
    private java.util.List<io.enkrypt.bolt.models.avro.Transfer> transfers;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.enkrypt.bolt.models.avro.Trace.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.error)) {
        this.error = data().deepCopy(fields()[0].schema(), other.error);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.transfers)) {
        this.transfers = data().deepCopy(fields()[1].schema(), other.transfers);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Trace instance
     * @param other The existing instance to copy.
     */
    private Builder(io.enkrypt.bolt.models.avro.Trace other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.error)) {
        this.error = data().deepCopy(fields()[0].schema(), other.error);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.transfers)) {
        this.transfers = data().deepCopy(fields()[1].schema(), other.transfers);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'error' field.
      * @return The value.
      */
    public java.lang.Integer getError() {
      return error;
    }

    /**
      * Sets the value of the 'error' field.
      * @param value The value of 'error'.
      * @return This builder.
      */
    public io.enkrypt.bolt.models.avro.Trace.Builder setError(int value) {
      validate(fields()[0], value);
      this.error = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'error' field has been set.
      * @return True if the 'error' field has been set, false otherwise.
      */
    public boolean hasError() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'error' field.
      * @return This builder.
      */
    public io.enkrypt.bolt.models.avro.Trace.Builder clearError() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'transfers' field.
      * @return The value.
      */
    public java.util.List<io.enkrypt.bolt.models.avro.Transfer> getTransfers() {
      return transfers;
    }

    /**
      * Sets the value of the 'transfers' field.
      * @param value The value of 'transfers'.
      * @return This builder.
      */
    public io.enkrypt.bolt.models.avro.Trace.Builder setTransfers(java.util.List<io.enkrypt.bolt.models.avro.Transfer> value) {
      validate(fields()[1], value);
      this.transfers = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'transfers' field has been set.
      * @return True if the 'transfers' field has been set, false otherwise.
      */
    public boolean hasTransfers() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'transfers' field.
      * @return This builder.
      */
    public io.enkrypt.bolt.models.avro.Trace.Builder clearTransfers() {
      transfers = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Trace build() {
      try {
        Trace record = new Trace();
        record.error = fieldSetFlags()[0] ? this.error : (java.lang.Integer) defaultValue(fields()[0]);
        record.transfers = fieldSetFlags()[1] ? this.transfers : (java.util.List<io.enkrypt.bolt.models.avro.Transfer>) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Trace>
    WRITER$ = (org.apache.avro.io.DatumWriter<Trace>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Trace>
    READER$ = (org.apache.avro.io.DatumReader<Trace>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}

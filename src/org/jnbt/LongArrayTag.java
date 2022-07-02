package org.jnbt;

import java.util.Arrays;
import java.util.Locale;

/**
 * The {@code TAG_Long_Array} tag.
 */
public class LongArrayTag extends Tag {

    private final long[] value;

	/**
	 * Creates the tag.
	 * 
	 * @param name  The name.
	 * @param value The value.
	 */
	public LongArrayTag(final String name, final long[] value) {
		super(name);
        this.value = value;
    }

    @Override
    public long[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder hex = new StringBuilder();
        for (long b : value) {
            String hexDigits = Long.toHexString(b).toUpperCase(Locale.ROOT);
            if (hexDigits.length() == 1) {
                hex.append("0");
            }
            hex.append(hexDigits).append(" ");
        }
        return "TAG_Long_Array(" + hex + ")";
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + Arrays.hashCode(value);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof LongArrayTag)) {
			return false;
		}
		final LongArrayTag other = (LongArrayTag) obj;
		if (!Arrays.equals(value, other.value)) {
			return false;
		}
		return true;
	}
}

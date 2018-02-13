package seedu.addressbook.data.person;

/**
 * Represents a person's contact in the address book.
 */
public abstract class Contact {
    public String value;
    protected boolean isPrivate;

    /**
     * Returns true if the given string is a valid contact.
     */
    protected abstract boolean isValid(String test);

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

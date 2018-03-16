package seedu.addressbook.data.Tagging;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

import java.util.ArrayList;

/**
 * Records recently created and deleted Taggings.
 * Tagging represents an association between a person and a tag.
 */
public class Tagging {

    public static final int INVALID_INDEX = -1;
    /**
     * Lists all taggings as a String.
     */
    public static ArrayList<Tagging> uniqueTaggingList;
    public static ArrayList<String> toBePrintedTaggings;

    private Person person;
    private Tag tag;

    /**
     * Constructs a Tagging object.
     * new taggings are recorded in {@code} toBePrintedTaggings.
     */
    Tagging(Person person, Tag tag) {
        this.person = person;
        this.tag = tag;
        recordNewTagging(person, tag);
    }

    @Override
    /**
     * Records recently removed taggings.
     */
    private void finalize() throws Throwable {
        recordDeletedTagging();
    }

    /**
     * @return the printable form of all added/deleted taggings.
     */
    public static String getPrintableResult() {
        String printableTaggings;

        for (String tagging : toBePrintedTaggings) {
            printableTaggings = tagging + "\n";
        }
        return printableTaggings;
    }

    /**
     * Clears all element in the printable list.
     */
    public static reset() {
        toBePrintedTaggings.clear();
    }

    private void recordDeletedTagging() {
        toBePrintedTaggings.add(person.getName().toString() + " " + tag.toString());
        uniqueTaggingList.remove(getTargetIndex());
    }

    /**
     * @return index of tagging that will be removed.
     * @return INVALID_INDEX if tagging does not exist.
     */
    private int getTargetIndex() {
        for (int i = 0; i < uniqueTaggingList.size(); i++) {
            if(isSame(i)) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    private boolean isSame(int i) {
        return uniqueTaggingList.get(i).getPerson() == person && uniqueTaggingList.get(i).getTag() == tag;
    }

    private void recordNewTagging(Person person, Tag tag) {
        uniqueTaggingList.add(new Tagging(person, tag));
        toBePrintedTaggings.add(person.getName().toString() + " " + tag.toString());
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }
}

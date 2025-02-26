public interface Embedded {
    /* Returns the index of the opening bracket */
    int getStartIndex();

    /* Returns the index of the closing bracket */
    int getEndIndex();

    /* Returns the substring inside brackets */
    String getCommand();
}

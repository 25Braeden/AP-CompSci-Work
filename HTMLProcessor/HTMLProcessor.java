public class HTMLProcessor {
    // find first tag in string of text
    // a tag is enclosed by < [content] />
    // <em>some text</em>
    // first tag would be <em> and second tag would be </em>
    //
    // intuition:
    // str.indexOf('<') and str.indexOf('>') -> if either = -1 return null, else start there
    // if both these occur, return a new tag that is str.subtring(str.indexOf('<'), str.indexOf('>'))

    public static Tag findFirstTag(String text) {
        int startIndex = text.indexOf("<");
        int endIndex = text.indexOf(">", startIndex);

        if (startIndex == -1) return null;
        if (endIndex == -1) return null;

        String content = text.substring(startIndex + 1, endIndex);

        return new Tag(startIndex, endIndex + 1, content);
    }

    // String str = "<b>wow this is bold!</b> This is nothing!<i>italics?</i>"
    //
    // assume findFirstTag works -> we can keep removing the first tag from the string.
    //
    // we don't need to remove the words between the tags. Just the tags themselves
    //
    // findFirstTag will return null when no first tag is present.
    // while (tempTag != null) -> keep removing the tags
    //
    // str = str.subString(0, tempTag.getStartIndex()) + str.substring(tempTag.getEndIndex()) -> should remove first tag. Then keep looping.
    public static String removeAllTags(String text) {
        Tag someTag = findFirstTag(text);

        while (someTag != null) {
            text = text.substring(0, someTag.getStartIndex()) + text.substring(someTag.getEndIndex());
            someTag = findFirstTag(text);
        }

        return text;
    }

    public static void main(String[] args) {
        String text = "The <i>quick</i> <b>brown</b> fox <b>jumps <u>over</b> the lazy</u> dog";
        System.out.println(text);
        text = removeAllTags(text);
        System.out.println(text);

        // Mr. Schmidt I learned what args does. When running this (assuming youre using VSCode) press the button in the top right
        // to open terminal, then manually run it using 'java HTMLProcessor.java (argument)', if you enter the word 'test' after the .java
        // you'll run these test cases.

        // I don't remember if you can check if primative type list is empty and I'm using vim so no autofill... try catch it is!
        try {
            Object obj = args[0];
        } catch (Exception _) {
            System.exit(0);
        }

        if (!args[0].equals("test")) System.exit(0);

        String[] testCases = {
            "<b>Bolded!<i> Bolded and italics!</b></i>",
            "<a><b><c>rah</c></b></a>",
            "<wow this is a long tag!>Isn't that crazy?</wow this is a long tag>"
        };

        String[] testSolutions = new String[3];
        for (int i = 0; i < testCases.length; i++) {
            testSolutions[i] = removeAllTags(testCases[i]);
        }

        if (testSolutions[0].equalsIgnoreCase("Bolded! Bolded and italics!")) System.out.println("Case 1 passed.");
        if (testSolutions[1].equalsIgnoreCase("rah")) System.out.println("Case 2 passed.");
        if (testSolutions[2].equalsIgnoreCase("Isn't that crazy?")) System.out.println("Case 3 passed.");
    }
}

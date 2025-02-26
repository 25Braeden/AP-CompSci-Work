public class Tag implements Embedded{
    private int startIndex;
    private int endIndex;
    private String command;

    public Tag(int i, int j, String cmd) {
        this.startIndex = i;
        this.endIndex = j;
        this.command = cmd;
    }

    @Override
    public int getStartIndex() {
        return this.startIndex;
    }

    @Override
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override
    public String getCommand() {
        return this.command;
    }
}

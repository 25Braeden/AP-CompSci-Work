public record Tuple<A, B> (
        A first,
        B second
) {
    public Tuple {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Tuple arguments cannot be null");
        }
    }
    public Tuple<B, A> swap() {
        return new Tuple<>(second, first);
    }
    public static <A, B> Tuple<A, B> of (A first, B second) {
        return new Tuple<>(first, second);
    }
    public String asString() {
        return String.format("(%s, %s)", first, second);
    }
}

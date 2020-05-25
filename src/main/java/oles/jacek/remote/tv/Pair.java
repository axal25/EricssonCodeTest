package oles.jacek.remote.tv;

public final class Pair<A, B> {
    private final A left;
    private final B right;

    public Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    public A left() {
        return left;
    }

    public B right() {
        return right;
    }

    public String toString() {
        return String.format(
                "%s{ %s, %s }",
                this.getClass().getSimpleName(),
                String.format("left%s", left.getClass().getSimpleName()),
                String.format("right%s", right.getClass().getSimpleName().toLowerCase())
        );
    }
}

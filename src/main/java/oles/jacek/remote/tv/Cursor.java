package oles.jacek.remote.tv;

public class Cursor {
    private Coordinate position;
    private int clicks;

    public Cursor() {
        this.position = TvRemote.getKeyboard().get('a');
    }

    public void moveAndSelect(char c) {
        Coordinate nextPosition = TvRemote.getKeyboard().get(c);
        this.clicks += this.position.getClickDistance(nextPosition) + 1;
        this.position = nextPosition;
    }

    public Coordinate getPosition() {
        return position;
    }

    public int getClicks() {
        return clicks;
    }
}

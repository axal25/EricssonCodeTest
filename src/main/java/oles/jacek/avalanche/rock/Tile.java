package oles.jacek.avalanche.rock;

public enum Tile implements ITile {
    FREE {
        @Override
        public Coordinate getRocksNewCoordinate(Coordinate rocksCoordinate) {
            return new Coordinate(rocksCoordinate.getX(), rocksCoordinate.getY() + 1);
        }
    }; // .

    public enum SLOPE implements ITile {
        LEFT {
            @Override
            public Coordinate getRocksNewCoordinate(Coordinate rocksCoordinate) {
                return new Coordinate(rocksCoordinate.getX() - 1, rocksCoordinate.getY() + 1);
            }
        }, // /
        RIGHT {
            @Override
            public Coordinate getRocksNewCoordinate(Coordinate rocksCoordinate) {
                return new Coordinate(rocksCoordinate.getX() + 1, rocksCoordinate.getY() + 1);
            }
        }; // \
    }

    public enum ROCK implements ITile {
        STATIONARY, // _
        MOVABLE; // o

        @Override
        public Coordinate getRocksNewCoordinate(Coordinate rocksCoordinate) {
            return rocksCoordinate;
        }
    }
}

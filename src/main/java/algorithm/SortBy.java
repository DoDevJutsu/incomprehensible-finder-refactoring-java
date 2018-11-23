package algorithm;

public enum SortBy {

	Closer {
        @Override
        Pair choose(Pair pairA, Pair pairB) {
            return pairA.areCloserInAgeThan(pairB) ? pairA : pairB;
        }
    },

    Further {
        @Override
        Pair choose(Pair pairA, Pair pairB) {
            return pairA.areCloserInAgeThan(pairB) ? pairB : pairA;
        }
    };

    abstract Pair choose(Pair pairA, Pair pairB);
}

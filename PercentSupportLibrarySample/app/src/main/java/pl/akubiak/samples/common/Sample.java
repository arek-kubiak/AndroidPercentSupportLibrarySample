package pl.akubiak.samples.common;

public class Sample {

    private final int _id;
    private final String _title;

    public Sample(int id, String title) {
        _id = id;
        _title = title;
    }

    public int getId() {
        return _id;
    }

    @Override
    public String toString() {
        return _title;
    }
}
package com.example2.membership;

class DateRange {
    private long epochStart;
    private long epochEnd;

    public DateRange(long epochStart, long epochEnd) {
        this.epochStart = epochStart;
        this.epochEnd = epochEnd;
    }

    public long getEpochStart() {
        return epochStart;
    }

    public long getEpochEnd() {
        return epochEnd;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "epochStart=" + epochStart +
                ", epochEnd=" + epochEnd +
                '}';
    }
}

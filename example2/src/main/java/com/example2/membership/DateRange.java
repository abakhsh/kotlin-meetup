package com.example2.membership;

class DateRange {
    private long epochStart;
    private long epochEnd;

    DateRange(long epochStart, long epochEnd) {
        this.epochStart = epochStart;
        this.epochEnd = epochEnd;
    }

    long getEpochStart() {
        return epochStart;
    }

    long getEpochEnd() {
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

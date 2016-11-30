package com.preslavrachev.soundfeed.model.twitter;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by preslavrachev on 27/11/16.
 */
public class Timeline implements Iterable<ExtendedStatus> {

    private List<ExtendedStatus> statuses;
    private long start;
    private long size;

    @Override
    public Iterator<ExtendedStatus> iterator() {
        return statuses.iterator();
    }

    @Override
    public void forEach(Consumer<? super ExtendedStatus> action) {
        statuses.forEach(action);
    }

    @Override
    public Spliterator<ExtendedStatus> spliterator() {
        return statuses.spliterator();
    }

    public List<ExtendedStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<ExtendedStatus> statuses) {
        this.statuses = statuses;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Timeline{");
        sb.append("statuses=").append(statuses);
        sb.append(", start=").append(start);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}

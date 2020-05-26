package com.document;

import java.util.List;

public interface RecordsRepository<T> {
    List<T> getRecords();
}

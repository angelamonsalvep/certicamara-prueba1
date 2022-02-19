package com.certicamara.certicamaraprueba1.domain;

import java.time.LocalDateTime;

public class Query {

    private int queryId;
    private LocalDateTime date;

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

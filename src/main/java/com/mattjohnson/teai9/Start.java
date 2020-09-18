package com.mattjohnson.teai9;

import com.mattjohnson.teai9.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Start {

    private DbService dbService;

    @Autowired
    public Start(DbService dbService) {
        this.dbService = dbService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws IOException {

    }


}

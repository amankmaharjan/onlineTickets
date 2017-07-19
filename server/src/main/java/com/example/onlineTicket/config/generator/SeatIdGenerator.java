package com.example.onlineTicket.config.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aman on 7/11/17.
 */
public class SeatIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = "seat";
        Connection connection = session.connection();

        String uuid = UUID.randomUUID().toString().substring(0,7);
        return uuid;
    }

}

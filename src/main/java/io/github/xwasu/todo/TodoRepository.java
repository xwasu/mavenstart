package io.github.xwasu.todo;

import io.github.xwasu.HibernateUtil;
import io.github.xwasu.lang.Lang;

import java.util.List;

class TodoRepository {
    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Todo ", Todo.class).list();

        transaction.commit();
        session.close();
        return result;
    }
}

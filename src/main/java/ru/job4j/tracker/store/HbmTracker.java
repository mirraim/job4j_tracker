package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.Item;

import javax.persistence.Query;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item oldItem = session.get(Item.class, id);
        if (oldItem == null) {
            return false;
        }
        oldItem.setName(item.getName());
        oldItem.setDescription(item.getDescription());
        oldItem.setCreated(item.getCreated());
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item == null) {
            return false;
        }
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List rsl = session.createQuery("from Item ").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Item where name =: key");
        query.setParameter("key", key);
        List rsl = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}

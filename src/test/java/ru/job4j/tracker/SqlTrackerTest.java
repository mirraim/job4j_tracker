package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                                            .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
       connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void createItem() throws Exception {
       SqlTracker tracker = new SqlTracker(connection);
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
    }

    @Test
    public void whenReplace() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item bug = new Item("Bug");
            tracker.add(bug);
            int id = bug.getId();
            Item bugWithDesc = new Item("Bug with description");
            tracker.replace(id, bugWithDesc);
            assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item bug = new Item("Bug");
            tracker.add(bug);
            int id = bug.getId();
            tracker.delete(id);
            assertNull(tracker.findById(id));
    }

    @Test
    public void whenfindAll() throws Exception {
      SqlTracker tracker = new SqlTracker(connection);
            Item item1 = new Item("one");
            Item item2 = new Item("two");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findAll().size(), is(2));
    }

    @Test
    public void whenfindbyName() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item item1 = new Item("one");
            Item item2 = new Item("two");
            Item item3 = new Item("two");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findByName("two").size(), is(2));
    }

    @Test
    public void whenfindById() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
            Item item1 = new Item("one");
            Item item2 = new Item("two");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findById(item1.getId()).getName(), is("one"));
    }
}
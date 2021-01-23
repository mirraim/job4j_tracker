package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address address1 = new Address("Moscow", "Arbat", 12, 3);
        Address address2 = new Address("London", "Baker street", 3, 1);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> profiles = Arrays.asList(profile1, profile2);
        List<Address> expected = Arrays.asList(address1, address2);
    }

}
package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Profiles profiles = new Profiles();
        Address address1 = new Address("Moscow", "Arbat", 12, 3);
        Address address2 = new Address("London", "Baker street", 3, 1);
        Address address3 = new Address("Moscow", "Arbat", 12, 3);
        Address address4 = new Address("Paris", "Richelieu", 6, 1);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);
        List<Profile> profilesList = Arrays.asList(profile1, profile2, profile3, profile4);
        List<Address> expected = Arrays.asList(address2, address1, address4);
        assertThat(profiles.collect(profilesList), is(expected));
    }

}
package com.panopticode.problems.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateIPAddressTest {
    @DataProvider(name = "validIPAddresses")
    public static Object[][] validIPAddresses() {
        return new Object[][] {
                { "172.16.254.1", "IPv4" },
                { "192.168.1.1", "IPv4" },
                { "192.168.1.0", "IPv4" },
                { "192.168.01.1", "Neither" },
                { "192.168.1.00", "Neither" },
                { "192.168@1.1", "Neither" },
                { "2001:0db8:85a3:0:0:8a2e:0370:7334", "IPv6" },
                { "256.256.256.256", "Neither" },
                { "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "IPv6"},
                { "2001:db8:85a3:0:0:8A2E:0370:7334", "IPv6" },
                { "2001:0db8:85a3::8A2E:037j:7334", "Neither" },
                { "1e1.4.5.6", "Neither" },
                { "02001:0db8:85a3:0000:0000:8a2e:0370:7334", "Neither" },
        };
    }

    @Test(dataProvider = "validIPAddresses")
    public void testValidIPAddress(String address, String expected) {
        var sol = new ValidateIPAddress();

        assertEquals(sol.validIPAddress(address), expected);
    }
}
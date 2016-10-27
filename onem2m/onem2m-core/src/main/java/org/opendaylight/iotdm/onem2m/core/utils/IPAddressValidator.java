/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.iotdm.onem2m.core.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * Created by canwu on 11/19/15.
 */
public class IPAddressValidator {

    private static Pattern VALID_IPV4_PATTERN = null;
    private static Pattern VALID_IPV6_PATTERN = null;
    private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

    static {
        try {
            VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
            VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
        } catch (PatternSyntaxException e) {
            //logger.severe("Unable to compile pattern", e);
        }
    }

    /**
     * Determine if the given string is a valid IPv4 or IPv6 address.  This method
     * uses pattern matching to see if the given string could be a valid IP address.
     *
     * @param ipAddress A string that is to be examined to verify whether or not
     * it could be a valid IP address.
     * @return <code>true</code> if the string is a value that is a valid IP address,
     *  <code>false</code> otherwise.
     */
    public static boolean isIpAddress(String ipAddress) {
        Matcher m1 = VALID_IPV4_PATTERN.matcher(ipAddress);
        Matcher m2 = VALID_IPV6_PATTERN.matcher(ipAddress);
        return m1.matches() || m2.matches();
    }

    public static boolean isIpv4Address(String ipAddress) {
        Matcher m1 = VALID_IPV4_PATTERN.matcher(ipAddress);
        return m1.matches();

    }

    public static boolean isIpv6Address(String ipAddress) {
        Matcher m2 = VALID_IPV6_PATTERN.matcher(ipAddress);
        return m2.matches();
    }
}
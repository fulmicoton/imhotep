/*
 * Copyright (C) 2014 Indeed Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package com.indeed.imhotep.client;

/**
* @author jsgroth
*/
public class Host implements Comparable<Host> {
    public final String hostname;
    public final int port;

    public Host(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    @Override
    public int compareTo(Host o) {
        int c = hostname.compareTo(o.hostname);
        if (c != 0) {
            return c;
        }
        return port < o.port ? -1 : port > o.port ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Host host = (Host) o;

        if (port != host.port) return false;
        if (hostname != null ? !hostname.equals(host.hostname) : host.hostname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostname != null ? hostname.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    @Override
    public String toString() {
        return hostname+":"+port;
    }
}

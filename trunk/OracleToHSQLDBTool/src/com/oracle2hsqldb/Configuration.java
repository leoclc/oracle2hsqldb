/*
 * Schemamule, a library for automating database schema tasks
 * Copyright (C) 2006, Moses M. Hohman and Rhett Sutphin
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St., 5th Floor, Boston, MA  02110-1301

 * To contact the authors, send email to:
 * { mmhohman OR rsutphin } AT sourceforge DOT net
 */

package com.oracle2hsqldb;

import com.oracle2hsqldb.dialect.Dialect;
import com.oracle2hsqldb.dialect.GenericDialect;

/**
 * @author Moses Hohman
 */
public class Configuration {
    public static final Configuration DEFAULT_CONFIG = new Configuration(true, true, false, new GenericDialect());

    private boolean supportsPrimaryKeys;
    private boolean supportsForeignKeys;
    private boolean supportsSequences;
    private Dialect dialect;

    public Configuration(boolean supportsPrimaryKeys, boolean supportsForeignKeys, boolean supportsSequences, Dialect dialect) {
        this.supportsPrimaryKeys = supportsPrimaryKeys;
        this.supportsForeignKeys = supportsForeignKeys;
        this.supportsSequences = supportsSequences;
        this.dialect = dialect;
    }

    public boolean supportsPrimaryKeys() {
        return supportsPrimaryKeys;
    }

    public boolean supportsForeignKeys() {
        return supportsForeignKeys;
    }

    public boolean supportsUniqueKeys() {
        return dialect.supportsUnique();
    }

    public boolean supportsSequences() {
        return dialect.supportsSequences() && supportsSequences;
    }

    public Dialect dialect() {
        return dialect;
    }

    public void dialect(Dialect dialect) {
        this.dialect = dialect;
    }
}
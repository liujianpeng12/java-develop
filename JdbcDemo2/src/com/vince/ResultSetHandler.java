package com.vince;

import java.sql.ResultSet;

public interface ResultSetHandler {

	Object doHandler(ResultSet rs);
}

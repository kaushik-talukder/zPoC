package com.example.poc.sqlgenerator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlGenerator {
	private static String SCHEMA_PREFIX = "XSS";

	private static List<String> SEQ_NAME_LIST = null;
	private static List<String> TAB_NAME_LIST = null;

	static {
		SEQ_NAME_LIST = new ArrayList<>(Arrays.asList(new String[] { "GAME_SB_SALES_COACH_GRP_ID_SEQ" }));
	}

	static {
		TAB_NAME_LIST = new ArrayList<>(Arrays.asList(new String[] { "GAME_SB_SALES_COACH_STORE_GRP" }));
	}
	
	private static void printSequenceSql() {
		StringBuffer sequenceSql = new StringBuffer().append("CREATE SEQUENCE {0}_OWN.{1}  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;");
		if("XSS".equalsIgnoreCase(SCHEMA_PREFIX)) {
			sequenceSql = sequenceSql
					.append("\n").append("GRANT SELECT ON {0}_OWN.{1} TO {0}_APPL;").append("\n");
					
		} else {
			sequenceSql = sequenceSql
					.append("\n").append("GRANT SELECT, ALTER ON {0}_OWN.{1} TO {0}_UPDATE_ROLE;").append("\n")
					.append("GRANT SELECT ON {0}_OWN.{1} TO {0}_SELECT_ROLE;").append("\n");
		}
		sequenceSql.append("CREATE OR REPLACE SYNONYM {0}_APPL.{1} FOR {0}_OWN.{1};").append("\n");
		MessageFormat mf = new MessageFormat(sequenceSql.toString());

		SEQ_NAME_LIST.stream().forEach(seq -> {
			System.out.println(mf.format(new Object[] { SCHEMA_PREFIX, seq }));
		});
	}
	
	private static void printTableSql() {
		StringBuffer tableSql = new StringBuffer()
				.append("CREATE TABLE {0}_OWN.{1} (") 
				.append("\n\n") 
				.append(") TABLESPACE {0}_DATA;") 
				.append("\n\n") 
				.append("CREATE UNIQUE INDEX {0}_OWN.{1}_PK ON {0}_OWN.{1} () TABLESPACE {0}_INDEX;") 
				.append("\n") 
				.append("ALTER TABLE {0}_OWN.{1} ADD CONSTRAINT {1}_PK PRIMARY KEY () USING INDEX;") 
				.append("\n\n");
		
		if("XSS".equalsIgnoreCase(SCHEMA_PREFIX)) {
			tableSql =  tableSql
					.append("GRANT SELECT,DELETE,INSERT,UPDATE ON {0}_OWN.{1} TO {0}_APPL;") 
					.append("\n");
					
		} else {
			tableSql = tableSql 
					.append("GRANT SELECT, INSERT, DELETE, UPDATE, ALTER ON {0}_OWN.{1} TO {0}_UPDATE_ROLE;") 
					.append("\n") 
					.append("GRANT SELECT ON {0}_OWN.{1} TO {0}_SELECT_ROLE;") 
					.append("\n");
		}
		tableSql.append("CREATE OR REPLACE SYNONYM {0}_APPL.{1} FOR {0}_OWN.{1};")
		.append("\n");
		MessageFormat mf = new MessageFormat(tableSql.toString());

		TAB_NAME_LIST.stream().forEach(tab -> {
			System.out.println(mf.format(new Object[] { SCHEMA_PREFIX, tab }));
		});
	}
	
	public static void main(String[] args) {
		printTableSql();
		printSequenceSql();
	}
}

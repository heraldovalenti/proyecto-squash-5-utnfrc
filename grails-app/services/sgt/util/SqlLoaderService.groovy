package sgt.util

import groovy.sql.Sql

class SqlLoaderService {

	def dataSource
	
    def loadInsertFile(String fileName) {
		String sqlStatement = new File("sqlScripts/" + fileName).text
		Sql sql = Sql.newInstance(dataSource)
		sql.executeInsert(sqlStatement)
    }
}

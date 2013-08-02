
	dataSource {
		pooled = true
		driverClassName = "com.mysql.jdbc.Driver"
	}
//	hibernate {
//	cache.use_second_level_cache=true
//	cache.use_query_cache=true
//	cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
//	}
	
	//create para crear la estructura de la bd y poder meterle cosas
	//update: una vez creada la bd poder recuperar y poner cosas
	//create-update: cuando modificamos un valor en la bd
	environments {
		development {
			 dataSource {
					dbCreate = "update"
					username = "matlock"
					password = "qwerty"
					url = "jdbc:mysql://127.0.0.1:3306/sgt"
			 }
		}
		test {
			 dataSource {
					dbCreate = "update"
					username = "matlock"
					password = "qwerty"
					url = "jdbc:mysql://127.0.0.1:3306/sgt"
			 }
		}
		production {
			 dataSource {
					dbCreate = "update"
					username = "matlock"
					password = "qwerty"
					url = "jdbc:mysql://127.0.0.1:3306/sgt"
			 }
		}
	}



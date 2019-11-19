make:
	sudo cp mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf
	sudo mysql -u root -p accounts < dump-accounts.sql

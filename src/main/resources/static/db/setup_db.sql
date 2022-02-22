create database shopquabbly;

create user 'shop_quabbly'@'localhost' identified by 'quab_stock123';
grant all privileges on shopquabbly.* to 'shop_quabbly'@'localhost';
flush privileges
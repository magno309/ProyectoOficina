create database Oficina;
use Oficina;

create table Clientes(
	Id int primary key auto_increment,
    Nombre varchar(45),
    Direccion  varchar(100),
    Telefono char(13)
)
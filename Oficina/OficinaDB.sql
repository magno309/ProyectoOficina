create database Oficina;
use Oficina;

create table Clientes(
	Id_Cliente int primary key auto_increment,
    Nombre varchar(45) not null,
    Direccion  varchar(100) not null default '',
    Telefono char(12) not null default '',
    Celular char(12) not null default ''
);

CREATE TABLE Servicios (
    Id_Servicio INT PRIMARY KEY AUTO_INCREMENT,
    Id_Cliente INT NOT NULL,
    Descripcion varchar(150) NOT NULL default '',
    Fecha DATE,
    FOREIGN KEY (Id_Cliente)
        REFERENCES Clientes (Id_Cliente)
);

delimiter $$
create procedure agregarCliente(
	Nombre varchar(45),
    Direccion  varchar(100),
    Telefono char(12),
    Celular char(12) )
BEGIN
	insert into Clientes (Nombre, Direccion, Telefono, Celular)
    values (Nombre, Direccion, Telefono, Celular);
END$$
delimiter ;

delimiter $$
create procedure agregarServicio(Id_Cliente INT,
    Descripcion TEXT,
    Fecha DATE)
BEGIN
	insert into Servicios (Id_Cliente, Descripcion, Fecha)
    values (Id_Cliente, Descripcion, Fecha);
END$$
delimiter ;

select * from Clientes;
alter table clientes auto_increment = 1;

call agregarCliente('Juanito Alcachofa', 'Granja Feliz', '', '');
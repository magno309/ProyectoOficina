create database Oficina;
use Oficina;

create table Clientes(
	Id_Cliente int primary key auto_increment,
    Nombre varchar(45) not null,
    Direccion  varchar(100),
    Telefono char(12),
    Celular char(12)
);

CREATE TABLE Servicios (
    Id_Servicio INT PRIMARY KEY AUTO_INCREMENT,
    Id_Cliente INT NOT NULL,
    Descripcion TEXT NOT NULL,
    Fecha DATE,
    FOREIGN KEY (Id_Cliente)
        REFERENCES Clientes (Id_Cliente)
);

delimiter $$
create procedure agregarCliente(Nombre varchar(45),
    Direccion  varchar(100),
    Telefono char(12),
    Celular char(12) )
BEGIN
	insert into Clientes (Nombre, Direccion, Telefono, Celular)
    values (Nombre, Direccion, Telefono, Celular);
END$$
delimiter ;

call agregarCliente('Amparo García', 'Bravo #57, Huandacareo, Mich', null, '551-349-0185');

select * from Clientes;

delimiter $$
create procedure agregarServicio(Id_Cliente INT,
    Descripcion TEXT,
    Fecha DATE)
BEGIN
	insert into Servicios (Id_Cliente, Descripcion, Fecha)
    values (Id_Cliente, Descripcion, Fecha);
END$$
delimiter ;

call agregarServicio(1, 'Reparación de puerta automatica', curdate());

select * from Clientes where nombre like 'Amp%';

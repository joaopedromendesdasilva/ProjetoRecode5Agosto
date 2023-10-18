CREATE DATABASE agencia_sql;
USE agencia_sql;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY,
    nomeCliente VARCHAR(255),
    cpfCliente VARCHAR(11),
    enderecoCliente VARCHAR(255),
    telefoneCliente VARCHAR(20)
);

CREATE TABLE Destino (
    idDestino INT PRIMARY KEY,
    precoDestino DECIMAL(10, 2),
    nomeDestino VARCHAR(255),
    descricaoDestino TEXT
);

CREATE TABLE Agencia (
    idAgencia INT PRIMARY KEY,
    idDestino INT,
    nomeAgencia VARCHAR(255),
    enderecoAgencia VARCHAR(255),
    telefoneAgencia VARCHAR(20),
    FOREIGN KEY (idDestino) REFERENCES Destino(idDestino)
);

CREATE TABLE Reservas (
    idReserva INT PRIMARY KEY,
    idCliente INT,
    idDestino INT,
    dataReserva DATE,
    quantidadePessoas INT,
    vagasDisponiveis INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idDestino) REFERENCES Destino(idDestino)
);

CREATE TABLE Viagem (
    idViagem INT PRIMARY KEY,
    idReserva INT,
    dataPartida DATE,
    dataRetorno DATE,
    FOREIGN KEY (idReserva) REFERENCES Reservas(idReserva)
);


INSERT INTO Cliente (idCliente, nomeCliente, cpfCliente, enderecoCliente, telefoneCliente)
VALUES (1, 'Cliente 1', '123.456.789-01', 'Endereço Cliente 1', '123-456-7890');

INSERT INTO Destino (idDestino, precoDestino, nomeDestino, descricaoDestino)
VALUES (1, 1000.00, 'Destino 1', 'Descrição Destino 1');

INSERT INTO Agencia (idAgencia, idDestino, nomeAgencia, enderecoAgencia, telefoneAgencia)
VALUES (1, 1, 'Agência 1', 'Endereço Agência 1', '987-654-3210');

INSERT INTO Reservas (idReserva, idCliente, idDestino, dataReserva, quantidadePessoas, vagasDisponiveis)
VALUES (1, 1, 1, '2023-10-15', 2, 8);

INSERT INTO Viagem (idViagem, idReserva, dataPartida, dataRetorno)
VALUES (1, 1, '2023-11-01', '2023-11-10');
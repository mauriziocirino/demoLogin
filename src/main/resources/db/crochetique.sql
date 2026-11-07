DROP DATABASE IF EXISTS Crochetique;

CREATE DATABASE IF NOT EXISTS Crochetique;
use Crochetique;

-- tabella cliente
CREATE TABLE Utente (
	id int auto_increment PRIMARY KEY,
    username varchar(50) not null unique,
    pass varchar(255) not null,
    ruolo enum('admin', 'user') not null,
    email varchar(100) not null unique
);

-- tabella pagamento
CREATE TABLE Pagamento(
	numCarta varchar(19),
    idUtente int not null,
    nomeIntestatario varchar(30) not null,
    cognomeIntestatario varchar(30) not null,
    meseScadenza tinyint not null,
    annoScadenza YEAR not null,
    PRIMARY KEY (idUtente, numCarta),
    FOREIGN KEY (idUtente)  REFERENCES Utente(id) on delete cascade
);
-- tabella tessuto + colore 
CREATE TABLE Tessuto (
    id int auto_increment primary key,
    materiale varchar(50) not null,
    coloreHEX varchar(7) not null CHECK (coloreHEX REGEXP('^#[0-9A-Fa-f]{6}'))
);
-- tabella modello
CREATE TABLE Modello(
	id int auto_increment primary key,
    chiusura enum('Cerniera', 'Clutch', 'Strap', 'Bottone', 'Nessuna') default 'Nessuna',
    nome varchar(30) not null
);

-- tabella catalogo
CREATE TABLE Catalogo(
	id int auto_increment primary key,
    nome varchar(30) not null,
    stagione enum('Estate', 'Autunno', 'Inverno', 'Primavera') not null,
    anno int not null
);

-- tabella articolo 
CREATE TABLE Articolo(
	id int auto_increment primary key,
    descrizione varchar(100) not null, 
    numAcquisti int default 0,
    foto longblob default null,
    dimensione enum('XS','S', 'M', 'L', 'XL'),
	price decimal(9,2) not null,
    codiceTessuto int not null,
    idCatalogo int,
	FOREIGN KEY (codiceTessuto) REFERENCES Tessuto(id),
    FOREIGN KEY (idCatalogo) REFERENCES Catalogo(id) on delete set null
);

-- tabella Borsa
CREATE TABLE Borsa(
	id int not null, 
    imbottitura bool default 0,
    idModello int not null,
    PRIMARY KEY(id),
    FOREIGN KEY(id) REFERENCES Articolo(id) on delete cascade,
    FOREIGN KEY(idModello)REFERENCES Modello(id) on delete cascade
);

-- tabella Accessorio
CREATE TABLE Accessorio(
	id int not null,
    indossabile tinyint default 0,
	PRIMARY KEY(id),
	FOREIGN KEY(id) REFERENCES Articolo(id) on delete cascade
);

-- ordine
CREATE TABLE Ordine (
	id int auto_increment primary key,
    idUtente int not null,
    via varchar(30) not null,
    civico varchar(6) not null,
    CAP varchar(5) not null,
    stato enum('Pagato', 'In Elaborazione', 'Spedito', 'Consegnato', 'Completato') not null,
    FOREIGN KEY (idUtente) REFERENCES Utente(id)
);

-- tabella articoloOrdine
CREATE TABLE articoloOrdine(
	idArticolo int not null,
    idOrdine int not null,
    quantity int default 1 not null,
    totPrezzo decimal(10,2) default 0.00,
    PRIMARY KEY (idArticolo, idOrdine),
    FOREIGN KEY(idArticolo) REFERENCES Articolo(id),
    FOREIGN KEY(idOrdine) REFERENCES Ordine(id) on delete cascade
);
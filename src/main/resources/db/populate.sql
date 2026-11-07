use crochetique;

-- Popolamento della tabella Tessuto
INSERT INTO Tessuto (materiale, coloreHEX) VALUES
('Cotone', "#FF0000"), 
('Lana', "#00FF00"),
('Seta', "#0000FF"),
('Poliestere', "#000000");

-- Popolamento della tabella Modello
INSERT INTO Modello (chiusura, nome) VALUES
('Cerniera', 'Borsa elegante'),
('Clutch', 'Borsa a tracolla'),
('Strap', 'Borsa da sera');

-- Popolamento della tabella Catalogo
INSERT INTO Catalogo (nome, stagione, anno) VALUES
('Borse Estate', 'Estate', 2020),
('Borse Autunno', 'Autunno', 2021),
('Borse Inverno', 'Inverno', 2021);

-- Popolamento della tabella Cliente
INSERT INTO Utente (username, pass, ruolo, email) VALUES
('admin', 'admin123', 'admin', 'admin@example.com'),
('user1', 'user123', 'user', 'user1@example.com'),
('user2', 'user456', 'user', 'user2@example.com'),
('userNull', 'userNull', 'user', 'user3@example.com');


-- Popolamento della tabella Articolo
INSERT INTO Articolo (descrizione, numAcquisti, foto, dimensione, price, codiceTessuto, idCatalogo) VALUES
('Borsa elegante in cotone', 10, 'https://dummyimage.com/600x400/bd8abd/fff.jpg&text=foto', 'M', 50.00, 1, 1),  -- venduta più di 2 volte
('Borsa a tracolla in lana', 5, 'https://dummyimage.com/600x400/e02fe0/4f58d6.jpg&text=foto1', 'L', 45.00, 2, 2),
('Borsa da sera in seta', 2, 'https://dummyimage.com/600x400/8fde2f/4f58d6.jpg&text=foto2', 'S', 60.00, 3, 3),
('Collana in poliestere', 15, 'https://dummyimage.com/600x400/de3131/ffffff.jpg&text=foto3', 'L', 30.00, 4, 1),
('Ciondolo in PELLE', 10, 'https://dummyimage.com/600x400/424242/ffffff.jpg&text=foto4', 'M', 50.00, 1, null);


-- Popolamento della tabella Borsa
INSERT INTO Borsa (id, imbottitura, idModello) VALUES
(1, 1, 1),  -- Prima borsa elegante
(2, 0, 2),  -- Borsa a tracolla
(3, 1, 3);  -- Borsa da sera

-- Popolamento della tabella Accessorio
INSERT INTO Accessorio (id, indossabile) VALUES
(4, 1),  -- Accessorio indossabile
(5, 0);  -- Accessorio non indossabile

-- Popolamento della tabella Ordine
INSERT INTO Ordine (idUtente, via, civico, CAP) VALUES
(1, 'Via Roma', '1', '00100'),
(2, 'Viale Milano', '12', '20100'),
(3, 'Piazza Garibaldi', '3', '30100'),
(1, 'Via Roma', '1', '00100');

-- Popolamento della tabella articoloOrdine
INSERT INTO articoloOrdine (idArticolo, idOrdine, quantity) VALUES
 (1, 1, 1), 
(2, 1, 1),
(3, 1, 1),  -- admin ha acquistato tutto
(4, 1, 1), 
(5, 1, 1),
(2, 2, 1),
(3, 3, 1),		-- ordine un solo articolo
(1, 2, 1),
(1, 3, 2);
SELECT * FROM ARTICOLO;
-- update totPrezzo in ArticoloOrdine
SET SQL_SAFE_UPDATES = 0;
update articoloOrdine aOrdi JOIN Articolo a on a.id=aOrdi.idArticolo
set totPrezzo= a.price * aOrdi.quantity;
SET SQL_SAFE_UPDATES = 1;

-- update numAcquisti
SET SQL_SAFE_UPDATES = 0;
UPDATE Articolo a
JOIN (
    SELECT idArticolo, SUM(quantity) AS totaleAcquisti
    FROM articoloOrdine
    GROUP BY idArticolo
) as aOrd ON a.id = aOrd.idArticolo
SET a.numAcquisti = aOrd.totaleAcquisti;
SET SQL_SAFE_UPDATES = 1;

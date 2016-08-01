DROP TABLE IF EXISTS TOPPING;
CREATE TABLE TOPPING (
NAME                VARCHAR20 NOT NULL,
KEY                 VARCHAR8 NOT NULL,
PRICE               INTEGER NOT NULL,
PRICE40             INTEGER NOT NULL,
IS_LIMITED          BOOLEAN,
IMAGE               TEXT,
FONT_COLOR          VARCHAR6,
BACKGROUND_COLOR    VARCHAR6,
VISIBLE             BOOLEAN
);

INSERT INTO TOPPING VALUES ('PIECZARKI', '1',       110, 200, 1, 'img/pieczarki.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CEBULA', '2',          80, 200, 1, 'img/cebula.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SALAMI_PEPERONI', '3', 150, 200, 1, 'img/pepperoni.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SALAMI', '4',          150, 200, 1, 'img/salami.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('PAPRYKA', '5',         120, 200, 1, 'img/papryka.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('KUKURYDZA', '6',       110, 200, 1, 'img/kukurydza.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('ANANAS', '7',          120, 200, 1, 'img/ananas.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SZYNKA', '8',          170, 200, 1, 'img/szynka.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('BOCZEK', '9',          170, 200, 1, 'img/boczek.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('OLIWKI', '10',         140, 200, 1, 'img/oliwki.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('POMIDOR', '11',        110, 200, 1, 'img/pomidor.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('PAPRYCZKI_PEPERONI', '12', 140, 200, 1, 'img/chili.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('RUKOLA', '13',         120, 200, 1, 'img/rukola.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('SZPINAK', '14',        120, 200, 1, 'img/szpinak.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('KURCZAK', '15',        290, 300, 1, 'img/kurczak.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('LAZUR', '16',          190, 200, 1, 'img/lazur.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('BROKULY', '17',        140, 200, 1, 'img/brokuly.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SUSZONE_POMIDORY', '18', 190, 200, 1, 'img/suszone_pomidory.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SER_FETA', '19',       190, 200, 1, 'img/feta.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SZYNKA_PROSCIUTTO', '20', 420, 600, 1, 'img/szynka_prosciutto.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('SER', 'SER',           180, 300, 0, 'img/ser.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('MIESO WOLOWE', '21',   300, 300, 1, 'img/wolowina.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CHORIZO', '22',        300, 300, 1, 'img/chorizo.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('RICOTTA', '23',        260, 300, 1, 'img/ricotto.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('GORGONZOLA', '24',     380, 500, 1, 'img/gorgonzola.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('OLIWKI ZIELONE', '25', 140, 200, 1, 'img/oliwki_zielone.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('KAPARY', '26',         190, 200, 1, 'img/kapary.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CZOSNEK', '27',        160, 200, 1, 'img/czosnek.png', '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('PARMEZAN', '28',       220, 300, 1, 'img/parmezan.png', '000000', '8c3c00','1');
INSERT INTO TOPPING VALUES ('STARTER', 'START',     0, 0, 0, 'img/ser.png', '000000', '8c3c00','0');
INSERT INTO TOPPING VALUES ('SLONECZNIK', '29',     100, 200, 1, 'img/slonecznik.png', '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('OSTRY SOS', 'OSTRY',   0, 0, 0, null, '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('BBQ', 'BBQ',           0, 0, 0, null, '000000', '8c3c00', '1');

DROP TABLE IF EXISTS ADDITION;
CREATE TABLE ADDITION (
NAME               VARCHAR20 NOT NULL,
KEY                VARCHAR8 NOT NULL,
PRICE              INTEGER NOT NULL,
PRIORITY           INTEGER,
IMAGE              TEXT,
FONT_COLOR         VARCHAR6,
BACKGROUND_COLOR   VARCHAR6,
CHICKEN     BOOLEAN
);

INSERT INTO ADDITION VALUES ('CZOSNKOWY',    'X',  150, 10, 'img/czosnkowy.png',  'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('POMIDOROWY',   'Y',  150, 20, 'img/pomidorowy.png', 'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('PIEKIELNY',    'Z',  150, 30, 'img/piekielny.png',  'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('SAMBAL',       'S',  150, 40, 'img/sambal.png',     'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('BBQ',          'Q',  240, 50, 'img/bbq.png',        'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('BBQ2',         'Q2', 150, 60, 'img/bbq.png',        'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('KETCHUP',   'KECHUP', 150, 70, null,        'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('OIL',        'OIL',  190, 80, 'img/oil.png',        'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('COLA',       'COL',  500, 90, 'img/cola.png',       'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('FANTA',      'FAN',  500, 100, 'img/fanta.png',      'ffffff', '3282ff', 0);
INSERT INTO ADDITION VALUES ('KURCZAK', 'KURCZAK', 2680, 110, null,                'ffffff', '3282ff', 1);
INSERT INTO ADDITION VALUES ('FRYTKI',      'FRY', 480, 120, null,                'ffffff', '3282ff', 1);
INSERT INTO ADDITION VALUES ('ZIEMNIAKI',  'ZIEM', 480, 130, null,                'ffffff', '3282ff', 1);

DROP TABLE IF EXISTS COMPOSITION;
CREATE TABLE COMPOSITION (
ID              INTEGER PRIMARY KEY AUTOINCREMENT,
KEY             VARCHAR8 NOT NULL,
PRICE           INTEGER NOT NULL,
PRIORITY        INTEGER,
NAME            VARCHAR20 NOT NULL,
TOPPINGS        TEXT
);

INSERT INTO COMPOSITION VALUES (1,  'STARTER',  '0',  0,  '1',  'START');
INSERT INTO COMPOSITION VALUES (2 ,  '1',  '0',  0,  '1',  '3,3,12,12,12,OSTRY');
INSERT INTO COMPOSITION VALUES (3 ,  '2',  '0',  0,  '1',  '11,5,6,14');
INSERT INTO COMPOSITION VALUES (4 ,  '3',  '0',  0,  '1',  '8,9,3,4');
INSERT INTO COMPOSITION VALUES (5 ,  '4',  '0',  0,  '1',  '1,3,4');
INSERT INTO COMPOSITION VALUES (6 ,  '5',  '0',  0,  '1',  '1,8,6');
INSERT INTO COMPOSITION VALUES (7 ,  '6',  '0',  0,  '1',  '8,6,7');
INSERT INTO COMPOSITION VALUES (8 ,  '7',  '0',  0,  '1',  '3,4,12');
INSERT INTO COMPOSITION VALUES (9 ,  '8',  '0',  0,  '1',  '8,9,5');
INSERT INTO COMPOSITION VALUES (10 ,  '9',  '0',  0,  '1',  '9,3,6,10');
INSERT INTO COMPOSITION VALUES (11,  '10',  '0',  0,  '1',  '1,9,11,6');
INSERT INTO COMPOSITION VALUES (12,  '11',  '0',  0,  '1',  '1,8,5,14');
INSERT INTO COMPOSITION VALUES (13,  '12',  '0',  0,  '1',  '1,8,11,10');
INSERT INTO COMPOSITION VALUES (14,  '13',  '0',  0,  '1',  '8,11,5,13');
INSERT INTO COMPOSITION VALUES (15,  '14',  '0',  0,  '1',  '1,3,4,12');
INSERT INTO COMPOSITION VALUES (16,  '15',  '0',  0,  '1',  '1,8,9,12');
INSERT INTO COMPOSITION VALUES (17,  '16',  '0',  0,  '1',  '3,4,11,12');
INSERT INTO COMPOSITION VALUES (18,  '17',  '0',  0,  '1',  '23,24,28');

DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
KEY             VARCHAR30 PRIMARY KEY NOT NULL,
VALUE           TEXT
);

INSERT INTO PROPERTY VALUES ('QUEUE_TOPPING_IN_ORDER',  'OSTRY,BBQ,SER,27,18,24,23,1,2,8,4,3,9,11,17,5,6,10,25,7,12,15,26,21,19,29,28,20,22,13,14');
INSERT INTO PROPERTY VALUES ('QUEUE_TOPPING_IN_FOOD_PANEL',  '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,SER,OSTRY,BBQ');

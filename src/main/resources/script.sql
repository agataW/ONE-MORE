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

INSERT INTO TOPPING VALUES ('PIECZARKI', '1',       110, 200, 1, 'img/food/pieczarki.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CEBULA', '2',          80, 200, 1, 'img/food/cebula.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SALAMI_PEPERONI', '3', 150, 200, 1, 'img/food/pepperoni.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SALAMI', '4',          150, 200, 1, 'img/food/salami.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('PAPRYKA', '5',         120, 200, 1, 'img/food/papryka.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('KUKURYDZA', '6',       110, 200, 1, 'img/food/kukurydza.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('ANANAS', '7',          120, 200, 1, 'img/food/ananas.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SZYNKA', '8',          170, 200, 1, 'img/food/szynka.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('BOCZEK', '9',          210, 300, 1, 'img/food/boczek.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('OLIWKI', '10',         140, 200, 1, 'img/food/oliwki.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('POMIDOR', '11',        110, 200, 1, 'img/food/pomidor.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('PAPRYCZKI_PEPERONI', '12', 140, 200, 1, 'img/food/chili.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('RUKOLA', '13',         120, 200, 1, 'img/food/rukola.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('SZPINAK', '14',        180, 300, 1, 'img/food/szpinak.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('KURCZAK', '15',        290, 300, 1, 'img/food/kurczak.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('OGOREK', '16',          190, 200, 1, 'img/food/ogorek.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('BROKULY', '17',        140, 200, 1, 'img/food/brokuly.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SUSZONE_POMIDORY', '18', 190, 200, 1, 'img/food/suszone_pomidory.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SER_FETA', '19',       190, 200, 1, 'img/food/feta.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('SZYNKA_PROSCIUTTO', '20', 420, 600, 1, 'img/food/szynka_prosciutto.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('SER', 'SER',           180, 300, 0, 'img/food/ser.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('MIESO WOLOWE', '21',   300, 300, 1, 'img/food/wolowina.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CHORIZO', '22',        300, 300, 1, 'img/food/chorizo.png', '000000', 'ff0000', '1');
INSERT INTO TOPPING VALUES ('RICOTTA', '23',        260, 300, 1, 'img/food/ricotto.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('GORGONZOLA', '24',     380, 500, 1, 'img/food/gorgonzola.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('OLIWKI ZIELONE', '25', 140, 200, 1, 'img/food/oliwki_zielone.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('KAPARY', '26',         190, 200, 1, 'img/food/kapary.png', '000000', '14c814', '1');
INSERT INTO TOPPING VALUES ('CZOSNEK', '27',        160, 200, 1, 'img/food/czosnek.png', '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('PARMEZAN', '28',       220, 300, 1, 'img/food/parmezan.png', '000000', '8c3c00','1');
INSERT INTO TOPPING VALUES ('STARTER', 'START',     0, 0, 0, 'img/food/ser.png', '000000', '8c3c00','0');
INSERT INTO TOPPING VALUES ('OSTRY SOS', 'OSTRY',   0, 0, 0, null, '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('BBQ', 'BBQ',           0, 0, 0, null, '000000', '8c3c00', '1');
INSERT INTO TOPPING VALUES ('BIALY', 'BIALY',       100, 200, 0, null, '000000', '8c3c00', '1');

DROP TABLE IF EXISTS ADDITION;
CREATE TABLE ADDITION (
NAME               VARCHAR20 NOT NULL,
KEY                VARCHAR8 NOT NULL,
PRICE              INTEGER NOT NULL,
IMAGE              TEXT,
CHICKEN            BOOLEAN
);

INSERT INTO ADDITION VALUES ('CZOSNKOWY',    'X',       200,    'img/food/czosnkowy.png',    0);
INSERT INTO ADDITION VALUES ('POMIDOROWY',   'Y',       200,    'img/food/pomidorowy.png',   0);
INSERT INTO ADDITION VALUES ('PIEKIELNY',    'Z',       200,    'img/food/piekielny.png',    0);
INSERT INTO ADDITION VALUES ('BBQ USA',    'Q USA',     300,    'img/food/bbq.png',          0);
INSERT INTO ADDITION VALUES ('BBQ',         'Q',        200,    'img/food/bbq.png',          0);
INSERT INTO ADDITION VALUES ('KETCHUP',   'KECHUP',     200,    null,                   0);
INSERT INTO ADDITION VALUES ('OIL',        'OIL',       300,    'img/food/oil.png',          0);
INSERT INTO ADDITION VALUES ('COLA',       'COL',       500,    'img/food/cola.png',         0);
INSERT INTO ADDITION VALUES ('KURCZAK', 'KURCZAK',      2700,   null,                   1);
INSERT INTO ADDITION VALUES ('KURCZAK XXL', 'KUR XXL',  4350,   null,                   1);
INSERT INTO ADDITION VALUES ('FRYTKI',      'FRY',      500,    null,                   1);
INSERT INTO ADDITION VALUES ('ZIEMNIAKI',  'ZIEM',      600,    null,                   1);
INSERT INTO ADDITION VALUES ('M1',  'M1',               2300,   null,                   0);
INSERT INTO ADDITION VALUES ('M2',  'M2',               2300,   null,                   0);
INSERT INTO ADDITION VALUES ('M3',  'M3',               2300,   null,                   0);

DROP TABLE IF EXISTS COMPOSITION;
CREATE TABLE COMPOSITION (
KEY             VARCHAR8 NOT NULL,
TOPPINGS        TEXT
);

INSERT INTO COMPOSITION VALUES ('STARTER', 'START');
INSERT INTO COMPOSITION VALUES ('1', '3,3,12,12,12,OSTRY');
INSERT INTO COMPOSITION VALUES ('2', '11,5,6,14');
INSERT INTO COMPOSITION VALUES ('3', '8,9,3,4');
INSERT INTO COMPOSITION VALUES ('4', '1,3,4');
INSERT INTO COMPOSITION VALUES ('5', '1,8,6');
INSERT INTO COMPOSITION VALUES ('6', '8,6,7');
INSERT INTO COMPOSITION VALUES ('7', '3,4,12');
INSERT INTO COMPOSITION VALUES ('8', '8,9,5');
INSERT INTO COMPOSITION VALUES ('9', '9,3,6,10');
INSERT INTO COMPOSITION VALUES ('10', '1,9,11,6');
INSERT INTO COMPOSITION VALUES ('11', '1,8,5,14');
INSERT INTO COMPOSITION VALUES ('12', '1,8,11,10');
INSERT INTO COMPOSITION VALUES ('13', '8,11,5,13');
INSERT INTO COMPOSITION VALUES ('14', '1,3,4,12');
INSERT INTO COMPOSITION VALUES ('15', '1,8,9,12');
INSERT INTO COMPOSITION VALUES ('16', '3,4,11,12');
INSERT INTO COMPOSITION VALUES ('17', '23,24,28');

DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
KEY             VARCHAR30 PRIMARY KEY NOT NULL,
VALUE           TEXT
);

INSERT INTO PROPERTY VALUES ('QUEUE_TOPPING_IN_ORDER',  'OSTRY,BBQ,BIALY,SER,27,18,24,23,1,2,8,4,3,9,11,14,17,5,6,10,25,7,12,15,26,21,19,29,28,20,22,13');
INSERT INTO PROPERTY VALUES ('QUEUE_TOPPING_IN_FOOD_PANEL',  '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,SER,OSTRY,BBQ,BIALY');
INSERT INTO PROPERTY VALUES ('ADDITION_PRIORITY',  'X,Y,Z,Q USA,Q,KECHUP,OIL,COL,KURCZAK,KUR XXL,FRY,ZIEM,M1,M2,M3');

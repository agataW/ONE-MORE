CREATE TABLE IF NOT EXISTS TOPPING (
    ID                  INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME                VARCHAR20 NOT NULL,
    KEY                 VARCHAR8 NOT NULL,
    PRICE               INTEGER NOT NULL,
    PRIORITY            INTEGER,
    IS_LIMITED          BOOLEAN,
    IMAGE               TEXT,
    FONT_COLOR          VARCHAR6,
    BACKGROUND_COLOR    VARCHAR6,
    VISIBLE             BOOLEAN
);


INSERT OR IGNORE INTO TOPPING VALUES (1,    'PIECZARKI',            '1',       70,    10,    1,   'img/pieczarki.png',           '000000',   'ff0000',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (2,    'CEBULA',               '2',       30,    20,    1,   'img/cebula.png',              '000000',   'ff0000',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (3,    'SALAMI_PEPERONI',      '3',       110,   50,    1,   'img/pepperoni.png',           '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (4,    'SALAMI',               '4',       110,   60,    1,   'img/salami.png',              '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (5,    'PAPRYKA',              '5',       80,    120,   1,   'img/papryka.png',             '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (6,    'KUKURYDZA',            '6',       70,    150,   1,   'img/kukurydza.png',           '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (7,    'ANANAS',               '7',       110,   130,   1,   'img/ananas.png',              '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (8,    'SZYNKA',               '8',       120,   30,    1,   'img/szynka.png',              '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (9,    'BOCZEK',               '9',       120,   40,    1,   'img/boczek.png',              '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (10,   'OLIWKI',               '10',      70,    130,   1,   'img/oliwki.png',              '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (11,   'POMIDOR',              '11',      70,    110,   1,   'img/pomidor.png',             '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (12,   'PAPRYCZKI_PEPERONI',   '12',      90,    160,   1,   'img/chili.png',               '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (13,   'RUKOLA',               '13',      70,    190,   0,   'img/rukola.png',              '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (14,   'SZPINAK',              '14',      70,    200,   0,   'img/szpinak.png',             '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (15,   'KURCZAK',              '15',      270,   170,   1,   'img/kurczak.png',             '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (16,   'TUNCZYK',              '16',      260,   100,   1,   'img/tunczyk.png',             '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (17,   'BROKULY',              '17',      110,   90,    1,   'img/brokuly.png',             '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (18,   'SUSZONE_POMIDORY',     '18',      150,   70,    1,   'img/suszone_pomidory.png',    '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (19,   'SER_FETA',             '19',      160,   80,    1,   'img/feta.png',                '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (20,   'SZYNKA_PROSCIUTTO',    '20',      380,   170,   1,   'img/szynka_prosciutto.png',   '000000',   'ffff00',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (21,   'SER',                  'SER',     80,    0,     0,   'img/ser.png',                 '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (22,   'MIESO WOLOWE',         '21',      270,   0,     0,   'img/wolowina.png',            '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (23,   'CHORIZO',              '22',      290,   0,     0,   'img/chorizo.png',            '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (24,   'RICOTTA',              '23',      240,   0,     0,   'img/ricotto.png',            '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (25,   'GORGONZOLA',           '24',      360,   0,     0,   'img/gorgonzola.png',         '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (26,   'OLIWKI ZIELONE',       '25',      70,    0,     0,   'img/oliwki_zielone.png',     '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (27,   'KAPARY',               '26',      160,   0,     0,   'img/kapary.png',             '000000',   '14c814',   '1');
INSERT OR IGNORE INTO TOPPING VALUES (28,   'OSTRY SOS',            'OSTRY',   0,     0,     0,   '',                            '000000',   '8c3c00',   '0');
INSERT OR IGNORE INTO TOPPING VALUES (29,   'PARMEZAN',             'PRMZN',   0,     0,     0,   '',                            '000000',   '8c3c00',   '0');


CREATE TABLE IF NOT EXISTS ADDITION (
    ID                 INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME               VARCHAR20 NOT NULL,
    KEY                VARCHAR8 NOT NULL,
    PRICE              INTEGER NOT NULL,
    PRIORITY           INTEGER,
    IMAGE              TEXT,
    FONT_COLOR         VARCHAR6,
    BACKGROUND_COLOR   VARCHAR6
);


INSERT OR IGNORE INTO ADDITION VALUES (1, 'CZOSNKOWY',    'X',  160, 10, 'img/czosnkowy.png',  'ffffff', '3282ff');
INSERT OR IGNORE INTO ADDITION VALUES (2, 'POMIDOROWY',   'Y',  160, 20, 'img/pomidorowy.png', 'ffffff', '3282ff');
INSERT OR IGNORE INTO ADDITION VALUES (3, 'PIEKIELNY',    'Z',  200, 30, 'img/piekielny.png',  'ffffff', '3282ff');
INSERT OR IGNORE INTO ADDITION VALUES (4, 'BBQ',          'Q',  240, 40, 'img/bbq.png',        'ffffff', '3282ff');
INSERT OR IGNORE INTO ADDITION VALUES (5, 'OIL_1',     'OIL1',  190, 50, 'img/oil.png',        '000000', 'ffffff');
INSERT OR IGNORE INTO ADDITION VALUES (6, 'OIL_2',     'OIL2',  190, 60, 'img/oil2.png',       'ffffff', '000000');
INSERT OR IGNORE INTO ADDITION VALUES (7, 'COLA',       'COL',  400, 70, 'img/cola.png',       'ffffff', '8c3c00');
INSERT OR IGNORE INTO ADDITION VALUES (8, 'PEPSI',      'PEP',  400, 80, 'img/pepsi.png',      'ffffff', '8c3c00');

CREATE TABLE IF NOT EXISTS COMPOSITION (
    ID              INTEGER PRIMARY KEY AUTOINCREMENT,
    KEY             VARCHAR8 NOT NULL,
    PRICE           INTEGER NOT NULL,
    PRIORITY        INTEGER,
    NAME            VARCHAR20 NOT NULL,
    TOPPINGS        TEXT
);

INSERT OR IGNORE INTO COMPOSITION VALUES (1 ,  '1',  '0',  0,  '1',  '3,3,12,12,12,OSTRY');
INSERT OR IGNORE INTO COMPOSITION VALUES (2 ,  '2',  '0',  0,  '1',  '11,5,6,14');
INSERT OR IGNORE INTO COMPOSITION VALUES (3 ,  '3',  '0',  0,  '1',  '8,9,3,4');
INSERT OR IGNORE INTO COMPOSITION VALUES (4 ,  '4',  '0',  0,  '1',  '1,3,4');
INSERT OR IGNORE INTO COMPOSITION VALUES (5 ,  '5',  '0',  0,  '1',  '1,8,6');
INSERT OR IGNORE INTO COMPOSITION VALUES (6 ,  '6',  '0',  0,  '1',  '8,6,7');
INSERT OR IGNORE INTO COMPOSITION VALUES (7 ,  '7',  '0',  0,  '1',  '3,4,12');
INSERT OR IGNORE INTO COMPOSITION VALUES (8 ,  '8',  '0',  0,  '1',  '8,9,5');
INSERT OR IGNORE INTO COMPOSITION VALUES (9 ,  '9',  '0',  0,  '1',  '9,3,6,10');
INSERT OR IGNORE INTO COMPOSITION VALUES (10,  '10',  '0',  0,  '1',  '1,9,11,6');
INSERT OR IGNORE INTO COMPOSITION VALUES (11,  '11',  '0',  0,  '1',  '1,8,5,14');
INSERT OR IGNORE INTO COMPOSITION VALUES (12,  '12',  '0',  0,  '1',  '1,8,11,10');
INSERT OR IGNORE INTO COMPOSITION VALUES (13,  '13',  '0',  0,  '1',  '8,11,5,13');
INSERT OR IGNORE INTO COMPOSITION VALUES (14,  '14',  '0',  0,  '1',  '1,3,4,12');
INSERT OR IGNORE INTO COMPOSITION VALUES (15,  '15',  '0',  0,  '1',  '1,8,9,12');
INSERT OR IGNORE INTO COMPOSITION VALUES (16,  '16',  '0',  0,  '1',  '3,4,11,12');
INSERT OR IGNORE INTO COMPOSITION VALUES (17,  '17',  '0',  0,  '1',  'SER,23,24,PRMZN');


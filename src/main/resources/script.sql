CREATE TABLE IF NOT EXISTS TOPPING (
    ID                  INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME                VARCHAR20 NOT NULL,
    KEY                 VARCHAR8 NOT NULL,
    PRICE               INTEGER NOT NULL,
    PRIORITY            INTEGER,
    IS_LIMITED          BOOLEAN,
    IMAGE               TEXT,
    FONT_COLOR          VARCHAR6,
    BACKGROUND_COLOR    VARCHAR6
);

INSERT OR IGNORE INTO TOPPING(
    ID,
    NAME,
    KEY,
    PRICE,
    PRIORITY,
    IS_LIMITED,
    IMAGE,
    FONT_COLOR,
    BACKGROUND_COLOR)
VALUES
    (1, 'PIECZARKI',          '1',  70,   10, 1, 'img/pieczarki.png',         'ffffff', 'ff0000'),
    (2, 'CEBULA',             '2',  30,   20, 1, 'img/cebula.png',            'ffffff', 'ff0000'),
    (3, 'SALAMI_PEPERONI',    '3',  110,  50, 1, 'img/pepperoni.png',         '000000', 'ffff00'),
    (4, 'SALAMI',             '4',  110,  60, 1, 'img/salami.png',            '000000', 'ffff00'),
    (5, 'PAPRYKA',            '5',  80,  120, 1, 'img/papryka.png',           'ffffff', '14c814'),
    (6, 'KUKURYDZA',          '6',  70,  150, 1, 'img/kukurydza.png',         'ffffff', '14c814'),
    (7, 'ANANAS',             '7',  110, 130, 1, 'img/ananas.png',            'ffffff', '14c814'),
    (8, 'SZYNKA',             '8',  120,  30, 1, 'img/szynka.png',            '000000', 'ffff00'),
    (9, 'BOCZEK',             '9',  120,  40, 1, 'img/boczek.png',            '000000', 'ffff00'),
    (10, 'OLIWKI',             '10', 70,  130, 1, 'img/oliwki.png',            'ffffff', '14c814'),
    (11, 'POMIDOR',            '11', 70,  110, 1, 'img/pomidor.png',           'ffffff', '14c814'),
    (12, 'PAPRYCZKI_PEPERONI', '12', 90,  160, 1, 'img/chili.png',             'ffffff', '14c814'),
    (13, 'RUKOLA',             '13', 70,  190, 0, 'img/rukola.png',            'ffffff', '14c814'),
    (14, 'SZPINAK',            '14', 70,  200, 0, 'img/szpinak.png',           'ffffff', '14c814'),
    (15, 'KURCZAK',            '15', 270, 170, 1, 'img/kurczak.png',           '000000', 'ffff00'),
    (16, 'TUNCZYK',            '16', 260, 100, 1, 'img/tunczyk.png',           '000000', 'ffff00'),
    (17, 'BROKULY',            '17', 110,  90, 1, 'img/brokuly.png',           'ffffff', '14c814'),
    (18, 'SUSZONE_POMIDORY',   '18', 150,  70, 1, 'img/suszone_pomidory.png',  'ffffff', '14c814'),
    (19, 'SER_FETA',           '19', 160,  80, 1, 'img/feta.png',              'ffffff', '14c814'),
    (20, 'SZYNKA_PROSCIUTTO',  '20', 380, 170, 1, 'img/szynka_prosciutto.png', 'ffffff', 'ffff00'),
    (21, 'SER',                'SER', 80,   0, 0, 'img/ser.png',               'ffffff', '14c814')
;


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

INSERT OR IGNORE INTO ADDITION (
    ID,
    NAME,
    KEY,
    PRICE,
    PRIORITY,
    IMAGE,
    FONT_COLOR,
    BACKGROUND_COLOR)
VALUES
    (1, 'CZOSNKOWY',    'X',  160, 10, 'img/czosnkowy.png',  'ffffff', '3282ff'),
    (2, 'POMIDOROWY',   'Y',  160, 20, 'img/pomidorowy.png', 'ffffff', '3282ff'),
    (3, 'PIEKIELNY',    'Z',  200, 30, 'img/piekielny.png',  'ffffff', '3282ff'),
    (4, 'BBQ',          'Q',  240, 40, 'img/bbq.png',        'ffffff', '3282ff'),
    (5, 'OIL_1',     'OIL1',  190, 50, 'img/oil.png',        '000000', 'ffffff'),
    (6, 'OIL_2',     'OIL2',  190, 60, 'img/oil2.png',       'ffffff', '000000'),
    (7, 'COLA',       'COL',  400, 70, 'img/cola.png',       'ffffff', '8c3c00'),
    (8, 'PEPSI',      'PEP',  400, 80, 'img/pepsi.png',      'ffffff', '8c3c00')
;

CREATE TABLE IF NOT EXISTS COMPOSITION (
    ID              INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME            VARCHAR20 NOT NULL,
    TOPPINGS        TEXT,
    ADDITIONS       TEXT
);
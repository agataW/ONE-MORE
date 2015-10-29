CREATE TABLE TOPPING (
    ID            INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME          VARCHAR20 NOT NULL,
    KEY           VARCHAR8 NOT NULL,
    PRICE         INTEGER NOT NULL,
    PRIORITY      INTEGER,
    IS_LIMITED    BOOLEAN,
    IMAGE         TEXT,
    FONT_COLOR    VARCHAR6
);

INSERT INTO TOPPING(
    NAME,
    KEY,
    PRICE,
    PRIORITY,
    IS_LIMITED,
    IMAGE,
    FONT_COLOR,
    BACKGROUND_COLOR)
VALUES
    ('PIECZARKI',          '1',  70,   10, 1, 'img/pieczarki.png',         'ffffff', 'ff0000'),
    ('CEBULA',             '2',  30,   20, 1, 'img/cebula.png',            'ffffff', 'ff0000'),
    ('SALAMI_PEPERONI',    '3',  110,  50, 1, 'img/pepperoni.png',         '000000', 'ffff00'),
    ('SALAMI',             '4',  110,  60, 1, 'img/salami.png',            '000000', 'ffff00'),
    ('PAPRYKA',            '5',  80,  120, 1, 'img/papryka.png',           'ffffff', '14c814'),
    ('KUKURYDZA',          '6',  70,  150, 1, 'img/kukurydza.png',         'ffffff', '14c814'),
    ('ANANAS',             '7',  110, 130, 1, 'img/ananas.png',            'ffffff', '14c814'),
    ('SZYNKA',             '8',  120,  30, 1, 'img/szynka.png',            '000000', 'ffff00'),
    ('BOCZEK',             '9',  120,  40, 1, 'img/boczek.png',            '000000', 'ffff00'),
    ('OLIWKI',             '10', 70,  130, 1, 'img/oliwki.png',            'ffffff', '14c814'),
    ('POMIDOR',            '11', 70,  110, 1, 'img/pomidor.png',           'ffffff', '14c814'),
    ('PAPRYCZKI_PEPERONI', '12', 90,  160, 1, 'img/chili.png',             'ffffff', '14c814'),
    ('RUKOLA',             '13', 70,  190, 0, 'img/rukola.png',            'ffffff', '14c814'),
    ('SZPINAK',            '14', 70,  200, 0, 'img/szpinak.png',           'ffffff', '14c814'),
    ('KURCZAK',            '15', 270, 170, 1, 'img/kurczak.png',           '000000', 'ffff00'),
    ('TUNCZYK',            '16', 260, 100, 1, 'img/tunczyk.png',           '000000', 'ffff00'),
    ('BROKULY',            '17', 110,  90, 1, 'img/brokuly.png',           'ffffff', '14c814'),
    ('SUSZONE_POMIDORY',   '18', 150,  70, 1, 'img/suszone_pomidory.png',  'ffffff', '14c814'),
    ('SER_FETA',           '19', 160,  80, 1, 'img/feta.png',              'ffffff', '14c814'),
    ('SZYNKA_PROSCIUTTO',  '20', 380, 170, 1, 'img/szynka_prosciutto.png', 'ffffff', 'ffff00'),
    ('SER',                'SER', 80,   0, 0, 'img/ser.png',               'ffffff', '14c814')
;


CREATE TABLE ADDITION (
    ID                 INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME               VARCHAR20 NOT NULL,
    KEY                VARCHAR8 NOT NULL,
    PRICE              INTEGER NOT NULL,
    PRIORITY           INTEGER,
    IMAGE              TEXT,
    FONT_COLOR         VARCHAR6,
    BACKGROUND_COLOR   VARCHAR6
);

INSERT INTO ADDITION (
    NAME,
    KEY,
    PRICE,
    PRIORITY,
    IMAGE,
    FONT_COLOR,
    BACKGROUND_COLOR)
VALUES
    ('CZOSNKOWY',    'X',  160, 10, 'img/czosnkowy.png',  'ffffff', '3282ff'),
    ('POMIDOROWY',   'Y',  160, 20, 'img/pomidorowy.png', 'ffffff', '3282ff'),
    ('PIEKIELNY',    'Z',  200, 30, 'img/piekielny.png',  'ffffff', '3282ff'),
    ('BBQ',          'Q',  240, 40, 'img/bbq.png',        'ffffff', '3282ff'),
    ('OIL_1',     'OIL1',  190, 50, 'img/oil.png',        '000000', 'ffffff'),
    ('OIL_2',     'OIL2',  190, 60, 'img/oil2.png',       'ffffff', '000000'),
    ('COLA',       'COL',  400, 70, 'img/cola.png',       'ffffff', '8c3c00'),
    ('PEPSI',      'PEP',  400, 80, 'img/pepsi.png',      'ffffff', '8c3c00')
;

CREATE TABLE COMPOSITION (
    ID              INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME            VARCHAR20 NOT NULL,
    TOPPINGS        TEXT,
    ADDITIONS       TEXT
);

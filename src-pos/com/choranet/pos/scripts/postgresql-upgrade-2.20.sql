--    CHORA POS is a point of sales application designed for touch screens.
--    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
--    http://www.choranet.com

-- Database upgrade script for POSTGRESQL

-- v2.20 - v2.30

INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('30', 'Printer.PartialCash', 0, $FILE{/com/choranet/pos/templates/Printer.PartialCash.xml});

-- final script

DELETE FROM SHAREDTICKETS;

UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

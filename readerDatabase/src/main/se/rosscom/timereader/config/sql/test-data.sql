INSERT INTO Competition VALUES (1, '2014-07-03', 'Vansbro Marathon');
commit;
INSERT INTO CompetitionPart VALUES (1, 'Vansbro Marathon', '43.00', 1, 'dist', null);
INSERT INTO CompetitionPart VALUES (2, 'Vansbro HalvMarathon', '23.00', 1, 'dist', null);
INSERT INTO CompetitionPart VALUES (3, 'Vansbro KvartsMarathon', '10.00', 1, 'dist', null);
commit;
INSERT INTO Reader VALUES (10, 1, 1, 'End', '43.00');
INSERT INTO Reader VALUES (10, 1, 2, 'End', '23.00');
INSERT INTO Reader VALUES (10, 1, 3, 'End', '10.00');
INSERT INTO Reader VALUES (11, 1, 2, 'Split', '20.00');
COMMIT;
INSERT INTO ReaderConfiguration values (10, '10.0.1.66', 10000, 3150);
commit;
--INSERT INTO ReaderRegistration values (10, '0123456789', 1, '2014-07-03', '2014-07-03', '2014-07-03 16:20:30', 1);
--commit; 
INSERT INTO StartingGroup values (1, 1, 'Plasket', 0, '2014-07-03 10:00:00', null);
commit;
INSERT INTO StartId values (1, 1, '0123456789', 1);
commit;



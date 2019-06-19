INSERT INTO `soccer`.`user` (`id`, `last_name`, `first_name`, `username`, `password`) VALUES ('1', 'Olha', 'Yurieva', 'Olha_Yurieva', '$2a$11$PwOUjsWoMvtF0d0lsxucTeWqAHoGBFeHUFAe5OsnHa9YjaC3PgFua');
INSERT INTO `soccer`.`user` (`id`, `last_name`, `first_name`, `username`, `password`) VALUES ('2', 'Vitaliy', 'Chumak', 'Vitaliy_Chumak', '$2y$11$4wgiNkFufbHdr9PGlwr9KuAjDEns.Ou1bnAxlmAgd4dGqnt2G5fGG');
INSERT INTO `soccer`.`user` (`id`, `last_name`, `first_name`, `username`, `password`) VALUES ('3', 'Yaroslav', 'Nikitchenko', 'Yaroslav_Nikitchenko', '$2y$11$w9Z2DmliOiaSqefu.xAmou/cGKP/vbgYEevDfJsB/bhcy7j4z99Uy');
INSERT INTO `soccer`.`user` (`id`, `last_name`, `first_name`, `username`, `password`) VALUES ('4', 'Denis', 'Baranov', 'Denis_Baranov', '$2y$11$FINWVxxHb5iRwLX15Hv5guwHLG75jyL9bcYk9EQafDg0kKbgEmi2i');

INSERT INTO `soccer`.`authorities` (`id`, `authority`) VALUES ('1', 'ADMIN');
INSERT INTO `soccer`.`authorities` (`id`, `authority`) VALUES ('2', 'USER');

INSERT INTO `soccer`.`role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `soccer`.`role` (`user_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `soccer`.`role` (`user_id`, `role_id`) VALUES ('3', '2');
INSERT INTO `soccer`.`role` (`user_id`, `role_id`) VALUES ('4', '2');




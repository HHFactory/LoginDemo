insert into demo.user values('admin@hhfactory.com','$2a$10$BQprE2KUm19AZDyPp53nDOCyzSYrn6MmNqa3hFPDM5MPc2vl/9sYu','鈴木一朗');
insert into demo.user values('user@hhfactory.com','$2a$10$wsW/lKbDowPJVzqSR73breu6h9Iz8NlFeK8ivdz3H9Cs3ExpIZG5O','田中太郎');
insert into demo.user values('guest@hhfactory.com','$2a$10$rgxIfQPpMHWuvSzsX/BAn.PaUYlEwEvKXHwwhCpQdcb/Yh21ocLXO','佐藤花子');

insert into demo.role values(1,'管理者','ROLE_ADMIN');
insert into demo.role values(2,'一般ユーザ','ROLE_USER');
insert into demo.role values(3,'ゲスト','ROLE_GUEST');

insert into demo.permission values(1,'登録権限','create');
insert into demo.permission values(2,'参照権限','read');
insert into demo.permission values(3,'管理権限','manageUser');

insert into demo.user_has_role values ('鈴木一朗','1');
insert into demo.user_has_role values ('田中太郎','2');
insert into demo.user_has_role values ('佐藤花子','3');

insert into demo.role_has_permission values('ROLE_ADMIN','1');
insert into demo.role_has_permission values('ROLE_ADMIN','2');
insert into demo.role_has_permission values('ROLE_ADMIN','3');
insert into demo.role_has_permission values('ROLE_USER','1');
insert into demo.role_has_permission values('ROLE_USER','2');
insert into demo.role_has_permission values('ROLE_GUEST','1');

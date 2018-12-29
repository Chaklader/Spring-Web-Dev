INSERT  INTO user VALUES (1, '$2a$10$Z/ZmQPEtyWqrie0KGhfAM.h2.al2N0nks9Tz.tJYSbFTmhnrRm8b2', 'laklak20', 'mohsenkw');


INSERT  INTO menu VALUES 
(1, 0, NULL, NULL, 0, NULL, NULL, NULL, 0, 'mainmenu'), 
;

INSERT  INTO module VALUES 
(1, NULL, 'user', 1, 'user'), 
(2, NULL, 'category', 1, 'category'), 
(3, NULL, 'content', 1, 'content');

INSERT  INTO category VALUES 
(1, 0, 'cat1', 0, 'cat1', 3),
(2, 0, 'cat2', 0, 'cat2', 3),
(3, 0, 'cat3', 0, 'cat3', 3);

INSERT  INTO content VALUES 
(1, 'content content fdsf df dsf a', NULL, '', 'content1', 1, 'content1', 1),
(2, 'content content fdsf df dsf hjghjghja', NULL, '', 'content2', 1, 'content2', 1),
(3, 'content content fdsf df dsfdg s sg  fdsg gasfd gfd a', NULL, '', 'content3', 1, 'content3', 2);

INSERT  INTO permission VALUES 
(1, 'admin_content_manage', 1, 'مدیریت مطالب'),
(2, 'admin_content_delete', 1, 'حذف مطالب'),
(3, 'admin_category_manage', 1, 'مدیریت دسته بندی');

INSERT  INTO role VALUES 
(1, 'super_admin', 1, 'مدیر کل'),
(2, 'normal_user', 0, 'کاربر عادی');

INSERT  INTO user_role VALUES 
(1, 1);

INSERT  INTO role_permission VALUES 
(1, 1),
(1, 2),
(1, 3);

INSERT  INTO page VALUES 
(1, '<p>page content 1</p>', 'page-title-1', 'page title 1'),
(2, '<p>page content 2</p>', 'page-title-2', 'page title 2');
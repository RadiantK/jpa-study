-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'kang', 'kang@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'mark', 'mark@fastcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@slowcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'sophia@slowcampus.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'kang', 'kang@another.com', now(), now());

insert into publisher(`id`, `name`) values (1, '패스트캠퍼스');

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (1, 'JPA 패키지', 1, false, 100);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (2, 'Spring Security', 1, false, 200);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (3, 'SpringBoot 패키지', 1, true, 100);

insert into review(id, title, content, score, user_id, book_id) values (1, '내 인생을 바꾼 책', '좋습니다.', 5.0, 1, 1);

insert into review(id, title, content, score, user_id, book_id) values (2, '내욜이 별로입니다.', '별로입니다.', 3.0, 2, 2);

insert into comment(id, comment, review_id) values (1, '좋아요', 1);

insert into comment(id, comment, review_id) values (2, '그저 그래요', 1);

insert into comment(id, comment, review_id) values (3, '괜찮네요', 2);
drop table if exists tb_book;

drop table if exists tb_chapter;

drop table if exists tb_followership;

drop table if exists tb_followership_collection;

drop table if exists tb_followership_followershipcollection;

drop table if exists tb_group;

drop table if exists tb_group_admin;

drop table if exists tb_group_flower;

drop table if exists tb_paragraph;

drop table if exists tb_post;

drop table if exists tb_post_token;

drop table if exists tb_profile;

drop table if exists tb_token;

drop table if exists tb_user;

drop table if exists tb_verse;

drop table if exists tb_verse_token;

/*==============================================================*/
/* Table: tb_book                                               */
/*==============================================================*/
create table tb_book
(
   id                   varchar(3) not null,
   title                varchar(100) not null,
   abbr                 varchar(10) not null,
   part                 int not null,
   seq					int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_chapter                                            */
/*==============================================================*/
create table tb_chapter
(
   id                   bigint not null auto_increment,
   book_id              varchar(3) not null,
   num           		varchar(3) not null,
   contain_join_verse	bool,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_followership                                       */
/*==============================================================*/
create table tb_followership
(
   id                   bigint not null auto_increment,
   leader_id            bigint not null,
   follower_id          bigint not null,
   remark	          	varchar(50),
   created_at			timestamp default 0 not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_followership_collection                            */
/*==============================================================*/
create table tb_followership_collection
(
   id                   bigint not null auto_increment,
   user_id              bigint not null,
   name      			varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_followership_followershipcollection                */
/*==============================================================*/
create table tb_followership_followershipcollection
(
   followership_id      		bigint not null,
   followership_collection_id 	bigint not null,
   primary key (followership_id, followership_collection_id)
);

/*==============================================================*/
/* Table: tb_group                                              */
/*==============================================================*/
create table tb_group
(
   id                   bigint not null auto_increment,
   name           		varchar(50) not null,
   about_me             varchar(500),
   avatar               varchar(50),
   created_at           timestamp default 0 not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_group_admin                                        */
/*==============================================================*/
create table tb_group_admin
(
   user_id              bigint not null,
   group_id             bigint not null,
   primary key (user_id, group_id)
);

/*==============================================================*/
/* Table: tb_group_flower                                       */
/*==============================================================*/
create table tb_group_flower
(
   member_id            bigint not null,
   group_id             bigint not null,
   primary key (member_id, group_id)
);

/*==============================================================*/
/* Table: tb_paragraph                                          */
/*==============================================================*/
create table tb_paragraph
(
   id                   bigint not null auto_increment,
   chapter_id           bigint not null,
   title                varchar(100),
   subtitle             varchar(500),
   section_title		varchar(100),
   related_title		varchar(100),
   dialog_title			varchar(100),
   epilog             	varchar(100),
   type       			varchar(2) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_post                                               */
/*==============================================================*/
create table tb_post
(
   id                   bigint not null auto_increment,
   user_id              bigint not null,
   title                varchar(100) not null,
   content              text not null,
   open                 bool,
   created_at         	timestamp default 0 not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_post_token                                         */
/*==============================================================*/
create table tb_post_token
(
   post_id              bigint not null,
   token_id             bigint not null,
   primary key (post_id, token_id)
);

/*==============================================================*/
/* Table: tb_profile                                            */
/*==============================================================*/
create table tb_profile
(
   id                   bigint not null auto_increment,
   user_id              bigint not null,
   gender               varchar(1),
   brithday             varchar(10),
   location             varchar(50),
   about_me          	varchar(500),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_token                                              */
/*==============================================================*/
create table tb_token
(
   id                   bigint not null auto_increment,
   book_id              varchar(3) not null,
   chapter_id           bigint not null,
   name           		varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   id                   bigint not null auto_increment,
   login_name           varchar(50) not null,
   screen_name          varchar(20),
   name                 varchar(50),
   password             varchar(255) not null,
   salt                 varchar(64) not null,
   roles                varchar(255) not null,
   avatar               varchar(50),
   created_at        	timestamp default 0 not null,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_verse                                              */
/*==============================================================*/
create table tb_verse
(
   id                   bigint not null auto_increment,
   chapter_id           bigint not null,
   paragraph_id         bigint,
   book_id              bigint not null,
   title				varchar(200),
   num             		varchar(3) not null,
   num2					varchar(3),
   num3					varchar(3),
   text           		varchar(2000) not null,
   text2           		varchar(1000),
   text3           		varchar(1000),
   text4           		varchar(1000),
   text5           		varchar(1000),
   text6           		varchar(1000),
   text7           		varchar(1000),
   text8           		varchar(1000),
   text9           		varchar(1000),
   text10           	varchar(1000),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_verse_token                                        */
/*==============================================================*/
create table tb_verse_token
(
   verse_id             bigint not null,
   token_id             bigint not null,
   primary key (token_id, verse_id)
);
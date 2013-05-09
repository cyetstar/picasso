-- bible --
insert into tb_book(id, title, abbr, part, seq) values('jhn', '约翰福音', '约', 2, 40);

insert into tb_chapter(id, book_id, num, contain_join_verse) values(1, 'jhn', 1, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(2, 'jhn', 2, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(3, 'jhn', 3, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(4, 'jhn', 4, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(5, 'jhn', 5, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(6, 'jhn', 6, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(7, 'jhn', 7, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(8, 'jhn', 8, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(9, 'jhn', 9, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(10, 'jhn', 10, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(11, 'jhn', 11, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(12, 'jhn', 12, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(13, 'jhn', 13, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(14, 'jhn', 14, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(15, 'jhn', 15, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(16, 'jhn', 16, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(17, 'jhn', 17, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(18, 'jhn', 18, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(19, 'jhn', 19, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(20, 'jhn', 20, false);
insert into tb_chapter(id, book_id, num, contain_join_verse) values(21, 'jhn', 21, false);

insert into tb_paragraph(id, chapter_id, title, related_title, type) values(1, 1, '道成肉身', null, 'p');
insert into tb_paragraph(id, chapter_id, title, related_title, type) values(2, 1, '施洗约翰的见证', '（太3·1—12；可1·1—8；路3·1—18）', 'p');
insert into tb_paragraph(id, chapter_id, title, related_title, type) values(3, 1, '　神的羔羊', null, 'p');
insert into tb_paragraph(id, chapter_id, title, related_title, type) values(4, 1, '初次选召门徒', null, 'p');
insert into tb_paragraph(id, chapter_id, title, related_title, type) values(5, 1, '呼召腓力和拿但业', null, 'p');

insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(1, 1, 1, 1, 1, '太初有道，道与　神同在，道就是　神。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(2, 1, 1, 1, 2, '这道太初与　神同在。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(3, 1, 1, 1, 3, '万物是借着他造的；凡被造的，没有一样不是借着他造的。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(4, 1, 1, 1, 4, '生命在他里头，这生命就是人的光。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(5, 1, 1, 1, 5, '光照在黑暗里，黑暗却不接受光。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(6, 1, 1, 1, 6, '有一个人，是从　神那里差来的，名叫约翰。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(7, 1, 1, 1, 7, '这人来，为要作见证，就是为光作见证，叫众人因他可以信。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(8, 1, 1, 1, 8, '他不是那光，乃是要为光作见证。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(9, 1, 1, 1, 9, '那光是真光，照亮一切生在世上的人。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(10, 1, 1, 1, 10, '他在世界，世界也是借着他造的，世界却不认识他。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(11, 1, 1, 1, 11, '他到自己的地方来，自己的人倒不接待他。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(12, 1, 1, 1, 12, '凡接待他的，就是信他名的人，他就赐他们权柄作　神的儿女。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(13, 1, 1, 1, 13, '这等人不是从血气生的，不是从情欲生的，也不是从人意生的，乃是从　神生的。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(14, 1, 1, 1, 14, '道成了肉身，住在我们中间，充充满满地有恩典有真理。我们也见过他的荣光，正是父独生子的荣光。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(15, 1, 1, 1, 15, '约翰为他作见证，喊着说：「这就是我曾说：『那在我以后来的，反成了在我以前的，因他本来在我以前。』」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(16, 1, 1, 1, 16, '从他丰满的恩典里，我们都领受了，而且恩上加恩。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(17, 1, 1, 1, 17, '律法本是借着摩西传的；恩典和真理都是由耶稣基督来的。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(18, 1, 1, 1, 18, '从来没有人看见　神，只有在父怀里的独生子将他表明出来。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(19, 1, 1, 2, 19, '约翰所作的见证记在下面：犹太人从耶路撒冷差祭司和利未人到约翰那里，问他说：「你是谁？」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(20, 1, 1, 2, 20, '他就明说，并不隐瞒，明说：「我不是基督。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(21, 1, 1, 2, 21, '他们又问他说：「这样，你是谁呢？是以利亚吗？」他说：「我不是。」「是那先知吗？」他回答说：「不是。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(22, 1, 1, 2, 22, '于是他们说：「你到底是谁，叫我们好回复差我们来的人。你自己说，你是谁？」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(23, 1, 1, 2, 23, '他说：「我就是那在旷野有人声喊着说：『修直主的道路』，正如先知以赛亚所说的。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(24, 1, 1, 2, 24, '那些人是法利赛人差来的；');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(25, 1, 1, 2, 25, '他们就问他说：「你既不是基督，不是以利亚，也不是那先知，为什么施洗呢？」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(26, 1, 1, 2, 26, '约翰回答说：「我是用水施洗，但有一位站在你们中间，是你们不认识的，');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(27, 1, 1, 2, 27, '就是那在我以后来的，我给他解鞋带也不配。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(28, 1, 1, 2, 28, '这是在约旦河外伯大尼，约翰施洗的地方作的见证。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(29, 1, 1, 3, 29, '次日，约翰看见耶稣来到他那里，就说：「看哪，　神的羔羊，除去世人罪孽的！');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(30, 1, 1, 3, 30, '这就是我曾说：『有一位在我以后来、反成了在我以前的，因他本来在我以前。』');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(31, 1, 1, 3, 31, '我先前不认识他，如今我来用水施洗，为要叫他显明给以色列人。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(32, 1, 1, 3, 32, '约翰又作见证说：「我曾看见圣灵，仿佛鸽子从天降下，住在他的身上。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(33, 1, 1, 3, 33, '我先前不认识他，只是那差我来用水施洗的、对我说：『你看见圣灵降下来，住在谁的身上，谁就是用圣灵施洗的。』');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(34, 1, 1, 3, 34, '我看见了，就证明这是　神的儿子。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(35, 1, 1, 4, 35, '再次日，约翰同两个门徒站在那里。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(36, 1, 1, 4, 36, '他见耶稣行走，就说：「看哪，这是　神的羔羊！」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(37, 1, 1, 4, 37, '两个门徒听见他的话，就跟从了耶稣。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(38, 1, 1, 4, 38, '耶稣转过身来，看见他们跟着，就问他们说：「你们要什么？」他们说：「拉比，在哪里住？」（拉比翻出来就是夫子。）');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(39, 1, 1, 4, 39, '耶稣说：「你们来看。」他们就去看他在哪里住，这一天便与他同住；那时约有申正了。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(40, 1, 1, 4, 40, '听见约翰的话跟从耶稣的那两个人，一个是西门·彼得的兄弟安得烈。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(41, 1, 1, 4, 41, '他先找着自己的哥哥西门，对他说：「我们遇见弥赛亚了。」（弥赛亚翻出来就是基督。）');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(42, 1, 1, 4, 42, '于是领他去见耶稣。耶稣看着他，说：「你是约翰的儿子西门，你要称为矶法。」（矶法翻出来就是彼得。）');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(43, 1, 1, 5, 43, '又次日，耶稣想要往加利利去，遇见腓力，就对他说：「来跟从我吧。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(44, 1, 1, 5, 44, '这腓力是伯赛大人，和安得烈、彼得同城。');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(45, 1, 1, 5, 45, '腓力找着拿但业，对他说：「摩西在律法上所写的和众先知所记的那一位，我们遇见了，就是约瑟的儿子拿撒勒人耶稣。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(46, 1, 1, 5, 46, '拿但业对他说：「拿撒勒还能出什么好的吗？」腓力说：「你来看！」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(47, 1, 1, 5, 47, '耶稣看见拿但业来，就指着他说：「看哪，这是个真以色列人，他心里是没有诡诈的。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(48, 1, 1, 5, 48, '拿但业对耶稣说：「你从哪里知道我呢？」耶稣回答说：「腓力还没有招呼你，你在无花果树底下，我就看见你了。」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(49, 1, 1, 5, 49, '拿但业说：「拉比，你是　神的儿子，你是以色列的王！」');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(50, 1, 1, 5, 50, '耶稣对他说：「因为我说『在无花果树底下看见你』，你就信吗？你将要看见比这更大的事」；');
insert into tb_verse(id, book_id, chapter_id, paragraph_id, num, text) values(51, 1, 1, 5, 51, '又说：「我实实在在地告诉你们，你们将要看见天开了，　神的使者上去下来在人子身上。」');

-- user --
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (1, 'cyetstar@gmail.com', 'cyetstar', '七草千树', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 'admin', '2013-03-30 16:31:59');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (2, 'davidx424@yahoo.com.cn', null, '锤子', 'eb731a72d0728717a1389d5b2cfc8432016e2734', '3f6e3c754e9b9cb3', 'user', '2013-03-30 16:32:08');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (3, '156049722@qq.com', null, 'francois', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 'admin', '2013-03-15 01:00:00');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (4, 'alo1314@gmail.com', null, 'Alo', 'f87d761281d92a752e1913aed9d40fa49ac52b0d', '9e0c9f31f3036b13', 'user', '2013-03-30 18:59:27');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (5, 'beichenshi@gmail.com', null, 'Beichen Shi', '59813e03817a77269e42480f04a21301171cb6d5', '828597a5f276b678', 'user', '2013-03-30 19:01:24');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (6, 'lugang912@gmail.com', null, 'Colin Lui', '2dfbed85a2572812ebd2e6447d7c25b51341fd19', '3fd24c8b0d89cfbb', 'user', '2013-03-30 19:02:18');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (7, 'socary@gmail.com', null, 'socary', 'be084db75a2803a4c69240373d0cf5e76700519b', '458c0e71b9faab77', 'user', '2013-03-30 19:03:52');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (8, '377503633@qq.com', null, 'von archon', '55c03a2b3470a4e03fd01be030bba49e75ca7fb6', '0cf3c562fa8ddb62', 'user', '2013-03-30 19:04:26');
insert into tb_user (id, login_name, screen_name, name, password, salt, roles, created_at) values (9, 'zhouyongfen@gmail.com', null, 'yongfen', 'afa64bf318935c6159249a7afd1cf1cbf3d89e89', 'e0ade727b5b11236', 'user', '2013-03-30 19:04:57');

insert into tb_profile (id, user_id, gender, brithday, location, about_me) values (1, 1, '1', '1982/12/16', '温州', '开发者');

insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (1, 2, 1, '次号', '2013-03-30 19:01:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (2, 3, 1, null, '2013-03-30 19:02:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (3, 4, 1, null, '2013-03-30 19:03:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (4, 5, 1, null, '2013-03-30 19:04:57');
                                                              
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (5, 1, 2, '主号', '2013-03-30 19:05:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (6, 3, 2, null, '2013-03-30 19:06:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (7, 4, 2, null, '2013-03-30 19:07:57');
insert into tb_followership (id, leader_id, follower_id, remark, created_at) values (8, 5, 2, null, '2013-03-30 19:08:57');

insert into tb_followership_collection (id, user_id, name) values (1, 1, '教友');

insert into tb_followership_followershipcollection (followership_id, followership_collection_id) values (1, 1);
insert into tb_followership_followershipcollection (followership_id, followership_collection_id) values (2, 1);

-- post --
insert into tb_post (id, user_id, title, content, open, created_at) values (1, 1, '第1条笔记', '笔记内容', true, '2013-03-30 19:04:57');
insert into tb_post (id, user_id, title, content, open, created_at) values (2, 1, '第1条私密笔记', '笔记内容', false, '2013-03-30 19:05:17');
insert into tb_post (id, user_id, title, content, open, created_at) values (3, 2, '我关注的人写的笔记', '笔记内容', true, '2013-03-30 19:15:17');
insert into tb_post (id, user_id, title, content, open, created_at) values (4, 2, '我关注的人写的私密笔记', '笔记内容', false, '2013-03-30 20:05:17');

insert into tb_token(id, book_id, chapter_id, name) values (1, 'jhn', 1, '约 1:1-2');
insert into tb_token(id, book_id, chapter_id, name) values (2, 'jhn', 1, '约 1:9');

insert into tb_post_token(post_id, token_id) values (1, 1);
insert into tb_post_token(post_id, token_id) values (2, 2);
insert into tb_post_token(post_id, token_id) values (3, 1);
insert into tb_post_token(post_id, token_id) values (3, 2);

insert into tb_verse_token(verse_id, token_id) values (1, 1);
insert into tb_verse_token(verse_id, token_id) values (2, 1);
insert into tb_verse_token(verse_id, token_id) values (9, 2);

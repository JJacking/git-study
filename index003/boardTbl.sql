create table boardTbl(
    num number PRIMARY key,
    nickName varchar2(30),
    email varchar2(50),
    title varchar2(50),
    content varchar2(80),
    readCount number default 0,
    wirteDate date default sysdate
    );


create sequence boardTbl_seq;

drop sequence boardTbl_seq;

insert into boardTbl(num,nickName,email,pass,title,content)
values(boardTbl_seq.NEXTVAL,'제우스','timo@naver.com',1234,'티모','티모는탑');

select * from boardtbl;

commit;

drop table boardTbl;
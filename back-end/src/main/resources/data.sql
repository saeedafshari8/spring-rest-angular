---
INSERT INTO user (id,username, password) VALUES(1, 'user1', '$2a$11$rvVOUPp/XS2VFsdHX6P4l.pCBM5LLWeRiPKmRl0NMTNxVQEdJOepe');
INSERT INTO user (id,username, password) VALUES(2, 'user2', '$2a$11$rvVOUPp/XS2VFsdHX6P4l.pCBM5LLWeRiPKmRl0NMTNxVQEdJOepe');
---
INSERT INTO role (id,name) VALUES(1, 'ADMIN');
INSERT INTO role (id,name) VALUES(2, 'USER');
---
INSERT INTO user_role (user_id, role_id) VALUES(1,1);
INSERT INTO user_role (user_id, role_id) VALUES(2,2);
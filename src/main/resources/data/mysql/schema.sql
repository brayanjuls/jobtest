DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS questionstype;

CREATE TABLE question_type(
id BIGINT(30)  NOT NULL auto_increment,
description VARCHAR(200) NOT NULL,
PRIMARY KEY(id)
);


CREATE TABLE questions(
id BIGINT(30)  NOT NULL auto_increment,
description VARCHAR(200) NOT NULL,
type BIGINT(30) NOT NULL,
difficulty INT NOT NULL,
createdby VARCHAR(100) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (type) REFERENCES question_type(id)
);


CREATE TABLE answers(
id BIGINT(30)  NOT NULL auto_increment,
idquestion BIGINT(30) NOT NULL,
description VARCHAR(200) NOT NULL,
advise VARCHAR(200) NOT NULL,
point INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (idquestion) REFERENCES questions(id)
);

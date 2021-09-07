CREATE TABLE task (
                      id bigint primary key auto_increment,
                      title varchar(200),
                      description varchar(200),
                      points int
);



INSERT INTO task (title, description, points) VALUES(
                                                        'Criar banco de dados',
                                                        'Criação do banco de dados oracle',
                                                        150
                                                    );



INSERT INTO task (title, description, points) VALUES(
                                                        'Análise de dados',
                                                        'Modelagem do banco de dados',
                                                        50
                                                    );



INSERT INTO task (title, description, points) VALUES(
                                                        'Prototipação',
                                                        'Desenvolver protótipo de alta fidelidade',
                                                        80
                                                    );


CREATE TABLE user (
                      id bigint primary key auto_increment,
                      name varchar(120),
                      email varchar(120),
                      password varchar(120)
);


INSERT INTO user (name, email, password) VALUES('Luis Robbo',
                                                'luis@mail.com',
                                                'LuisSenha123');

INSERT INTO user (name, email, password) VALUES('Felipe Roque',
                                                'fehroque@mail.com',
                                                'felipe123');

INSERT INTO user (name, email, password) VALUES('Lucas Padovani',
                                                'lpadova@mail.com',
                                                'lpadova1423');

INSERT INTO user (name, email, password) VALUES('Lucas Kazuo',
                                                'kazuo@mail.com',
                                                'kazuoLucas123');



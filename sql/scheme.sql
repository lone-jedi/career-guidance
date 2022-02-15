--
-- ZNO exams table
--
CREATE TABLE exams(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Career tests table
--
CREATE TABLE test(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Test`s questions table
--
CREATE TABLE question(
	id SERIAL PRIMARY KEY,
	title VARCHAR(1000) NOT NULL,
	test_id INT NOT NULL
);

--
-- Question`s answers table
--
CREATE TABLE answer(
	id SERIAL PRIMARY KEY,
	title VARCHAR(1000) NOT NULL,
	weight NUMERIC NOT NULL,
	question_id INT NOT NULL
);

--
-- Test results table
--
CREATE TABLE result(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	score_from NUMERIC NOT NULL,
	score_to NUMERIC NOT NULL,
	test_id INT NOT NULL
);

--
-- Specialties
--
CREATE TABLE specialty(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT
);

--
-- Many to many reference between results and specialties
--
CREATE TABLE result_specialty(
	result_id INT NOT NULL,
	specialty_id INT NOT NULL,
	PRIMARY KEY(result_id, specialty_id)
);

--
-- Cathedra`s table
--
CREATE TABLE cathedra(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	university_id INT NOT NULL,
	specialty_id INT NOT NULL
);

--
-- Universities
--
CREATE TABLE university(
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description TEXT,
	rate NUMERIC,
	logo VARCHAR(255),
	location VARCHAR(255)
);


ALTER TABLE question
ADD CONSTRAINT fk_test_question
FOREIGN KEY(test_id)
REFERENCES test(id);

ALTER TABLE answer
ADD CONSTRAINT fk_question_answer
FOREIGN KEY(question_id)
REFERENCES question(id);

ALTER TABLE result
ADD CONSTRAINT fk_test_result
FOREIGN KEY(test_id)
REFERENCES test(id);

ALTER TABLE result_specialty
ADD CONSTRAINT fk_result_specialty
FOREIGN KEY(result_id)
REFERENCES result(id);

ALTER TABLE result_specialty
ADD CONSTRAINT fk_specialty_result
FOREIGN KEY(specialty_id)
REFERENCES specialty(id);

ALTER TABLE cathedra
ADD CONSTRAINT fk_university_cathedra
FOREIGN KEY(university_id)
REFERENCES university(id);

--
--
-- INSERT DATA SECTION
--
--

INSERT INTO test(title) VALUES ('Головний профорієнтаційний тест');

INSERT INTO question(title, test_id) VALUES
('Як на мене, контролювати інших людей та вести облік - нудне заняття.', 1),
('Я краще буду займатись фінансовими операціями, аніж виступати на сцені.', 1),
('Ніколи точно не розраховую час, який витрачаю на дорогу до школи. Для мене це здається неможливим', 1),
('Ризик - моє друге "Я"', 1),
('Люблю працювати з технікою', 1);

INSERT INTO answer(title, weight, question_id) VALUES
('Так', 1, 1),
('Важко сказати', 3, 1),
('Ні', 6, 1),

('Так', 5, 2),
('Важко сказати', 3, 2),
('Ні', 1, 2),

('Так', 1, 3),
('Важко сказати', 3, 3),
('Ні', 6, 3),

('Так', 1, 4),
('Важко сказати', 3, 4),
('Ні', 6, 4),

('Так', 6, 5),
('Важко сказати', 3, 5),
('Ні', 1, 5),

INSERT INTO exam(title, description) VALUES
('Українська мова', ''),
('Українська мова і література', ''),
('Математика (завдання рівня стандарту)', ''),
('Математика', ''),
('Історія України', ''),
('Англійська мова', ''),
('Іспанська мова', ''),
('Німецька мова', ''),
('Французька мова', ''),
('Біологія', ''),
('Географія', ''),
('Фізика', ''),
('Хімія', '');


INSERT INTO result(title, score_from, score_to, test_id)
VALUES
    ('Гуманітарій', 0, 9, 1),
    ('Нейтрал', 10, 19, 1),
    ('Технарь', 20, 29, 1);

INSERT INTO specialty(title, description)
VALUES
	('Освіта', '111111111111'),
	('Культура і мистецтво', '2222222222222222'),
	('Гуманітарні науки', '3333333333333333333'),
	('Журналістика', '444444444444444444'),
	('Право', '555555555555'),
	('Інформаційні технології', '66666666666666666');

INSERT INTO result_specialty(result_id, specialty_id)
VALUES
	(1, 1),
	(1, 2),
	(2, 3),
	(2, 4),
	(2, 5),
	(3, 5),
	(3, 6);

INSERT INTO university(title, description, rate, location) VALUES
('ОНАХТ', 'Одеська Національна Академія Харчових Технології', 4234, 'Україна, Одеса'),
('НУОП', 'Одеський Політехнічний Університет', 4419, 'Україна, Одеса');

INSERT INTO cathedra(title, description, university_id, specialty_id) VALUES
('Комп технологій та кібербезпеки', '111', 1, 6),
('Мережеві технології', '2222', 1, 6),
('Міжнародне право', '3333', 1, 5),
('Комп технологій та кібербезпеки', '22111111', 2, 6),
('Мережеві технології', '1112222222', 2, 6),
('Міжнародне право', '2223333333', 2, 5),
('Мистецтво', '4444', 1, 2),
('Література', '5555', 1, 3),
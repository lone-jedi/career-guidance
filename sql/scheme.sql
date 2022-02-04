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
	question_id INT NOT NULL
);

ALTER TABLE question
ADD CONSTRAINT fk_test_question
FOREIGN KEY(test_id)
REFERENCES test(id);

ALTER TABLE answer
ADD CONSTRAINT fk_question_answer
FOREIGN KEY(question_id)
REFERENCES question(id);
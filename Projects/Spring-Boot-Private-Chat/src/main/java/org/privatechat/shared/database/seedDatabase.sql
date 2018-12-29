USE chat;

INSERT INTO user (
  email,
  password,
  role,
  fullName
) VALUES (
  'evan@test.com', '$2a$10$qNl6oSAKpNe1Bqc6CTvJNOWiYgwOPizqJrxGUsv4WcZwqphX5Og6G', 'STANDARD-ROLE', 'Evan Delgado'
), (
  'annie@test.com', '$2a$10$qNl6oSAKpNe1Bqc6CTvJNOWiYgwOPizqJrxGUsv4WcZwqphX5Og6G', 'STANDARD-ROLE', 'Annie Smith'
), (
  'joe@test.com', '$2a$10$qNl6oSAKpNe1Bqc6CTvJNOWiYgwOPizqJrxGUsv4WcZwqphX5Og6G', 'STANDARD-ROLE', 'Joe Kelly'
), (
  'roger@test.com', '$2a$10$qNl6oSAKpNe1Bqc6CTvJNOWiYgwOPizqJrxGUsv4WcZwqphX5Og6G', 'STANDARD-ROLE', 'Roger Ford'
);
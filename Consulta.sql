CREATE TABLE pessoa(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(70),
	email VARCHAR(70)
);

CREATE TABLE veiculo(
	idproduto INT AUTO_INCREMENT PRIMARY KEY,
	chassi VARCHAR(17),
	placa VARCHAR(6),
	modelo VARCHAR(60),
	nome VARCHAR(60),
	valor DOUBLE
);
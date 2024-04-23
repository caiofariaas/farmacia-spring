ALTER TABLE usuarios ADD ativo tinyint;
UPDATE usuarios SET ativo = 1;
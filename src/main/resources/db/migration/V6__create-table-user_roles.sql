 CREATE TABLE user_roles(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,

    FOREIGN KEY(user_id) REFERENCES usuarios(id),
    FOREIGN KEY(role_id) REFERENCES roles(id)
 );

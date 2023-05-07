CREATE TABLE IF NOT EXISTS orchestrator.users
(
    id              SERIAL PRIMARY KEY,
    user_id         UUID NOT NULL UNIQUE,
    email           VARCHAR(50) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    user_status     SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS orchestrator.roles
(
    id              SERIAL PRIMARY KEY,
    role_name       VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS orchestrator.user_roles
(
    user_id         INT NOT NULL,
    role_id         INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES orchestrator.users(id) ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES orchestrator.roles(id) ON UPDATE CASCADE
);
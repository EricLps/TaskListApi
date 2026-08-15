CREATE TABLE task(

    id UUID PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(500),
    status VARCHAR(20) DEFAULT 'PENDING',
    creation_date TIMESTAMP

);
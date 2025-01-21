CREATE TABLE courses (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    description TEXT,
    thumbnailUrl TEXT NOT NULL
);
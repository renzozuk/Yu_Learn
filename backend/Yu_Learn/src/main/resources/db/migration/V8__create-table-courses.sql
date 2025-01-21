CREATE TABLE IF NOT EXISTS courses (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    description TEXT,
    thumbnailUrl TEXT NOT NULL
);
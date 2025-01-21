CREATE TABLE lessons (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    description TEXT,
    thumbnailUrl TEXT NOT NULL,
    categories TEXT[]
);
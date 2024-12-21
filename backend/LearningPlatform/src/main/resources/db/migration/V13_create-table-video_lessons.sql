CREATE TABLE video_lessons (
    id TEXT PRIMARY KEY UNIQUE NOT NULL REFERENCES lessons(id),
    video_url TEXT NOT NULL
);
CREATE TABLE text_lessons (
    id TEXT PRIMARY KEY UNIQUE NOT NULL REFERENCES lessons(id),
    pdf_url TEXT NOT NULL
);
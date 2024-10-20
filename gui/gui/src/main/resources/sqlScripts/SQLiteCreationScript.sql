

CREATE TABLE IF NOT EXISTS User
(
    id             INTEGER PRIMARY KEY AUTOINCREMENT,
    name           TEXT NOT NULL,
    lastName       TEXT NOT NULL,
    hashedPassword TEXT NOT NULL,
    description    TEXT,
    email          TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS Paper
(
    id           INTEGER PRIMARY KEY,
    title        TEXT    NOT NULL,
    description  TEXT    NOT NULL,
    documentLink TEXT,
    conferenceId INTEGER NOT NULL,
    userId       INTEGER NOT NULL,
    FOREIGN KEY (userId) REFERENCES User (id),
    FOREIGN KEY (conferenceId) REFERENCES Conference (id)
);
CREATE TABLE IF NOT EXISTS PaperReview
(
    id         INTEGER PRIMARY KEY,
    paperId    INTEGER NOT NULL,
    reviewerId INTEGER NOT NULL,
    approved   TEXT CHECK (approved in ('TRUE', 'FALSE')),
    FOREIGN KEY (paperId) REFERENCES Paper (id),
    FOREIGN KEY (reviewerId) REFERENCES User (id)
);
CREATE TABLE IF NOT EXISTS Conference
(
    id          INTEGER PRIMARY KEY,
    title       TEXT    NOT NULL,
    description TEXT    NOT NULL,
    city        TEXT    NOT NULL,
    date        TEXT    NOT NULL,
    adminId     INTEGER NOT NULL,
    FOREIGN KEY (adminId) REFERENCES User (id)
);
CREATE TABLE IF NOT EXISTS UserConference
(
    id           integer PRIMARY KEY NOT NULL,
    userId       integer             NOT NULL,
    conferenceId integer             NOT NULL,
    rol          integer             NOT NULL,
    FOREIGN KEY (userId) REFERENCES User (id),
    FOREIGN KEY (conferenceId) REFERENCES Conference (id)
);
CREATE TABLE IF NOT EXISTS Jobs
(
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    conferenceId integer NOT NULL,
    paperId      TEXT    NOT NULL,
    FOREIGN KEY (conferenceId) REFERENCES Conference (id),
    FOREIGN KEY (paperId) REFERENCES paper (id)
);
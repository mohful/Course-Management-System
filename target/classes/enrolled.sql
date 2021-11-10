CREATE TABLE enrolled (
    student INTEGER,
    course VARCHAR(255),
      FOREIGN KEY (student) REFERENCES students,
      FOREIGN KEY (course) REFERENCES courses,
      PRIMARY KEY (student, course)
);


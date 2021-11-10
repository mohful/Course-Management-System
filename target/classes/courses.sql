CREATE TABLE courses (
    course_no varchar(255) PRIMARY KEY,
    course_title varchar(255),
    course_description varchar(255),
    max_capacity int
);

INSERT INTO courses (course_no, course_title, course_description, max_capacity) VALUES ('CS-101', 'Introduction To Computer Science', 'This is a course', 6);
INSERT INTO courses (course_no, course_title, course_description, max_capacity) VALUES ('DB-101', 'Database', 'This is a course', 3);
INSERT INTO courses (course_no, course_title, course_description, max_capacity) VALUES ('PF-101', 'Programming Fundamentals', 'This is a course', 5);
INSERT INTO courses (course_no, course_title, course_description, max_capacity) VALUES ('MA-201', 'Calculus', 'This is a course', 5);
INSERT INTO courses (course_no, course_title, course_description, max_capacity) VALUES ('WP-102', 'Web Programming', 'This is a course', 5);
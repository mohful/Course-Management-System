package Model;

public enum Databases {

    COURSES {
        public String toString() {
            return "/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/courses.db";
        }
    },

    STUDENT {
        public String toString() {
            return "/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/student.db";
        }
    },

    PROFESSOR {
        public String toString() {
            return "/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/professor.db";
        }
    },

    ACCOUNTS {
        public String toString() {
            return "/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/account.db";
        }
    },

    ENROLMENT {
        public String toString() {
            return "/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/enrolled.db";
        }
    },
    
}

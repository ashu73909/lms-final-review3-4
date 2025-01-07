// Simple in-memory database simulation
let db = {
    users: [],
    courses: [],
    tests: [],
    results: []
};

export const initializeDB = async () => {
    // Initialize with some sample data
    db.courses = [
        { id: 1, title: 'Introduction to JavaScript', description: 'Learn the basics of JavaScript programming' },
        { id: 2, title: 'Web Development Fundamentals', description: 'HTML, CSS, and JavaScript basics' },
        { id: 3, title: 'Advanced Programming Concepts', description: 'Deep dive into programming patterns' }
    ];

    db.tests = [
        { id: 1, courseId: 1, title: 'JavaScript Basics Quiz', questions: [] },
        { id: 2, courseId: 2, title: 'HTML & CSS Assessment', questions: [] }
    ];
};

export const dbService = {
    // User operations
    createUser: (user) => {
        const newUser = { ...user, id: Date.now() };
        db.users.push(newUser);
        return newUser;
    },
    
    getUser: (email) => db.users.find(u => u.email === email),
    
    // Course operations
    getCourses: () => db.courses,
    getCourse: (id) => db.courses.find(c => c.id === id),
    
    // Test operations
    getTests: () => db.tests,
    getTest: (id) => db.tests.find(t => t.id === id),
    
    // Results operations
    saveTestResult: (result) => {
        db.results.push({ ...result, id: Date.now() });
    },
    
    getResults: (userId) => db.results.filter(r => r.userId === userId)
};
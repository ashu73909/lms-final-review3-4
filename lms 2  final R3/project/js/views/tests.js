export const renderTests = (container) => {
    const tests = [
        {
            id: 1,
            title: 'HTML & CSS Fundamentals',
            duration: '45 minutes',
            questions: 20,
            difficulty: 'Beginner',
            icon: '🌟'
        },
        {
            id: 2,
            title: 'JavaScript Basics',
            duration: '60 minutes',
            questions: 25,
            difficulty: 'Intermediate',
            icon: '⭐'
        },
        {
            id: 3,
            title: 'Advanced Programming Concepts',
            duration: '90 minutes',
            questions: 30,
            difficulty: 'Advanced',
            icon: '💫'
        }
    ];

    container.innerHTML = `
        <div class="container py-5">
            <h2 class="mb-4">✍️ Available Tests</h2>
            <div class="row">
                ${tests.map(test => `
                    <div class="col-md-6 mb-4">
                        <div class="test-card">
                            <div class="d-flex align-items-center mb-3">
                                <span style="font-size: 2rem;" class="me-3">${test.icon}</span>
                                <h3 class="h5 mb-0">${test.title}</h3>
                            </div>
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <span class="badge bg-primary">${test.difficulty}</span>
                                <span class="text-muted">⏱️ ${test.duration}</span>
                            </div>
                            <p>📝 Number of questions: ${test.questions}</p>
                            <button onclick="window.location.hash='#test/${test.id}'" class="btn btn-primary w-100">
                                Start Test 🎯
                            </button>
                        </div>
                    </div>
                `).join('')}
            </div>
        </div>
    `;
};
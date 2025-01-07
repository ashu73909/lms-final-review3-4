export const renderCourses = (container) => {
    const courses = [
        {
            id: 1,
            title: 'Web Development Fundamentals',
            description: 'Learn HTML, CSS, and JavaScript basics',
            duration: '8 weeks',
            image: 'https://placehold.co/600x400',
            icon: '💻'
        },
        {
            id: 2,
            title: 'Database Design',
            description: 'Master SQL and database concepts',
            duration: '6 weeks',
            image: 'https://placehold.co/600x400',
            icon: '🗄️'
        },
        {
            id: 3,
            title: 'Advanced Programming',
            description: 'Deep dive into algorithms and data structures',
            duration: '10 weeks',
            image: 'https://placehold.co/600x400',
            icon: '🚀'
        }
    ];

    container.innerHTML = `
        <div class="container py-5">
            <h2 class="mb-4">📚 Available Courses</h2>
            <div class="row g-4">
                ${courses.map(course => `
                    <div class="col-md-4">
                        <div class="card course-card h-100">
                            <div class="text-center pt-4">
                                <span style="font-size: 3rem;">${course.icon}</span>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${course.title}</h5>
                                <p class="card-text">${course.description}</p>
                                <p class="text-muted">⏱️ Duration: ${course.duration}</p>
                                <button onclick="window.location.hash='#course/${course.id}'" class="btn btn-primary w-100">
                                    View Course 👉
                                </button>
                            </div>
                        </div>
                    </div>
                `).join('')}
            </div>
        </div>
    `;
};
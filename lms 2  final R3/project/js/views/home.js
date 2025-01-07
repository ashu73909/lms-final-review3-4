export const renderHome = (container) => {
    container.innerHTML = `
        <div class="container py-5">
            <div class="row">
                <div class="col-12 text-center mb-5">
                    <h1>Welcome to EduLearn LMS 📚</h1>
                    <p class="lead">Your journey to knowledge starts here ✨</p>
                </div>
            </div>
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body text-center">
                            <h5 class="card-title">
                                <span class="display-5 mb-3">📖</span><br>
                                Courses
                            </h5>
                            <p class="card-text">Explore our wide range of courses designed to help you succeed.</p>
                            <a href="#courses" class="btn btn-primary">Browse Courses</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body text-center">
                            <h5 class="card-title">
                                <span class="display-5 mb-3">✍️</span><br>
                                Tests
                            </h5>
                            <p class="card-text">Test your knowledge and track your progress.</p>
                            <a href="#tests" class="btn btn-primary">Take Tests</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card h-100">
                        <div class="card-body text-center">
                            <h5 class="card-title">
                                <span class="display-5 mb-3">🏆</span><br>
                                Rankings
                            </h5>
                            <p class="card-text">See how you compare with other learners.</p>
                            <a href="#rankings" class="btn btn-primary">View Rankings</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
};
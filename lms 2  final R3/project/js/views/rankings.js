export const renderRankings = (container) => {
    const rankings = [
        { rank: 1, name: 'John Doe', score: 980, courses: 8, medal: '🥇' },
        { rank: 2, name: 'Jane Smith', score: 945, courses: 7, medal: '🥈' },
        { rank: 3, name: 'Mike Johnson', score: 920, courses: 6, medal: '🥉' },
        { rank: 4, name: 'Sarah Williams', score: 890, courses: 8, medal: '🌟' },
        { rank: 5, name: 'David Brown', score: 860, courses: 5, medal: '🌟' }
    ];

    container.innerHTML = `
        <div class="container py-5">
            <h2 class="mb-4">🏆 Student Rankings</h2>
            <div class="ranking-table p-4">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Rank</th>
                            <th>Name</th>
                            <th>Score</th>
                            <th>Courses Completed</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${rankings.map(student => `
                            <tr>
                                <td>
                                    <span class="badge bg-${student.rank <= 3 ? 'warning' : 'secondary'} fs-5">
                                        ${student.medal}
                                    </span>
                                </td>
                                <td>${student.name}</td>
                                <td>🎯 ${student.score}</td>
                                <td>📚 ${student.courses}</td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            </div>
        </div>
    `;
};
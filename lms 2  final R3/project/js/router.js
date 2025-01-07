import { renderHome } from './views/home.js';
import { renderLogin } from './views/login.js';
import { renderCourses } from './views/courses.js';
import { renderTests } from './views/tests.js';
import { renderRankings } from './views/rankings.js';
import { renderProfile } from './views/profile.js';

const routes = {
    '#home': renderHome,
    '#login': renderLogin,
    '#courses': renderCourses,
    '#tests': renderTests,
    '#rankings': renderRankings,
    '#profile': renderProfile
};

export const router = {
    init: () => {
        // Handle initial route
        window.addEventListener('hashchange', () => {
            router.handleRoute();
        });
        
        // Handle the initial route
        if (!window.location.hash) {
            window.location.hash = '#home';
        } else {
            router.handleRoute();
        }
    },
    
    handleRoute: () => {
        const hash = window.location.hash;
        const render = routes[hash] || routes['#home'];
        const mainContent = document.getElementById('mainContent');
        render(mainContent);
    }
};
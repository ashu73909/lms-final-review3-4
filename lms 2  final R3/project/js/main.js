import { initializeDB } from './db.js';
import { router } from './router.js';
import { authService } from './services/auth.js';

// Initialize the application
document.addEventListener('DOMContentLoaded', async () => {
    await initializeDB();
    router.init();
    
    // Check if user is logged in
    const user = authService.getCurrentUser();
    if (user) {
        document.getElementById('loginNav').classList.add('d-none');
        document.getElementById('profileNav').classList.remove('d-none');
    }
});
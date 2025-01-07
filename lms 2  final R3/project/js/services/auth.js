import { dbService } from '../db.js';

export const authService = {
    login: (email, password) => {
        const user = dbService.getUser(email);
        if (user && user.password === password) {
            localStorage.setItem('currentUser', JSON.stringify(user));
            return user;
        }
        return null;
    },
    
    register: (userData) => {
        const user = dbService.createUser(userData);
        localStorage.setItem('currentUser', JSON.stringify(user));
        return user;
    },
    
    logout: () => {
        localStorage.removeItem('currentUser');
    },
    
    getCurrentUser: () => {
        const userStr = localStorage.getItem('currentUser');
        return userStr ? JSON.parse(userStr) : null;
    }
};
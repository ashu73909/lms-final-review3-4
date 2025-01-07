import { authService } from '../services/auth.js';

export const renderProfile = (container) => {
    const user = authService.getCurrentUser();
    
    if (!user) {
        window.location.hash = '#login';
        return;
    }

    container.innerHTML = `
        <div class="container py-5">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center mb-4">
                                <span style="font-size: 4rem;">👤</span>
                                <h2 class="card-title mt-3">My Profile</h2>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">👤 Name</label>
                                <input type="text" class="form-control" value="${user.name}" readonly>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">📧 Email</label>
                                <input type="email" class="form-control" value="${user.email}" readonly>
                            </div>
                            <button onclick="handleLogout()" class="btn btn-danger w-100">
                                <i class="bi bi-box-arrow-right"></i> Logout 👋
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;

    window.handleLogout = () => {
        authService.logout();
        document.getElementById('loginNav').classList.remove('d-none');
        document.getElementById('profileNav').classList.add('d-none');
        window.location.hash = '#home';
    };
};
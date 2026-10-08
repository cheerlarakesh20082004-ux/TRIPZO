import { useState } from 'react'

export function AuthPage({ onBack, onContinueAsCustomer }) {
  const [mode, setMode] = useState('login')

  return (
    <div className="page auth-page">
      <header className="topbar auth-topbar">
        <button type="button" className="brand-wrap brand-link brand-button" onClick={onBack}>
          <div className="brand-mark">T</div>
          <span className="brand-name">Tripzo</span>
        </button>

        <button type="button" className="secondary-btn small-btn" onClick={onBack}>
          Back to Home
        </button>
      </header>

      <main className="auth-shell">
        <section className="auth-card">
          <div className="auth-tab-row">
            <button
              type="button"
              className={mode === 'login' ? 'auth-tab active' : 'auth-tab'}
              onClick={() => setMode('login')}
            >
              Login
            </button>
            <button
              type="button"
              className={mode === 'register' ? 'auth-tab active' : 'auth-tab'}
              onClick={() => setMode('register')}
            >
              Register
            </button>
          </div>

          <div className="auth-form-wrap">
            {mode === 'login' ? (
              <form className="auth-form">
                <h2>Welcome back</h2>
                <label>
                  Email or Phone
                  <input type="text" placeholder="you@example.com" />
                </label>
                <label>
                  Password
                  <input type="password" placeholder="Enter your password" />
                </label>
                <button type="submit" className="primary-btn form-btn" onClick={onContinueAsCustomer}>
                  Login to Tripzo
                </button>
              </form>
            ) : (
              <form className="auth-form">
                <h2>Create an account</h2>
                <label>
                  Full Name
                  <input type="text" placeholder="Your name" />
                </label>
                <label>
                  Email
                  <input type="email" placeholder="you@example.com" />
                </label>
                <label>
                  Phone
                  <input type="tel" placeholder="+91 98765 43210" />
                </label>
                <label>
                  Password
                  <input type="password" placeholder="Create password" />
                </label>
                <button type="submit" className="primary-btn form-btn" onClick={onContinueAsCustomer}>
                  Register Now
                </button>
              </form>
            )}
          </div>
        </section>
      </main>
    </div>
  )
}

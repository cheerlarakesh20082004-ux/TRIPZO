const features = [
  {
    title: 'For Riders',
    description: 'Book rides in seconds with transparent fare estimates and live trip updates.',
    accent: 'customers',
  },
  {
    title: 'For Drivers',
    description: 'Accept ride requests, track earnings, and manage your availability from one dashboard.',
    accent: 'drivers',
  },
  {
    title: 'For Admins',
    description: 'Monitor operations, manage users, and review trip performance with real-time insights.',
    accent: 'admins',
  },
]

const rideTypes = [
  { name: 'Bike', rate: '₹8/km', icon: '🏍️' },
  { name: 'Auto', rate: '₹12/km', icon: '🚕' },
  { name: 'Cab', rate: '₹15/km', icon: '🚗' },
  { name: 'Premium', rate: '₹20/km', icon: '🚘' },
]

const steps = [
  'Enter pickup and destination',
  'Compare fare options instantly',
  'Track your driver in real time',
  'Ride and pay without hassle',
]

export function HomePage({ onNavigateToAuth, onNavigateToCustomer }) {
  return (
    <div className="page home-page">
      <header className="topbar">
        <div className="brand-wrap">
          <div className="brand-mark">T</div>
          <span className="brand-name">Tripzo</span>
        </div>

        <nav className="nav-links" aria-label="Main navigation">
          <button type="button" className="nav-btn">Home</button>
          <button type="button" className="nav-btn" onClick={onNavigateToAuth}>Login</button>
          <button type="button" className="nav-btn" onClick={onNavigateToAuth}>Register</button>
          <button type="button" className="nav-btn">About</button>
        </nav>

        <button type="button" className="primary-btn" onClick={onNavigateToCustomer || onNavigateToAuth}>
          Get Started
        </button>
      </header>

      <main>
        <section className="hero-section">
          <div className="hero-copy">
            <p className="eyebrow">Your Ride. Your Way.</p>
            <h1>Ride smarter, faster, and more comfortably.</h1>
            <p className="subtext">
              Tripzo makes everyday travel easier with quick booking, reliable drivers, and
              transparent pricing for every trip.
            </p>

            <div className="cta-row">
              <button type="button" className="primary-btn large-btn" onClick={onNavigateToCustomer || onNavigateToAuth}>
                Book a Ride
              </button>
              <button type="button" className="secondary-btn">
                Explore Services
              </button>
            </div>

            <div className="mini-stats">
              <div>
                <strong>12k+</strong>
                <span>Daily rides</span>
              </div>
              <div>
                <strong>4.8/5</strong>
                <span>Customer rating</span>
              </div>
              <div>
                <strong>2 min</strong>
                <span>Average pickup</span>
              </div>
            </div>
          </div>

          <div className="hero-visual">
            <div className="ride-card">
              <div className="card-header">
                <span className="status-dot" />
                <span>Live trip</span>
              </div>

              <div className="route-box">
                <div className="route-line" />
                <div className="pickup-point">
                  <span className="point pickup" />
                  <div>
                    <small>Pickup</small>
                    <strong>MG Road</strong>
                  </div>
                </div>

                <div className="drop-point">
                  <span className="point drop" />
                  <div>
                    <small>Destination</small>
                    <strong>Indiranagar</strong>
                  </div>
                </div>
              </div>

              <div className="fare-row">
                <div>
                  <small>Estimated fare</small>
                  <strong>₹398</strong>
                </div>
                <div className="driver-pill">
                  <span className="driver-avatar">D</span>
                  <span>Driver on the way</span>
                </div>
              </div>
            </div>
          </div>
        </section>

        <section className="feature-section">
          <div className="section-heading">
            <p className="eyebrow">All-in-one mobility platform</p>
            <h2>Built for every part of the ride journey</h2>
          </div>

          <div className="feature-grid">
            {features.map((feature) => (
              <article key={feature.title} className={`feature-card ${feature.accent}`}>
                <div className="feature-icon">{feature.title.charAt(0)}</div>
                <h3>{feature.title}</h3>
                <p>{feature.description}</p>
              </article>
            ))}
          </div>
        </section>

        <section className="ride-options-section">
          <div className="section-heading">
            <p className="eyebrow">Choose your ride</p>
            <h2>Flexible options for every route</h2>
          </div>

          <div className="ride-type-grid">
            {rideTypes.map((ride) => (
              <div key={ride.name} className="ride-type-card">
                <div className="ride-emoji">{ride.icon}</div>
                <h3>{ride.name}</h3>
                <p>{ride.rate}</p>
              </div>
            ))}
          </div>
        </section>

        <section className="how-it-works">
          <div className="section-heading">
            <p className="eyebrow">How Tripzo works</p>
            <h2>From booking to arrival in just a few steps</h2>
          </div>

          <div className="step-list">
            {steps.map((step, index) => (
              <div key={step} className="step-item">
                <span className="step-number">0{index + 1}</span>
                <p>{step}</p>
              </div>
            ))}
          </div>
        </section>
      </main>

      <footer className="site-footer">
        <div>
          <span className="brand-name">Tripzo</span>
          <p>Smart mobility for modern cities.</p>
        </div>
        <div className="footer-links">
          <span>Privacy</span>
          <span>Terms</span>
          <span>Support</span>
        </div>
      </footer>
    </div>
  )
}

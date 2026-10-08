const stats = [
  { label: 'Trips this month', value: '18', accent: 'blue' },
  { label: 'Total spend', value: '₹2,480', accent: 'green' },
  { label: 'Saved rides', value: '3', accent: 'purple' },
  { label: 'Avg. rating', value: '4.8/5', accent: 'amber' },
]

const recentTrips = [
  { id: 'TRP-1042', route: 'MG Road → Indiranagar', status: 'Completed', amount: '₹398' },
  { id: 'TRP-1036', route: 'Koramangala → Whitefield', status: 'Completed', amount: '₹620' },
  { id: 'TRP-1028', route: 'HSR Layout → Domlur', status: 'In Progress', amount: '₹310' },
]

const quickActions = ['Book a ride', 'Ride history', 'Payments', 'Support']

export function CustomerDashboardPage({ onBack }) {
  return (
    <div className="page dashboard-page">
      <header className="topbar dashboard-topbar">
        <div className="brand-wrap">
          <div className="brand-mark">T</div>
          <span className="brand-name">Tripzo</span>
        </div>

        <div className="dashboard-actions">
          <button type="button" className="secondary-btn small-btn">
            Notifications
          </button>
          <button type="button" className="primary-btn small-btn" onClick={onBack}>
            Sign Out
          </button>
        </div>
      </header>

      <main className="dashboard-shell">
        <aside className="sidebar-panel">
          <div className="profile-summary">
            <div className="avatar-large">A</div>
            <div>
              <h3>Aisha Khan</h3>
              <p>Premium Rider</p>
            </div>
          </div>

          <nav className="sidebar-nav" aria-label="Customer dashboard navigation">
            <button type="button" className="nav-item active">Dashboard</button>
            <button type="button" className="nav-item">Book Ride</button>
            <button type="button" className="nav-item">Current Ride</button>
            <button type="button" className="nav-item">Ride History</button>
            <button type="button" className="nav-item">Profile</button>
            <button type="button" className="nav-item">Payments</button>
          </nav>
        </aside>

        <section className="dashboard-content">
          <div className="welcome-row">
            <div>
              <p className="eyebrow">Customer dashboard</p>
              <h1>Welcome back, Aisha</h1>
            </div>
            <button type="button" className="primary-btn">Book a new ride</button>
          </div>

          <div className="stats-grid">
            {stats.map((stat) => (
              <div key={stat.label} className={`stat-card ${stat.accent}`}>
                <p>{stat.label}</p>
                <strong>{stat.value}</strong>
              </div>
            ))}
          </div>

          <div className="content-grid">
            <div className="panel current-trip-panel">
              <div className="panel-header">
                <h3>Current ride</h3>
                <span className="status-badge">In progress</span>
              </div>

              <div className="route-summary">
                <div>
                  <small>Pickup</small>
                  <strong>MG Road</strong>
                </div>
                <div className="route-arrow">→</div>
                <div>
                  <small>Destination</small>
                  <strong>Indiranagar</strong>
                </div>
              </div>

              <div className="driver-summary">
                <div className="avatar-small">D</div>
                <div>
                  <strong>Driver: Rahul Nair</strong>
                  <p>Cab • ETA: 4 min</p>
                </div>
              </div>
            </div>

            <div className="panel quick-actions-panel">
              <div className="panel-header">
                <h3>Quick actions</h3>
              </div>
              <div className="quick-actions-list">
                {quickActions.map((action) => (
                  <button type="button" key={action} className="action-chip">
                    {action}
                  </button>
                ))}
              </div>
            </div>
          </div>

          <div className="panel table-panel">
            <div className="panel-header">
              <h3>Recent rides</h3>
              <button type="button" className="secondary-btn small-btn">View all</button>
            </div>

            <table>
              <thead>
                <tr>
                  <th>Trip ID</th>
                  <th>Route</th>
                  <th>Status</th>
                  <th>Amount</th>
                </tr>
              </thead>
              <tbody>
                {recentTrips.map((trip) => (
                  <tr key={trip.id}>
                    <td>{trip.id}</td>
                    <td>{trip.route}</td>
                    <td>
                      <span className={trip.status === 'Completed' ? 'table-status success' : 'table-status warning'}>
                        {trip.status}
                      </span>
                    </td>
                    <td>{trip.amount}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </section>
      </main>
    </div>
  )
}

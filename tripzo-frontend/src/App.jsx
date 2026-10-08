import { useState } from 'react'
import './App.css'
import { HomePage } from './pages/HomePage'
import { AuthPage } from './pages/AuthPage'
import { CustomerDashboardPage } from './pages/CustomerDashboardPage'

function App() {
  const [view, setView] = useState('home')

  if (view === 'home') {
    return <HomePage onNavigateToAuth={() => setView('auth')} onNavigateToCustomer={() => setView('customer')} />
  }

  if (view === 'auth') {
    return <AuthPage onBack={() => setView('home')} onContinueAsCustomer={() => setView('customer')} />
  }

  return <CustomerDashboardPage onBack={() => setView('home')} />
}

export default App

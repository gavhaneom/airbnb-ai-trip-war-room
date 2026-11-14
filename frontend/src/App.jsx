import { useEffect, useState } from 'react'

const API = 'http://localhost:8080/api/v1'

export default function App() {
  const [trips, setTrips] = useState([])
  const [error, setError] = useState('')
  const [form, setForm] = useState({
    name: '', destination: '', startDate: '', endDate: '',
    totalBudget: '', maxParticipants: 4
  })

  async function loadTrips() {
    try {
      setError('')
      const response = await fetch(`${API}/trips`)
      if (!response.ok) throw new Error('Could not load trips. Is the backend running?')
      setTrips(await response.json())
    } catch (e) { setError(e.message) }
  }

  useEffect(() => { loadTrips() }, [])

  function update(event) {
    setForm({ ...form, [event.target.name]: event.target.value })
  }

  async function createTrip(event) {
    event.preventDefault()
    try {
      setError('')
      const response = await fetch(`${API}/trips`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          ...form,
          totalBudget: Number(form.totalBudget),
          maxParticipants: Number(form.maxParticipants)
        })
      })
      const data = await response.json()
      if (!response.ok) throw new Error(data.error || 'Trip creation failed')
      setForm({ name: '', destination: '', startDate: '', endDate: '', totalBudget: '', maxParticipants: 4 })
      await loadTrips()
    } catch (e) { setError(e.message) }
  }

  return (
    <main className="page">
      <header className="topbar">
        <div className="brand"><span className="brand-mark">✦</span> Trip War Room</div>
        <span className="tag">FULL-STACK PROJECT</span>
      </header>

      <section className="hero">
        <p className="eyebrow">PLAN TOGETHER · TRAVEL BETTER</p>
        <h1>Your next trip starts <em>here.</em></h1>
        <p className="subtitle">Create a trip room, organize the essentials, and bring your group plan together.</p>
      </section>

      {error && <div className="error">{error}</div>}

      <section className="content-grid">
        <form className="panel form-panel" onSubmit={createTrip}>
          <div className="panel-heading"><div><p className="eyebrow">GET STARTED</p><h2>Create a trip</h2></div><span className="icon">＋</span></div>
          <label>Trip name<input name="name" value={form.name} onChange={update} placeholder="e.g. Summer in Lisbon" required maxLength="120" /></label>
          <label>Destination<input name="destination" value={form.destination} onChange={update} placeholder="City, Country" required /></label>
          <div className="two-col">
            <label>Start date<input type="date" name="startDate" value={form.startDate} onChange={update} required /></label>
            <label>End date<input type="date" name="endDate" value={form.endDate} onChange={update} required /></label>
          </div>
          <div className="two-col">
            <label>Total budget<input type="number" min="0.01" step="0.01" name="totalBudget" value={form.totalBudget} onChange={update} placeholder="1200" required /></label>
            <label>Group size<input type="number" min="1" max="50" name="maxParticipants" value={form.maxParticipants} onChange={update} required /></label>
          </div>
          <button className="primary" type="submit">Create trip room <span>→</span></button>
        </form>

        <section className="panel trips-panel">
          <div className="panel-heading"><div><p className="eyebrow">YOUR WORKSPACE</p><h2>Trip rooms</h2></div><span className="count">{trips.length} TOTAL</span></div>
          {trips.length === 0 ? (
            <div className="empty"><div className="empty-icon">✈</div><h3>No trips yet</h3><p>Create your first trip room to see it here.</p></div>
          ) : (
            <div className="trip-list">{trips.map(trip => (
              <article className="trip-card" key={trip.id}>
                <div className="trip-symbol">✦</div>
                <div className="trip-info"><h3>{trip.name}</h3><p>{trip.destination}</p><small>{trip.startDate} — {trip.endDate}</small></div>
                <div className="trip-budget"><strong>${Number(trip.totalBudget).toLocaleString()}</strong><small>{trip.maxParticipants} people</small></div>
              </article>
            ))}</div>
          )}
          <button className="refresh" onClick={loadTrips} type="button">↻ Refresh trips</button>
        </section>
      </section>
      <footer>Educational project starter · React + Spring Boot + MySQL</footer>
    </main>
  )
}

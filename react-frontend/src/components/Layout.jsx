function Layout({ title, subtitle, children }) {
  return (
    <div className="page">
      <header className="site-header">
        <h1>{title}</h1>
        {subtitle && <p>{subtitle}</p>}
      </header>

      <main className="container">
        {children}
      </main>
    </div>
  );
}

export default Layout;

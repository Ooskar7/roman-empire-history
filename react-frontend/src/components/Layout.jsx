function Layout({ title, subtitle, backgroundImage, children }) {
  const headerStyle = backgroundImage
    ? { backgroundImage: `linear-gradient(rgba(60, 35, 24, 0.72), rgba(60, 35, 24, 0.72)), url(${backgroundImage})` }
    : {};

  return (
    <div className="page">
      <header className="site-header hero-header" style={headerStyle}>
        <h1>{title}</h1>
        {subtitle && <p>{subtitle}</p>}
      </header>

      <main className="container">{children}</main>
    </div>
  );
}

export default Layout;

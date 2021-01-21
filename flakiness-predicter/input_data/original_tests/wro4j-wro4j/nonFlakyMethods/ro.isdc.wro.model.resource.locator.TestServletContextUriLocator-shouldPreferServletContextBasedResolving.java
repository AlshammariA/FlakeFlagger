@Test public void shouldPreferServletContextBasedResolving() throws IOException {
  final InputStream is=new ByteArrayInputStream("a {}".getBytes());
  Mockito.when(Context.get().getServletContext().getResourceAsStream(Mockito.anyString())).thenReturn(is);
  final ServletContextUriLocator locator=new ServletContextUriLocator();
  initLocator(locator);
  locator.setLocatorStrategy(ServletContextUriLocator.LocatorStrategy.SERVLET_CONTEXT_FIRST);
  final InputStream actualIs=locator.locate("test.css");
  final BufferedReader br=new BufferedReader(new InputStreamReader(actualIs));
  assertEquals("a {}",br.readLine());
}

@Test public void shouldReloadCache() throws IOException, ServletException {
  victim.handle(request,response);
  verify(response,times(1)).setStatus(HttpServletResponse.SC_OK);
}

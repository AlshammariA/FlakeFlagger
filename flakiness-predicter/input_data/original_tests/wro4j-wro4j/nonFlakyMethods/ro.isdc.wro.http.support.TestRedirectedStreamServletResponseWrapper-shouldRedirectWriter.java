@Test public void shouldRedirectWriter() throws Exception {
  final String message="Hello world!";
  victim.getWriter().write(message);
  victim.getWriter().flush();
  Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}

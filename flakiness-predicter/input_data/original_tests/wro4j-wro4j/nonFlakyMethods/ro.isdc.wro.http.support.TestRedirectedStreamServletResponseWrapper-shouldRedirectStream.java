@Test public void shouldRedirectStream() throws Exception {
  final String message="Hello world!";
  victim.getOutputStream().write(message.getBytes());
  victim.getOutputStream().flush();
  Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}

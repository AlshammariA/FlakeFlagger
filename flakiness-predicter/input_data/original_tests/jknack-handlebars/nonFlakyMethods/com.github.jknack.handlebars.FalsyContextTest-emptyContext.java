@Test public void emptyContext() throws IOException {
  shouldCompileTo("Hello {{world}}!",new Object(),"Hello !");
}

@Test public void anyContext() throws IOException {
  shouldCompileTo("Hello {{world}}!",true,"Hello !");
  shouldCompileTo("Hello {{world}}!",13.4,"Hello !");
}

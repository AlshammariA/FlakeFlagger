@Test public void nullContext() throws IOException {
  shouldCompileTo("Hello {{world}}!",null,"Hello !");
}

@Test public void emptyMapContext() throws IOException {
  shouldCompileTo("Hello {{world}}!",Collections.emptyMap(),"Hello !");
}

@Test public void emptyList() throws IOException {
  shouldCompileTo("Hello {{world}}!",Collections.emptyList(),"Hello !");
}

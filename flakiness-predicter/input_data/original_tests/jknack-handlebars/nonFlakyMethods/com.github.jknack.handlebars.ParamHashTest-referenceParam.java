@Test public void referenceParam() throws IOException {
  shouldCompileTo("{{varp . ref}}",$("ref","."),"String:.");
}

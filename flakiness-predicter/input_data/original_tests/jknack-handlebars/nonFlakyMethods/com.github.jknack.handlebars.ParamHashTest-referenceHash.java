@Test public void referenceHash() throws IOException {
  shouldCompileTo("{{var h=ref}}",$("ref","."),"String:.");
}

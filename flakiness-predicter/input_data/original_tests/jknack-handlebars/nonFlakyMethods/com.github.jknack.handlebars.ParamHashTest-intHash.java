@Test public void intHash() throws IOException {
  shouldCompileTo("{{var h=9}}",$,"Integer:9");
}

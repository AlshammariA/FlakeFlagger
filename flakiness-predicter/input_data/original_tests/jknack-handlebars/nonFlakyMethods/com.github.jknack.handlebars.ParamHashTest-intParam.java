@Test public void intParam() throws IOException {
  shouldCompileTo("{{varp . 9}}",$,"Integer:9");
}

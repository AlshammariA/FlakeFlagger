@Test public void charsHash() throws IOException {
  shouldCompileTo("{{var h='Hey!' }}",$,"String:Hey!");
}

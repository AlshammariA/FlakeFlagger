@Test public void shouldAcceptBadOptions() throws Exception {
  jsLint.setOptions("1,2");
  jsLint.validate("");
}

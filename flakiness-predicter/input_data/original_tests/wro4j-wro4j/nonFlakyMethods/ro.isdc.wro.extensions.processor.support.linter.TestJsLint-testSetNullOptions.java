@Test public void testSetNullOptions() throws Exception {
  final String options=null;
  jsLint.setOptions(options);
  jsLint.validate("");
}

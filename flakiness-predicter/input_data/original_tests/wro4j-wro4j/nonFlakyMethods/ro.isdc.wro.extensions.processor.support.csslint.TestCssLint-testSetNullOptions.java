@Test public void testSetNullOptions() throws Exception {
  cssLint.setOptions(null);
  cssLint.validate("");
}

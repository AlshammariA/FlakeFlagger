@Test public void testWithSeveralOptions() throws Exception {
  cssLint.setOptions("1, 2");
  cssLint.validate("");
}

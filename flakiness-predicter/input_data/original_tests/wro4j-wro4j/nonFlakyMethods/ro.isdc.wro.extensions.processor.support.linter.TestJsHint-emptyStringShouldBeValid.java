@Test public void emptyStringShouldBeValid() throws Exception {
  final String options=null;
  jsHint.setOptions(options);
  jsHint.validate("");
}

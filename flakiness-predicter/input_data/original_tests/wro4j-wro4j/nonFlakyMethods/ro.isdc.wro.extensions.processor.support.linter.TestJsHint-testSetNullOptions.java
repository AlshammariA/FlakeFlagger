@Test public void testSetNullOptions() throws Exception {
  final String options=null;
  jsHint.setOptions(options);
  jsHint.validate(VALID_JS);
}

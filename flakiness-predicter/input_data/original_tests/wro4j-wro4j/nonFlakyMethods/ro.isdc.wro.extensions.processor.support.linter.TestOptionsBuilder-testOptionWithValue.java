@Test public void testOptionWithValue() throws Exception {
  assertEquals("{\"maxerr\": 100}",optionsBuilder.build("maxerr=100"));
}

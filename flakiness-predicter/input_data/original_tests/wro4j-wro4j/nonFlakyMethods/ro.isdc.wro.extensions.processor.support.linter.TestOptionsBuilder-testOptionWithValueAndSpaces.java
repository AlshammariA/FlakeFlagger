@Test public void testOptionWithValueAndSpaces() throws Exception {
  assertEquals("{\"maxerr\": 100}",optionsBuilder.build("maxerr =  100"));
}

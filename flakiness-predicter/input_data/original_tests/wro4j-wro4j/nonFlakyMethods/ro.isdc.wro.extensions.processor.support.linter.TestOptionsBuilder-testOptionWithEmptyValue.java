@Test(expected=IllegalArgumentException.class) public void testOptionWithEmptyValue() throws Exception {
  assertEquals("{\"maxerr\": 100}",optionsBuilder.build("maxerr="));
}

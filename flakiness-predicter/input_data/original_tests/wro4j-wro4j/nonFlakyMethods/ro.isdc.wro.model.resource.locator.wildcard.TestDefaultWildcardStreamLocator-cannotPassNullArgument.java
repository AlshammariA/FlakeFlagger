@Test(expected=IOException.class) public void cannotPassNullArgument() throws IOException {
  locator.locateStream(null,null);
}

@Test(expected=IOException.class) public void cannotPassNullFolder() throws IOException {
  locator.locateStream("/resource/*.css",null);
}

@Test(expected=MalformedURLException.class) public void cannotLocateMalformedUrl() throws IOException {
  victim.locate("/someInvalidUri.html");
}

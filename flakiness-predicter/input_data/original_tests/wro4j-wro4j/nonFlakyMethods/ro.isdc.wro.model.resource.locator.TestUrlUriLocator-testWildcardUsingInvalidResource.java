@Test(expected=IOException.class) public void testWildcardUsingInvalidResource() throws IOException {
  victim.locate(createUri("http://www.google.com/*.js"));
}

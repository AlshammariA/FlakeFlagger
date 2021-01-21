@Test(expected=WroRuntimeException.class) public void shouldFailWhenNoCapableLocatorAvailable() throws Exception {
  factory.addLocator(new ClasspathUriLocator());
  factory.locate("http://www.google.com");
}

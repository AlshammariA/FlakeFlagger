@Test(expected=SAXParseException.class) public void testWildcardImports() throws Throwable {
  try {
    loadModelFromLocation("testimport/wildcard.xml");
  }
 catch (  final WroRuntimeException e) {
    throw e.getCause();
  }
}

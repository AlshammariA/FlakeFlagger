@Test public void renderingUndefinedPartialThrowsException() throws IOException {
  try {
    shouldCompileTo("{{> whatever}}",$,null);
    fail("rendering undefined partial throws an exception");
  }
 catch (  HandlebarsException ex) {
    HandlebarsError error=ex.getError();
    assertNotNull(error);
    assertEquals("The partial '/whatever.hbs' could not be found",error.reason);
  }
}

@Test(expected=HandlebarsException.class) public void missingKeyError() throws IOException {
  shouldCompileTo("{{i18n \"missing\"}}",null,"error");
}

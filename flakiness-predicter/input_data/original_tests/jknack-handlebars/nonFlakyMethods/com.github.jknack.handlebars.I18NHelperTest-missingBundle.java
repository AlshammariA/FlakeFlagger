@Test(expected=HandlebarsException.class) public void missingBundle() throws IOException {
  shouldCompileTo("{{i18n \"key\" bundle=\"missing\"}}!",null,"");
}

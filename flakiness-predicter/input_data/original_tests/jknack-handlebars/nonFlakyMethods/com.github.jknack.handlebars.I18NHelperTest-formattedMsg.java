@Test public void formattedMsg() throws IOException {
  shouldCompileTo("{{i18n \"formatted\" \"Handlebars.java\"}}!",null,"Hi Handlebars.java!");
}

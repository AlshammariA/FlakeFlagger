@Test public void customLocale() throws IOException {
  shouldCompileTo("{{i18n \"hello\" locale=\"es_AR\"}} Handlebars.java!",$,"Hola Handlebars.java!");
}

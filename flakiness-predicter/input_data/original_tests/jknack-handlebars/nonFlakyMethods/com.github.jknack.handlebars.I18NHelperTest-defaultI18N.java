@Test public void defaultI18N() throws IOException {
  shouldCompileTo("{{i18n \"hello\"}} Handlebars.java!",$,"Hi Handlebars.java!");
}

@Test public void setCustomLocale() throws IOException {
  shouldCompileTo("{{i18n \"hello\" bundle=\"myMessages\" locale=\"es_AR\"}}",null,"Hola");
}

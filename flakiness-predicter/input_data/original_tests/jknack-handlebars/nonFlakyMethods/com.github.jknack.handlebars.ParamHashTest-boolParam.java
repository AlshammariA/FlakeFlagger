@Test public void boolParam() throws IOException {
  shouldCompileTo("{{varp . true}}",$,"Boolean:true");
  shouldCompileTo("{{varp . false}}",$,"Boolean:false");
}

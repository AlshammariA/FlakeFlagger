@Test public void boolHash() throws IOException {
  shouldCompileTo("{{var h=true}}",$,"Boolean:true");
  shouldCompileTo("{{var h=false}}",$,"Boolean:false");
}

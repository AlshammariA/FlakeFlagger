@Test public void testHelperWithParams() throws IOException {
  shouldCompileTo("{{helperWithParams \"string\" true 4}}",$,"helperWithParams:string:true:4");
}

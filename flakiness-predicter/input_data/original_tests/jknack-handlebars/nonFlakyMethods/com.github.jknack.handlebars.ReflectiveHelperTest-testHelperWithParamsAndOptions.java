@Test public void testHelperWithParamsAndOptions() throws IOException {
  shouldCompileTo("{{helperWithParamsAndOptions \"string\" true 4}}",$,"helperWithParamsAndOptions:string:true:4");
}

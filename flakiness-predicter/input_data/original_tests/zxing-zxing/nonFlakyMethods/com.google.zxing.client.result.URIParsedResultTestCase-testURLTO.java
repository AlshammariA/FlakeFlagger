@Test public void testURLTO(){
  doTest("urlto::bar.com","http://bar.com",null);
  doTest("urlto::http://bar.com","http://bar.com",null);
  doTest("urlto:foo:bar.com","http://bar.com","foo");
}

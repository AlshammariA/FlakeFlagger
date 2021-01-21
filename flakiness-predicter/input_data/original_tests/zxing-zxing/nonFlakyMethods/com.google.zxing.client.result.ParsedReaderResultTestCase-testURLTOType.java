@Test public void testURLTOType(){
  doTestResult("urlto:foo:bar.com","foo\nhttp://bar.com",ParsedResultType.URI);
  doTestResult("URLTO:foo:bar.com","foo\nhttp://bar.com",ParsedResultType.URI);
  doTestResult("URLTO::bar.com","http://bar.com",ParsedResultType.URI);
  doTestResult("URLTO::http://bar.com","http://bar.com",ParsedResultType.URI);
}

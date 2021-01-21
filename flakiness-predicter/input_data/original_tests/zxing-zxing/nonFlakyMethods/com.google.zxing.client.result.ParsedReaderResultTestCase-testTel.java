@Test public void testTel(){
  doTestResult("tel:+15551212","+15551212",ParsedResultType.TEL);
  doTestResult("TEL:+15551212","+15551212",ParsedResultType.TEL);
  doTestResult("tel:212 555 1212","212 555 1212",ParsedResultType.TEL);
  doTestResult("tel:2125551212","2125551212",ParsedResultType.TEL);
  doTestResult("tel:212-555-1212","212-555-1212",ParsedResultType.TEL);
  doTestResult("tel","tel",ParsedResultType.TEXT);
  doTestResult("telephone","telephone",ParsedResultType.TEXT);
}

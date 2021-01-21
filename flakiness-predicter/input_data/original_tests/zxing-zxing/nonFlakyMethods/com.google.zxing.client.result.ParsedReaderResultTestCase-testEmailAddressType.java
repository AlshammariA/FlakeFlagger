@Test public void testEmailAddressType(){
  doTestResult("srowen@example.org","srowen@example.org",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("mailto:srowen@example.org","srowen@example.org",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("MAILTO:srowen@example.org","srowen@example.org",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("srowen@example","srowen@example",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("srowen","srowen",ParsedResultType.TEXT);
  doTestResult("Let's meet @ 2","Let's meet @ 2",ParsedResultType.TEXT);
}

@Test public void testSMS(){
  doTestResult("sms:+15551212","+15551212",ParsedResultType.SMS);
  doTestResult("SMS:+15551212","+15551212",ParsedResultType.SMS);
  doTestResult("sms:+15551212;via=999333","+15551212",ParsedResultType.SMS);
  doTestResult("sms:+15551212?subject=foo&body=bar","+15551212\nfoo\nbar",ParsedResultType.SMS);
  doTestResult("sms:+15551212,+12124440101","+15551212\n+12124440101",ParsedResultType.SMS);
}

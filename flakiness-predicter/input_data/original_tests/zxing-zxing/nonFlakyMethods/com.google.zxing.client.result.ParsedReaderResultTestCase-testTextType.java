@Test public void testTextType(){
  doTestResult("","",ParsedResultType.TEXT);
  doTestResult("foo","foo",ParsedResultType.TEXT);
  doTestResult("Hi.","Hi.",ParsedResultType.TEXT);
  doTestResult("This is a test","This is a test",ParsedResultType.TEXT);
  doTestResult("This is a test\nwith newlines","This is a test\nwith newlines",ParsedResultType.TEXT);
  doTestResult("This: a test with lots of @ nearly-random punctuation! No? OK then.","This: a test with lots of @ nearly-random punctuation! No? OK then.",ParsedResultType.TEXT);
}

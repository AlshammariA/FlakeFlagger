@Test public void testEmailType(){
  doTestResult("MATMSG:TO:srowen@example.org;;","srowen@example.org",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("MATMSG:TO:srowen@example.org;SUB:Stuff;;","srowen@example.org\nStuff",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("MATMSG:TO:srowen@example.org;SUB:Stuff;BODY:This is some text;;","srowen@example.org\nStuff\nThis is some text",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("MATMSG:SUB:Stuff;BODY:This is some text;TO:srowen@example.org;;","srowen@example.org\nStuff\nThis is some text",ParsedResultType.EMAIL_ADDRESS);
  doTestResult("TO:srowen@example.org;SUB:Stuff;BODY:This is some text;;","TO:srowen@example.org;SUB:Stuff;BODY:This is some text;;",ParsedResultType.TEXT);
}

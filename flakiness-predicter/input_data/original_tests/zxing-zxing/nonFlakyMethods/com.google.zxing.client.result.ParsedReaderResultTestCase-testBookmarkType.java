@Test public void testBookmarkType(){
  doTestResult("MEBKM:URL:google.com;;","http://google.com",ParsedResultType.URI);
  doTestResult("MEBKM:URL:google.com;TITLE:Google;;","Google\nhttp://google.com",ParsedResultType.URI);
  doTestResult("MEBKM:TITLE:Google;URL:google.com;;","Google\nhttp://google.com",ParsedResultType.URI);
  doTestResult("MEBKM:URL:http://google.com;;","http://google.com",ParsedResultType.URI);
  doTestResult("MEBKM:URL:HTTPS://google.com;;","HTTPS://google.com",ParsedResultType.URI);
}

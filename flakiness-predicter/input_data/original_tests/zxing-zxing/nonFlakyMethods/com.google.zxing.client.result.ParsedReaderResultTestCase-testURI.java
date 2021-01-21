@Test public void testURI(){
  doTestResult("http://google.com","http://google.com",ParsedResultType.URI);
  doTestResult("google.com","http://google.com",ParsedResultType.URI);
  doTestResult("https://google.com","https://google.com",ParsedResultType.URI);
  doTestResult("HTTP://google.com","HTTP://google.com",ParsedResultType.URI);
  doTestResult("http://google.com/foobar","http://google.com/foobar",ParsedResultType.URI);
  doTestResult("https://google.com:443/foobar","https://google.com:443/foobar",ParsedResultType.URI);
  doTestResult("google.com:443","http://google.com:443",ParsedResultType.URI);
  doTestResult("google.com:443/","http://google.com:443/",ParsedResultType.URI);
  doTestResult("google.com:443/foobar","http://google.com:443/foobar",ParsedResultType.URI);
  doTestResult("http://google.com:443/foobar","http://google.com:443/foobar",ParsedResultType.URI);
  doTestResult("https://google.com:443/foobar","https://google.com:443/foobar",ParsedResultType.URI);
  doTestResult("ftp://google.com/fake","ftp://google.com/fake",ParsedResultType.URI);
  doTestResult("gopher://google.com/obsolete","gopher://google.com/obsolete",ParsedResultType.URI);
}

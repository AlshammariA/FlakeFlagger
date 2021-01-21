/** 
 * Verify encoding of URLs
 */
@Test public void encode(){
  assertEquals("http://google.com",HttpRequest.encode("http://google.com"));
  assertEquals("https://google.com",HttpRequest.encode("https://google.com"));
  assertEquals("http://google.com/a",HttpRequest.encode("http://google.com/a"));
  assertEquals("http://google.com/a/",HttpRequest.encode("http://google.com/a/"));
  assertEquals("http://google.com/a/b",HttpRequest.encode("http://google.com/a/b"));
  assertEquals("http://google.com/a?",HttpRequest.encode("http://google.com/a?"));
  assertEquals("http://google.com/a?b=c",HttpRequest.encode("http://google.com/a?b=c"));
  assertEquals("http://google.com/a?b=c%20d",HttpRequest.encode("http://google.com/a?b=c d"));
  assertEquals("http://google.com/a%20b",HttpRequest.encode("http://google.com/a b"));
  assertEquals("http://google.com/a.b",HttpRequest.encode("http://google.com/a.b"));
  assertEquals("http://google.com/%E2%9C%93?a=b",HttpRequest.encode("http://google.com/\u2713?a=b"));
  assertEquals("http://google.com/a%5Eb",HttpRequest.encode("http://google.com/a^b"));
  assertEquals("http://google.com/%25",HttpRequest.encode("http://google.com/%"));
  assertEquals("http://google.com/a.b?c=d.e",HttpRequest.encode("http://google.com/a.b?c=d.e"));
  assertEquals("http://google.com/a.b?c=d/e",HttpRequest.encode("http://google.com/a.b?c=d/e"));
  assertEquals("http://google.com/a?%E2%98%91",HttpRequest.encode("http://google.com/a?\u2611"));
  assertEquals("http://google.com/a?b=%E2%98%90",HttpRequest.encode("http://google.com/a?b=\u2610"));
  assertEquals("http://google.com/a?b=c%2Bd&e=f%2Bg",HttpRequest.encode("http://google.com/a?b=c+d&e=f+g"));
  assertEquals("http://google.com/+",HttpRequest.encode("http://google.com/+"));
  assertEquals("http://google.com/+?a=b%2Bc",HttpRequest.encode("http://google.com/+?a=b+c"));
}

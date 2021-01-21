@Test public void testNotURI(){
  doTestNotUri("google.c");
  doTestNotUri(".com");
  doTestNotUri(":80/");
  doTestNotUri("ABC,20.3,AB,AD");
  doTestNotUri("http://google.com?q=foo bar");
  doTestNotUri("12756.501");
  doTestNotUri("google.50");
}

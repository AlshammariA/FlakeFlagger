@Test public void testIsPossiblyMalicious(){
  doTestIsPossiblyMalicious("http://google.com",false);
  doTestIsPossiblyMalicious("http://google.com@evil.com",true);
  doTestIsPossiblyMalicious("http://google.com:@evil.com",true);
  doTestIsPossiblyMalicious("google.com:@evil.com",false);
  doTestIsPossiblyMalicious("https://google.com:443",false);
  doTestIsPossiblyMalicious("https://google.com:443/",false);
  doTestIsPossiblyMalicious("https://evil@google.com:443",true);
  doTestIsPossiblyMalicious("http://google.com/foo@bar",false);
  doTestIsPossiblyMalicious("http://google.com/@@",false);
}

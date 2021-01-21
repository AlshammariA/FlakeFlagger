@Test public void testBookmarkDocomo(){
  doTest("MEBKM:URL:google.com;;","http://google.com",null);
  doTest("MEBKM:URL:http://google.com;;","http://google.com",null);
  doTest("MEBKM:URL:google.com;TITLE:Google;","http://google.com","Google");
}

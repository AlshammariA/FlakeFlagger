@Test public void testReadLineChunks() throws Exception {
  HttpParams params=new BasicHttpParams();
  SessionInputBuffer inbuf=new SessionInputBufferImpl(16,16,params);
  ReadableByteChannel channel=newChannel("One\r\nTwo\r\nThree");
  inbuf.fill(channel);
  CharArrayBuffer line=new CharArrayBuffer(64);
  line.clear();
  Assert.assertTrue(inbuf.readLine(line,false));
  Assert.assertEquals("One",line.toString());
  line.clear();
  Assert.assertTrue(inbuf.readLine(line,false));
  Assert.assertEquals("Two",line.toString());
  line.clear();
  Assert.assertFalse(inbuf.readLine(line,false));
  channel=newChannel("\r\nFour");
  inbuf.fill(channel);
  line.clear();
  Assert.assertTrue(inbuf.readLine(line,false));
  Assert.assertEquals("Three",line.toString());
  inbuf.fill(channel);
  line.clear();
  Assert.assertTrue(inbuf.readLine(line,true));
  Assert.assertEquals("Four",line.toString());
  line.clear();
  Assert.assertFalse(inbuf.readLine(line,true));
}

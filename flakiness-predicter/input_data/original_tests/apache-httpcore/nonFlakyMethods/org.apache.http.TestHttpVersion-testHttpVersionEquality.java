@Test public void testHttpVersionEquality() throws Exception {
  HttpVersion ver1=new HttpVersion(1,1);
  HttpVersion ver2=new HttpVersion(1,1);
  Assert.assertEquals(ver1.hashCode(),ver2.hashCode());
  Assert.assertTrue(ver1.equals(ver1));
  Assert.assertTrue(ver1.equals(ver2));
  Assert.assertTrue(ver1.equals(ver1));
  Assert.assertTrue(ver1.equals(ver2));
  Assert.assertFalse(ver1.equals(new Float(1.1)));
  Assert.assertTrue((new HttpVersion(0,9)).equals(HttpVersion.HTTP_0_9));
  Assert.assertTrue((new HttpVersion(1,0)).equals(HttpVersion.HTTP_1_0));
  Assert.assertTrue((new HttpVersion(1,1)).equals(HttpVersion.HTTP_1_1));
  Assert.assertFalse((new HttpVersion(1,1)).equals(HttpVersion.HTTP_1_0));
  Assert.assertTrue((new ProtocolVersion("HTTP",0,9)).equals(HttpVersion.HTTP_0_9));
  Assert.assertTrue((new ProtocolVersion("HTTP",1,0)).equals(HttpVersion.HTTP_1_0));
  Assert.assertTrue((new ProtocolVersion("HTTP",1,1)).equals(HttpVersion.HTTP_1_1));
  Assert.assertFalse((new ProtocolVersion("http",1,1)).equals(HttpVersion.HTTP_1_1));
  Assert.assertTrue(HttpVersion.HTTP_0_9.equals(new ProtocolVersion("HTTP",0,9)));
  Assert.assertTrue(HttpVersion.HTTP_1_0.equals(new ProtocolVersion("HTTP",1,0)));
  Assert.assertTrue(HttpVersion.HTTP_1_1.equals(new ProtocolVersion("HTTP",1,1)));
  Assert.assertFalse(HttpVersion.HTTP_1_1.equals(new ProtocolVersion("http",1,1)));
}

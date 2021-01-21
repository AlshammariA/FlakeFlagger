@Test public void testGetInstance() throws Exception {
  int length=400;
  byte[] data=new byte[length];
  new Random().nextBytes(data);
  DataRecord dr=InMemoryDataRecord.getInstance(data);
  assertTrue(InMemoryDataRecord.isInstance(dr.getIdentifier().toString()));
  DataRecord dr2=InMemoryDataRecord.getInstance(dr.getIdentifier().toString());
  assertTrue(IOUtils.contentEquals(dr.getStream(),dr2.getStream()));
  assertTrue(IOUtils.contentEquals(dr.getStream(),new ByteArrayInputStream(data)));
  assertEquals(length,dr.getLength());
  assertEquals(dr2.getLength(),dr.getLength());
  assertEquals(dr,dr2);
}

@Test public void testCombinedIdentifier() throws Exception {
  String id=store.writeBlob(new ByteArrayInputStream(new byte[2]));
  assertEquals(2,store.getBlobLength(id));
  String combinedId=id + id;
  assertEquals(4,store.getBlobLength(combinedId));
  doTestRead(new byte[4],4,combinedId);
}

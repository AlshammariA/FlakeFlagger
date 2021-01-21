@Test public void testEncodedBlobId() throws Exception {
  BlobId blobId=new BlobId("abc" + BlobId.SEP + "123");
  assertEquals("abc",blobId.blobId);
  assertEquals(123,blobId.length);
  blobId=new BlobId("abc" + BlobId.SEP + "abc"+ BlobId.SEP+ "123");
  assertEquals("abc" + BlobId.SEP + "abc",blobId.blobId);
  assertEquals(123,blobId.length);
  blobId=new BlobId("abc",123);
  assertEquals("abc" + BlobId.SEP + "123",blobId.encodedValue());
  assertTrue(BlobId.isEncoded("abc" + BlobId.SEP + "123"));
  assertFalse(BlobId.isEncoded("abc"));
}

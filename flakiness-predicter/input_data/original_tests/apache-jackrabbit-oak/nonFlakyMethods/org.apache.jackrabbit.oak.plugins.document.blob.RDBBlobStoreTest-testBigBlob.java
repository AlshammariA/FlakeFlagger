@Test public void testBigBlob() throws Exception {
  int min=0;
  int max=8 * 1024 * 1024;
  int test=0;
  while (max - min >= 2) {
    test=(max + min) / 2;
    byte[] data=new byte[test];
    Random r=new Random(0);
    r.nextBytes(data);
    byte[] digest=getDigest(data);
    try {
      RDBBlobStoreFriend.storeBlock(blobStore,getDigest(data),0,data);
      byte[] data2=RDBBlobStoreFriend.readBlockFromBackend(blobStore,digest);
      if (!Arrays.equals(data,data2)) {
        throw new Exception("data mismatch for length " + data.length);
      }
      min=test;
    }
 catch (    Exception ex) {
      max=test;
    }
  }
  LOG.info("max id length for " + URL + " was "+ test);
  int expected=Math.max(blobStore.getBlockSize(),2 * 1024 * 1024);
  assertTrue("expected supported block size is " + expected + ", but measured: "+ test,test >= expected);
}

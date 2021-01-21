@Test public void testGarbageCollection() throws Exception {
  HashMap<String,byte[]> map=new HashMap<String,byte[]>();
  ArrayList<String> mem=new ArrayList<String>();
  int count;
  for (int i=1; i <= 1000; i*=10) {
    byte[] data=new byte[i];
    String id;
    id=store.writeBlob(new ByteArrayInputStream(data));
    map.put(new String(id),data);
    mem.add(id);
    data=new byte[i];
    Arrays.fill(data,(byte)1);
    id=store.writeBlob(new ByteArrayInputStream(data));
    map.put(new String(id),data);
    mem.add(id);
  }
  store.startMark();
  store.sweep();
  for (  String id : map.keySet()) {
    byte[] test=readFully(id);
    assertTrue(Arrays.equals(map.get(id),test));
  }
  mem.clear();
  store.clearInUse();
  store.startMark();
  for (  String id : map.keySet()) {
    byte[] d=map.get(id);
    if (d[0] != 0) {
      continue;
    }
    if (store instanceof AbstractBlobStore) {
      ((AbstractBlobStore)store).mark(id);
    }
 else {
      store.getBlobLength(id);
    }
  }
  count=store.sweep();
  store.clearInUse();
  store.clearCache();
  try {
    Thread.sleep(1);
  }
 catch (  InterruptedException e) {
  }
  store.startMark();
  count=store.sweep();
  assertTrue("count: " + count,count > 0);
  int failedCount=0;
  for (  String id : map.keySet()) {
    long length=store.getBlobLength(id);
    try {
      readFully(id);
    }
 catch (    Exception e) {
      assertTrue(id + ":" + length,length > store.getBlockSizeMin());
      failedCount++;
    }
  }
  assertTrue("failedCount: " + failedCount,failedCount > 0);
}

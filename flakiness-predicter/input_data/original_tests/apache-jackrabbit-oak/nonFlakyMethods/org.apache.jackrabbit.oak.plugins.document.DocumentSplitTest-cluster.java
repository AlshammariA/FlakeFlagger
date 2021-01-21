@Test public void cluster(){
  MemoryDocumentStore ds=new MemoryDocumentStore();
  MemoryBlobStore bs=new MemoryBlobStore();
  DocumentMK.Builder builder;
  builder=new DocumentMK.Builder();
  builder.setDocumentStore(ds).setBlobStore(bs).setAsyncDelay(0);
  DocumentMK mk1=builder.setClusterId(1).open();
  mk1.commit("/","+\"test\":{\"prop1\":0}",null,null);
  mk1.backgroundWrite();
  builder=new DocumentMK.Builder();
  builder.setDocumentStore(ds).setBlobStore(bs).setAsyncDelay(0);
  DocumentMK mk2=builder.setClusterId(2).open();
  builder=new DocumentMK.Builder();
  builder.setDocumentStore(ds).setBlobStore(bs).setAsyncDelay(0);
  DocumentMK mk3=builder.setClusterId(3).open();
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    mk1.commit("/","^\"test/prop1\":" + i,null,null);
    mk2.commit("/","^\"test/prop2\":" + i,null,null);
    mk3.commit("/","^\"test/prop3\":" + i,null,null);
  }
  mk1.runBackgroundOperations();
  mk2.runBackgroundOperations();
  mk3.runBackgroundOperations();
  NodeDocument doc=ds.find(NODES,Utils.getIdFromPath("/test"));
  assertNotNull(doc);
  Map<Revision,String> revs=doc.getLocalRevisions();
  assertEquals(3,revs.size());
  revs=doc.getValueMap("_revisions");
  assertEquals(3 * NodeDocument.NUM_REVS_THRESHOLD,revs.size());
  Revision previous=null;
  for (  Map.Entry<Revision,String> entry : revs.entrySet()) {
    if (previous != null) {
      assertTrue(previous.compareRevisionTimeThenClusterId(entry.getKey()) > 0);
    }
    previous=entry.getKey();
  }
  mk1.dispose();
  mk2.dispose();
  mk3.dispose();
}

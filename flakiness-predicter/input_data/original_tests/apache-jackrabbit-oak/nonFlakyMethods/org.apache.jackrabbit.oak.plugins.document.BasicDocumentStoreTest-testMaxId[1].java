@Test public void testMaxId(){
  Assume.assumeTrue(!(super.ds instanceof MongoDocumentStore));
  int min=0;
  int max=32768;
  int test=0;
  while (max - min >= 2) {
    test=(max + min) / 2;
    String id=generateString(test);
    UpdateOp up=new UpdateOp(id,true);
    up.set("_id",id);
    boolean success=super.ds.create(Collection.NODES,Collections.singletonList(up));
    if (success) {
      NodeDocument findme=super.ds.find(Collection.NODES,id,0);
      assertNotNull("failed to retrieve previously stored document",findme);
      super.ds.remove(Collection.NODES,id);
      min=test;
    }
 else {
      max=test;
    }
  }
  LOG.info("max id length for " + super.dsname + " was "+ test);
}

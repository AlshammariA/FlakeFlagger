@Test public void testMaxProperty(){
  int min=0;
  int max=1024 * 1024 * 4;
  int test=0;
  while (max - min >= 256) {
    test=(max + min) / 2;
    String id=this.getClass().getName() + ".testMaxProperty-" + test;
    String pval=generateString(test);
    UpdateOp up=new UpdateOp(id,true);
    up.set("_id",id);
    up.set("foo",pval);
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
  LOG.info("max prop length for " + super.dsname + " was "+ test);
}

@Test public void batchAdd() throws Exception {
  DocumentStore docStore=openDocumentStore();
  Revision r1=new Revision(0,0,0);
  int nUpdates=10;
  List<UpdateOp> updateOps=new ArrayList<UpdateOp>();
  for (int i=0; i < nUpdates; i++) {
    String path="/node" + i;
    UpdateOp updateOp=new UpdateOp(path,true);
    updateOp.set(Document.ID,"/node" + i);
    updateOp.setMapEntry("property1",r1,"value1");
    updateOp.increment("property2",1);
    updateOp.set("property3","value3");
    updateOps.add(updateOp);
  }
  docStore.create(Collection.NODES,updateOps);
}

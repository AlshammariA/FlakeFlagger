@Test public void batchRemove() throws Exception {
  DocumentStore docStore=openDocumentStore();
  int nUpdates=10;
  Revision r1=new Revision(0,0,0);
  List<String> ids=Lists.newArrayList();
  List<UpdateOp> updateOps=new ArrayList<UpdateOp>();
  for (int i=0; i < nUpdates; i++) {
    String path="/node" + i;
    UpdateOp updateOp=new UpdateOp(path,true);
    updateOp.set(Document.ID,"/node" + i);
    updateOp.setMapEntry("property1",r1,"value1");
    updateOp.increment("property2",1);
    updateOp.set("property3","value3");
    updateOps.add(updateOp);
    ids.add(updateOp.getId());
  }
  docStore.create(Collection.NODES,updateOps);
  for (  String id : ids) {
    assertNotNull(docStore.find(Collection.NODES,id));
  }
  docStore.remove(Collection.NODES,ids);
  for (  String id : ids) {
    assertNull(docStore.find(Collection.NODES,id));
  }
}

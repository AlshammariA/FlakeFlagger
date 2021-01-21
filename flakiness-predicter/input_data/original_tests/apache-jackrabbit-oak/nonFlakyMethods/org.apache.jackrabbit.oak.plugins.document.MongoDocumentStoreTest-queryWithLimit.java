@Test public void queryWithLimit() throws Exception {
  DocumentStore docStore=openDocumentStore();
  DocumentNodeStore store=new DocumentMK.Builder().setDocumentStore(docStore).setAsyncDelay(0).getNodeStore();
  Revision rev=Revision.newRevision(0);
  List<UpdateOp> inserts=new ArrayList<UpdateOp>();
  for (int i=0; i < DocumentMK.MANY_CHILDREN_THRESHOLD * 2; i++) {
    DocumentNodeState n=new DocumentNodeState(store,"/node-" + i,rev);
    inserts.add(n.asOperation(true));
  }
  docStore.create(Collection.NODES,inserts);
  List<NodeDocument> docs=docStore.query(Collection.NODES,Utils.getKeyLowerLimit("/"),Utils.getKeyUpperLimit("/"),DocumentMK.MANY_CHILDREN_THRESHOLD);
  assertEquals(DocumentMK.MANY_CHILDREN_THRESHOLD,docs.size());
  store.dispose();
}

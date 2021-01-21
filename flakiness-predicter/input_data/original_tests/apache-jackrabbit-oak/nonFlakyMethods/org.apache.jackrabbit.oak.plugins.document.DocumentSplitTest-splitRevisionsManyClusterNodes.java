@Test public void splitRevisionsManyClusterNodes(){
  int numClusterNodes=5;
  String id=Utils.getIdFromPath("/test");
  mk.commit("/","+\"test\":{}",null,null);
  DocumentStore store=mk.getDocumentStore();
  int clusterId=mk.getNodeStore().getClusterId();
  List<Revision> revs=Lists.newArrayList();
  UpdateOp op=new UpdateOp(id,false);
  for (int i=0; i < numClusterNodes; i++) {
    for (int j=0; j < NUM_REVS_THRESHOLD; j++) {
      Revision r=Revision.newRevision(i + 1);
      if (clusterId == r.getClusterId()) {
        revs.add(r);
      }
      op.setMapEntry("prop",r,"value");
      NodeDocument.setRevision(op,r,"c");
    }
  }
  store.findAndUpdate(NODES,op);
  NodeDocument doc=store.find(NODES,id);
  assertNotNull(doc);
  List<UpdateOp> splitOps=Lists.newArrayList(doc.split(mk.getNodeStore()));
  assertEquals(2,splitOps.size());
  String prevId=Utils.getPreviousIdFor("/test",revs.get(revs.size() - 2),0);
  assertEquals(prevId,splitOps.get(0).getId());
  assertEquals(id,splitOps.get(1).getId());
}

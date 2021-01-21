@Test public void cascadingWithSplitRatio(){
  String id=Utils.getIdFromPath("/test");
  mk.commit("/","+\"test\":{}",null,null);
  DocumentStore store=mk.getDocumentStore();
  int clusterId=mk.getNodeStore().getClusterId();
  UpdateOp op=new UpdateOp(id,false);
  for (int i=0; i < 1000; i++) {
    Revision r=Revision.newRevision(2);
    op.setMapEntry("prop",r,"some long test value with many characters");
    NodeDocument.setRevision(op,r,"c");
  }
  store.findAndUpdate(NODES,op);
  NodeDocument doc=store.find(NODES,id);
  assertNotNull(doc);
  assertTrue(doc.getMemory() > NodeDocument.DOC_SIZE_THRESHOLD);
  for (int i=0; i < NUM_REVS_THRESHOLD / 2; i++) {
    Revision r=Revision.newRevision(clusterId);
    op.setMapEntry("prop",r,"value");
    NodeDocument.setRevision(op,r,"c");
  }
  TreeSet<Revision> prev=Sets.newTreeSet(mk.getNodeStore().getRevisionComparator());
  for (int i=0; i < PREV_SPLIT_FACTOR; i++) {
    Revision low=Revision.newRevision(clusterId);
    Revision high=Revision.newRevision(clusterId);
    prev.add(high);
    NodeDocument.setPrevious(op,new Range(high,low,0));
  }
  store.findAndUpdate(NODES,op);
  doc=store.find(NODES,id);
  assertNotNull(doc);
  List<UpdateOp> splitOps=Lists.newArrayList(doc.split(mk.getNodeStore()));
  assertEquals(2,splitOps.size());
  op=splitOps.get(0);
  String newPrevId=Utils.getPreviousIdFor("/test",prev.last(),1);
  assertEquals(newPrevId,op.getId());
  op=splitOps.get(1);
  assertEquals(id,op.getId());
  for (  Map.Entry<UpdateOp.Key,UpdateOp.Operation> entry : op.getChanges().entrySet()) {
    Revision r=entry.getKey().getRevision();
    assertNotNull(r);
    assertEquals(clusterId,r.getClusterId());
    if (entry.getKey().getName().equals("_prev")) {
      if (entry.getValue().type == REMOVE_MAP_ENTRY) {
        assertTrue(prev.contains(r));
      }
 else       if (entry.getValue().type == SET_MAP_ENTRY) {
        assertEquals(newPrevId,Utils.getPreviousIdFor("/test",r,1));
      }
 else {
        fail("unexpected update operation " + entry);
      }
    }
 else {
      fail("unexpected update operation " + entry);
    }
  }
}

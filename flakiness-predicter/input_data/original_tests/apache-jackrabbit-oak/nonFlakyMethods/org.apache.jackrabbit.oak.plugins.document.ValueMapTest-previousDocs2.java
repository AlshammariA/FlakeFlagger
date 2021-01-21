@Test public void previousDocs2(){
  MemoryDocumentStore store=new MemoryDocumentStore();
  String rootPath="/";
  String rootId=Utils.getIdFromPath(rootPath);
  Revision r01=new Revision(0,0,1);
  Revision r12=new Revision(1,0,2);
  Revision r22=new Revision(2,0,2);
  Revision r31=new Revision(3,0,1);
  Revision r42=new Revision(4,0,2);
  Revision r51=new Revision(5,0,1);
  UpdateOp op=new UpdateOp(Utils.getPreviousIdFor(rootPath,r31,0),true);
  op.set(ID,op.getId());
  op.setMapEntry("p0",r01,"0");
  NodeDocument.setRevision(op,r01,"c");
  op.setMapEntry("p1",r31,"1");
  NodeDocument.setRevision(op,r31,"c");
  store.createOrUpdate(NODES,op);
  op=new UpdateOp(Utils.getPreviousIdFor(rootPath,r42,0),true);
  op.set(ID,op.getId());
  op.setMapEntry("p1",r12,"0");
  NodeDocument.setRevision(op,r12,"c");
  op.setMapEntry("p1",r22,"1");
  NodeDocument.setRevision(op,r22,"c");
  op.setMapEntry("p0",r42,"1");
  NodeDocument.setRevision(op,r42,"c");
  store.createOrUpdate(NODES,op);
  op=new UpdateOp(rootId,true);
  op.set(ID,op.getId());
  op.setMapEntry("p0",r51,"2");
  op.setMapEntry("p1",r51,"2");
  NodeDocument.setRevision(op,r51,"c");
  NodeDocument.setPrevious(op,new Range(r42,r12,0));
  NodeDocument.setPrevious(op,new Range(r31,r01,0));
  store.createOrUpdate(NODES,op);
  NodeDocument doc=store.find(NODES,rootId);
  assertNotNull(doc);
  List<NodeDocument> prevDocs=Lists.newArrayList(doc.getPreviousDocs("p1",null));
  assertEquals(2,prevDocs.size());
  assertEquals(Utils.getPreviousIdFor(rootPath,r31,0),prevDocs.get(0).getId());
  assertEquals(Utils.getPreviousIdFor(rootPath,r42,0),prevDocs.get(1).getId());
  List<Revision> revs=new ArrayList<Revision>();
  for (  Revision r : doc.getValueMap("p1").keySet()) {
    revs.add(r);
  }
  assertEquals(Arrays.asList(r51,r31,r22,r12),revs);
}

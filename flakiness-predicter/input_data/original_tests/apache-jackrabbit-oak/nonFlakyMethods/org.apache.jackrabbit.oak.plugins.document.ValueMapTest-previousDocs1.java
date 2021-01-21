@Test public void previousDocs1(){
  String rootPath="/";
  String rootId=Utils.getIdFromPath(rootPath);
  Revision r0=new Revision(0,0,1);
  MemoryDocumentStore store=new MemoryDocumentStore();
  UpdateOp op=new UpdateOp(Utils.getPreviousIdFor(rootPath,r0,0),true);
  op.set(ID,op.getId());
  op.setMapEntry("prop",r0,"0");
  NodeDocument.setRevision(op,r0,"c");
  store.createOrUpdate(NODES,op);
  Revision r1low=new Revision(1,0,1);
  Revision r1high=new Revision(1,10,1);
  op=new UpdateOp(Utils.getPreviousIdFor(rootPath,r1high,0),true);
  op.set(ID,op.getId());
  for (int i=r1low.getCounter(); i <= r1high.getCounter(); i++) {
    Revision r=new Revision(1,i,1);
    op.setMapEntry("foo",r,String.valueOf(i));
    NodeDocument.setRevision(op,r,"c");
  }
  store.createOrUpdate(NODES,op);
  op=new UpdateOp(rootId,true);
  op.set(ID,op.getId());
  Revision r2=new Revision(2,0,1);
  op.setMapEntry("prop",r2,"1");
  NodeDocument.setRevision(op,r2,"c");
  NodeDocument.setPrevious(op,new Range(r0,r0,0));
  NodeDocument.setPrevious(op,new Range(r1high,r1low,0));
  store.createOrUpdate(NODES,op);
  NodeDocument doc=store.find(NODES,rootId);
  assertNotNull(doc);
  Set<Revision> revs=doc.getValueMap("prop").keySet();
  assertEquals(2,revs.size());
  assertTrue(revs.contains(r0));
  assertTrue(revs.contains(r2));
  Iterator<Revision> it=revs.iterator();
  assertTrue(it.hasNext());
  assertEquals(r2,it.next());
  assertTrue(it.hasNext());
  assertEquals(r0,it.next());
}

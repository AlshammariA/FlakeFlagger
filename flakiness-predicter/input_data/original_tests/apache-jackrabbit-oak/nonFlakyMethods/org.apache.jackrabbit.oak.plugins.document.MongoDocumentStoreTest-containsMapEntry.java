@Test public void containsMapEntry(){
  Revision r=new Revision(0,0,0);
  Revision unknown=new Revision(0,1,0);
  DocumentStore docStore=openDocumentStore();
  UpdateOp op=new UpdateOp("/node",true);
  op.setMapEntry("map",r,"value");
  docStore.createOrUpdate(Collection.NODES,op);
  op=new UpdateOp("/node",false);
  op.set("prop","value");
  op.containsMapEntry("map",unknown,true);
  assertNull(docStore.findAndUpdate(Collection.NODES,op));
  op=new UpdateOp("/node",false);
  op.set("prop","value");
  op.containsMapEntry("map",r,true);
  NodeDocument doc=docStore.findAndUpdate(Collection.NODES,op);
  assertNotNull(doc);
  doc=docStore.find(Collection.NODES,"/node");
  assertNotNull(doc);
  assertNotNull(doc.get("prop"));
  assertEquals("value",doc.get("prop"));
  op=new UpdateOp("/node",false);
  op.set("prop","other");
  op.containsMapEntry("map",r,false);
  assertNull(docStore.findAndUpdate(Collection.NODES,op));
  doc=docStore.find(Collection.NODES,"/node");
  assertNotNull(doc);
  assertNotNull(doc.get("prop"));
  assertEquals("value",doc.get("prop"));
}

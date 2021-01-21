@Test public void addGetAndRemove() throws Exception {
  DocumentStore docStore=openDocumentStore();
  UpdateOp updateOp=new UpdateOp("/",true);
  Revision r1=new Revision(0,0,0);
  updateOp.setMapEntry("property1",r1,"value1");
  updateOp.increment("property2",1);
  updateOp.set("property3","value3");
  docStore.createOrUpdate(Collection.NODES,updateOp);
  NodeDocument doc=docStore.find(Collection.NODES,"/");
  assertNotNull(doc);
  Map<?,?> property1=(Map<?,?>)doc.get("property1");
  assertNotNull(property1);
  String value1=(String)property1.get(r1);
  assertEquals("value1",value1);
  Long value2=(Long)doc.get("property2");
  assertEquals(Long.valueOf(1),value2);
  String value3=(String)doc.get("property3");
  assertEquals("value3",value3);
  docStore.remove(Collection.NODES,"/");
  doc=docStore.find(Collection.NODES,"/");
  assertTrue(doc == null);
}

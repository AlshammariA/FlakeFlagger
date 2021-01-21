@Test public void testQuery(){
  String base=this.getClass().getName() + ".testQuery-";
  for (int i=0; i < 10; i++) {
    String id=base + i;
    UpdateOp up=new UpdateOp(id,true);
    up.set("_id",id);
    boolean success=super.ds.create(Collection.NODES,Collections.singletonList(up));
    assertTrue("document with " + id + " not created",success);
    removeMe.add(id);
  }
  List<String> result=getKeys(ds.query(Collection.NODES,base,base + "A",5));
  assertEquals(5,result.size());
  assertTrue(result.contains(base + "4"));
  assertFalse(result.contains(base + "5"));
  result=getKeys(ds.query(Collection.NODES,base,base + "A",20));
  assertEquals(10,result.size());
  assertTrue(result.contains(base + "0"));
  assertTrue(result.contains(base + "9"));
}

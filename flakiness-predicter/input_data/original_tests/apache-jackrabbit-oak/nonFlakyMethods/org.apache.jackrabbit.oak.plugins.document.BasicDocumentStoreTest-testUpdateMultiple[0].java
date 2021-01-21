@Test public void testUpdateMultiple(){
  String id=this.getClass().getName() + ".testUpdateMultiple";
  UpdateOp up=new UpdateOp(id,true);
  up.set("_id",id);
  boolean success=super.ds.create(Collection.NODES,Collections.singletonList(up));
  assertTrue(success);
  removeMe.add(id);
  List<String> toupdate=new ArrayList<String>();
  toupdate.add(id + "-" + UUID.randomUUID());
  toupdate.add(id);
  UpdateOp up2=new UpdateOp(id,false);
  up2.set("foo","bar");
  ds.update(Collection.NODES,toupdate,up2);
  ds.invalidateCache();
  Document d=ds.find(Collection.NODES,id);
  assertNotNull(d);
  assertEquals(d.get("foo").toString(),"bar");
}

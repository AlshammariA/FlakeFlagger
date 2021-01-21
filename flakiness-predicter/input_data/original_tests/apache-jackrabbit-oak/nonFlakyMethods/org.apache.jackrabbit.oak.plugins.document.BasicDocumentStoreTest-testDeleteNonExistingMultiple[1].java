@Test public void testDeleteNonExistingMultiple(){
  String id=this.getClass().getName() + ".testDeleteNonExistingMultiple-" + UUID.randomUUID();
  UpdateOp up=new UpdateOp(id + "-2",true);
  up.set("_id",id + "-2");
  boolean success=super.ds.create(Collection.NODES,Collections.singletonList(up));
  assertTrue(success);
  List<String> todelete=new ArrayList<String>();
  todelete.add(id + "-2");
  todelete.add(id);
  ds.remove(Collection.NODES,todelete);
  Document d=ds.find(Collection.NODES,id + "-2");
  assertTrue(d == null);
}

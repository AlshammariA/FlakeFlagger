@Test public void testAddAndRemove(){
  String id=this.getClass().getName() + ".testAddAndRemove";
  NodeDocument nd=super.ds.find(Collection.NODES,id);
  if (nd != null) {
    super.ds.remove(Collection.NODES,id);
  }
  UpdateOp up=new UpdateOp(id,true);
  up.set("_id",id);
  assertTrue(super.ds.create(Collection.NODES,Collections.singletonList(up)));
  removeMe.add(id);
}

@Test public void testInterleavedUpdate(){
  String id=this.getClass().getName() + ".testInterleavedUpdate";
  NodeDocument nd=super.ds1.find(Collection.NODES,id);
  if (nd != null) {
    super.ds1.remove(Collection.NODES,id);
  }
  UpdateOp up=new UpdateOp(id,true);
  up.set("_id",id);
  up.set("_foo",0l);
  assertTrue(super.ds1.create(Collection.NODES,Collections.singletonList(up)));
  long increments=10;
  for (int i=0; i < increments; i++) {
    up=new UpdateOp(id,true);
    up.set("_id",id);
    up.increment("_foo",1l);
    if (i % 2 == 0) {
      super.ds1.update(Collection.NODES,Collections.singletonList(id),up);
    }
 else {
      super.ds2.update(Collection.NODES,Collections.singletonList(id),up);
    }
  }
  removeMe.add(id);
  nd=super.ds1.find(Collection.NODES,id,0);
  assertEquals("_foo should have been incremented 10 times",increments,nd.get("_foo"));
}

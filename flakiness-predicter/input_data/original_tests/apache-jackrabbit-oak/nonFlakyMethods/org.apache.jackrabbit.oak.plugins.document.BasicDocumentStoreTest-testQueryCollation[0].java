@Test public void testQueryCollation(){
  String base=this.getClass().getName() + ".testQueryCollation";
  List<UpdateOp> creates=new ArrayList<UpdateOp>();
  List<String> expected=new ArrayList<String>();
  for (  char c : "!\"#$%&'()*+,-./0123456789:;<=>?@AZ[\\]^_`az{|}~".toCharArray()) {
    String id=base + c;
    UpdateOp up=new UpdateOp(id,true);
    up.set("_id",id);
    creates.add(up);
    removeMe.add(id);
    id=base + "/" + c;
    up=new UpdateOp(id,true);
    up.set("_id",id);
    creates.add(up);
    expected.add(id);
    removeMe.add(id);
  }
  boolean success=super.ds.create(Collection.NODES,creates);
  assertTrue("documents not created",success);
  List<String> result=getKeys(ds.query(Collection.NODES,base + "/",base + "0",1000));
  List<String> diff=new ArrayList<String>();
  diff.addAll(result);
  diff.removeAll(expected);
  if (!diff.isEmpty()) {
    fail("unexpected query results (broken collation handling in persistence?): " + diff);
  }
  diff=new ArrayList<String>();
  diff.addAll(expected);
  diff.removeAll(result);
  if (!diff.isEmpty()) {
    fail("missing query results (broken collation handling in persistence?): " + diff);
  }
  assertEquals("incorrect result ordering in query result (broken collation handling in persistence?)",expected,result);
}

@Test public void bindVariableTest() throws Exception {
  Tree tree=root.getTree("/");
  Tree test=tree.addChild("test");
  test.addChild("hello").setProperty("id","1");
  test.addChild("world").setProperty("id","2");
  root.commit();
  Map<String,PropertyValue> sv=new HashMap<String,PropertyValue>();
  sv.put("id",PropertyValues.newString("1"));
  Iterator<? extends ResultRow> result;
  result=executeQuery("select * from [nt:base] where id = $id",SQL2,sv).getRows().iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/hello",result.next().getPath());
  sv.put("id",PropertyValues.newString("2"));
  result=executeQuery("select * from [nt:base] where id = $id",SQL2,sv).getRows().iterator();
  assertTrue(result.hasNext());
  assertEquals("/test/world",result.next().getPath());
}

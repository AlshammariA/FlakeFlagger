@Test public void testCreateListOfAddresses() throws Exception {
  List<String> list=new ArrayList<String>();
  list.add("The user <the.user@me.com>");
  list.add("another.user@me.com");
  List<Tuple<String,String>> tupleList=commonsmailHelper.createListOfAddresses(list);
  assertEquals(2,tupleList.size());
  assertEquals("the.user@me.com",tupleList.get(0).x);
  assertEquals("The user",tupleList.get(0).y);
  assertEquals("another.user@me.com",tupleList.get(1).x);
  assertEquals(null,tupleList.get(1).y);
}

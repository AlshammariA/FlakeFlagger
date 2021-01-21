@Test public void testSuperInsertGetRemove(){
  String cf="Super1";
  Mutator<String> m=createMutator(ko,se);
  @SuppressWarnings("unchecked") List<HColumn<String,String>> columns=Arrays.asList(createColumn("name1","value1",se,se),createColumn("name2","value2",se,se));
  m.insert("testSuperInsertGetRemove",cf,createSuperColumn("testSuperInsertGetRemove",columns,se,se,se));
  SuperColumnQuery<String,String,String,String> q=createSuperColumnQuery(ko,se,se,se,se);
  q.setSuperName("testSuperInsertGetRemove").setColumnFamily(cf);
  QueryResult<HSuperColumn<String,String,String>> r=q.setKey("testSuperInsertGetRemove").execute();
  assertNotNull(r);
  HSuperColumn<String,String,String> sc=r.get();
  assertNotNull(sc);
  assertEquals(2,sc.getSize());
  HColumn<String,String> c=sc.get(0);
  String value=c.getValue();
  assertEquals("value1",value);
  String name=c.getName();
  assertEquals("name1",name);
  HColumn<String,String> c2=sc.get(1);
  assertEquals("name2",c2.getName());
  assertEquals("value2",c2.getValue());
  m=createMutator(ko,se);
  m.subDelete("testSuperInsertGetRemove",cf,"testSuperInsertGetRemove",null,se,se);
  r=q.execute();
  sc=r.get();
  assertNull(sc);
}

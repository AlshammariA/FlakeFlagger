@Test public void testMultigetCount(){
  String cf="Standard1";
  Mutator<String> m=createMutator(keyspace,se);
  List<String> keys=new ArrayList<String>();
  for (int i=0; i < 5; i++) {
    String key="k" + i;
    m.addInsertion(key,cf,createColumn("name","value" + i,se,se));
    keys.add(key);
  }
  m.execute();
  MultigetCountQuery<String,String> mcq=new MultigetCountQuery<String,String>(keyspace,se,se);
  mcq.setColumnFamily(cf);
  mcq.setColumnNames("name");
  mcq.setKeys(keys.toArray(new String[]{}));
  QueryResult<Map<String,Integer>> result=mcq.execute();
  assertEquals(5,result.get().size());
}

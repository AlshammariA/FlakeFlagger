@Test public void testSubDelete(){
  Mutator<String> m=createMutator(keyspace,se);
  List<HColumn<String,String>> columnList=new ArrayList<HColumn<String,String>>();
  columnList.add(createColumn("col_1","val_1",se,se));
  columnList.add(createColumn("col_2","val_2",se,se));
  columnList.add(createColumn("col_3","val_3",se,se));
  HSuperColumn<String,String,String> superColumn=createSuperColumn("super_name",columnList,se,se,se);
  MutationResult r=m.insert("sk1","Super1",superColumn);
  SuperColumnQuery<String,String,String,String> scq=HFactory.createSuperColumnQuery(keyspace,se,se,se,se);
  scq.setColumnFamily("Super1");
  scq.setKey("sk1");
  scq.setSuperName("super_name");
  assertEquals(3,scq.execute().get().getColumns().size());
  m.discardPendingMutations();
  columnList.remove(1);
  columnList.remove(0);
  superColumn.setSubcolumns(columnList);
  m.addSubDelete("sk1","Super1",superColumn);
  m.execute();
  assertEquals(2,scq.execute().get().getColumns().size());
}
